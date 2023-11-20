package mintychochip.tulip.util;

import org.bukkit.Material;
import org.bukkit.block.Biome;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static List<Material> materialListContains(String charsequence) {
        List<Material> materialList = null;
        for (Material value : Material.values()) {
            if (value.toString().contains(charsequence.toUpperCase())) {
                if (materialList == null) {
                    materialList = new ArrayList<>();
                }
                materialList.add(value);
            }
        }
        return materialList;
    }

    public static List<Biome> biomeListContains(String charsequence) {
        List<Biome> materialList = null;
        for (Biome value : Biome.values()) {
            if (value.toString().contains(charsequence.toUpperCase())) {
                if (materialList == null) {
                    materialList = new ArrayList<>();
                }
                materialList.add(value);
            }
        }
        return materialList;
    }
}
