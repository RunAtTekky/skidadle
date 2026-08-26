package com.example.skidadlebackend.model.dto.request;

import jakarta.validation.constraints.NotNull;

public record InitRequest(@NotNull Integer row, @NotNull Integer col) {}
