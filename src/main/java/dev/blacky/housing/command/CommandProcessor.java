package dev.blacky.housing.command;

import dev.blacky.housing.Housing;
import dev.blacky.housing.command.subcommand.AbstractSubcommand;
import dev.blacky.housing.util.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandProcessor extends BukkitCommand {
    private final Housing plugin;
    private final Map<String, AbstractSubcommand> subCommands;

    public CommandProcessor(Housing plugin) {
        super("housing", "Housing system", "/housing help", List.of("h"));
        this.setPermission("housing.command");
        this.plugin = plugin;
        this.subCommands = new HashMap<>();

        this.registerSubCommand();
    }

    private void registerSubCommand() {

    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            ChatUtils.sendError(sender, "You don't have permission to execute this command!");
            return false;
        }

        if (args.length == 0) {
            ChatUtils.sendError(sender, "Please use /housing help to see all commands!");
            return false;
        }

        String command = args[0];

        if (!subCommands.containsKey(command)) {
            ChatUtils.sendError(sender, "Unknown command!");
            return false;
        }

        try {
            AbstractSubcommand subCommand = subCommands.get(command);

            if (!sender.hasPermission(subCommand.getPermission())) {
                ChatUtils.sendError(sender, "You don't have permission to execute this command!");
                return false;
            }

            subCommand.execute(sender, args);
        } catch (Exception e) {
            ChatUtils.sendError(sender, "An error occurred while executing this command! Please contact an administrator!");
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        if (args.length == 0 || args.length == 1) {
            return getCompletion(this.subCommands.keySet().stream().toList(), args);
        }

        String subCommand = args[0];

        if (this.subCommands.containsKey(subCommand)) {
            String[] newArgs = new String[args.length - 1];
            System.arraycopy(args, 1, newArgs, 0, args.length - 1);

            return getCompletion(this.subCommands.get(subCommand).tabComplete(newArgs), args);
        }

        return List.of();
    }

    private List<String> getCompletion(List<String> arguments, String[] args) {
        List<String> results = new ArrayList<>();
        for (String argument : arguments) {
            if (!argument.toLowerCase().startsWith(args[args.length - 1].toLowerCase())) continue;
            results.add(argument);
        }
        return results;
    }
}
