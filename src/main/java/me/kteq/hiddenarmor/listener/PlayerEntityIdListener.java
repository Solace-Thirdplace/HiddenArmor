package me.kteq.hiddenarmor.listener;

import me.kteq.hiddenarmor.HiddenArmor;
import me.kteq.hiddenarmor.manager.PlayerManager;
import me.kteq.hiddenarmor.util.EventUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/** Keeps {@link PlayerManager}'s entity id lookup current; these events run on the player's thread. */
public class PlayerEntityIdListener implements Listener {
    private final PlayerManager playerManager;

    public PlayerEntityIdListener(HiddenArmor plugin) {
        EventUtil.register(this, plugin);
        this.playerManager = plugin.getPlayerManager();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent event) {
        playerManager.trackEntityId(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onQuit(PlayerQuitEvent event) {
        playerManager.untrackEntityId(event.getPlayer());
    }
}
