package com.laptrinhjavaweb.service;

import java.util.List;

public interface GenericService<D, ID> {
    List<D> findAll();

//    List<D> findAllByProperties(Pageable pageable, List<Criterion> criterionList);

    D findOneById(ID id);

    D save(D dto) throws Exception;

//    D update(D dto) throws Exception;

    void deleteById(ID... ids) throws Exception;
}
