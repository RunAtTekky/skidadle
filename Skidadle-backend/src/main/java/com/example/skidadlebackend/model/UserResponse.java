package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {
    int id;
    int boardId;
    int score;
}
