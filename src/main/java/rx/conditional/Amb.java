package rx.conditional;

import io.reactivex.Observable;

import static io.reactivex.Observable.amb;
import static io.reactivex.Observable.timer;
import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Amb {

    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> timer1 = timer(1, SECONDS).map(t->{return 1;});
        Observable<Integer> timer2 = timer(2, SECONDS).map(t->{return 2;});
        Observable<Integer> timer3 = timer(3, SECONDS).map(t->{return 3;});

        amb(asList(timer1,timer2,timer3)).subscribe(v-> out.println(v));

        SECONDS.sleep(5);
    }
}
