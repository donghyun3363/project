package com.kt.caike.common.service;

import com.kt.caike.common.ifs.BaseEntity;
import com.kt.caike.common.request.KtRequest;
import com.kt.caike.common.response.KtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


public abstract class CRUDService<ID, DTO, ENTITY extends BaseEntity<ID>> {

    @Autowired(required = false)
    protected JpaRepository<ENTITY, ID> repository;

    @Autowired(required = false)
    protected ConverterService<DTO, ENTITY> converterService;

    // DTO 를 통한 ENTITY 생성
    public KtResponse<DTO> create(KtRequest<DTO> req){

        // DTO -> ENTITY 로 변환
        var newEntity = converterService.toEntity(req.getBody());

        // ENTITY SAVE
        var saveEntity = repository.saveAndFlush(newEntity);

        // SAVE 된 ENTITY -> DTO 로 변환
        var responseDto = converterService.toDto(saveEntity);

        // Response
        return new KtResponse<DTO>().responseOk(req.getHeader(), responseDto);
    }

    // Index id 로 ENTITY 정보 Return
    public KtResponse<DTO> read(ID id){
        return repository.findById(id)
                .map(entity -> {
                    var responseDto = converterService.toDto(entity);
                    return new KtResponse<DTO>().responseOk(responseDto);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public KtResponse<DTO> update(KtRequest<DTO> dto){
        var entity = converterService.toEntity(dto.getBody());
        var oldEntity = repository.getById(entity.getId());

        if(oldEntity != null){
            // Front -> DTO 로 들어오지 않는 기본 Not null 항목
            entity.setCreatedBy(oldEntity.getCreatedBy());
            entity.setUpdatedBy(oldEntity.getUpdatedBy());

            entity.setCreatedAt(oldEntity.getCreatedAt());
            entity.setUpdatedAt(oldEntity.getUpdatedAt());
        }

        var saveEntity = repository.save(entity);
        var responseDto = converterService.toDto(saveEntity);
        return new KtResponse<DTO>().responseOk(responseDto);
    }

    public KtResponse delete(ID id){
        repository.deleteById(id);
        return new KtResponse().responseOk();
    }

    public KtResponse<List<DTO>> findAll(Integer page, Integer size, String sort){
        var optionalSort = Sort.Direction.fromOptionalString(sort);
        var sorting = optionalSort.orElse(Sort.Direction.ASC);
        var pageable = PageRequest.of(page, size, sorting,"id");
        var dtoList= repository.findAll(pageable)
                .stream()
                .map(entity -> converterService.toDto(entity))
                .collect(Collectors.toList());

        return new KtResponse<List<DTO>>().responseOk(dtoList);
    }
}
