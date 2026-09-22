package lw01.unguided;

abstract class WashService implements Billable {
    private String id;
    private int days;
    private int units;

    protected WashService(String id, int days, int units) {
        this.id = id;
        this.days = days;
        this.units = units;
    }

    public String getId() {
        return id;
    }
    public int getDays() {
        return days;
    }
    public int getUnits(){
        return units;
    }

    
    public int calculateCharge() {
        return 0;
    }
    public int calculateCharge(int units) {
        return units * calculateCharge();
    }

    public String label(){
        return "Service";
    }
    public String summary(){
        return getId() + " | " + label() + " | " + calculateCharge();
    }
}