package org.syh.serialize.date;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;

public class DeserializeTest {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = DeserializeTest.class.getClassLoader().getResourceAsStream("json-date-parse.json");
        JsonNode jsonNode = new ObjectMapper().readTree(inputStream);

        ObjectMapper mapperOffsetDateTime = new ObjectMapper();
        mapperOffsetDateTime.registerModule(new JavaTimeModule());
        JsonNode jsonNodeOffsetDateTime = jsonNode.get("offset-datetime-wrapper");
        OffsetDateTimeWrapper offsetDateTimeWrapper = mapperOffsetDateTime.readValue(
                mapperOffsetDateTime.writeValueAsString(jsonNodeOffsetDateTime),
                OffsetDateTimeWrapper.class
        );
        System.out.println(offsetDateTimeWrapper.dateStart + " ----- " + offsetDateTimeWrapper.dateEnd);

        ObjectMapper mapperDateTime = new ObjectMapper();
        mapperDateTime.registerModule(new JodaModule());
        JsonNode jsonNoteDateTime = jsonNode.get("datetime-wrapper");
        DateTimeWrapper dateTimeWrapper = mapperDateTime.readValue(
                mapperDateTime.writeValueAsString(jsonNoteDateTime),
                DateTimeWrapper.class
        );
        System.out.println(dateTimeWrapper.dateStart + " ----- " + offsetDateTimeWrapper.dateEnd);
    }
}
