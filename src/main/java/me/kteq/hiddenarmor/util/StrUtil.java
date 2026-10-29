package me.kteq.hiddenarmor.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public abstract class StrUtil {
    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> color(List<String> stringList){
        List<String> coloredStringList = new ArrayList<>();
        for(String s : stringList){
            coloredStringList.add(color(s));
        }
        return coloredStringList;
    }

    /**
     * Same result as commons-lang 2 {@code WordUtils.capitalizeFully(s)} with whitespace delimiters:
     * every word lower-cased, then its first character upper-cased. commons-lang 2 is not on the
     * Paper 26.2 API classpath and is not guaranteed on the server, so the plugin carries its own copy.
     */
    public static String capitalizeFully(String s){
        if (s == null || s.isEmpty()) return s;
        char[] chars = s.toLowerCase().toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isWhitespace(chars[i])) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                chars[i] = Character.toTitleCase(chars[i]);
                capitalizeNext = false;
            }
        }
        return new String(chars);
    }

}
