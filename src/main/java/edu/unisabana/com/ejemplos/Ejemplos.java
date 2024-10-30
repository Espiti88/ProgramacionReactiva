package edu.unisabana.com.ejemplos;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;

public class Ejemplos {

    public static void main(String[] args) {
        System.out.println("RxJava Map");
        rxjavaMap();

        System.out.println("Reactor Map");
        reactorMap();

        System.out.println("RxJava Filter");
        rxjavaFilter();

        System.out.println("Reactor Filter");
        reactorFilter();

        System.out.println("RxJava Flat");
        rxjavaFlat();

        System.out.println("Reactor Flat");
        reactorFlat();

        System.out.println("RxJava Merge");
        rxjavaMerge();

        System.out.println("Reactor Merge");
        reactorMerge();

        System.out.println("RxJava Zip");
        rxjavaZip();

        System.out.println("Reactor Zip");
        reactorZip();
    }


    public static void rxjavaMap() {
        Observable.just(1, 2, 3, 4, 5)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }


    public static void reactorMap() {
        Flux.just(1, 2, 3, 4, 5)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }

    public static void rxjavaFilter() {
        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
    }

    public static void reactorFilter() {
        Flux.just(1, 2, 3, 4, 5)
                .filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
    }

    public static void rxjavaFlat() {
        Observable.just(1, 2, 3)
                .flatMap(item -> Observable.just(item * 10, item * 20))
                .subscribe(System.out::println);
    }

    public static void reactorFlat() {
        Flux.just(1, 2, 3)
                .flatMap(item -> Flux.just(item * 10, item * 20))
                .subscribe(System.out::println);
    }

    public static void rxjavaMerge() {
        Observable<Integer> observable1 = Observable.just(1, 3, 5);
        Observable<Integer> observable2 = Observable.just(2, 4, 6);

        Observable.merge(observable1, observable2)
                .subscribe(System.out::println);
    }

    public static void reactorMerge() {
        Flux<Integer> flux1 = Flux.just(1, 3, 5);
        Flux<Integer> flux2 = Flux.just(2, 4, 6);

        Flux.merge(flux1, flux2)
                .subscribe(System.out::println);
    }

    public static void rxjavaZip() {
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<String> observable2 = Observable.just("A", "B", "C");

        Observable.zip(observable1, observable2, (num, letter) -> num + letter)
                .subscribe(System.out::println);
    }

    public static void reactorZip() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<String> flux2 = Flux.just("A", "B", "C");

        Flux.zip(flux1, flux2, (num, letter) -> num + letter)
                .subscribe(System.out::println);
    }
}
