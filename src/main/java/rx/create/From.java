package rx.create;


import io.reactivex.Observable;
import java.util.Arrays;

public class From {

    public static void main(String[] args) {
        String[] animals = {"bear", "lion", "dog", "parrot"};

        Observable.fromArray(animals).subscribe(animal -> System.out.println(animal));

        System.out.println("java 8:");
        Arrays.asList(animals).stream().forEach(animal -> System.out.println(animal));
    }
}
