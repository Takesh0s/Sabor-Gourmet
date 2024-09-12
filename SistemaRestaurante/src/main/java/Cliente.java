package SistemaRestaurante;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    
    public Cliente(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public void visualizarCliente(){
    System.out.println("Nome: " + this.nome);
    System.out.println("Endereco: " + this.endereco);
    System.out.println("Telefone: " + this.telefone);
    }
    
    public static Cliente registrarCliente(String nome, String endereco, String telefone){
        return new Cliente(nome, endereco, telefone);
    }
    
    public String getNome(){
    return nome;
    }
}
