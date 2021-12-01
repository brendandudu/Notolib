package dto;

public class CallForFunds {

    private double amount;
    private String rib;
    private String reason;

    public CallForFunds() {
    }

    public CallForFunds(double amount, String rib, String reason) {
        this.amount = amount;
        this.rib = rib;
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "CallForFunds{" +
                "amount=" + amount +
                ", rib='" + rib + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
