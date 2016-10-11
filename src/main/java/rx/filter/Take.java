package rx.filter;

import io.reactivex.Observable;

import static io.reactivex.Observable.range;
import static java.lang.System.out;

/*
 * Emits only the first x elements of an observable.
 */
public class Take {

    public static void main(String[] args) {
        range(1, 10).take(2).subscribe(w -> out.println(w));
    }

}
