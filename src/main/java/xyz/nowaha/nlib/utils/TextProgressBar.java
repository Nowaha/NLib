package xyz.nowaha.nlib.utils;

import org.bukkit.ChatColor;

public class TextProgressBar {

    public static String create(double progress, int width) {
        return create(progress, width, "#");
    }

    public static String create(double progress, int width, String character) {
        return create(progress, width, character, ChatColor.GREEN, ChatColor.RED);
    }

    public static String create(double progress, int width, String character, ChatColor completed, ChatColor uncompleted) {
        StringBuilder res = new StringBuilder();
        boolean switched = false;

        res.append(completed);
        for (int i = 0; i < width; i++) {
            if (!switched && (float) (i) / (float) (width) > progress || (i == width-1 && progress != 1d) || progress == 0) {
                res.append(uncompleted);
                switched = true;
            }

            res.append(character);
        }

        return res.toString();
    }

}
