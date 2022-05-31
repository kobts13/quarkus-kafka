package kafka;

import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import restclient.MyRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;

@Slf4j
@ApplicationScoped
public class Consumer {

    @Inject
    @RestClient
    MyRestClient restClient;

    @Incoming("in")
    @Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)
//    @Blocking
    public Uni<Void> consume(String message) {
        log.info("[SEKO] received message: {}", message);
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Multi.createFrom().range(0, 10)
//                .onItem().invoke(() -> {
//                    restClient.hello();
//                }).subscribe().with(integer -> {
//                    log.info("RESULT: {}", integer);
//                }, throwable -> {
//                    log.error("ERROR", throwable);
//                });
        System.out.println("START: " + new Date());
        Uni<Void> uni = Uni.createFrom().voidItem();
        for (int i = 0; i < 500; i++) {
//            Uni.createFrom().item(1)
//                    .subscribe().with(integer -> {
//                        restClient.getById("io.quarkus:quarkus-resteasy-reactive");
//                    });
            uni = uni.chain(() -> {
                sleep(1000);
                return restClient.extensions();
            }).replaceWithVoid();
        }
        System.out.println("FINISH: " + new Date());
        return uni;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        long start = System.currentTimeMillis();
//        while (System.currentTimeMillis() < (start + millis)) {}
    }
}
