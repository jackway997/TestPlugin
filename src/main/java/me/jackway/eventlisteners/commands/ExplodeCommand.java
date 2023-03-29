package me.jackway.eventlisteners.commands;

import me.jackway.eventlisteners.EventListeners;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ExplodeCommand implements CommandExecutor
{
    Plugin plugin = EventListeners.getPlugin(EventListeners.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings)
    {
        String food = plugin.getConfig().getString("Food");

        if (sender instanceof Player p)
        {
            p.sendMessage(food);
        }
        return true;
    }
}
