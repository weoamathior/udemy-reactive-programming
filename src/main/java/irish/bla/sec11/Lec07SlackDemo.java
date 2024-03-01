package irish.bla.sec11;

import irish.bla.sec11.assignment.SlackMember;
import irish.bla.sec11.assignment.SlackRoom;
import irish.bla.util.Util;

public class Lec07SlackDemo {
    public static void main(String[] args) {
        SlackRoom room = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        room.joins(sam);
        room.joins(jake);

        sam.says("Hi everybody...");

        Util.sleepSeconds(4);

        jake.says("Heyo");
        sam.says("I'm bored");
        Util.sleepSeconds(4);

        room.joins(mike);
        mike.says("Hey all... glad to be here");
    }
}
