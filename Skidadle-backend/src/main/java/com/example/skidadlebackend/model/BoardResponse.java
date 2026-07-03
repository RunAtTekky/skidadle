package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BoardResponse {
    Board board;
    String error;
    ResponseStatus status;
}
