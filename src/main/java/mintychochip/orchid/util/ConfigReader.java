package mintychochip.orchid.util;

import mintychochip.orchid.Orchid;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigReader {

    private String fileName;
    private final File file;
    private YamlConfiguration config;

    public ConfigReader(String fileName) {
        file = new File(String.valueOf(Orchid.getInstance()), fileName);

        if (!file.exists()) {

        }

    }
}
