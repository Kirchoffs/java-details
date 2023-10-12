package org.syh.regex;

import java.io.BufferedReader;
import java.io.FileReader;

public class OtherRegexMatchSample {
    public static String projectPath = System.getProperty("user.dir");
    public static String resourcePath = projectPath + "/src/main/resources";

    public static void main(String[] args) throws Exception {
        RegexMatchSampleA();
    }

    private static void RegexMatchSampleA() throws Exception {
        String fileName = "other-regex-match-sample-a";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(resourcePath + "/" + fileName));
        String content = bufferedReader.readLine();
        System.out.println(content);

        String regex = "\"\\{\\{([^(::)]*)::([^(}})]*)::(boolean|number|string)}}\"";

        String replacedContent = content.replaceAll(regex, "{{$1::$2}}");
        System.out.println(replacedContent);
    }
}
