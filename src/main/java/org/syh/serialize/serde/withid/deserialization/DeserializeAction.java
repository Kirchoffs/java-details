package org.syh.serialize.serde.withid.deserialization;

import org.syh.serialize.serde.withid.serialization.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeAction {
    public static void main(String[] args) {
        String filename = "person.ser";

        deserialize(filename);
    }

    private static void deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person person = (Person) ois.readObject();
            System.out.println("Deserialization success: " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
