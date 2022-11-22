package Framework.Default;

public class Auth {
	String PIN = "1234";
	
	public boolean checkPin(String pin) {
		return pin.equals(PIN);
	}
	
}
