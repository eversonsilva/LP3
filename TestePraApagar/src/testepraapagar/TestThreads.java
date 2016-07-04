package testepraapagar;

public class TestThreads {

    public static void main(String[] args) {
        MyThread t1;
        MyThread t2, t3;
        t1 = new MyThread("Primeiro", 1000);
        t2 = new MyThread("Segundo", 500);
        t3 = new MyThread("Terceiro", 2000);
        t1.start();
        t2.start();
        t3.start();
    }
}
