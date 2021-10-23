public class Item {
    private String descricao;
    private Integer quantidade;
    
    public Item( String descricao, Integer quantidade ) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    //get set
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }
    
    public Integer getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade( Integer quantidade ) {
        this.quantidade = quantidade;
    }
    
    public boolean equals( Object obj ) {
        Item outroItem = (Item) obj;
        return this.quantidade == outroItem.getQuantidade() && this.descricao == outroItem.getDescricao();
    }
    
    public void diminuirQuantidade() {
        this.quantidade -= 1;
    }
    
}
