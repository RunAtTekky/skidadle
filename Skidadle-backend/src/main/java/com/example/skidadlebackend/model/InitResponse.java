package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InitResponse {
    Board board;
    User user1;
    User user2;
    String error;
    ResponseStatus status;
}
