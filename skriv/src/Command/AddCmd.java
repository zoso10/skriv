package Command;

import classes.Notes;
import classes.Word;

/**
 *
 * @author jps5481
 */
public class AddCmd implements Command {

    Notes n;
    Word w;

    public AddCmd(Notes ni, Word wi) {
        n = ni;
        w = wi;
    }

    @Override
    public void redo() {
        n.addWord(w);
    }

    @Override
    public void undo() {
        n.removeLastWord();
    }
}
