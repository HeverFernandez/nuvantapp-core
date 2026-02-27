package com.aitamh.nuvantapp.services.service;

import com.aitamh.nuvantapp.services.exceptions.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<T, ID> {

    Page<T> findByLike(T t, Pageable pageable) throws ServiceException;

    Optional<T> findById(ID id) throws ServiceException;

    ID save (T t) throws ServiceException;

    void udpate (T t) throws ServiceException;

    void delete (T t) throws ServiceException;

}