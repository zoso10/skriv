package classes;

/**
 *
 * @author jps5481
 */
public class StrikethroughCommand implements AbstractCommand {

    public StrikethroughCommand() {
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
