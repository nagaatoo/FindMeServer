package ru.numbdev.FIndMeServer.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.numbdev.FIndMeServer.exception.ServerException;
import ru.numbdev.FIndMeServer.model.UserCoordinate;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    private final HashMap<String, UserCoordinate> users = new HashMap();

    @Override
    public void addUser(String sessionId) {
        if (StringUtils.isBlank(sessionId)) {
            throw new ServerException("Cannot add user: incorrect data (sessionId - " + sessionId);
        }
        users.put(sessionId, new UserCoordinate());
    }

    @Override
    public void changeUserCoordinates(String sessionId, UserCoordinate coordinate) {
        if (coordinate == null || !coordinate.isCorrect()) {
            throw new ServerException("Cannot change coordinates: incorrect data (coordinate - " + coordinate);
        }
        users.put(sessionId, coordinate);
        System.out.println(coordinate.toString());
    }

    @Override
    public void removeUser(String sessionId) {
        users.remove(sessionId);
    }
}
