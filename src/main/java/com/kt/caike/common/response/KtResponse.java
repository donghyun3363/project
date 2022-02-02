package com.kt.caike.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kt.caike.common.header.KtHeader;
import com.kt.caike.common.request.Pagination;
import com.kt.caike.member.db.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@SuppressWarnings("unchecked")
public class KtResponse<T> {

    @JsonProperty("header")
    private KtHeader header;

    @Valid
    @JsonProperty("body")
    private T body;

    @JsonProperty("pagination")
    private Pagination pagination;

    @JsonIgnore
    public KtResponse(KtHeader requestHeader){
        this.header = requestHeader;
    }

    @JsonIgnore
    public KtResponse<T> responseOk(){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().responseOk())
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> responseOk(KtHeader header){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().responseOk(header))
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> responseOk(T body){
        return (KtResponse<T>) KtResponse.builder()
                .body(body)
                .header(KtHeader.builder().build().responseOk())
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> responseOk(T body, Pagination pagination){
        return (KtResponse<T>) KtResponse.builder()
                .body(body)
                .header(KtHeader.builder().build().responseOk())
                .pagination(pagination)
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> responseOk(KtHeader requestHeader, T body){
        return (KtResponse<T>) KtResponse.builder()
                .body(body)
                .header(KtHeader.builder().build().responseOk(requestHeader))
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> responseOk(KtHeader requestHeader, T body, Pagination pagination){
        return (KtResponse<T>) KtResponse.builder()
                .body(body)
                .header(KtHeader.builder().build().responseOk(requestHeader))
                .pagination(pagination)
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> validationError(){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().validationError())
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> validationError(String description){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().validationError(description))
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> validationError(BindingResult bindingResult){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().validationError())
                .body(bindingResult.getAllErrors())
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> validationError(String uri, String method, String description){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().validationError(uri, method, description))
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> serverError(){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().serverError())
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> serverError(String code, String description){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().serverError(code, description))
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> serverError(String description){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().serverError(description))
                .build()
                ;
    }

    @JsonIgnore
    public KtResponse<T> serverError(String uri, String method, String description){
        return (KtResponse<T>) KtResponse.builder()
                .header(KtHeader.builder().build().serverError(uri, method, description))
                .build()
                ;
    }
}
