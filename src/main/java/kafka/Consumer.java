package kafka;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
public class Consumer {

    @Incoming("in")
    public void consume(String message) {
        log.info("[SEKO] received message: {}", message);
    }
}
