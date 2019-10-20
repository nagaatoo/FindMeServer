package ru.numbdev.FIndMeServer.endpoint;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Component;
import ru.numbdev.FIndMeServer.service.FindService;
import ru.numbdev.FIndMeServer.service.FindServiceImpl;

import java.security.Principal;

@Component
public class SocketEndpoint {

    private final FindService findService;

    public SocketEndpoint(FindService findService) {
        this.findService = findService;
    }

    @SubscribeMapping("/*")
    private void subscribe(Principal user) {
        System.out.println("Connected!");
    }

}
