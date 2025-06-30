package stream.three;

public class Transaction {

    private String id;
    private double amount;
    private String curency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurency() {
        return curency;
    }

    public void setCurency(String curency) {
        this.curency = curency;
    }

    public Transaction(String id, double amount, String curency) {
        this.id = id;
        this.amount = amount;
        this.curency = curency;
    }


}
