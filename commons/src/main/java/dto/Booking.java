package dto;

public class Booking {

    private String acquirerEmail;
    private String notaryEmail;
    private float amount; //TODO changer par le prix d'un logement

    public Booking() {
    }

    public Booking(String acquirerEmail, String notaryEmail, float amount) {
        this.acquirerEmail = acquirerEmail;
        this.notaryEmail = notaryEmail;
        this.amount = amount;
    }

    public String getAcquirerEmail() {
        return acquirerEmail;
    }

    public void setAcquirerEmail(String acquirerEmail) {
        this.acquirerEmail = acquirerEmail;
    }

    public String getNotaryEmail() {
        return notaryEmail;
    }

    public void setNotaryEmail(String notaryEmail) {
        this.notaryEmail = notaryEmail;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
