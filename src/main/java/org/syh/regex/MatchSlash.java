package org.syh.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchSlash {
    public static String projectPath = System.getProperty("user.dir");
    public static String resourcePath = projectPath + "/src/main/resources";

    public static void main(String[] args) throws Exception {
        String fileName = "match-slash";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(resourcePath + "/" + fileName));
        String content = bufferedReader.readLine();
        System.out.println(content);

        String replacedContentAlpha = content.replaceAll("\\\\", "c");
        System.out.println(replacedContentAlpha);

        String regex = "\\\\";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        String replacedContentBeta = matcher.replaceAll("c");
        System.out.println(replacedContentBeta);
    }
}
