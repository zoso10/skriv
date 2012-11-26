package classes;

/**
 *
 * @author jps5481
 */
public interface AbstractCommand {

    public void redo(Notes n, Word w);

    public void undo(Notes n, Word w);
}
