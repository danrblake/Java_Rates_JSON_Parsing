public class RatesMain {

    public static void main(String args[]){

        RateFileReader rateFileReader = new RateFileReader("resources/rates.json");
        RatesParser ratesParser = new RatesParser("resources/rates.json");
        System.out.println(ratesParser.getJSONSuccess());
    }
}
