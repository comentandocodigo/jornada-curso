import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {

    @Test
    public void elfoNoturnoGanha3XPPorAtaque() {
        ElfoNoturno noturno = new ElfoNoturno("Noturno");
        Anao balin = new Anao("Balin");
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        assertEquals( (Integer) 3, noturno.getExperiencia() );
    }
    
    @Test
    public void elfoNoturnoPerde15HPPorAtaque() {
        ElfoNoturno noturno = new ElfoNoturno("Noturno");
        Anao balin = new Anao("Balin");
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        assertEquals( 85.0, noturno.getVida() );
        assertEquals( Status.SOFREU_DANO, noturno.getStatus() );
    }
    
    @Test
    public void elfoNoturnoMorreApos7Ataques() {
        ElfoNoturno noturno = new ElfoNoturno("Noturno");
        Anao balin = new Anao("Balin");
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        noturno.atacarOutroPersonagem(balin, noturno.getFlecha());
        assertEquals( 0.0, noturno.getVida() );
        assertEquals( Status.MORTO, noturno.getStatus() );
    }
}
