package mintychochip.orchid.config;

import mintychochip.orchid.util.ConfigReader;

public class SpellConfig {

    private final ConfigReader c;

    public SpellConfig() {
        c = new ConfigReader("spells.yml"); //make a manager to find all the yml files
    }
}
