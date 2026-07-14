package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class HelloResponse {
    String greeting;
    ResponseStatus status;
}
