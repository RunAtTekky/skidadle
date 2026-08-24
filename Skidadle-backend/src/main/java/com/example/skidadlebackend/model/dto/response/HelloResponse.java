package com.example.skidadlebackend.model.dto.response;

import com.example.skidadlebackend.model.enums.ResponseStatus;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class HelloResponse {
  String greeting;
  ResponseStatus status;
}
