import java.util.*;

public class Inventario {
    private ArrayList<Item> itens;
    
    public Inventario() {
        this.itens = new ArrayList<>();
    }
    
    public ArrayList<Item> getItens() {
        return this.itens;
    }
    
    public void adicionar( Item item ) {
        this.itens.add(item);
    }
    
    public Item obter( int posicao ) {
        return this.validarSePosicaoNaoExiste( posicao ) ? null : this.itens.get( posicao );
    }
    
    private boolean validarSePosicaoNaoExiste( int posicao ) {
        return posicao >= this.itens.size();
    }
    
    public void remover( Item item ) {
        this.itens.remove( item );
    }
}