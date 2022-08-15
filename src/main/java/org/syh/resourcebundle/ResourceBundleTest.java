package org.syh.resourcebundle;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;


public class ResourceBundleTest {
    public static void main(String[] args) {
        test_pl_PL();
        test_pl();
        test();
    }

    private static void test_pl_PL() {
        Locale locale = new Locale("pl", "PL");
        ResourceBundle exampleBundle =
                ResourceBundle.getBundle("org.syh.resourcebundle.ExampleResource", locale);

        System.out.println(exampleBundle.getString("currency"));
        System.out.println(exampleBundle.getObject("toUsdRate"));
        System.out.println(Arrays.toString(exampleBundle.getStringArray("cities")));
    }

    private static void test_pl() {
        Locale locale = new Locale("pl");
        ResourceBundle exampleBundle =
                ResourceBundle.getBundle("org.syh.resourcebundle.ExampleResource", locale);

        System.out.println(exampleBundle.getString("greeting"));
        System.out.println(exampleBundle.getObject("language"));
    }

    private static void test() {
        ResourceBundle exampleBundle =
                ResourceBundle.getBundle("org.syh.resourcebundle.ExampleResource");

        System.out.println(exampleBundle.getString("greeting"));
    }
}
