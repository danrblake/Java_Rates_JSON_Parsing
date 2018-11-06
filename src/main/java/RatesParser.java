import org.json.simple.JSONObject;
public class RatesParser {

    JSONObject rates;
    JSONObject rateValues;

   public RatesParser(String filePath){
        RateFileReader rateFileReader = new RateFileReader(filePath);
        this.rates = rateFileReader.getFullJSONFile();
    }

    public JSONObject getFile(){
       return rates;
    }

    private Object getJSONValue(String key){return rates.get(key);}

    public boolean getJSONSuccess() {
            boolean result;
         result = (Boolean) getJSONValue("success");
            return result;

    }
    public Double getSpecificRate(String countryCode){
        rateValues = (JSONObject) getJSONValue("rates");
        return (Double) (rateValues.get(countryCode));
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
