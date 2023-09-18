package com.definitionbuddy.dictionary;

import com.definitionbuddy.search.DefinitionSearch;
import com.definitionbuddy.search.WebServiceDefinitionSearch;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

import static com.definitionbuddy.dictionary.Language.ENGLISH;
import static com.definitionbuddy.dictionary.Language.SPANISH;
import static com.definitionbuddy.search.WebServiceDefinitionSearch.newForeignLanguageInstance;
import static com.definitionbuddy.search.WebServiceDefinitionSearch.newInstance;

public class GeneralDictionary implements Dictionary {

    private final DefinitionSearch search;

    // dummy additional objects to show that
    // new dependencies can be added within a static factory method
    // without affecting the client
    private SynonymFinder finder;
    private ExampleProvider examples;

    // implement singleton
    private static final GeneralDictionary ENGLISH = new GeneralDictionary(newForeignLanguageInstance(Language.ENGLISH));
    private static final GeneralDictionary SPANISH = new GeneralDictionary(newForeignLanguageInstance(Language.SPANISH));
    public GeneralDictionary() {
        search = newInstance();
    }

    public GeneralDictionary(DefinitionSearch search) {
        this.search = search;
    }

    public GeneralDictionary(DefinitionSearch search, SynonymFinder finder, ExampleProvider examples) {
        this.search = search;
        this.finder = finder;
        this.examples = examples;
    }

    public static GeneralDictionary english() {
        return ENGLISH;
    }


    public static GeneralDictionary spanish() {
        return SPANISH;
    }

    public List<String> getDefinitions(String word) throws JsonProcessingException {
        return search.getDefinition(word);
    }
}
