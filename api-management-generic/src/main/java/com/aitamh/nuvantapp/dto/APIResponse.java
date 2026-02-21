package com.aitamh.nuvantapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse<T> {
    private MetaResponse meta;
    //private  DataResponse<T> data;
    private T result;
}