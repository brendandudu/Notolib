package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotificationDTO {

    private String userEmail;
    private String message;

    public NotificationDTO(String userEmail, String message) {
        this.userEmail = userEmail;
        this.message = message;
    }

    public NotificationDTO(){}

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "PERSONNE : " + userEmail + " ET MESSAGE : " + message;
    }
}
