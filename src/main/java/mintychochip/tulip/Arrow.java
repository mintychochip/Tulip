package mintychochip.tulip;

public enum Arrow {
    EXPLOSION,
    WEB;

    private final int ID;

    Arrow(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
