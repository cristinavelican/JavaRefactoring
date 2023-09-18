package com.definitionbuddy.search;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.definitionbuddy.helpers.JsonHelper.extractDefinitions;
import static java.nio.charset.StandardCharsets.UTF_8;

public class LocalBackupDefinitionSearch implements DefinitionSearch {

    public static LocalBackupDefinitionSearch newInstance(){
        return new LocalBackupDefinitionSearch();
    }


 public List<String> getDefinition(String word) throws JsonProcessingException {

        String content;
        try {
            content = Files.readString(Paths.get("definition-buddy/src/main/resources/BackupLocalDefinitions.json"), UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return extractDefinitions(content);



    }
}
