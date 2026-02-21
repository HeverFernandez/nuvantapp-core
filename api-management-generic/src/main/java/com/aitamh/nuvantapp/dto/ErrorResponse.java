package com.aitamh.nuvantapp.dto;

import com.aitamh.nuvantapp.config.ApplicationProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ErrorResponse {

    private final ApplicationProperties app;
    private final Environment env;

    public ResponseEntity<Object> buildErrorResponse(
            HttpStatus status, String message, HttpServletRequest request, Exception ex) {

        String transactionId = UUID.randomUUID().toString();
        String correlationId = Optional.ofNullable(request.getHeader("X-Correlation-Id"))
                .orElse("galaxy-" + UUID.randomUUID().toString().substring(0, 8));

        String traceId = Optional.ofNullable(MDC.get("traceId"))
                .orElse(UUID.randomUUID().toString().substring(0, 8));

        String node = Optional.ofNullable(System.getenv("HOSTNAME"))
                .orElse("localhost");

        MetaResponse meta = MetaResponse.builder()
                .status(status.value())
                .message(message)
                .service(app.getName())
                .version(app.getVersion())
                .path(request.getRequestURI())
                .method(request.getMethod())
                .environment(getEnvironment())
                .transactionId(transactionId)
                .correlationId(correlationId)
                .traceId(traceId)
                .elapsedTime("0ms")
                .node(node)
                .build();

        return ResponseEntity.status(status)
                .body(Map.of("errors", meta));
    }


    private String getEnvironment(){
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("default");
    }

    private String getCorrelationId(HttpServletRequest request){
        return Optional.ofNullable(request.getHeader("X-Correlation-Id"))
                .filter(id -> !id.isBlank())
                .orElseGet(() -> "galaxy-" + UUID.randomUUID().toString().substring(0, 8));
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
