package xyz.nowaha.nlib.utils;

import java.util.ArrayList;
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

    public static List<String> replaceInList(List<String> into, String replace, List<String> with) {
        List<String> old = into;
        List<String> newList = new ArrayList(old);

        for (int i = 0; i < old.size(); ++i) {
            String oldLine = old.get(i);
            if (oldLine.toLowerCase().contains(replace.toLowerCase())) {
                newList.remove(i);
                newList.addAll(i, with.stream().map((String it) -> oldLine.replace(replace, it)).toList());
                break;
            }
        }

        return newList;
    }

}
