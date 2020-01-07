package ru.numbdev.FIndMeServer.util;

import com.google.gson.Gson;
import ru.numbdev.FIndMeServer.model.UserCoordinate;

public class JsonUtils {

    public static <T> String toJson(T object) {
        return new Gson().toJson(object);
    }

    public static <T> T toObject(String jsonString) {
        return (T) toObject(jsonString, UserCoordinate.class);
    }

    public static <T> T toObject(String jsonString, Class<T> clazz) {
        return new Gson().fromJson(jsonString, clazz);
    }
}
