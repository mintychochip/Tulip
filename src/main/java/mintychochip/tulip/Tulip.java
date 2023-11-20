package mintychochip.tulip;

import mintychochip.tulip.tasks.FlagRefresh;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tulip extends JavaPlugin {

    private static Tulip instance;

    public static Tulip getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onEnable() {
        instance = this;
        FlagRefresh flagRefresh = new FlagRefresh();
    }
}
