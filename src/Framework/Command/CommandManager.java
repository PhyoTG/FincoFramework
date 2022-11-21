package Framework.Command;

import java.util.Stack;

import Framework.Interface.Command;

public class CommandManager {
	
	Stack<Command> historyStack;
	Stack<Command> undoStack;
	
	public CommandManager() {
		this.historyStack = new Stack<Command>();
    	this.undoStack = new Stack<Command>();
	}
	
	public void submit(Command c) {
		c.execute();
		historyStack.push(c);
	}
	
	public void undo() {
    	if(!historyStack.empty()) {
    		Command c =  (Command) historyStack.pop();
    		c.undo();
    		undoStack.push(c);
    	}
	}
	
	public void redo() {
		if(!undoStack.empty()) {
    		Command c =  (Command) undoStack.pop();
    		c.redo();
    	}
	}
}
