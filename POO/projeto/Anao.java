public class Anao extends Personagem {
    public Anao( String nome ) {
        super(nome);
        super.vida = 110.0;
        this.inventario.adicionar(new Item( "Escudo", 1 ));
        super.qtdDano = 10.0;
    }
    
    public void verficarEscudoSetarDano() {
        super.qtdDano = this.itemEstaAtivo( this.inventario.obter( 0 ), 1 ) ? 5.0 : 10.0;
    }
}