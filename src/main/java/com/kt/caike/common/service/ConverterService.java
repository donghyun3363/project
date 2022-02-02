package com.kt.caike.common.service;

import com.kt.caike.common.ifs.FunctionalEnumIfs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface ConverterService<DTO, ENTITY> {
    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);

    default <ENUM> List<ENUM> stringToEnumList(String enums, FunctionalEnumIfs<ENUM> func){
        List<String> items = Arrays.asList(enums.split(" "));
        return items.stream().map(str -> func.methodCall(str)).collect(Collectors.toList());
    }

    default  <T> String enumListToString(List<T> enumList){
        return enumList.stream().map(value -> value.toString()).collect(Collectors.joining(" "));
    }
}
