package com.example.skidadlebackend.model.dto.response;

import com.example.skidadlebackend.model.entity.Board;
import com.example.skidadlebackend.model.entity.User;
import com.example.skidadlebackend.model.enums.ResponseStatus;
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
