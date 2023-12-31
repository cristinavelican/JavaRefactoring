package com.definitionbuddy.dictionary;

import com.definitionbuddy.search.LocalBackupDefinitionSearch;

import static com.definitionbuddy.dictionary.Language.ENGLISH;
import static com.definitionbuddy.dictionary.Language.SPANISH;
import static com.definitionbuddy.search.WebServiceDefinitionSearch.newForeignLanguageInstance;
import static com.definitionbuddy.search.WebServiceDefinitionSearch.newInstance;

/**
 * A simple (a.k.a. parametrized) switch-based factory
 */
public class  SimpleDictionaryFactory {

    //singleton principle
    private static final GeneralDictionary ENGLISH = new GeneralDictionary(newForeignLanguageInstance(Language.ENGLISH));
    private static final GeneralDictionary SPANISH = new GeneralDictionary(newForeignLanguageInstance(Language.SPANISH));
    public static GeneralDictionary english() {
        return ENGLISH;
    }

    public static GeneralDictionary spanish() {
        return SPANISH;
    }

    public static GeneralDictionary ofLanguage(Language language){
        return new GeneralDictionary(newForeignLanguageInstance(language));
    }

    /**
     * Only English is supported for specialized types (as per requirements)
     */
    public static Dictionary ofType(DictionaryType type){
        switch (type){
            case GENERAL:
                return new GeneralDictionary(newInstance());
            case LEGAL:
                return new LegalDictionary();
            case MEDICAL:
                return new MedicalDictionary();
            default:
                throw new IllegalArgumentException("We currently don't support dictionaries of type" + type);
        }
    }
}
