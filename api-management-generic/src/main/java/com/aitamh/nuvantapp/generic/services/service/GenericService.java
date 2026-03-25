package com.aitamh.nuvantapp.generic.services.service;

import com.aitamh.nuvantapp.generic.services.exceptions.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<T, R, ID> {

    Page<R> findByLike(T t, Pageable pageable) throws ServiceException;

    Optional<R> findById(ID id) throws ServiceException;

    R save (T t) throws ServiceException;

    R update (ID id, T t) throws ServiceException;

    void delete (ID id) throws ServiceException;

    Page<R> findAll(Pageable pageable);

}