package dto;

public class CallForFunds {

    private float amount;
    private String ribDebtor;
    private String ribCreditor;
    private String reason;

    public CallForFunds() {
    }

    public CallForFunds(float amount, String ribDebtor, String ribCreditor, String reason) {
        this.amount = amount;
        this.ribDebtor = ribDebtor;
        this.ribCreditor = ribCreditor;
        this.reason = reason;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getRibDebtor() {
        return ribDebtor;
    }

    public void setRibDebtor(String ribDebtor) {
        this.ribDebtor = ribDebtor;
    }

    public String getRibCreditor() {
        return ribCreditor;
    }

    public void setRibCreditor(String ribCreditor) {
        this.ribCreditor = ribCreditor;
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
                ", ribDebtor='" + ribDebtor + '\'' +
                ", ribCreditor='" + ribCreditor + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
