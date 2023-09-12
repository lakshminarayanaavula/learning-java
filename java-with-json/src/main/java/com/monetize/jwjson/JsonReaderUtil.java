package com.monetize.jwjson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonReaderUtil {

  public static <T> T loadPlayers(InputStream inputStream, TypeReference<T> type) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(inputStream, type);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
