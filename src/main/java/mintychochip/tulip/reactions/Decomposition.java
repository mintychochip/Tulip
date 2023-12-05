package mintychochip.tulip.reactions;

import mintychochip.tulip.container.ChemicalCompound;

import java.util.List;

public abstract class Decomposition { //all decomposition steps take one chemial compound

    private final ChemicalCompound chemicalCompound;

    public Decomposition(ChemicalCompound chemicalCompound) {
        this.chemicalCompound = chemicalCompound;
    }

    public abstract List<ChemicalCompound> reduction();

    public ChemicalCompound getChemicalCompound() {
        return chemicalCompound;
    }
}
