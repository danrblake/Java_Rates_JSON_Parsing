import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
public class JSONFileTester {

    private String filePath = "resources/rates.json";
    private JSONObject JSONFile;
    private JSONObject allRates;
    private RatesParser ratesParser;
    private Set<String> rateKeySet;
    private Object[] rateArray;

    @Before
    public void setUp() {
        ratesParser = new RatesParser(filePath);
        allRates = (JSONObject) ratesParser.getAllRates();
        JSONFile = ratesParser.getFile();
        rateKeySet = allRates.keySet();
        rateArray = rateKeySet.toArray();

    }

    @Test
    public void checkAllRatesPresent() {
        for (int i = 0; i < rateArray.length; i++) {
            assertTrue(allRates.containsKey(rateArray[i]));
        }
    }

    @Test
    public void checkAllRatesHaveRateValue() {
        for (int i = 0; i < rateArray.length; i++) {
            assertNotEquals(null, allRates.get(rateArray[i].toString()));
        }
    }
    @Test
    public void testDuplicateCountryCodes() {
        boolean checkedDuplicates = false;
        boolean duplicates = false;
        for (int i = 0; i < rateArray.length; i++) {
            for (int j = i + 1; j < rateArray.length; j++) {
                if (rateArray[i].equals(rateArray[j])) {
                    duplicates = true;
                }
            }
            checkedDuplicates = true;
        }
        assertFalse(duplicates);
        assertTrue(checkedDuplicates);
    }

    @Test
    public void testAllGetters(){
        assertTrue( ratesParser.getJSONSuccess());
        assertEquals("EUR",ratesParser.getBaseCurrency());
        assertEquals("2018-10-10", ratesParser.getRatesDate());
        assertEquals(1539182646, ratesParser.getTimeStamp(), 0.000000000);
    }

    @Test
    public void testInvalidKey(){
        assertFalse(allRates.containsKey("AAA"));
    }
}
