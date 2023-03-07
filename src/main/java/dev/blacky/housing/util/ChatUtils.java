package dev.blacky.housing.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class ChatUtils {
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String format(String message) {
        return colorize("&8[&6Housing&8] &7" + message); //TODO replace with config prefix
    }

    public static String formatError(String message) {
        return colorize("&8[&6Housing&8] &c" + message); //TODO replace with config prefix
    }

    public static String formatSuccess(String message) {
        return colorize("&8[&6Housing&8] &a" + message); //TODO replace with config prefix
    }

    public static String formatInfo(String message) {
        return colorize("&8[&6Housing&8] &b" + message); //TODO replace with config prefix
    }

    public static String formatWarning(String message) {
        return colorize("&8[&6Housing&8] &e" + message); //TODO replace with config prefix
    }

    public static void sendInfo(CommandSender sender, String message) {
        sender.sendMessage(formatInfo(message));
    }

    public static void sendSuccess(CommandSender sender, String message) {
        sender.sendMessage(formatSuccess(message));
    }

    public static void sendError(CommandSender sender, String message) {
        sender.sendMessage(formatError(message));
    }

    public static void sendWarning(CommandSender sender, String message) {
        sender.sendMessage(formatWarning(message));
    }
}
