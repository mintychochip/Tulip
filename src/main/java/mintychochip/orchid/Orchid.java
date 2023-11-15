package mintychochip.orchid;

import mintychochip.orchid.config.RegistryConfig;
import mintychochip.orchid.handler.ProjectileHandler;
import mintychochip.orchid.listener.PlayerListener;
import mintychochip.orchid.registry.OrchidRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Orchid extends JavaPlugin {

    private static RegistryConfig registryConfig;
    private static Orchid instance;
    @Override
    public void onEnable() {
        instance = this;
        ProjectileHandler projectileHandler = new ProjectileHandler();
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(),this);
        registryConfig = new RegistryConfig("keywords.yml");
        OrchidRegistry registry = new OrchidRegistry();

    }

    public static Orchid getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static RegistryConfig getRegistryConfig() {
        return registryConfig;
    }
}
