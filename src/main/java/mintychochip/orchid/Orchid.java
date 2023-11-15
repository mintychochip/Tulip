package mintychochip.orchid;

import mintychochip.orchid.config.KeywordConfig;
import mintychochip.orchid.handler.ProjectileHandler;
import mintychochip.orchid.listener.PlayerListener;
import mintychochip.orchid.registry.OrchidRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Orchid extends JavaPlugin {

    private static KeywordConfig keywordConfig;
    private static Orchid instance;

    public static KeywordConfig getKeywordConfig() {
        return keywordConfig;
    }

    public static Orchid getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onEnable() {
        instance = this;
        ProjectileHandler projectileHandler = new ProjectileHandler();
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(),this);
        keywordConfig = new KeywordConfig("keywords.yml");
        OrchidRegistry registry = new OrchidRegistry();

    }
}
