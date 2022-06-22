package xyz.nowaha.nlib.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Coloring {

    private static final Pattern hexPattern = Pattern.compile("<#([A-Fa-f0-9]){6}>");

    public static String color(String message) {
        Matcher matcher = hexPattern.matcher(message);
        while(matcher.find()) {
            final ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String before = message.substring(0, matcher.start());
            final String after = message.substring(matcher.end());
            message = before + hexColor + after;
            matcher = hexPattern.matcher(message);
        }

        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> color(List<String> strings) {
        return strings.stream()
                .map(Coloring::color)
                .collect(Collectors.toList());
    }

    public static String applyPattern(char[] pattern, String to) {
        if (pattern.length == 0) return to;

        StringBuilder res = new StringBuilder();

        int colorIndex = 0;
        for (char c : to.toCharArray()) {
            res.append(ChatColor.getByChar(pattern[colorIndex]));
            res.append(c);

            colorIndex++;
            if (colorIndex >= pattern.length) {
                colorIndex = 0;
            }
        }

        return res.toString();
    }

}
