package diary.diarynew.dto.responseDTO;

public class AuthResponseDTO {
    private String token;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String message;

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String token, String username, String email, String firstName, String lastName, String message) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthResponseDTO(String message) {
        this.message = message;
    }
}
