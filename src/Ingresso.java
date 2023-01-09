public class Ingresso {

    private int numeroDoIngresso;
    private final String numeroDoAssento;
    private double preco;
    private boolean inteira;

    public Ingresso(String numeroDoAssento, double preco) {
        this.numeroDoAssento = numeroDoAssento;
        this.preco = preco;
        this.inteira = true;
    }

    public String getNumeroDoAssento() {
        return numeroDoAssento;
    }

    public void inteiraOuMeia(boolean inteira){
        if(!inteira){
            this.preco = 19.99;
            this.inteira = false;
        }
    }
    public void mostrarIngresso(){
        System.out.println("Número do ingresso: " + this.numeroDoIngresso);
        System.out.println("Numéro do Assento: " + this.numeroDoAssento);
        if(this.inteira){
            System.out.println("Tipo de ingresso: Inteira");
        }else{
            System.out.println("Tipo de ingresso: Meia");
        }
        System.out.println("Preço: " + this.preco);
    }

    public void setNumeroDoIngresso(int numeroDoIngresso) {
        this.numeroDoIngresso = numeroDoIngresso;
    }
}
