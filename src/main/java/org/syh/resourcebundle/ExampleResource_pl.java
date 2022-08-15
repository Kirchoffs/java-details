package org.syh.resourcebundle;

import java.math.BigDecimal;
import java.util.ListResourceBundle;

public class ExampleResource_pl extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                { "greeting", "cześć" },
                { "language", "polish" },
        };
    }
}
