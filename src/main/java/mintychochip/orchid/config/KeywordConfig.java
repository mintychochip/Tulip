package mintychochip.orchid.config;

import mintychochip.orchid.container.Keyword;
import mintychochip.orchid.container.Modifier;
import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.util.ConfigReader;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class KeywordConfig { //will add mechanics config,cost,cooldown, and projectile alias
    //can add numerical, probably want to rename it though
    private final ConfigReader c;

    public KeywordConfig(String fileName) {
        c = new ConfigReader(fileName);
    }

    public Map<String, Modifier> modifiers() {
        ConfigurationSection configurationSection = getConfigurationSection("modifier");
        Map<String, Modifier> modifiers = new HashMap<>();
        for (String key : configurationSection.getKeys(false)) {
            Modifier modifier = Modifier.valueOf(key);
            for (String s : configurationSection.getStringList(key)) {
                modifiers.put(s, modifier);
            }
        }
        return modifiers;
    }

    public Map<String, Keyword> keywords() {
        ConfigurationSection configurationSection = getConfigurationSection("keyword");
        Map<String, Keyword> keywords = new HashMap<>();
        for (String key : configurationSection.getKeys(false)) {
            Keyword keyword = Keyword.valueOf(key);
            for (String s : configurationSection.getStringList(key)) {
                keywords.put(s, keyword);
            }
        }
        return keywords;
    }

    public Map<String, Shape> shapes() {
        ConfigurationSection configurationSection = getConfigurationSection("shape");
        Map<String, Shape> shapes = new HashMap<>();
        for (String key : configurationSection.getKeys(false)) {
            Shape shape = Shape.valueOf(key);
            for (String s : configurationSection.getStringList(key)) {
                shapes.put(s, shape);
            }
        }
        return shapes;
    }

    public ConfigurationSection getConfigurationSection(String header) {
        return c.getConfig().getConfigurationSection(header);
    }
}
