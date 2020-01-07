package ru.numbdev.FIndMeServer.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class UserCoordinate {

    private String userName;

    private Double latitude;

    private Double longitude;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isCorrect() {
        return StringUtils.isNoneBlank(userName) && latitude != 0 && longitude != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCoordinate that = (UserCoordinate) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, latitude, longitude);
    }

    @Override
    public String toString() {
        return "UserCoordinate{" +
                "userName='" + userName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
