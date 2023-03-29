package me.jackway.eventlisteners.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MenuCommand implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;

    public MenuCommand()
    {
        this.cooldown = new HashMap<>();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player p)
        {
            if (!this.cooldown.containsKey(p.getUniqueId())) // player to cooldown list
            {
                this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
            }
            else
            {
                long timeElapsed = System.currentTimeMillis() - cooldown.get(p.getUniqueId());
                if(timeElapsed <= 5000)
                {
                    p.sendMessage("on cooldown: "+ ((5000 - timeElapsed)/1000) +"s");
                    return true;
                }
                else
                {
                    this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                }

            }

            // inventory size is multiples of 9
            Inventory inventory = Bukkit.createInventory(p, 9, ChatColor.GOLD + "Bending Menu");
            ItemStack item = new ItemStack(Material.BOOK, 1);
            ItemMeta itemMeta = item.getItemMeta();

            // set lore
            ArrayList<String> lore = new ArrayList();
            lore.add("Use the powers of the earth ");
            lore.add("to send a powerful shockwave ");
            lore.add("outward from the player.");

            itemMeta.setLore(lore);


            itemMeta.setDisplayName(ChatColor.GREEN + "Earth Shock");
            item.setItemMeta(itemMeta);


            inventory.setItem(0, item);

            p.openInventory(inventory);


        }
        return true;
    }
}
