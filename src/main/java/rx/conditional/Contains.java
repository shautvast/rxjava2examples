package rx.conditional;

import io.reactivex.Observable;

import static java.lang.System.out;

public class Contains {

    public static void main(String[] args) {

        Observable.range(1, 5).contains(1).subscribe(b -> out.println(b));
        
    }
}
