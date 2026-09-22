package lw01.unguided;

public class MotorcycleWash extends WashService {
    public MotorcycleWash(String id, int days, int units) {
        super(id, days, units);
    }
    public int calculateCharge(){
        return (5000 + (15000 * getDays()))*getUnits();
    }
    
    public String label(){
        return "Motorcycle";
    }
}
