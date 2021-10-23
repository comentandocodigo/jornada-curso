import java.util.*;

public class ElfoVerde extends Elfo {
    
    private final ArrayList<String> DESCRICOES_VALIDAS = new ArrayList<>(
        Arrays.asList(
            "Espada de aço valiriano",
            "Arco de vidro",
            "Flecha de vidro"
        )
    );
    
    public ElfoVerde( String nome ) {
        super(nome);
        super.qtdExperienciaPorAtaque = 2;
    }
    
    private boolean descricaoValida( String descricao ) {
        return DESCRICOES_VALIDAS.contains( descricao );
    }
    
    @Override
    public void ganharItem( Item item ) {
        if( this.descricaoValida( item.getDescricao() ) ) {
            this.inventario.adicionar( item );
        }
    }
    
    @Override
    public void perderItem( Item item ) {
        if( this.descricaoValida( item.getDescricao() ) ) {
            this.inventario.remover( item );
        }
    }
}
