package org.syh.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiDemo {
    private static void doTest(ISpiTest iSpiTest) {
        iSpiTest.doTest();
    }

    public static void main(String[] args) {
        ServiceLoader<ISpiTest> serviceLoader = ServiceLoader.load(ISpiTest.class);
        Iterator<ISpiTest> iSpiTestIterator = serviceLoader.iterator();
        while (iSpiTestIterator.hasNext()) {
            ISpiTest iSpiTest = iSpiTestIterator.next();
            doTest(iSpiTest);
        }
    }
}
