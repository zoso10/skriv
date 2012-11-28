package classes;

/**
 *
 * @author jps5481
 */
public class InsertCommand implements AbstractCommand {

    Notes notesWhereInserted;
    Word insertedWord;

    public InsertCommand(Notes n, Word w) {
        notesWhereInserted = n;
        insertedWord = w;
    }

    @Override
    public void redo(Notes n, Word w) {
        n.addWord(w);
    }

    @Override
    public void undo(Notes n, Word w) {
        n.removeWord(w);
    }
}
