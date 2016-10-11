package rx.transform;

import io.reactivex.Observable;

/*
 * Splits an observable in multiple, using some criterium
 */
public class Window1 {
    static int counter = 1;

    public static void main(String[] args) {
        Observable.range(0, 100).window(10).forEach(window -> {
            System.out.println("\n" + counter++);
            window.forEach(value -> System.out.print(value + " "));
        });
    }
}
