package mintychochip.tulip;

import mintychochip.tulip.container.ChemicalCompound;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;

public class ChemicalRegistry {

    private static final Map<Material, ChemicalCompound> chemicalCompoundMap = new HashMap<>();

    private final ShapedRecipe recipe = new ShapedRecipe("asdasd");


    public static Map<Material, ChemicalCompound> getChemicalCompoundMap() {
        return chemicalCompoundMap;
    }
}
