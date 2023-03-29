package me.jackway.eventlisteners;

import me.jackway.eventlisteners.commands.ExplodeCommand;
import me.jackway.eventlisteners.commands.GodCommand;
import me.jackway.eventlisteners.commands.MenuCommand;
import me.jackway.eventlisteners.files.CustomConfig;
import me.jackway.eventlisteners.listeners.XPBottleBreakListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;

import java.sql.SQLOutput;
import java.util.List;

public final class EventListeners extends JavaPlugin  implements Listener {

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        System.out.println("The event listener test plugin has started.");

        // setup config file
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Setup custom config file
        CustomConfig.setup();
        CustomConfig.get().addDefault("Message", "this is the default message");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

        // register event listeners
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);

        // register commands
        getCommand("god").setExecutor(new GodCommand());
        //getCommand("Explode").setExecutor(new ExplodeCommand());
        getCommand("menu").setExecutor(new MenuCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (command.getName().equals("printMessageFromConfig"))
        {
            if (sender instanceof Player p) {
                String food = getConfig().getString("Food");
                p.sendMessage(ChatColor.DARK_PURPLE + "The food in the config.yml is " + ChatColor.RED + food);
            }
        }
        return true;
    }


}
