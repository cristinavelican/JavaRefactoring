package com.definitionbuddy;

import com.definitionbuddy.dictionary.GeneralDictionary;
import com.definitionbuddy.search.WebServiceDefinitionSearch;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GeneralDictionaryTest {

    @Test
    public void dictTest() throws JsonProcessingException {
        GeneralDictionary d = new GeneralDictionary(WebServiceDefinitionSearch.newInstance());

        List<String> definitions = d.getDefinitions("hello");

        Assertions.assertEquals(definitions.size(), 1);

        definitions.forEach(System.out::println);
    }


}