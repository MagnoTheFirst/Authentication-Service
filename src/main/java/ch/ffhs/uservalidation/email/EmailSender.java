package ch.ffhs.uservalidation.email;

public interface EmailSender {
    void send(String to, String email);
}
