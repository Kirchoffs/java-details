package org.syh.spi;

public class DefaultSpiTestImpl implements ISpiTest {
    @Override
    public void doTest() {
        System.out.println("Execute DefaultSpiTestImpl");
    }
}
