package Command;

import classes.Notes;
import classes.Word;

/**
 *
 * @author jps5481
 */
public class RemoveCmd implements Command {

    Notes n;
    Word w;
    int i;

    public RemoveCmd(Notes notes, Word word, int index) {
        n = notes;
        w = word;
        i = index;
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
