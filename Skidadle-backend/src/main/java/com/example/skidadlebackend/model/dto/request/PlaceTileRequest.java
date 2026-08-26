package com.example.skidadlebackend.model.dto.request;

import jakarta.validation.constraints.NotNull;

public record PlaceTileRequest(
    @NotNull Integer id,
    @NotNull Integer boardId,
    @NotNull Integer row,
    @NotNull Integer col,
    char ch) {}
