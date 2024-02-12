
package lt.codeacademy.javau8.PoliklinikosApp.payload.response;


public class MessageResponse {
    private String message;


    // Constructors:
    public MessageResponse() {
    }

    public MessageResponse(String message) {
        this.message = message;
    }



    // Getters and setters


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}