public class Orc extends Personagem {
    
    public Orc( String nome ) {
        super(nome);
        super.vida = 180.0;
        this.inventario.adicionar(new Item( "Garra", 1 ));
    }
}