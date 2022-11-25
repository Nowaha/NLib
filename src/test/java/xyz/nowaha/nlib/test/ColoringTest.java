package xyz.nowaha.nlib.test;

import org.bukkit.ChatColor;
import org.junit.jupiter.api.Test;
import xyz.nowaha.nlib.utils.Coloring;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColoringTest {

    @Test
    public void testColorStringNoColor() {
        assertEquals("Hello!", Coloring.color("Hello!"));
        assertEquals("Hello !", Coloring.color("Hello !"));
        assertEquals("Hello !  ", Coloring.color("Hello !  "));
        assertEquals("   Hello !  ", Coloring.color("   Hello !  "));
        assertEquals("&zHello!", Coloring.color("&zHello!"));
        assertEquals("&z Hello!", Coloring.color("&z Hello!"));
    }

    @Test
    public void testColorStringListNoColor() {
        var in1 = Arrays.asList("Hello", "world.");
        var in2 = Arrays.asList("Hello ", "world.");
        var in3 = Arrays.asList("Hello", "     worl d.    ");
        var in4 = Arrays.asList("&zHello", "     worl &zd.    ");

        assertEquals(in1, Coloring.color(in1));
        assertEquals(in2, Coloring.color(in2));
        assertEquals(in3, Coloring.color(in3));
        assertEquals(in4, Coloring.color(in4));
    }

    @Test
    public void testColorStringWithColor() {
        assertEquals(ChatColor.GREEN + "Hello!", Coloring.color("&aHello!"));
        assertEquals(ChatColor.YELLOW + " Hello!", Coloring.color("&e Hello!"));
        assertEquals(" " + ChatColor.YELLOW + " Hello!", Coloring.color(" &e Hello!"));
        assertEquals(ChatColor.GREEN + "H" + ChatColor.AQUA + "e" + ChatColor.RED + "l" + ChatColor.LIGHT_PURPLE + "l" + ChatColor.YELLOW + "o!", Coloring.color("&aH&be&cl&dl&eo!"));
        assertEquals(ChatColor.BOLD + "Bold!", Coloring.color("&lBold!"));
        assertEquals("\u00A7x\u00A7F\u00A7F\u00A7F\u00A7F\u00A7F\u00A7FWhite!", Coloring.color("<#FFFFFF>White!"));
        assertEquals("\u00A7x\u00A7F\u00A7F\u00A70\u00A70\u00A70\u00A70Red!", Coloring.color("<#FF0000>Red!"));
        assertEquals("\u00A7x\u00A7F\u00A7F\u00A70\u00A70\u00A70\u00A75Color!", Coloring.color("<#FF0005>Color!"));
        assertEquals("\u00A7x\u00A7F\u00A7F\u00A70\u00A70\u00A70\u00A75Multi\u00A7x\u00A7F\u00A7F\u00A75\u00A7A\u00A70\u00A75color!", Coloring.color("<#FF0005>Multi<#FF5A05>color!"));
    }

    @Test
    public void testColorStringListWithColor() {
        var in1 = Arrays.asList("&aHello", "&bworld.");
        var out1 = Arrays.asList(ChatColor.GREEN + "Hello", ChatColor.AQUA + "world.");
        var in2 = Arrays.asList("&cHello");
        var out2 = Arrays.asList(ChatColor.RED + "Hello");
        var in3 = Arrays.asList("<#FFFFFF>White!", "<#FF0000>Red!");
        var out3 = Arrays.asList("\u00A7x\u00A7F\u00A7F\u00A7F\u00A7F\u00A7F\u00A7FWhite!", "\u00A7x\u00A7F\u00A7F\u00A70\u00A70\u00A70\u00A70Red!");
        var in4 = Arrays.asList("<#FF0005>Multi<#FF5A05>color!", "<#FF0005>Multi<#FF5A05>color!");
        var out4 = Arrays.asList("\u00A7x\u00A7F\u00A7F\u00A70\u00A70\u00A70\u00A75Multi\u00A7x\u00A7F\u00A7F\u00A75\u00A7A\u00A70\u00A75color!", "\u00A7x\u00A7F\u00A7F\u00A70\u00A70\u00A70\u00A75Multi\u00A7x\u00A7F\u00A7F\u00A75\u00A7A\u00A70\u00A75color!");

        assertEquals(out1, Coloring.color(in1));
        assertEquals(out2, Coloring.color(in2));
        assertEquals(out3, Coloring.color(in3));
        assertEquals(out4, Coloring.color(in4));
    }

    @Test
    public void testColorPattern() {
        assertEquals("\u00A7aH", Coloring.applyPattern(new char[] {'a', 'b', 'c'}, "H"));
        assertEquals("\u00A7aH\u00A7be", Coloring.applyPattern(new char[] {'a', 'b', 'c'}, "He"));
        assertEquals("\u00A7aH\u00A7be\u00A7cl", Coloring.applyPattern(new char[] {'a', 'b', 'c'}, "Hel"));
        assertEquals("\u00A7aH\u00A7be\u00A7cl\u00A7al", Coloring.applyPattern(new char[] {'a', 'b', 'c'}, "Hell"));
        assertEquals("\u00A7aH\u00A7be\u00A7cl\u00A7al\u00A7bo", Coloring.applyPattern(new char[] {'a', 'b', 'c'}, "Hello"));
        assertEquals("\u00A7aH\u00A7be\u00A7cl\u00A7al\u00A7bo\u00A7c!", Coloring.applyPattern(new char[] {'a', 'b', 'c'}, "Hello!"));
        assertEquals("\u00A7aH\u00A7be\u00A7cl\u00A7al\u00A7bo\u00A7c \u00A7aw\u00A7bo\u00A7cr\u00A7al\u00A7bd\u00A7c!", Coloring.applyPattern(new char[] {'a', 'b', 'c'}, "Hello world!"));
    }

}
