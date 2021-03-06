<<<<<<< HEAD
package com.learning.thread;

public class ThreadNumber extends Thread {

    private final NumberGenerator ng;

    public ThreadNumber(NumberGenerator ng) {
        this.ng = ng;
    }

    @Override
    public void run() {
        callGenerator();
    }

    private void callGenerator() {
        synchronized (ng) {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " " + ng.randomNumber());
            }
        }
    }

}
=======
package com.learning.thread;

public class ThreadNumber extends Thread {

    private final NumberGenerator ng;

    public ThreadNumber(NumberGenerator ng) {
        this.ng = ng;
    }

    @Override
    public void run() {
        callGenerator();
    }

    private void callGenerator() {
        synchronized (ng) {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " " + ng.randomNumber());
            }
        }
    }

}
>>>>>>> f4057c49296405e8d39733d095f2ace084f59623
