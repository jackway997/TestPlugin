package me.jackway.eventlisteners.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class XPBottleBreakListener implements Listener
{
    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e)
    {
        e.setShowEffect(false);

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        System.out.println("A player has joined the server.");
        event.setJoinMessage("Welcome to the server "+ event.getPlayer().getName() +", you absolute ducking duckhead");
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event)
    {
        Player player = event.getPlayer();
        player.sendMessage("Get out of bed you fat shit");
    }
}
