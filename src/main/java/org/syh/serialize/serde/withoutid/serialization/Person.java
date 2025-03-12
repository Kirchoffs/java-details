package org.syh.serialize.serde.withoutid.serialization;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// public class Person implements Serializable {
//     private String name;
//     private int age;
//     private int gender;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     public void setGender(int gender) {
//         this.gender = gender;
//     }

//     @Override
//     public String toString() {
//         return "Person{name='" + name + "', age=" + age + ", gender=" + gender + "}";
//     }
// }
