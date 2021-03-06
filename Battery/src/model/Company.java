package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {

        int battery=0;
        int rechargeableBattery=0;

        for(int i=0;i<MAX_BATTERIES;i++) {

            if(batteries[i] != null && batteries[i] instanceof RechargeableBattery){

                rechargeableBattery++;
            }if(batteries[i] != null && batteries[i] instanceof Battery){

                battery++;
            }

        }

        battery = battery-rechargeableBattery;


    	return "El total de baterias tradicionales es: " + battery + " y el de baterias recargables es: " + rechargeableBattery;
    }
    
    public String showBatteriesInfo() {
    	String str = "";

        for(int i=0;i<MAX_BATTERIES;i++){

            if(batteries[i] != null && batteries[i] instanceof Battery){

                str += batteries[i].toString() + "\n";

            }if(batteries[i] != null && batteries[i] instanceof RechargeableBattery){

                str += batteries[i].toString() + "\n";

            }
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){

        double prom=0;
        int cont = 0;

        for(int i=0;i<MAX_BATTERIES;i++){

            if(batteries[i] != null && batteries[i] instanceof RechargeableBattery){

                cont++;

                prom += ((RechargeableBattery)batteries[i]).calculateUsefulLife();

            }
        }

        prom = prom/cont;

		return prom;
	}

}
