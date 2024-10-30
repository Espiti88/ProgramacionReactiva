package edu.unisabana.com.propio;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class WeatherDataStreamsBogota {

    // Flujo de datos de temperatura, genera un dato cada 8 segundos
    public static Observable<Integer> getTemperatureStream() {

        return Observable.interval(8, TimeUnit.SECONDS)
                .map(tick -> (int) (Math.random() * 130)) // Simula temperaturas entre 0 y 130°F
                .doOnNext(temp -> System.out.println("BOGOTA - Temperatura actual: " + temp + "°F")); // Ejecuta una acción adicional sin modificar el flujo
    }

    // Flujo de datos de condiciones climáticas, genera un dato cada 8 segundos
    public static Observable<String> getConditionStream() {

        return Observable.interval(8, TimeUnit.SECONDS)
                .map(tick -> {
                    double random = Math.random();
                    return random > 0.7 ? "Tormenta" : "Despejado";
                })
                .doOnNext(cond -> System.out.println("BOGOTA - Condición climática actual: " + cond)); // Ejecuta una acción adicional sin modificar el flujo
    }
}
