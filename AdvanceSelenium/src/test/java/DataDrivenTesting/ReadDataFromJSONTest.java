package DataDrivenTesting;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class ReadDataFromJSONTest {
        public static void main(String[] args) throws Throwable{
        	
        	
        	JSONParser parser = new JSONParser();
        	Object obj = parser.parse(new FileReader("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\New Text Document (3).txt"));
        	JSONObject map = (JSONObject)obj;
        	System.out.println(map.get("url"));
        	System.out.println(map.get("browser"));
        	System.out.println(map.get("username"));
        	System.out.println(map.get("password"));
        	System.out.println(map.get("timeOut"));
        	
        }
}
