package com.aitamh.nuvantapp.exceptions;

import com.aitamh.nuvantapp.controller.generic.GenericControllerImpl;
import com.aitamh.nuvantapp.utils.ErrorUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {

    private final GenericControllerImpl base;

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<?> handleResourceNoContentException(NoContentException ex, HttpServletRequest request) {
        return base.buildErrorResponse(HttpStatus.NO_CONTENT, null, request, ex);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(NotFoundException ex,HttpServletRequest request) {
        return base.buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request, ex);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleResourceNotFoundException(BadRequestException ex, HttpServletRequest request) {
        if (ex.getBindingResult()!=null && ex.getBindingResult().hasErrors()){
            return base.buildErrorResponse(HttpStatus.BAD_REQUEST, ErrorUtil.getFieldErrors(ex.getBindingResult()), request, ex);
        }
        return base.buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request, ex);
    }

}