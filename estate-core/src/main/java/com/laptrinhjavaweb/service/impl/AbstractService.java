package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.GenericConverter;
import com.laptrinhjavaweb.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class AbstractService<D, E, ID> implements GenericService<D, ID> {
    protected GenericConverter<D, E> converter;
    protected JpaRepository<E, ID> repository;

    public AbstractService(GenericConverter<D, E> converter, JpaRepository<E, ID> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public List<D> findAll() {
        List<E> entityList = repository.findAll();
        List<D> dtoList = new ArrayList<>();

//        convert entity to dto and add it to dto list
        for (E entity : entityList) {
            dtoList.add(converter.entityToDto(entity));
        }

        return dtoList;
    }

//    @Override
//    public List<D> findAllByProperties(Pageable pageable, List<Criterion> criterionList) {
//        List<E> entityList = repository.findAll();
//        List<D> dtoList = new ArrayList<>();
//
////        convert entity to dto and add it to dto list
//        for (E entity : entityList) {
//            dtoList.add(converter.entityToDto(entity));
//        }
//
//        return dtoList;
//    }

    @Override
    public D findOneById(ID id) {
        E entity = repository.getOne(id);
        return converter.entityToDto(entity);
    }

    @Override
    public D save(D dto) throws Exception {
        E entity = converter.dtoToEntity(dto);
        entity = repository.save(entity);
        return converter.entityToDto(entity);
    }

//    @Override
//    public D update(D dto) throws Exception {
//        E entity = converter.dtoToEntity(dto);
//        repository.is(entity);
//        return converter.entityToDto(entity);
//    }

    @Override
    public void deleteById(ID... ids) throws Exception {
        for (ID id : ids) {
            repository.deleteById(id);
        }
    }
}
