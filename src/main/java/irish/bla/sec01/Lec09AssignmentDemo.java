package irish.bla.sec01;

import irish.bla.sec01.assignment.FileService;
import irish.bla.util.Util;
import reactor.core.publisher.Mono;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {



        FileService.write("file05.txt", "file 5 is alive")
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        Mono<String> mono = FileService.read("file05.txt");
        mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file05.txt")
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());

    }
}
