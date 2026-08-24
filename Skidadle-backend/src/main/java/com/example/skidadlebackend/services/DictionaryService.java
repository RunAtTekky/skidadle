package com.example.skidadlebackend.services;

public interface DictionaryService {
  void loadWords();

  boolean isValidWord(String word);
}
