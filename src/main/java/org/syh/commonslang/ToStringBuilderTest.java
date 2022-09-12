package org.syh.commonslang;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ToStringBuilderTest {
    public static void main(String[] args) {
        Person tom = new Person("tom", 25);
        System.out.println(ToStringBuilder.reflectionToString(tom, ToStringStyle.SHORT_PREFIX_STYLE));
        System.out.println(ToStringBuilder.reflectionToString(tom));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
