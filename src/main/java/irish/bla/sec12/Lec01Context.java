package irish.bla.sec12;

import irish.bla.util.DefaultSubscriber;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.Locale;

public class Lec01Context {
    public static void main(String[] args) {

        getWelcomeMessage()
                .contextWrite(ctx -> ctx.put("user", ctx.get("user").toString().toUpperCase(Locale.ROOT)))
                .contextWrite(Context.of("user","sam"))
                .subscribe(DefaultSubscriber.newInstance());
    }
    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("unauth!"));
            }
        });
    }
}
