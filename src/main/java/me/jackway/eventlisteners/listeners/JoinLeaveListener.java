package me.jackway.eventlisteners.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

// Adding comments

public class JoinLeaveListener
{
    @EventHandler
    public void onLeave(PlayerQuitEvent e)
    {
        Player player = e.getPlayer();
        e.setQuitMessage(player.getDisplayName() + " has left, go steal their stuff.");
    }
}
