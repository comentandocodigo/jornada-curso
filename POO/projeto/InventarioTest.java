import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {

    @Test
    public void criarInventarioSemPassarValor() {
        Inventario inventario = new Inventario();
        assertEquals( 0, inventario.getItens().size() );
    }
    
    @Test
    public void criarInventarioPassandoValor() {
        Inventario inventario = new Inventario();
        assertEquals( 0, inventario.getItens().size() );
    }

    @Test
    public void adicionarUmItemNoInventario() {
        Inventario inventario = new Inventario();
        Item item = new Item( "Faca", 1 );
        inventario.adicionar(item);
        assertEquals( item, inventario.getItens().get(0) );
    }
    
    @Test
    public void adicionarDoisItemNoInventario() {
        Inventario inventario = new Inventario();
        Item item = new Item( "Faca", 1 );
        Item escudo = new Item( "Escudo", 2 );
        inventario.adicionar(item);
        inventario.adicionar(escudo);
        assertEquals( item, inventario.getItens().get(0) );
        assertEquals( escudo, inventario.getItens().get(1) );
    }
    
    @Test
    public void obterUmItemNoInventario() {
        Inventario inventario = new Inventario();
        Item item = new Item( "Faca", 1 );
        Item escudo = new Item( "Escudo", 2 );
        inventario.adicionar(item);
        inventario.adicionar(escudo);
        assertEquals( item, inventario.obter(0) );
        assertEquals( escudo, inventario.obter(1) );
    }
    
    @Test
    public void removerUmItemNoInventario() {
        Inventario inventario = new Inventario();
        Item item = new Item( "Faca", 1 );
        inventario.adicionar(item);
        inventario.remover(item);
        assertNull( inventario.obter(0) );
    }
}