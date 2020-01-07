package ru.numbdev.FIndMeServer.service;

import ru.numbdev.FIndMeServer.model.UserCoordinate;

public interface UserService {

    void addUser(String sessionId);

    void changeUserCoordinates(String sessionId, UserCoordinate coordinate);

    void removeUser(String sessionId);

}
