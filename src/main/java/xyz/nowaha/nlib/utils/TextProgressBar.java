package xyz.nowaha.nlib.utils;

import org.bukkit.ChatColor;

public class TextProgressBar {

    public static String create(double progress, int width) {
        return create(progress, width, "#");
    }

    public static String create(double progress, int width, String character) {
        return create(progress, width, character, String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.RED));
    }

    public static String create(double progress, int width, String character, String completed, String uncompleted) {
        StringBuilder res = new StringBuilder();
        boolean switched = false;

        completed = Coloring.color(completed);
        uncompleted = Coloring.color(uncompleted);

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
