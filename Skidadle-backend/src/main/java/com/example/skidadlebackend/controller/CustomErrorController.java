package com.example.skidadlebackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        Object statusCode = request.getAttribute("jakarta.servlet.error.status_code");
        Object pathObj = request.getAttribute("jakarta.servlet.error.request_uri");

        int status = statusCode != null ? Integer.parseInt(statusCode.toString()) : 500;
        String path = pathObj != null ? pathObj.toString() : "";

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", status);
        body.put("error", HttpStatus.valueOf(status).getReasonPhrase());
        body.put("message", status == 404 ? "Endpoint not found" : "Something went wrong");
        body.put("path", path);

        return ResponseEntity.status(status).body(body);
    }
}
