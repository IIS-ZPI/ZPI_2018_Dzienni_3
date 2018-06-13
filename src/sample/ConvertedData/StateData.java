package sample.ConvertedData;

import java.util.Map;
import java.util.TreeMap;

public class StateData
{
    String stateName;
    String baseTax;
    String localSurTax;
    Map<String, String> productTypeTax = new TreeMap<>();

    public StateData(String stateName){
        this.stateName = stateName;
    }

    public double getBaseTaxConverted()
    {
        baseTax = baseTax.replace("%","");
        double baseTaxConverted = Double.parseDouble(baseTax) / 100;
        return baseTaxConverted;
    }

    @Override
    public String toString(){
        return "Nazwa:" + stateName + " BaseTax:" + baseTax + " LocalSurTax:" + localSurTax;
    }

    public String getStateName() {
        return stateName;
    }

    public String getBaseTax() {
        return baseTax;
    }

    public void addTaxForProductType(String type, String tax){
        productTypeTax.put(type,tax);
    }

    public void setBaseTax(String baseTax) {
        this.baseTax = baseTax;
    }

    public void setLocalSurTax(String localSurTax) {
        this.localSurTax = localSurTax;
    }

}
