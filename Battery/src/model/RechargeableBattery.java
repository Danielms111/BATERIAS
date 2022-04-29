package model;

public class RechargeableBattery extends Battery {
    public final static char BATTERY_LITIO = 'l';
    public final static char BATTERY_NIQUEL_CADIO = 'n';
    public final static double FACTOR_LITIO = 0.92;
    public final static double FACTOR_NIQUEL_CADIO = 0.80;

    private int chargerNumber;

    private char type;

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {

        super(name, voltage, cost, capacity);

        this.chargerNumber = chargerNumber;

        this.type = type;
    }

    public double calculateUsefulLife(){

        double factor = 0;

        if(type == BATTERY_LITIO){

            factor = FACTOR_LITIO;

        }if(type == BATTERY_NIQUEL_CADIO){

            factor = FACTOR_NIQUEL_CADIO;
        }

        double usefulLife = (cost*voltage*capacity)/(1000*chargerNumber*factor);

        return usefulLife;
    }
    

    /**
     * @return int return the chargerNumber
     */
    public int getChargerNumber() {
        return chargerNumber;
    }

    /**
     * @param chargerNumber the chargerNumber to set
     */
    public void setChargerNumber(int chargerNumber) {
        this.chargerNumber = chargerNumber;
    }

    /**
     * @return char return the type
     */
    public char getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(char type) {
        this.type = type;
    }

    public String toString(){

        return "Bateria recargable" + "\n" + name + "\n" + calculateUsefulLife();
    }

}
