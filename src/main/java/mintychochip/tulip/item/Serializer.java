package mintychochip.tulip.item;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Serializer {

    public static String inventoryToBase64(Inventory inventory) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BukkitObjectOutputStream boos = new BukkitObjectOutputStream(bos);

            boos.writeInt(inventory.getSize());

            for (int i = 0; i < inventory.getSize(); i++) {
                boos.writeObject(inventory.getItem(i));
            }

            boos.close();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save inventory");
        }
    }

    public static byte[] itemStackArrayToBase64(ItemStack[] items) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BukkitObjectOutputStream boos = new BukkitObjectOutputStream(bos);

            boos.writeInt(items.length);

            for (int i = 0; i < items.length; i++) {
                boos.writeObject(items[i]);
            }

            boos.close();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save item stacks");
        }
    }

}
