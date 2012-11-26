package classes;

/**
 *
 * @author jps5481
 */
public class SelectCommand implements AbstractCommand {

    public SelectCommand() {
    }

    @Override
    public void redo(Notes n, Word w) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void undo(Notes n, Word w) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
