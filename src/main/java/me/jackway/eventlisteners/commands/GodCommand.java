package me.jackway.eventlisteners.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings)
    {
        if(sender instanceof Player p)
        {
            if (p.hasPermission("EventListeners.god"))
            {
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "God mode disabled");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "God mode enabled");
                }
            }
            else
            {
                p.sendMessage(ChatColor.RED + "You do not have the required permission for that command.");
            }
        }
        return true;
    }
}
