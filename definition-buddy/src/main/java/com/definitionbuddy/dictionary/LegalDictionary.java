package com.definitionbuddy.dictionary;

import com.definitionbuddy.search.DedicatedLegalDefinitionSearch;
import com.definitionbuddy.search.DefinitionSearch;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class LegalDictionary implements Dictionary {

    DefinitionSearch search;

    public LegalDictionary(DefinitionSearch search) {
        this.search = search;
    }

    public LegalDictionary() {
        this.search = new DedicatedLegalDefinitionSearch();
    }

    @Override
    public List<String> getDefinitions(String word) throws JsonProcessingException {
        return search.getDefinition(word);
    }
}
