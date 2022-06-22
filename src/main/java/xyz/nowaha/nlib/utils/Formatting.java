package xyz.nowaha.nlib.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Formatting {

    public static List<String> format(List<String> strings, String... variables) {
        return strings.stream()
                .map(str -> format(str, variables))
                .collect(Collectors.toList());
    }

    public static String format(String string, String... variables) {
        for (int i = 0; i < variables.length; i += 2) {
            String first = variables[i];
            String second = variables[i + 1];
            string = string.replace(first, second == null ? "[undefined]" : second);
        }
        return string;
    }

}
