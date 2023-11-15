package mintychochip.orchid.container;

import mintychochip.orchid.sequencer.BookReader;
import mintychochip.orchid.sequencer.PageSequencer;

import java.util.ArrayList;
import java.util.List;

public class OrchidBook {

    private final BookReader bookReader;

    private List<OrchidSpell> spellList;

    public OrchidBook(BookReader bookReader) {
        this.bookReader = bookReader;
        if (bookReader.hasPages()) {
            for (String page : bookReader.getPages()) {
                if (spellList == null) {
                    spellList = new ArrayList<>();
                }
                spellList.add(new PageSequencer(page).getMainSpell());
            }
        }
    }

    public OrchidSpell getSpell(int page) {
        return spellList.get(page);
    }
}
