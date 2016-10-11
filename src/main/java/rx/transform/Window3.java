package rx.transform;

import io.reactivex.Observable;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Buffers observed values until a criterium is met and the emits the buffered values as a new observable.
 */
public class Window3 {
    static AtomicBoolean newWindow = new AtomicBoolean(false);

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JTextField textField = new JTextField();

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                newWindow.set(true);
            }
        });

        frame.getContentPane().add(textField);
        frame.pack();
        frame.setVisible(true);

        Observable.interval(1, TimeUnit.SECONDS).window(() -> {
            return Observable.fromCallable(new Callable<Observable<String>>() {
                @Override
                public Observable<String> call() throws Exception {
                    return Observable.create(emitter -> {
                        if (newWindow.get()) {
                            newWindow.set(false);
                            emitter.onNext("");
                        }
                    });
                }
            });
        }).subscribe(observable -> {
            System.out.println("interrupt");
            observable.subscribe(value -> System.out.println(value));
        });
    }
}
