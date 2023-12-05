package mintychochip.tulip.util;

import mintychochip.tulip.Elements;
import mintychochip.tulip.container.ChemicalCompound;

public class FormulaParser {

    public static ChemicalCompound parseCurrentFormula(String chemicalFormula) { //parses it in the form of GOLD2LAPIS3 etc
        ChemicalCompound chemicalCompound = null;
        if (chemicalFormula != null) {
            chemicalCompound = new ChemicalCompound();
            StringBuilder element = new StringBuilder();
            for (char c : chemicalFormula.toCharArray()) {
                if (Character.isDigit(c)) {
                    chemicalCompound.getParsedElements().put(Enum.valueOf(Elements.class, element.toString().toUpperCase()), (int) c);
                    element.delete(0, element.length() - 1);
                } else {
                    element.append(c);
                }
            }
        }
        return chemicalCompound;
    }

}
