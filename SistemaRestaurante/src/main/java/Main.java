package SistemaRestaurante;

import java.util.ArrayList;
import java.util.Scanner;
    
public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<ItemMenu> menu = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu.add(new ItemMenu("Hamburguer", "Lanche", 15.90));
        menu.add(new ItemMenu("Pizza", "Lanche", 25.50));
        menu.add(new ItemMenu("Refrigerante", "Bebida", 5.00));
        menu.add(new ItemMenu("Suco Natural", "Bebida", 7.50));

        while (true) {
            System.out.println("\nBem-vindo ao Sabor Gourmet! Escolha uma opcao:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Visualizar Menu");
            System.out.println("3. Fazer Pedido");
            System.out.println("4. Acompanhar Pedido");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereco: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Cliente novoCliente = Cliente.registrarCliente(nome, endereco, telefone);
                    clientes.add(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("---- Menu ----");
                    for (ItemMenu item : menu) {
                        System.out.println(item.getDetalhesItem());
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Cliente cliente = encontrarCliente(nomeCliente);

                    if (cliente == null) {
                        System.out.println("Cliente nao encontrado. Cadastre-se primeiro.");
                        break;
                    }

                    Pedido novoPedido = new Pedido(cliente);

                    while (true) {
                        System.out.println("Escolha um item do menu (digite o nome ou 'fim' para finalizar): ");
                        String nomeItem = scanner.nextLine();

                        if (nomeItem.equalsIgnoreCase("fim")) {
                            break;
                        }

                        ItemMenu item = encontrarItemMenu(nomeItem);
                        if (item != null) {
                            novoPedido.adicionarItem(item);
                        } else {
                            System.out.println("Item não encontrado.");
                        }
                    }

                    System.out.println("Pedido finalizado!");
                    pedidos.add(novoPedido);
                    novoPedido.visualizarPedido();
                    break;
                case 4:
                    System.out.print("Digite o nome do cliente: ");
                    nomeCliente = scanner.nextLine();
                    cliente = encontrarCliente(nomeCliente);

                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    Pedido pedido = encontrarPedidoPorCliente(cliente);
                    if (pedido != null) {
                        pedido.visualizarPedido();
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao inválida. Tente novamente.");
            }
        }
    }

    private static Cliente encontrarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    private static ItemMenu encontrarItemMenu(String nome) {
        for (ItemMenu item : menu) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    private static Pedido encontrarPedidoPorCliente(Cliente cliente) {
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus().equals("Em preparação")) {
                return pedido;
            }
        }
        return null;
    }
}