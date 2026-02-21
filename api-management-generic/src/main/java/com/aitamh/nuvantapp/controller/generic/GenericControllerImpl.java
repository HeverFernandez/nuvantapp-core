package com.aitamh.nuvantapp.controller.generic;

import static com.aitamh.nuvantapp.controller.constants.APIMessageContants.*;
import com.aitamh.nuvantapp.config.ApplicationProperties;
import com.aitamh.nuvantapp.dto.APIResponse;
import com.aitamh.nuvantapp.dto.IDResponse;
import com.aitamh.nuvantapp.dto.MetaResponse;
import com.aitamh.nuvantapp.dto.PaginationResponse;

import com.aitamh.nuvantapp.exceptions.BadRequestException;
import com.aitamh.nuvantapp.exceptions.NoContentException;
import com.aitamh.nuvantapp.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.net.InetAddress;
import java.util.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public abstract class GenericControllerImpl implements GenericController {

    protected final Environment env;
    protected final ApplicationProperties app;

    protected  Integer getPage(Integer page){
        return  (page<=1)?0:(page-1);
    }

    protected <T> ResponseEntity<APIResponse<T>> getOk(T data, HttpServletRequest request){
        return buildResponse(HttpStatus.OK, MSG_OK, data, null, request);
    }
    protected <T> ResponseEntity<APIResponse<List<T>>> getOk(Page<T> page, HttpServletRequest request){
        return buildResponse(HttpStatus.OK, MSG_OK, page.getContent(), getPagination(page), request);
    }

    protected <T> ResponseEntity<APIResponse<T>> getCreated(T data, HttpServletRequest request) {
        return buildResponse(HttpStatus.CREATED, MSG_CREATED, data, null, request);
    }

    protected <T> ResponseEntity<APIResponse<T>> getError(String message, HttpServletRequest request) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, message, null, null, request);
    }

    public <T> ResponseEntity<APIResponse<T>> buildResponse(
            HttpStatus status,
            String message,
            T result,
            PaginationResponse pagination,
            HttpServletRequest request) {

        long startTime = System.currentTimeMillis();

        MetaResponse.MetaResponseBuilder metaBuilder = MetaResponse.builder()
                .status(status.value())
                .message(message)
                .service(app.getName())
                .version(app.getVersion())
                .path(request.getRequestURI())
                .method(request.getMethod())
                .environment(getEnvironment())
                .transactionId(UUID.randomUUID().toString())
                .correlationId(getCorrelationId(request))
                .traceId(getTraceId())
                .node(getNode())
                .elapsedTime((System.currentTimeMillis() - startTime)+ "ms");

        if (pagination != null) {
            metaBuilder.pagination(pagination);
        }

        APIResponse<T> apiResponse = APIResponse.<T>builder()
                .meta(metaBuilder.build())
                .result(result)
                .build();

        return ResponseEntity.status(status).body(apiResponse);
    }

    protected ResponseEntity<?> getNoContent() throws NoContentException {
        throw new NoContentException();
    }

    protected ResponseEntity<?> getBadRequest(String msg) throws BadRequestException {
        throw new BadRequestException(msg);
    }

    protected ResponseEntity<?> getBadRequest(BindingResult bindingResult) throws BadRequestException {
        throw new BadRequestException(bindingResult);
    }

    protected ResponseEntity<?> getBadRequest() throws BadRequestException {
        return getBadRequest(MSG_BAD_REQUEST);
    }


    protected ResponseEntity<?> getNotFound() throws NotFoundException {
        throw new NotFoundException(MSG_NOT_FOUND);
    }

    private <T> PaginationResponse getPagination(Page<T> dataPage){
        return PaginationResponse.builder()
                .page(dataPage.getNumber() + 1)
                .size(dataPage.getSize())
                .totalElements(dataPage.getTotalElements())
                .totalPages(dataPage.getTotalPages())
                .hasNext(dataPage.hasNext())
                .hasPrevious(dataPage.hasPrevious())
                .sort(dataPage.getSort().toString())
                .build();
    }
    public ResponseEntity<Object> buildErrorResponse(
            HttpStatus status,
            Object message,
            HttpServletRequest request,
            Exception ex) {

        long startTime = System.currentTimeMillis();

        MetaResponse meta = MetaResponse.builder()
                .status(status.value())
                .message(message)
                .service(app.getName())
                .version(app.getVersion())
                .path(request != null ? request.getRequestURI() : null)
                .method(request != null ? request.getMethod() : null)
                .environment(getEnvironment())
                .transactionId(UUID.randomUUID().toString())
                .correlationId(getCorrelationId(request))
                .traceId(getTraceId())
                .node(getNode())
                .elapsedTime((System.currentTimeMillis() - startTime) + "ms")
                .build();
        if ("dev".equalsIgnoreCase(getEnvironment())) {
            meta.setMessage(meta.getMessage() + " (" + ex.getClass().getSimpleName() + ")");
        }

        return ResponseEntity.status(status)
                .body(Map.of("errors", meta));
    }

    protected <T> IDResponse<T> getID(T t){
        return IDResponse.<T>builder()
                .id(t)
                .build();
    }

    private String getEnvironment(){
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("default");
    }

    private String getCorrelationId(HttpServletRequest request){
        return Optional.ofNullable(request.getHeader("X-Correlation-Id"))
                .filter(id -> !id.isBlank())
                .orElseGet(() -> "nuvanta-" + UUID.randomUUID().toString().substring(0, 8));
    }

    private String getTraceId(){
        return Optional.ofNullable(MDC.get("traceId"))
                .orElse(UUID.randomUUID().toString().substring(0, 12));
    }
    private String getNode() {
        return Optional.ofNullable(System.getenv("HOSTNAME"))
                .orElseGet(() -> InetAddress.getLoopbackAddress().getHostName());
    }
}

