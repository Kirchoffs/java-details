package org.syh.jsoncompare;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import net.javacrumbs.jsonunit.core.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class JsonCompareSimpleDemo {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String pathAlpha = "json-compare/jsonAlpha.json";
        String jsonStringAlpha = new String(
            JsonCompareSimpleDemo.class.getClassLoader().getResourceAsStream(pathAlpha).readAllBytes(),
            StandardCharsets.UTF_8
        );
        JsonNode jsonAlpha = objectMapper.readTree(jsonStringAlpha);
        System.out.println(jsonAlpha);

        String pathBeta = "json-compare/jsonBeta.json";
        String jsonStringBeta = new String(
            JsonCompareSimpleDemo.class.getClassLoader().getResourceAsStream(pathBeta).readAllBytes(),
            StandardCharsets.UTF_8
        );
        JsonNode jsonBeta = objectMapper.readTree(jsonStringBeta);
        System.out.println(jsonBeta);

        String[] pathsToIgnore = new String[] {
            "$.key-5",
            "$.key-6.key-6-2"
        };
        Function<Configuration, Configuration> configuration = conf -> conf.whenIgnoringPaths(pathsToIgnore);

        JsonAssertions.assertThatJson(jsonAlpha).withConfiguration(configuration).isEqualTo(jsonBeta);

        System.out.println("Success");
    }
}
