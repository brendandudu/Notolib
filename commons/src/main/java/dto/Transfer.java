package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transfer {
    private String ribCreditor;
    private float amount;

    public Transfer(String ribCreditor, float amount) {
        this.ribCreditor = ribCreditor;
        this.amount = amount;
    }

    public Transfer() {
    }

    public String getRibCreditor() {
        return ribCreditor;
    }

    public void setRibCreditor(String ribCreditor) {
        this.ribCreditor = ribCreditor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
