import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnaoTest {

    @Test
    public void anaoDeveNascerCom110DeVida() {
        Anao anaoAdulto = new Anao( "Anao Adulto" );
        assertEquals( 110.0, anaoAdulto.getVida(), 0.0001 );
    }
    
    @Test
    public void anaoRecebeAtaqueEFicaCom100DeVida() {
        Anao anaoAdulto = new Anao( "Anao Adulto" );
        anaoAdulto.sofrerDano();
        assertEquals( 100.0, anaoAdulto.getVida(), 0.0001 );
    }
    
    @Test
    public void anaoRecebe11AtaqueEZeraVida() {
        Anao anaoAdulto = new Anao( "Anao Adulto" );
        for( int i = 0; i < 11; i++ ) {
            anaoAdulto.sofrerDano();
        }
        assertEquals( 0.0, anaoAdulto.getVida(), 0.0001 );
    }
}