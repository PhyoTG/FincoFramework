package Framework.Proxy;
import Framework.Interface.AccountService;
import Framework.Proxy.Functor.Functor;
import Framework.Proxy.Functor.PostFunctor;
import Framework.Proxy.Functor.PreFunctor;

public class AccountProxy implements AccountService{

	AccountOperation service;
	
	Functor pre;
	Functor post;
	
	public AccountProxy(AccountOperation accOps) {
		service =  accOps;
		pre = new PreFunctor();
		post= new PostFunctor();
	}

	@Override
	public void doAction(String action) {
		pre.doProxyAction(new Object());
		service.doAction(action);
		post.doProxyAction("Doing "+action);
	}
	
	
	
}
