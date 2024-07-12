package org.syh.builder;

public class GreekAlphabetBuilderTest {
    public static void main(String[] args) {
        GreekAlphabet greekAlphabet = GreekAlphabet.builder()
                .alpha(1)
                .beta(2)
                .gamma(3)
                .delta(4)
                .epsilon(5)
                .build();
        System.out.println(greekAlphabet);
    }
}
