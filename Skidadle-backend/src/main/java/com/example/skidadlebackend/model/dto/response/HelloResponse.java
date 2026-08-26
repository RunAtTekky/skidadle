package com.example.skidadlebackend.model.dto.response;

import com.example.skidadlebackend.model.enums.ResponseStatus;
import lombok.Builder;

@Builder
public record HelloResponse(String greeting, ResponseStatus status) {}
