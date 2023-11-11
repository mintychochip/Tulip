package mintychochip.orchid.container;

public class OrchidSpell {

    private OrchidMechanic mechanic;
    private OrchidSpellSettings orchidSpellSettings;

    public OrchidMechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(OrchidMechanic mechanic) {
        this.mechanic = mechanic;
    }

    public OrchidSpellSettings getOrchidSpellSettings() {
        return orchidSpellSettings;
    }

    public void setOrchidSpellSettings(OrchidSpellSettings orchidSpellSettings) {
        this.orchidSpellSettings = orchidSpellSettings;
    }

}
