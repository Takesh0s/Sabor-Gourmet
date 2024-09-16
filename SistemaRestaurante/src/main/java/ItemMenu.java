package SistemaRestaurante;

public class ItemMenu {
    private String nome;
    private String categoria;
    private double preco;

    public ItemMenu(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public String getDetalhesItem() {
        return "- " + nome + " - Categoria: " + categoria + " - Preco: R$" + String.format("%.2f", preco);
    }

    public double calcularPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
