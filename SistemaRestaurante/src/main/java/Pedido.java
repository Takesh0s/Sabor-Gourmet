package SistemaRestaurante;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItemMenu> itens;
    private double total;
    private String status;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.status = "Em preparação";
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
        total += item.calcularPreco();
    }

    public double calcularTotal() {
        return total;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public void visualizarPedido() {
        System.out.println("Pedido do cliente: " + cliente.getNome());
        for (ItemMenu item : itens) {
            System.out.println(item.getDetalhesItem());
        }
        System.out.println("Total: R$" + total);
        System.out.println("Status do pedido: " + status);
    }

    public String getStatus() {
        return status;
    }
}