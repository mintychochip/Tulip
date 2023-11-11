package mintychochip.orchid.container;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Context {
    private Player player;
    private Block hitBlock;
    private Entity hitEntity;
    private Location location;

    public Context(Player player, Location location, Block hitBlock, Entity hitEntity) {
        this.player = player;
        this.location = location;
    }

    public Context(Player player, Location location) {
        this(player, location, null, null);
    }

    public Context(Location location) {
        this(null, location);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Block getHitBlock() {
        return hitBlock;
    }

    public void setHitBlock(Block hitBlock) {
        this.hitBlock = hitBlock;
    }

    public Entity getHitEntity() {
        return hitEntity;
    }

    public void setHitEntity(Entity hitEntity) {
        this.hitEntity = hitEntity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
