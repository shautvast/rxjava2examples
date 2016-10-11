package rx.create;

import io.reactivex.Observable;

/*
 * defers Observable creation until a subscriber is found
 */
public class Defer {
    private static String[] animals;

    public static void main(String[] args) {
        Observable<String> deferredAnimals = Observable.defer(() -> {
            return Observable.fromArray(animals); //Observable is created when subscribe is called
        });

        animals = new String[]{"bear", "lion", "dog", "parrot"};

        deferredAnimals.subscribe(animal -> System.out.println(animal));
    }

    public static void wontWork(){
        Observable<String> deferredAnimals = Observable.fromArray(animals); //Observable is created when animals is uninitialized

        animals = new String[]{"bear", "lion", "dog", "parrot"};

        deferredAnimals.subscribe(animal -> System.out.println(animal));
    }
}
