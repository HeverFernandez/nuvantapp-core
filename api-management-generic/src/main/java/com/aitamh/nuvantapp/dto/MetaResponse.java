package com.aitamh.nuvantapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetaResponse {
    private int status;
    private Object message;
    @Builder.Default
    private LocalDateTime timestamp= LocalDateTime.now();
    private String service;
    private String version;
    private String path;
    private String method;
    private String environment;
    private String transactionId;
    private String correlationId;
    private String traceId;
    private String elapsedTime;
    private String node;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaginationResponse pagination;
}