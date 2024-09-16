package SistemaRestaurante;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItemMenu> itens;
    private double total;
    private String status;
    private Timer timer;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.status = "Em preparacao";
        iniciarTimer();
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
        total += item.calcularPreco();
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public void visualizarPedido() {
        System.out.println("Pedido do cliente: " + cliente.getNome());
        for (ItemMenu item : itens) {
            System.out.println(item.getDetalhesItem());
        }
        System.out.println("Total: R$" + String.format("%.2f", total));
        System.out.println("Status do pedido: " + status);
        System.out.println();
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void iniciarTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (status.equals("Em preparacao")) {
                    atualizarStatus("Saiu para entrega");
                } else if (status.equals("Saiu para entrega")) {
                    atualizarStatus("Entregue");
                    timer.cancel();
                }
            }
        }, 40000, 40000);
    }
}
