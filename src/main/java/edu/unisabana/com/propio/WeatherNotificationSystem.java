package edu.unisabana.com.propio;

import io.reactivex.Observable;

public class WeatherNotificationSystem {

    public static void main(String[] args) {

        Observable<Integer> tempChia = WeatherDataStreamsChia.getTemperatureStream();
        Observable<String> condChia = WeatherDataStreamsChia.getConditionStream();

        Observable<Integer> tempBogota = WeatherDataStreamsBogota.getTemperatureStream();
        Observable<String> condBogota = WeatherDataStreamsBogota.getConditionStream();

        // Combinar temperatura y condición en pares para Chía utilizando .zip
        Observable<WeatherData> weatherDataChia = Observable
                .zip(tempChia, condChia, (temp, cond) -> new WeatherData(temp, cond, "Chía"));

        // Combinar temperatura y condición en pares para Bogotá utilizando .zip
        Observable<WeatherData> weatherDataBogota = Observable
                .zip(tempBogota, condBogota, (temp, cond) -> new WeatherData(temp, cond, "Bogotá"));

        // Sistema de Alertas Climatológicas para Chía y Bogotá
        Observable.merge(weatherDataChia, weatherDataBogota) // Manejar ambos datos en el mismo flujo con .merge
                .map(data -> new WeatherData((data.getTemperature() - 32) * 5/9, data.getCondition(), data.getPlace())) //Convertir la temperatura de °F a °C
                .filter(data -> data.getTemperature() > 35 || "Tormenta".equals(data.getCondition())) // Filtrar los datos que requieran alerta
                .subscribe(data -> System.out.println("------------------------------------\n" +
                                                      "ALERTA! " + data.toString() + "\n" +
                                                      "------------------------------------"));


        try {
            Thread.sleep(30000); // Ejecuta durante 30 segundos para ver varias alertas
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
