package mintychochip.tulip;

public enum Elements {

    GOLD("Au"),
    IRON("Fe"),
    COAL("C"),
    LAPIS("Lp");

    private final String formula;

    Elements(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }
}
