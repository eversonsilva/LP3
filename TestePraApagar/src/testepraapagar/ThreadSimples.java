package testepraapagar;

public class ThreadSimples extends Thread {

    public ThreadSimples(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((long) (Math.random() * 400));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("TERMINOU " + getName() + "!");
    }
}
