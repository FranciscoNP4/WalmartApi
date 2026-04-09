package com.walmartapi.mapper;

public interface CustomObjectMapper <E,D> {
    E mapToEntity(D dto);

    D mapToDto(E entity);
}
