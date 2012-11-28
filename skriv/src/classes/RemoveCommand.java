package classes;

/**
 *
 * @author jps5481
 */
public class RemoveCommand implements AbstractCommand {

    Notes notesWhereRemoved;
    Word removedWord;

    public RemoveCommand(Notes n, Word w) {
        notesWhereRemoved = n;
        removedWord = w;
    }

    @Override
    public void redo(Notes n, Word w) {
        n.removeWord(w);
    }

    @Override
    public void undo(Notes n, Word w) {
        n.addWord(w);
    }
}
