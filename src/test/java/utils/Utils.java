package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void saveEmployeeInfo(String firstName, String lastName, String username, String password) throws IOException, ParseException {
        String file= "./src/test/resources/employees.json";
        JSONParser jsonParser= new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(file));
        JSONObject empObj = new JSONObject();
        empObj.put("firstName",firstName);
        empObj.put("lastName",lastName);
        empObj.put("username",username);
        empObj.put("password",password);

        jsonArray.add(empObj);

        FileWriter writer=new FileWriter(file);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static JSONArray readEmployeeInfo() throws IOException, ParseException {
        String file= "./src/test/resources/employees.json";
        JSONParser parser= new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(file));
        return jsonArray;

    }
}
