package lw01.prelab;

class MonoPrint extends PrintJob {

    MonoPrint(String id, int pages) {
        super(id, pages);
    }
    
    @Override 
    public int calculateCharge() {
        return 500 * getPages();
    }

    public String label() {
        return "Mono";
    }
}
