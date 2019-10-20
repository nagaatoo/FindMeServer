package ru.numbdev.FIndMeServer.model;

/**
 * Объект координаты устройства.
 */
public class Coordinate {

    private double sourceValue;
    private int degres;
    private int minutes;
    private double seconds;

    private void ChangeOfSource(double source) {
        sourceValue = source;
        degres = (int) source;
        double floatMinutes = (source - degres) * 60;
        minutes = (int) floatMinutes;
        seconds = (floatMinutes - minutes) * 60;
    }

    private void SetSourceValue() {
        sourceValue = degres + (minutes + seconds / 60) / 60;
    }

    private void Validate(double value) throws Exception {
        if ((value < 0) || (value > 60)) {
            throw new Exception("Неверный угловой размер в минутах или секундах");
        }
    }

    public Coordinate(double value) {
        ChangeOfSource(value);
    }

    public double getDecimalValue() {
        return sourceValue;
    }

    public int getDegres() {
        return degres;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getSeconds() {
        return seconds;
    }

    public void setDecimalValue(double value) {
        sourceValue = value;
        ChangeOfSource(value);
    }

    public void setDegres(int newdegres) {
        degres = newdegres;
        SetSourceValue();
    }

    public void setMinutes(int newminutes) {
        try {
            Validate(newminutes);
            minutes = newminutes;
            SetSourceValue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setSeconds(double newseconds) {
        try {
            Validate(newseconds);
            seconds = newseconds;
            SetSourceValue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
