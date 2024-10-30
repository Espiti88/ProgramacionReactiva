package edu.unisabana.com.propio;

public class WeatherData {

    private int temperature;
    private String condition;
    private String place;

    public WeatherData(int temperature, String condition, String place) {
        this.temperature = temperature;
        this.condition = condition;
        this.place = place;
    }

    public int getTemperature() { return temperature; }

    public String getCondition() { return condition; }

    public String getPlace() { return place; }

    public void setTemperature(int temperature) { this.temperature = temperature; }

    public void setCondition(String condition) { this.condition = condition; }

    public void setPlace(String place) { this.place = place; }

    @Override
    public String toString() {
        return "Temperatura: " + temperature + "°C, Condición: " + condition + ", Lugar: " + place;
    }
}
