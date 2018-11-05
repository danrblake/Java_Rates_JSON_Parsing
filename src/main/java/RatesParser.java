import org.json.simple.JSONObject;
public class RatesParser {

    JSONObject rates;
    JSONObject rateValues;

   public RatesParser(String filePath){
        RateFileReader rateFileReader = new RateFileReader(filePath);
        rates = rateFileReader.getFullJSONFile();
    }

    private Object getJSONValue(String key){return rates.get(key);}

    public boolean getJSONSuccess() {
        try {
            return (boolean) getJSONValue("success");
        } catch (NullPointerException e) {
            return (boolean) getJSONValue("success");
        }
    }
    public Double getSpecificRate(String countryCode){
        rateValues = (JSONObject) getJSONValue("rates");
        return Double.parseDouble(rateValues.get(countryCode).toString());
    }

    public Object getAllRates(){
        rates = (JSONObject) getJSONValue("rates");
        return rates;
    }

    public String getRatesDate(){
       return getJSONValue("date").toString();
    }

    public String getBaseCurrency(){
       return getJSONValue("base").toString();
    }

    public double getTimeStamp(){
       return Double.parseDouble(getJSONValue("timestamp").toString());
    }
}
