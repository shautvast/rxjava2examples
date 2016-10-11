package rx.transform;


import io.reactivex.Observable;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

/*
 * splits an observable in new observables
 */
public class GroupBy {

    public static void main(String[] args) throws InterruptedException {

        Observable.range(0, 30)
                .groupBy(v -> v % 3)
                .subscribe(v ->
                        v.toList().subscribe(w -> out.println(w))
                );
    }
}
