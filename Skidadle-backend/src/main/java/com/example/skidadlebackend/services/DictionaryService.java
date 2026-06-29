package com.example.skidadlebackend.services;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DictionaryService {
    private static Set<String> possibleWords;

    public static boolean isValidWord(String word) {
        return possibleWords.contains(word);
    }
}
