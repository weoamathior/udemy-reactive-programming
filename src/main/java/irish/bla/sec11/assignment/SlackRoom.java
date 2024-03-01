package irish.bla.sec11.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {
    private String name;
    private Sinks.Many<SlackMessage> sink;
    private Flux<SlackMessage> flux;
    public SlackRoom(String n) {
        this.name = n;
        this.sink = Sinks.many().replay().all();
        this.flux = this.sink.asFlux();
    }

    public void joins(SlackMember member) {
        System.out.println(member + " ----joining---- " + this.name);

        this.subscribe(member);
        member.setMessageConsumer(msg -> {
            this.postMessage(msg, member);
        });

    }

    private void subscribe(SlackMember member) {
        this.flux
                .filter(sm -> !sm.getSenderName().equals(member.getName()))
                .doOnNext(sm -> sm.setReceiverName(member.getName()))
                .map(SlackMessage::toString)
                .subscribe(member::receive);
    }

    private void postMessage(String msg, SlackMember sender) {
        SlackMessage message = new SlackMessage();
        message.setMessage(msg);
        message.setSenderName(sender.getName());
        this.sink.tryEmitNext(message);
    }
}
