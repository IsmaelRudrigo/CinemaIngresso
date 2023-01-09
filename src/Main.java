import java.util.Scanner;

public class Main {
    public static Cinema cinema = new Cinema("Cinema",12, 8 );
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        boolean sair = false;

        menu();

        while(!sair){
            System.out.println("Digite sua opção: 6 - Para ver opções");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 0:
                    sair = true;
                    break;

                case 1:
                    reservarAssento();
                    break;

                case 2:
                    cancelarReserva();
                    break;

                case 3:
                    cinema.listarAssentos();
                    break;

                case 4:
                    cinema.listarAssentosReservados();
                    break;

                case 5:
                    cinema.listarIngressos();
                    break;

                case 6:
                    menu();
                    break;
            }
        }

    }

    public static void reservarAssento(){

        System.out.println("Meia ou inteira? 1 - para inteira, 2 - para meia");
        int opcao = sc.nextInt();
        sc.nextLine();

        String numero;

        if(opcao == 1){
            System.out.println("Digite o número do assento: ");
            numero = sc.nextLine();
            cinema.reservarAssento(numero, true);
        }else if(opcao == 2){
            System.out.println("Digite o número do assento: ");
            numero = sc.nextLine();
            cinema.reservarAssento(numero, false);
        }else{
            while(true){
                System.out.println("Opção inválida! Digite 1 para inteira ou 2 para meia");
                opcao = sc.nextInt();
                sc.nextLine();

                if(opcao == 1){
                    System.out.println("Digite o número do assento: ");
                    numero = sc.nextLine();
                    cinema.reservarAssento(numero, true);
                    break;
                }

                if(opcao == 2){
                    System.out.println("Digite o número do assento: ");
                    numero = sc.nextLine();
                    cinema.reservarAssento(numero, false);
                    break;
                }
            }
        }
    }

    public static void cancelarReserva(){
        System.out.println("Digite o número do assento: ");
        String numero = sc.nextLine();

        cinema.cancelarReserva(numero);
    }

    public static void menu(){
        System.out.println("Pressione \n" +
                "0 - para parar\n" +
                "1 - para reservar assento\n" +
                "2 - para cancelar assento\n" +
                "3 - para listar assentos\n" +
                "4 - para listar assentos reservados\n" +
                "5 - para listar ingressos\n" +
                "6 - para ver opções");
    }

}