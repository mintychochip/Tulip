package mintychochip.orchid.sequencer;

import mintychochip.orchid.container.OrchidSpell;
import org.bukkit.inventory.meta.BookMeta;

import javax.swing.text.AbstractDocument;
import java.util.*;

public class BookReader {

    private BookMeta bookMeta;

    private Map<Integer,String> content;

    private Map<String, OrchidSpell> readContent;
    public BookReader(BookMeta bookMeta) {
        this.bookMeta = bookMeta;
        if(bookMeta.hasPages()) {
            content = new HashMap<>();
            setup();
        }
    }

    public void setup() {
        int count = 0;
        for (String page : bookMeta.getPages()) {
            content.put(count++, page);
        }
    }

    public String getPage(int num) {
        return content.get(num);
    }
    public List<String> getPages() {
        return new ArrayList<>(content.values());
    }



}
