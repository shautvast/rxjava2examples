package rx.conditional;

import io.reactivex.Observable;

import static java.lang.System.out;

public class All {

    public static void main(String[] args) {

        Observable.range(1, 5).all(v -> {
            return v % 2 == 0;
        }).subscribe(b -> out.println(b));

    }
}
