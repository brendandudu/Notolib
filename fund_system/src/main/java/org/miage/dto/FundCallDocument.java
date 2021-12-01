package org.miage.dto;

public class FundCallDocument {

    private String acquerorRIB;
    private String notaryRIB;
    private double fundAmount;

    public String getAcquerorRIB() {
        return acquerorRIB;
    }

    public void setAcquerorRIB(String acquerorRIB) {
        this.acquerorRIB = acquerorRIB;
    }

    public String getNotaryRIB() {
        return notaryRIB;
    }

    public void setNotaryRIB(String notaryRIB) {
        this.notaryRIB = notaryRIB;
    }

    public double getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(double fundAmount) {
        this.fundAmount = fundAmount;
    }
}
