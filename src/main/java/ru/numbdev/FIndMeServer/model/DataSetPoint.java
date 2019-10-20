package ru.numbdev.FIndMeServer.model;

import ru.numbdev.FIndMeServer.exception.ServerException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Координаты устройств
 */
public class DataSetPoint {

    private static final Map<String, Coordinate> coordinates = new HashMap<>();

    private DataSetPoint() {

    }

    public static Map<String, Coordinate> getAllCoordinates() {
        return Collections.unmodifiableMap(coordinates);
    }

    public static void addCoordinate(String uuidMobile, Coordinate coordinate) {
        if (uuidMobile == null || coordinate == null) {
            throw new ServerException("Mac-address or coordinate doesn't found");
        }
        coordinates.put(uuidMobile, coordinate);
    }

    public static void removeMobile(String uuidMobile) {
        coordinates.remove(uuidMobile);
    }

    public static void changeCoordinate(String uuidMobile, Coordinate coordinate) {
        coordinates.remove(uuidMobile);
        coordinates.put(uuidMobile, coordinate);
    }
}
