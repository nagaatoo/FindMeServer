package ru.numbdev.FIndMeServer.endpoint;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.numbdev.FIndMeServer.service.FindService;
//import ru.numbdev.FIndMeServer.service.FindServiceImpl;

import java.security.Principal;
//
//@Controller
//public class SocketEndpoint {
//
//    private final FindService findService;
//
//    public SocketEndpoint(FindService findService) {
//        this.findService = findService;
//    }
//
//    @SubscribeMapping("/*")
//    private void subscribe(Principal user) {
//        System.out.println("Connected!");
//    }
//
//    @MessageMapping("/coordinate")
//    private void getCooedinates(String mess) {
//        System.out.println(mess);
//    }
//
//    @MessageMapping("/*")
//    private void test(String mess) {
//        System.out.println(mess);
//    }
//
//}
