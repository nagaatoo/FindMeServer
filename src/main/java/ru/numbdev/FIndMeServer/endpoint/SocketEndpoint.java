package ru.numbdev.FIndMeServer.endpoint;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class SocketEndpoint {

    @SubscribeMapping("/*")
    private void subscribe(Principal user) {
        System.out.println("Connected!");
    }

}
