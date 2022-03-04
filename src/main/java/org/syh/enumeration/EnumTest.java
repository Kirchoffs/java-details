package org.syh.enumeration;

enum Flower {
    Rose,
    Lily,
    Orchid,
    Sunflower,
    Jasmine
}

public class EnumTest {
    public static void main(String[] args) {
        Flower rose = Flower.valueOf("Rose");
        Flower orchid = Flower.valueOf("Orchid");
        System.out.println(rose);
        System.out.println(orchid);
    }
}
