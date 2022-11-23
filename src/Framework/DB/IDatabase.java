package Framework.DB;

import org.json.simple.JSONObject;

public interface IDatabase {
	public void write(String path, JSONObject jsonObject);
	public JSONObject read(String path);
}
