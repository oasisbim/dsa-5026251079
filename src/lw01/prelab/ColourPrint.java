package lw01.prelab;

class ColourPrint extends PrintJob {

    ColourPrint(String id, int pages) {
        super(id, pages);
    }
    
    @Override 
    public int calculateCharge() {
        // setup + cost of first 10 pages + cost of the rest
        return 2000 + (Math.min(getPages(), 10) * 1500 + Math.max(0, (getPages()-10)) * 1000);
    }

    public String label() {
        return "Colour";
    }

}