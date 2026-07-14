package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@Builder
public class User {
    private static AtomicInteger idCounter = new AtomicInteger(1);
    private int id;
    private int totalScore;
    private int boardId;

    public static User create(int boardId) {
        return User.builder()
                .id(idCounter.getAndIncrement())
                .boardId(boardId)
                .totalScore(0)
                .build();
    }

    public void addScore(int toAdd) {
        totalScore += toAdd;
    }
}
