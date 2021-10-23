import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest {

    @Test
    public void verificarSeElfoNasceCom2Flechas() {
        Elfo elfoAdulto = new Elfo("Elfo Adulto");
        assertEquals( (Integer) 2, elfoAdulto.getFlecha().getQuantidade() );
    }
    
    @Test
    public void elfoAtacaEPerde1Flecha() {
        Elfo elfoAdulto = new Elfo("Elfo Adulto");
        elfoAdulto.atacar( elfoAdulto.inventario.obter(0) );
        assertEquals( (Integer) 1, elfoAdulto.getFlecha().getQuantidade() );
    }
    
    @Test
    public void criarElfoEVerificarSeAumentouXP() {
        Elfo elfoAdulto = new Elfo("Elfo Adulto");
        elfoAdulto.atacar( elfoAdulto.inventario.obter(0) );
        assertEquals( (Integer) 1, elfoAdulto.getExperiencia() );
    }
    
    @Test
    public void criarElfoEVerificarVida() {
        Elfo elfoAdulto = new Elfo("Elfo Adulto");
        assertEquals( 100.0, elfoAdulto.getVida(), 0.001 );
    }
}