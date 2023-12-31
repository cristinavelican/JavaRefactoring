package com.definitionbuddy.dictionary;

import com.definitionbuddy.search.DedicatedMedicalDefinitionSearch;
import com.definitionbuddy.search.DefinitionSearch;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class MedicalDictionary implements Dictionary {

    DefinitionSearch search;

    public MedicalDictionary(DefinitionSearch search) {
        this.search = search;
    }

    public MedicalDictionary() {
        this.search = new DedicatedMedicalDefinitionSearch();
    }


    @Override
    public List<String> getDefinitions(String word) throws JsonProcessingException {
        return search.getDefinition(word);
    }
}
