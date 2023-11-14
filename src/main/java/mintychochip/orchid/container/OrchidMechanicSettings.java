package mintychochip.orchid.container;

public class OrchidMechanicSettings {
    private final boolean isMagnitudeAffectable;
    private final int range;
    private final int duration;

    public OrchidMechanicSettings(boolean isMagnitudeAffectable, int range, int duration) {
        this.isMagnitudeAffectable = isMagnitudeAffectable;
        this.range = range;
        this.duration = duration;
    }

    public boolean isMagnitudeAffectable() {
        return isMagnitudeAffectable;
    }

    public int getRange() {
        return range;
    }

    public int getDuration() {
        return duration;
    }
}
