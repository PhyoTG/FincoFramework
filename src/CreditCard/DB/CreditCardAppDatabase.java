package CreditCard.DB;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Framework.DB.IDatabase;

public class CreditCardAppDatabase implements IDatabase {
	
	String path = "./bank-data.json";
	
	public CreditCardAppDatabase(){
		this.path = "./credit-data.json";
	}
	
	@Override
	public void write(String path, JSONObject jsonObject) {
		System.out.println("From App Level DB write");
		if (path == null) {
            path = "./data.json";
        }
        System.out.println("Coming Credit APP Database");
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
        	e.printStackTrace();
        }

        return null;
	}

}
