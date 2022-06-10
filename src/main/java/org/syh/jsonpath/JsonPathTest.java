package org.syh.jsonpath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonPathTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Map<String, Object> jsonMap = new ObjectMapper()
                .readValue(new File("src/main/resources/json-data.json"), Map.class);

        String jsonData = new ObjectMapper().writeValueAsString(jsonMap);
        DocumentContext jsonContext = JsonPath.parse(jsonData);

        String jsonPathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
        String jsonPathCreatorName = jsonContext.read(jsonPathCreatorNamePath);
        System.out.println(jsonPathCreatorName);

        String jsonPathCreatorLocationPath = "$['tool']['jsonpath']['creator']['location'][*]";
        List<String> jsonpathCreatorLocation = jsonContext.read(jsonPathCreatorLocationPath);
        for (String location: jsonpathCreatorLocation) {
            System.out.println(location + " ");
        }
    }
}
