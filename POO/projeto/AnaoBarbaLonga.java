public class AnaoBarbaLonga extends Anao {
    private Sorteador sorteador;
    
    public AnaoBarbaLonga( String nome ) {
        super(nome);
        this.sorteador = new DadoD6();
    }
    
    public AnaoBarbaLonga( String nome, Sorteador sorteador ) {
        super(nome);
        this.sorteador = sorteador;
    }
    
    public void sofrerDano() {
        boolean devePerderVida = sorteador.sortear() < 3;
        if( devePerderVida ) {
            super.sofrerDano();
        }
    }
}