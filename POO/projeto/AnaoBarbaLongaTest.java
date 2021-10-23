import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnaoBarbaLongaTest {

    @Test
    public void anaoDevePerderVida33PorCento() {
       DadoFalso dado = new DadoFalso();
       dado.simularValor(2);
       AnaoBarbaLonga anao = new AnaoBarbaLonga( "Balin", dado );
       anao.sofrerDano();
       assertEquals( 100.0, anao.getVida(), 0.001 );
    }
    
    @Test
    public void anaoNaoDevePerderVida66PorCento() {
       DadoFalso dado = new DadoFalso();
       dado.simularValor(3);
       AnaoBarbaLonga anao = new AnaoBarbaLonga( "Balin", dado );
       anao.sofrerDano();
       assertEquals( 110.0, anao.getVida(), 0.001 );
    }
}
