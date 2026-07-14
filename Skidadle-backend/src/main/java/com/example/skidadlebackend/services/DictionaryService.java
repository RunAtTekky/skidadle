package com.example.skidadlebackend.services;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

@Service
public class DictionaryService {
    private Set<String> possibleWords;

    @PostConstruct
    public void loodWords() {
        possibleWords = new HashSet<>();

        try {
            ClassPathResource resourc = new ClassPathResource("wordlist.txt");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resourc.getInputStream(), StandardCharsets.UTF_8)
            );

            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase();
                if (!word.isEmpty()) {
                    possibleWords.add(word);
                }
            }

            reader.close();
            System.out.println("Loaded " + possibleWords.size() + " words into dictionary");
        } catch (IOException e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
            throw new RuntimeException("Failed to load dictionary file", e);
        }
    }

    public boolean isValidWord(String word) {
        if (word == null || word.isEmpty()) return false;

        return possibleWords.contains(word.toLowerCase());
    }
}
