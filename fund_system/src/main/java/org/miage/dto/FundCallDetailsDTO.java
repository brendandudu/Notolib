package org.miage.dto;

public class FundCallDetailsDTO {

    private  String acquirerEmail;
    private  String notaryEmail;

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

    @Override
    public String toString() {
        return "FundCallDetailsDTO{" +
                "acquirerEmail='" + acquirerEmail + '\'' +
                ", notaryEmail='" + notaryEmail + '\'' +
                '}';
    }
}
