package com.definitionbuddy.search;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface DefinitionSearch {

    List<String> getDefinition(String word) throws JsonProcessingException;
}
