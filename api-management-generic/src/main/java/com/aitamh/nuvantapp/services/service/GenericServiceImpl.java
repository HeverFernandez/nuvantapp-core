package com.aitamh.nuvantapp.services.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import static java.util.Objects.isNull;

public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID>{

    protected  String getLike(String val){
        return "%"+(isNull(val)?"":val)+"%";
    }

    protected Page<T> getPage(List<T> content, Pageable pageable, Long total){
        return new PageImpl<T>(content,pageable,total);
    }

}