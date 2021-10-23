public class Elfo extends Personagem {
    private int indiceFlecha = 0;
    
    public Elfo( String nome ) {
        super( nome );
        super.vida = 100.0;
        inventario.adicionar(new Item("Flecha", 2));
        inventario.adicionar(new Item("Arco", 1));
        this.ativarOuDesativarItem(true, this.inventario.obter(0) , 0);
        this.ativarOuDesativarItem(true, this.inventario.obter(1) , 1);
    }
    
    public Item getFlecha() {
        return this.inventario.obter(indiceFlecha);
    }
}