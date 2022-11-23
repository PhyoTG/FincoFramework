package Framework.DB;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Database implements IDatabase{

	String path = "./data.json";
	
	public Database(){
		this.path = "./data.json";
	}
	
	@Override
    public void write(String path, JSONObject jsonObject) {
		path = "./data.json";
        if (path == null) {
            path = "./data.json";
        }
        System.out.println("Coming");
        System.out.println(jsonObject);
        System.out.println(path);
        try {
            FileWriter file = new FileWriter(path);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
	@Override
    public JSONObject read(String path) {
        JSONParser jsonParser = new JSONParser();

        if (path == null) {
            path = this.path;
        }

        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));

            System.out.println(jsonObject);

            return jsonObject;
        } catch (IOException | org.json.simple.parser.ParseException e) {
        }

        return null;
    }
	
}
