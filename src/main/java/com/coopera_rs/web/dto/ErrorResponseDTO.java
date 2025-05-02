package com.coopera_rs.web.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record ErrorResponseDTO(
        String statusMessage,
        boolean success,
        int statusCode,
        List<String> error
) {
}


