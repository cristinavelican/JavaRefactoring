package com.definitionbuddy.dictionary;

public enum Language {

    ENGLISH("en"), SPANISH("es"), FRENCH("fr");

    private String language;

    Language(String language) {
        this.language = language;
    }

    @Override
    public String toString(){
        return language;
    }

}
