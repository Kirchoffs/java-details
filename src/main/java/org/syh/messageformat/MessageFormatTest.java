package org.syh.messageformat;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class MessageFormatTest {
    public static void main(String[] args) {
        String pattern = "On {0, date}, {1} sent you "
                + "{2, choice, 0#no messages|1#a message|2#two messages|2<{2, number, integer} messages}.";

        MessageFormat formatter = new MessageFormat(pattern, Locale.UK);

        String message = formatter.format(new Object[] {new Date(), "Alice", 2});
        System.out.println(message);
    }
}
