package model;

interface Rechargeable {

    public void calculateUsefulLife();
}

/*class RechargeableBattery implements Rechargeable{

    public void calculateUsefulLife(){

        double factor = 0;

        if(type == BATTERY_LITIO){

            factor = FACTOR_LITIO;

        }if(type == BATTERY_NIQUEL_CADIO){

            factor = FACTOR_NIQUEL_CADIO;
        }

        double usefulLife = (cost*voltage*capacity)/(1000*chargerNumber*factor);

        System.out.println("La vida util de la bateria es: " + usefulLife);
        
    }
}*/

