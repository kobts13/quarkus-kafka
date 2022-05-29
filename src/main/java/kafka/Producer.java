package kafka;

import io.smallrye.mutiny.Multi;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@ApplicationScoped
public class Producer {

    @Outgoing("out")
    public Multi<String> generate() {

        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .map(x -> LocalDateTime.now().toString());
    }
}
