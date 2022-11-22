package Framework.Proxy.Functor;

import Framework.Default.Auth;

public class PreFunctor implements Functor {
	
	@Override
	public void doProxyAction(Object obj) {
		Auth auth = new Auth();
		auth.checkPin("1234"); 
		// later we will ask with prompt and check the input is correct
	}

}
