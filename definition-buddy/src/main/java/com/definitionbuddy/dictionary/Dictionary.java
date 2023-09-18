package com.definitionbuddy.dictionary;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface Dictionary  {

    List<String> getDefinitions(String word) throws JsonProcessingException;

}
