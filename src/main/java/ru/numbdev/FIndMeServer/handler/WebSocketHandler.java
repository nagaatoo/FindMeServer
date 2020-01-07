package ru.numbdev.FIndMeServer.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.numbdev.FIndMeServer.exception.ServerException;
import ru.numbdev.FIndMeServer.model.UserCoordinate;
import ru.numbdev.FIndMeServer.service.UserService;
import ru.numbdev.FIndMeServer.util.JsonUtils;

@Component
public class WebSocketHandler implements org.springframework.web.socket.WebSocketHandler {

    @Autowired
    private UserService userService;

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) {
        System.out.println("Connected: " + webSocketSession.getId());
        userService.addUser(webSocketSession.getId());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
        if (!(webSocketMessage.getPayload() instanceof String)) {
            throw new ServerException("Server can get only JSON string");
        }

        String o = (String) webSocketMessage.getPayload();
        userService.changeUserCoordinates(webSocketSession.getId(), JsonUtils.toObject(o));
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) {
        System.out.println("Handle transport error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) {
        System.out.println("connection closed");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
