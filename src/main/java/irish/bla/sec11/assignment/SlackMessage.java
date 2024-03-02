package irish.bla.sec11.assignment;

import lombok.Data;

@Data
public class SlackMessage {
    private String senderName;
    private String receiverName;
    private String message;

    @Override
    public String toString() {
        return String.format("[%s -> %s]: %s", senderName, receiverName,message);
    }
}
