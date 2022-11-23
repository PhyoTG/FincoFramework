package Framework.DB;

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Database {

	String path = "./data.json";
	
    public void write(String path, JSONObject jsonObject) {
        if (path == null) {
            path = this.path;
        }

        try {
            FileWriter file = new FileWriter(path);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
        }
    }
	
}
