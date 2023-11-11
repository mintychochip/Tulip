package mintychochip.orchid;

import mintychochip.orchid.handelr.ProjectileHandler;
import mintychochip.orchid.listener.PlayerListener;
import mintychochip.orchid.registry.OrchidRegistry;
import mintychochip.orchid.spellcaster.OrchidCaster;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Orchid extends JavaPlugin {

    @Override
    public void onEnable() {
        ProjectileHandler projectileHandler = new ProjectileHandler();
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(),this);
        OrchidRegistry registry = new OrchidRegistry();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
