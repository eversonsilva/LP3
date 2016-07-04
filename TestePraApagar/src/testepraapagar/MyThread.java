package testepraapagar;

public class MyThread extends Thread {

    private String whoami;
    private int delay;

    public MyThread(String name, int d) {
        whoami = name;
        delay = d;
    }

    public void run() {
        try {
            sleep(delay);
        } catch (InterruptedException e) {
        }
        System.out.println("Alo, daqui fala " + whoami + " ! ");
    }
}
