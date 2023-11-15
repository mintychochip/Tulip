package mintychochip.orchid.config;

import mintychochip.orchid.container.Keyword;
import mintychochip.orchid.container.Modifier;
import mintychochip.orchid.util.ConfigReader;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RegistryConfig {
    private ConfigReader c;
    public RegistryConfig(String fileName) {
        c = new ConfigReader(fileName);
        ConfigurationSection mechanics = c.getConfig().getConfigurationSection("mechanics");
    }
    public Map<String,Modifier> getModifiers() {
        ConfigurationSection configurationSection = getConfigurationSection("modifiers");
        Map<String,Modifier> modifiers = new HashMap<>();
        for (String key : configurationSection.getKeys(false)) {
            modifiers.put(key,Modifier.valueOf(configurationSection.getString(key).toUpperCase()));
        }
        return modifiers;
    }
    public Map<String,Keyword> getKeywords() {
        Map<String,Keyword> keywordMap = new HashMap<>();
        for (String keywords : getConfigurationSection("keywords").getKeys(false)) {
            keywordMap.put(keywords, Keyword.valueOf(getConfigurationSection("keywords").getString(keywords).toUpperCase()));
        }
        return keywordMap;

    }
    public ConfigurationSection getConfigurationSection(String header) {
        return c.getConfig().getConfigurationSection(header);
    }
}
