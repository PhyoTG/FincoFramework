package Framework.Proxy.Functor;

import java.util.Stack;

public class PostFunctor implements Functor{
	
	Stack<Object> operationHistory;
	
	public PostFunctor() {
		operationHistory = new Stack<>();
	}
	
	@Override
	public void doProxyAction(Object ob) {
		operationHistory.push(ob);
	}
	
}
