package mintychochip.orchid.config;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.OrchidMechanicSettings;
import mintychochip.orchid.util.ConfigReader;
import org.bukkit.configuration.ConfigurationSection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

public class MechanicConfig {
    enum MechanicSettings {
        KEYWORDS,
        RANGE,
        DURATION,
        COST,
        COOLDOWN,
        DAMAGE

    }

    private final ConfigReader c;

    public MechanicConfig(String file) {
        c = new ConfigReader(file); //make a manager to find all the yml files
    }
    public OrchidMechanicSettings getMechanicSettings(String mechanic) {
        ConfigurationSection configurationSection = c.getConfigurationSection(mechanic);
        if (configurationSection == null) {
            return null;
        }
        OrchidMechanicSettings orchidMechanicSettings = new OrchidMechanicSettings();
        for (String key : configurationSection.getKeys(false)) {
            if (checkInSet(key)) {
                switch (MechanicSettings.valueOf(key.toUpperCase())) {
                    case COST -> orchidMechanicSettings.setCost(configurationSection.getInt(key));
                    case RANGE -> orchidMechanicSettings.setRange(configurationSection.getInt(key));
                    case COOLDOWN -> orchidMechanicSettings.setCooldown(configurationSection.getDouble(key));
                    case DURATION -> orchidMechanicSettings.setDuration(configurationSection.getInt(key));
                    case KEYWORDS -> orchidMechanicSettings.setKeywords(configurationSection.getStringList(key));
                    case DAMAGE -> orchidMechanicSettings.setDamage(configurationSection.getInt(key));
                }
            }
        }
        return orchidMechanicSettings;
    }

    public OrchidMechanic getMechanic(String mechanic) {
        try {
            Class<?> clazz = Class.forName("mintychochip.orchid.spells." + mechanic);
            Constructor<?> constructor = clazz.getConstructor(new Class[]{});
            Object o = constructor.newInstance();
            if(o instanceof OrchidMechanic) {
                return (OrchidMechanic) o;
            }
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public Set<String> getKeys() {
        return c.getConfig().getKeys(false);
    }
    public boolean checkInSet(String value) {
        MechanicSettings mechanicSettings = MechanicSettings.valueOf(value.toUpperCase());
        for (MechanicSettings val : MechanicSettings.values()) {
            if (val == mechanicSettings) {
                return true;
            }
        }
        return false;
    }
}
