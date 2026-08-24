package com.example.skidadlebackend.services.impl;

import com.example.skidadlebackend.services.DictionaryService;
import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {
  private Set<String> possibleWords;

  @PostConstruct
  @Override
  public void loadWords() {
    possibleWords = new HashSet<>();

    try {
      ClassPathResource resource = new ClassPathResource("wordlist.txt");
      BufferedReader reader =
          new BufferedReader(
              new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));

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

  @Override
  public boolean isValidWord(String word) {
    if (word == null || word.isEmpty()) return false;

    return possibleWords.contains(word.toLowerCase());
  }
}
