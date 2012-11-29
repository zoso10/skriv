package Command;

/**
 *
 * @author jps5481
 */
public interface Command {

    /**
     * Method to execute or redo a Command.
     */
    public void redo();

    /**
     * Method to undo a Command.
     */
    public void undo();
}
