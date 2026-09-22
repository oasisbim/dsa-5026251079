package lw01.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days, int units) {
        super(id, days, units);
    }
    public int calculateCharge(){
        return (15000 + (35000*Math.min(getDays(), 3) + Math.max(getDays() - 3, 0)*25000)) * getUnits();
    }

    public String label(){
        return "Car";
    }
}
