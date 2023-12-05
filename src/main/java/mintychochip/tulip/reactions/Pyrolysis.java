package mintychochip.tulip.reactions;

import mintychochip.tulip.ChemicalRegistry;
import mintychochip.tulip.container.ChemicalCompound;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Pyrolysis extends Decomposition {

    int duration;

    public Pyrolysis(ChemicalCompound chemicalCompound) {
        super(chemicalCompound);
    }

    @Override
    public List<ChemicalCompound> reduction(ItemStack itemStack) { //takes a chemicalCompound and converts it to two
        if (ChemicalRegistry.getChemicalCompoundMap().containsKey(itemStack.getType())) {
            ChemicalCompound chemicalCompound = ChemicalRegistry.getChemicalCompoundMap().get(itemStack.getType());
            chemicalCompound.getParsedElements();
        }

        return null;
    }
}
