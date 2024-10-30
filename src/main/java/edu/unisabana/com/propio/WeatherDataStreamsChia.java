package edu.unisabana.com.propio;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class WeatherDataStreamsChia {

    // Flujo de datos de temperatura, genera un dato cada 5 segundos
    public static Observable<Integer> getTemperatureStream() {

        return Observable.interval(5, TimeUnit.SECONDS)
                .map(tick -> (int) (Math.random() * 130)) // Simula temperaturas entre 0 y 130°F
                .doOnNext(temp -> System.out.println("CHIA - Temperatura actual: " + temp + "°F")); //Ejecuta una acción adicional sin modificar el flujo
    }

    // Flujo de datos de condiciones climáticas, genera un dato cada 5 segundos
    public static Observable<String> getConditionStream() {

        return Observable.interval(5, TimeUnit.SECONDS)
                .map(tick -> {
                    double random = Math.random();
                    return random > 0.7 ? "Tormenta" : "Despejado";
                })
                .doOnNext(cond -> System.out.println("CHIA - Condición climática actual: " + cond)); //Ejecuta una acción adicional sin modificar el flujo
    }
}
