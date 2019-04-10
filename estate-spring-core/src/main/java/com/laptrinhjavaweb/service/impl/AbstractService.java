package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.GenericConverter;
import com.laptrinhjavaweb.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class AbstractService<D, E, ID> implements GenericService<D, ID> {
    protected GenericConverter<D, E> converter;
    protected JpaRepository<E, ID> genericRepository;

    public AbstractService(GenericConverter<D, E> converter, JpaRepository<E, ID> genericRepository) {
        this.converter = converter;
        this.genericRepository = genericRepository;
    }

    @Override
    public List<D> findAll() {
        List<E> entityList = genericRepository.findAll();
        List<D> dtoList = new ArrayList<>();

//        convert entity to dto and add it to dto list
        for (E entity : entityList) {
            dtoList.add(converter.entityToDto(entity));
        }

        return dtoList;
    }

//    @Override
//    public List<D> findAllByProperties(Pageable pageable, List<Criterion> criterionList) {
//        List<E> entityList = genericRepository.findAll();
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
        E entity = genericRepository.getOne(id);
        return converter.entityToDto(entity);
    }

    @Override
    public D save(D dto) throws Exception {
        E entity = converter.dtoToEntity(dto);
        entity = genericRepository.save(entity);
        return converter.entityToDto(entity);
    }

//    @Override
//    public D update(D dto) throws Exception {
//        E entity = converter.dtoToEntity(dto);
//        genericRepository.is(entity);
//        return converter.entityToDto(entity);
//    }

    @Override
    public void deleteById(ID... ids) throws Exception {
        for (ID id : ids) {
            genericRepository.deleteById(id);
        }
    }
}
