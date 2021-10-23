import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest {

    @Test
    public void elfoVerdeGanha2XPPorAtaque() {
        ElfoVerde verde = new ElfoVerde("Celebron");
        Anao balin = new Anao("Balin");
        verde.atacarOutroPersonagem(balin, verde.getFlecha());
        assertEquals( (Integer) 2, verde.getExperiencia() );
    }
    
    @Test
    public void adicionarItemComDescricaoValidaNoElfoVerde() {
        ElfoVerde verde = new ElfoVerde("Celebron");
        Item arcoDeVidro = new Item( "Arco de vidro", 1 );
        verde.ganharItem(arcoDeVidro);
        Inventario inventario = verde.getInventario();
        assertEquals( new Item( "Arco", 1 ), inventario.obter(1) );
        assertEquals( new Item( "Flechas", 2 ), inventario.obter(0) );
        assertEquals( arcoDeVidro, inventario.obter(2) );
    }
    
    @Test
    public void adicionarItemComDescricaoInvalidaNoElfoVerde() {
        ElfoVerde verde = new ElfoVerde("Celebron");
        Item arcoDeMadeira = new Item( "Arco de madeira", 1 );
        verde.ganharItem(arcoDeMadeira);
        Inventario inventario = verde.getInventario();
        assertEquals( new Item( "Arco", 1 ), inventario.obter(1) );
        assertEquals( new Item( "Flechas", 2 ), inventario.obter(0) );
        assertNull( inventario.obter(2) );
    }
    
    @Test
    public void perderItemComDescricaoValidaNoElfoVerde() {
        ElfoVerde verde = new ElfoVerde("Celebron");
        Item arcoDeVidro = new Item( "Arco de vidro", 1 );
        verde.ganharItem(arcoDeVidro);
        Inventario inventario = verde.getInventario();
        assertEquals( new Item( "Arco", 1 ), inventario.obter(1) );
        assertEquals( new Item( "Flechas", 2 ), inventario.obter(0) );
        assertEquals( arcoDeVidro, inventario.obter(2) );
        verde.perderItem(arcoDeVidro);
        assertNull( inventario.obter(2) );
    }
    
    @Test
    public void perderItemComDescricaoInvalidaNoElfoVerde() {
        ElfoVerde verde = new ElfoVerde("Celebron");
        verde.perderItem(new Item( "Arco", 1 ));
        Inventario inventario = verde.getInventario();
        assertEquals( new Item( "Arco", 1 ), inventario.obter(1) );
        assertEquals( new Item( "Flechas", 2 ), inventario.obter(0) );
    }
}
