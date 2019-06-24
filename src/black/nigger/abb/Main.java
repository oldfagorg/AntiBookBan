package black.nigger.abb;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.charset.Charset;
import java.util.Iterator;

/*
    Created by John
    6/23/19
 */

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEdit(PlayerEditBookEvent event) {
        Iterator var2 = event.getNewBookMeta().getPages().iterator();
        while(var2.hasNext()) {
            String page = (String)var2.next();
            if (!Charset.forName("ISO-8859-1").newEncoder().canEncode((page))) {
                event.setCancelled(true);
            }
        }

    }

}