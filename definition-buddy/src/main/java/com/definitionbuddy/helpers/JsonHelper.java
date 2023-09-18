package com.definitionbuddy.helpers;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

import java.util.function.Predicate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;


import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class JsonHelper {

    /**
     * Accepts a Json String and extracts definitions from lines prefixed with "definition"
     * @param json properly formatted Json String
     * @return a list of definitions
     */
    public static List<String> extractDefinitions(String json) throws JsonProcessingException {
        //Parse JSON into Java Objects
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);
        //read the definitions from the JsonObject
        JsonNode definitionsArray = null;
        List<String> definitions = null;
        try {
            definitionsArray = rootNode.get(0).get("meanings").get(0).get("definitions");
            definitions= jsonNodeToList(definitionsArray, "definition");
        } catch (Exception exception) {
            System.out.println("Something went wrong " + exception.getMessage());
        }


        return definitions == null || definitions.isEmpty() ? List.of("Nothing found") : definitions;

    }

    public static List<String> jsonNodeToList(JsonNode node, String property) {
        List<String> result = new ArrayList<>();
        if (node.isArray()) {
            for(JsonNode jsonNode : node) {
                JsonNode definition = jsonNode.get(property);
                result.add(String.valueOf(definition));
            }
        } else {
            result.add(node.toString());
        }
        return result;
    }
}
