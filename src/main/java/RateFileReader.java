import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;
        import org.json.simple.parser.ParseException;

        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
public class RateFileReader {


    JSONObject fullJSONFile = new JSONObject();

    public RateFileReader(String filePath){
        try {
            FileReader ratesJSONFILE = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object ratesObject = parser.parse(ratesJSONFILE);
            fullJSONFile = (JSONObject) ratesObject;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getFullJSONFile() {return fullJSONFile;}
}
