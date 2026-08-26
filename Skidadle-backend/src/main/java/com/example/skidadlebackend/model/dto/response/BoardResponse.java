package com.example.skidadlebackend.model.dto.response;

import com.example.skidadlebackend.model.entity.Board;
import com.example.skidadlebackend.model.enums.ResponseStatus;
import lombok.Builder;

@Builder
public record BoardResponse(Board board, String error, ResponseStatus status) {}
