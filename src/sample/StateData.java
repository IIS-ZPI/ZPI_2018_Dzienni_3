package sample;

public class StateData {

    String stateName;
    String baseTax;
    String localSurTax;

    public String getStateName() {
        return stateName;
    }

    public String getBaseTax() {
        return baseTax;
    }

    public String getLocalSurTax() {
        return localSurTax;
    }

    public StateData(String stateName){
        this.stateName = stateName;
    }

    public void setBaseTax(String baseTax) {
        this.baseTax = baseTax;
    }

    public void setLocalSurTax(String localSurTax) {
        this.localSurTax = localSurTax;
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
}
