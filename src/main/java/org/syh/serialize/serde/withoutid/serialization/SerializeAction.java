package org.syh.serialize.serde.withoutid.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeAction {
    public static void main(String[] args) {
        String filename = "person.ser";
        Person person = new Person("Alice", 25);

        serialize(person, filename);
    }

    private static void serialize(Person person, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
            System.out.println("Serialization success: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
