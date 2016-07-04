package testepraapagar;

public class TesteDuasThreads {

    public static void main(String[] args) {
        ThreadSimples santo = new ThreadSimples("SANTOS");
        santo.setPriority(4);
        ThreadSimples palma = new ThreadSimples("PALMEIRAS");
        palma.setPriority(6);
        Thread.currentThread().setPriority(1);
        santo.start();
        palma.start();
        System.out.println("Main terminado!");
    }
}