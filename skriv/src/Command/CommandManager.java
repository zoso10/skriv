package Command;

import java.util.Stack;

/**
 *
 * @author jps5481
 */
public class CommandManager {

    Stack<Command> back;
    Stack<Command> forward;

    /**
     * Default Constructor
     */
    public CommandManager() {
        back = new Stack();
        forward = new Stack();
    }

    /**
     * Executes a given command.
     *
     * @param cmd
     */
    public void executeCmd(Command cmd) {
        back.push(cmd);
    }

    /**
     * Goes back one Command and returns the latest Command.
     *
     * @return
     */
    public Command goBack() {
        forward.push(back.peek());
        back.pop();
        return forward.peek();
    }

    /**
     * Goes forward one Command and returns the latest Command.
     *
     * @return
     */
    public Command goForward() {
        back.push(forward.peek());
        forward.pop();
        return back.peek();
    }
}
