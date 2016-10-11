package rx.filter;

import io.reactivex.Observable;
import java.util.Random;

import static io.reactivex.Observable.create;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Debounce {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> keys = create(observer -> {
            Random random = new Random();

            for (int i = 0; i < 50; i++) {
                long t = currentTimeMillis();
                int w = random.nextInt(500);

                out.println("time " + t + ", wait " + w);

                observer.onNext(t);

                sleep(w);
            }
        });

        keys.debounce(400, MILLISECONDS).subscribe(key -> out.println("event " + key));
    }

    public static void sleep(int w) {
        try {
            Thread.sleep(w);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
