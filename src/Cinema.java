import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private final String nome;
    private final int numeroDeAssentosPorFileira;
    private final int numeroDeFileiras;
    private final List<Assento> assentos;
    private final List<Ingresso> ingressos;

    public Cinema(String nome, int numeroDeAssentosPorFileira, int numeroDeFileiras) {
        this.nome = nome;
        this.numeroDeAssentosPorFileira = numeroDeAssentosPorFileira;
        this.numeroDeFileiras = numeroDeFileiras;
        this.assentos = new ArrayList<>();
        this.ingressos = new ArrayList<>();

        int ultimaFileira = 'A' + (numeroDeFileiras - 1);
        for(char fileira = 'A'; fileira<=ultimaFileira; fileira++){
            for(int assento=1; assento<=numeroDeAssentosPorFileira; assento++){
                this.assentos.add(new Assento(fileira + String.format("%02d", assento), 39.99));
            }
        }
    }

    public boolean reservarAssento(String numeroDoAssento, boolean inteira){

        int cont = 0;
        for(int i=1; i<this.assentos.size(); i++){
            Assento assento = this.assentos.get(i);
            if(numeroDoAssento.equals(assento.getNumeroDoAssento())){
                Ingresso ingresso = new Ingresso(numeroDoAssento, assento.getPreco());
                this.ingressos.add(ingresso);
                ingresso.inteiraOuMeia(inteira);
                cont++;
                return assento.reservar();
            }
        }
        if(cont == 0){
            System.out.println("Assento " + numeroDoAssento + " não existe");
        }
        return false;
    }

    public boolean cancelarReserva(String numeroDoAssento){

        int cont = 0;
        for(int i=1; i<this.assentos.size(); i++){
            Assento assento = this.assentos.get(i);
            if(numeroDoAssento.equals(assento.getNumeroDoAssento())){
                int indice = getIndiceDoIngresso(assento);
                cont++;
                if(indice != 0){
                    this.ingressos.remove(indice);
                }
                return assento.cancelar();
            }
        }
        if(cont == 0){
            System.out.println("Assento " + numeroDoAssento + " não existe");
        }
        return false;
    }

    public int getIndiceDoIngresso(Assento assento){
        for(int i=0; i<this.ingressos.size(); i++){
            Ingresso ingresso = this.ingressos.get(i);
            if(assento.getNumeroDoAssento().equals(ingresso.getNumeroDoAssento())){
                return ingressos.indexOf(ingresso);
            }
        }
        return 0;
    }

    public void listarAssentos(){

        int ultimoAssento = this.numeroDeAssentosPorFileira;
        int contador = 0;
        System.out.println("==========================================================");
        System.out.println("\n");
        for(int i=0; i<this.assentos.size(); i++){
            contador++;
            Assento assento = this.assentos.get(i);
            System.out.print(assento.getNumeroDoAssento() + " ");
            if(contador==ultimoAssento){
                System.out.println("\n");
                contador = 0;
            }
        }
        System.out.println("==========================================================");
    }

    public void listarAssentosReservados(){
        for(int i=0; i<this.assentos.size(); i++){
            Assento assento = this.assentos.get(i);
            if(assento.reservado){
                System.out.println(assento.numeroDoAssento);
            }
        }
    }

    public void listarIngressos(){
        int contador = 1;
        for(int i=0; i<this.ingressos.size(); i++){
            Ingresso ingresso = this.ingressos.get(i);
            ingresso.setNumeroDoIngresso(contador);
            ingresso.mostrarIngresso();
            contador++;
        }
    }

    public class Assento{

        private final String numeroDoAssento;
        private double preco;
        private boolean reservado;

        public Assento(String numeroDoAssento, double preco) {
            this.numeroDoAssento = numeroDoAssento;
            this.preco = preco;
            this.reservado = false;
        }

        public String getNumeroDoAssento() {
            return numeroDoAssento;
        }

        public double getPreco() {
            return preco;
        }

        public boolean reservar(){
            if(!this.reservado){
                this.reservado = true;
                System.out.println("Assento " + this.numeroDoAssento + " reservado");
                return true;
            }else{
                System.out.println("Assento " + this.numeroDoAssento + " já está reservado");
                return false;
            }
        }

        public boolean cancelar(){
            if(this.reservado){
                this.reservado = false;
                System.out.println("Reserva do assento " + this.numeroDoAssento + " cancelado");
                return true;
            }else{
                System.out.println("Assento " + this.numeroDoAssento + " não está reservado");
                return false;
            }
        }
    }
}
