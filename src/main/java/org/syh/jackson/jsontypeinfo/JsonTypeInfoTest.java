package org.syh.jackson.jsontypeinfo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonTypeInfoTest {
    public static void main(String[] args) throws Exception {
        View viewBefore = new View();
        viewBefore.setShapes(new ArrayList<>(List.of(Rectangle.of(3, 6), Circle.of(5))));

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("-- serializing --");
        String serializedData = objectMapper.writeValueAsString(viewBefore);
        System.out.println(serializedData);

        System.out.println("-- deserializing --");
        View viewAfter = objectMapper.readValue(serializedData, View.class);
        System.out.println(viewAfter);
    }
}
