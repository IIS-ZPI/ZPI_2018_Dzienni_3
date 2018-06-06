package sample;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class StateData {

    String stateName;
    String baseTax;
    String localSurTax;
    Map<String, String> productTypeTax = new TreeMap<>();


    public StateData(String stateName){
        this.stateName = stateName;
    }
    public String getStateName() {
        return stateName;
    }

    public String getBaseTax() {
        return baseTax;
    }

    public String getLocalSurTax() {
        return localSurTax;
    }

    public String getTaxForProductType(String type){
        return productTypeTax.get(type);
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



    @Override
    public String toString(){
        return "Nazwa:" + stateName + " BaseTax:" + baseTax + " LocalSurTax:" + localSurTax;
    }
}
