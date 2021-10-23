import java.util.Random;

public class DadoD6 implements Sorteador {
    
    public int sortear() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}