package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InitResponse {
    User user1;
    User user2;
}
