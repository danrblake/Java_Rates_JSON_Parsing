import org.json.simple.JSONObject;
public class RatesParser {

    JSONObject rates;

   public RatesParser(String filePath){
        RateFileReader rateFileReader = new RateFileReader(filePath);
        rates = rateFileReader.getFullJSONFile();
    }

    private Object getJSONValue(String key){return rates.get(key);}

    public String getJSONSuccess(){
       return getJSONValue("success").toString();
    }



}
