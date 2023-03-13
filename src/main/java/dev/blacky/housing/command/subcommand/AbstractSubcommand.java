package dev.blacky.housing.command.subcommand;

import dev.blacky.housing.Housing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.command.CommandSender;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractSubcommand {
    public final Housing plugin;
    @Getter
    @Setter
    private String permission;

    public abstract void execute(CommandSender sender, String[] args);

    public abstract List<String> tabComplete(String[] args);
}
