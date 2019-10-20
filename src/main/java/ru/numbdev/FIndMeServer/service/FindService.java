package ru.numbdev.FIndMeServer.service;

import ru.numbdev.FIndMeServer.exception.ServerException;

public interface FindService {

    void addMobile(String mac, double coordinate) throws ServerException;

    void updateMobileCoordinate(String mac, double coordinate) throws ServerException;
}
