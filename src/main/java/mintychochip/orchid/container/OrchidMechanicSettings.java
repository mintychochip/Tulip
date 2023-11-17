package mintychochip.orchid.container;

import java.util.List;

public class OrchidMechanicSettings {
    private boolean isMagnitudeAffectable;
    private int range;
    private double duration;
    private int cost;
    private double cooldown;
    private boolean isCantrip;
    public boolean isMagnitudeAffectable() {
        return isMagnitudeAffectable;
    }
    private List<String> keywords;

    public int getRange() {
        return range;
    }

    public double getDuration() {
        return duration;
    }
    private String name;

    public void setMagnitudeAffectable(boolean magnitudeAffectable) {
        isMagnitudeAffectable = magnitudeAffectable;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public boolean isCantrip() {
        return isCantrip;
    }

    public void setCantrip(boolean cantrip) {
        isCantrip = cantrip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
