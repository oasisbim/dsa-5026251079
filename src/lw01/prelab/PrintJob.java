package lw01.prelab;

abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    PrintJob(String id, int pages) {
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return this.id;
    }

    public int getPages() {
        return this.pages;
    }

    @Override 
    public int calculateCharge() {
        return 0;
    }

    //"copies" means how many the documents get copied. one document has many pages. copies are different from pages.
    public int calculateCharge(int copies) {
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
