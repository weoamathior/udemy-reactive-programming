package irish.bla.sec03;

import irish.bla.sec03.assignment.FileReaderService;
import irish.bla.util.DefaultSubscriber;

import java.nio.file.Paths;

public class Lec09FileReaderAssignment {
    public static void main(String[] args) {
        FileReaderService service = new FileReaderService();

        service.read(Paths.get("src/main/resources/assignment/sec03/file01.txt"))
                .take(10)
                .subscribe(DefaultSubscriber.newInstance());
    }
}
