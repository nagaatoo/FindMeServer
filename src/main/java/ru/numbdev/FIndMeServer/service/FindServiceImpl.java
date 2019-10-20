package ru.numbdev.FIndMeServer.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.numbdev.FIndMeServer.exception.ServerException;
import ru.numbdev.FIndMeServer.model.Coordinate;
import ru.numbdev.FIndMeServer.model.DataSetPoint;

import java.util.Map;

@Service
@EnableScheduling
public class FindServiceImpl implements FindService {

    private static int count = 1;

    private final SimpMessagingTemplate template;

    public FindServiceImpl(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Override
    public void addMobile(String uuidMobile, double coordinate) throws ServerException {
        checkUUIDAndCoordinate(uuidMobile, coordinate);
        Coordinate coordinateObj = new Coordinate(coordinate);
        DataSetPoint.addCoordinate(uuidMobile, coordinateObj);
    }

    @Override
    public void updateMobileCoordinate(String uuidMobile, double coordinate) throws ServerException {
        checkUUIDAndCoordinate(uuidMobile, coordinate);
        Coordinate coordinateObj = new Coordinate(coordinate);
        DataSetPoint.changeCoordinate(uuidMobile, coordinateObj);
    }

    @Scheduled(fixedRate = 1500)
    public void manageCoordinates() {
        Map<String, Coordinate> allCoordinates = DataSetPoint.getAllCoordinates();
        for (Map.Entry<String, Coordinate> entry : allCoordinates.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }

    /**
     * Проверка входных данных для координат
     *
     * @param uuidMobile uuid телефона
     * @param coordinate координаты с gps
     */
    private void checkUUIDAndCoordinate(String uuidMobile, double coordinate) {
        if (StringUtils.isBlank(uuidMobile) || coordinate == 0L) {
            throw new ServerException("UUID or coordinate doesn't found");
        }
    }
}
