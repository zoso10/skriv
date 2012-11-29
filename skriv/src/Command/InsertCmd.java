package Command;

import classes.Notes;
import classes.Word;

/**
 *
 * @author jps5481
 */
public class InsertCmd implements Command {

    private Notes n;
    private Word w;
    private int i;

    public InsertCmd(Notes notePage, Word word, int index) {
        n = notePage;
        w = word;
        i = index;
    }

    @Override
    public void redo() {
        n.insertWord(w, i);
    }

    @Override
    public void undo() {
        n.removeWord(i);
    }
}
