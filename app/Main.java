package app;

import java.util.ArrayList;
import java.util.Scanner;

import app.models.Aviao;
import app.models.Reserva;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        ArrayList<Aviao> torreG = new ArrayList<Aviao>();

        int codigo = 0;
        do {
            
        System.out.println("--- Menu ---");
        System.out.println("Código | Descrição");
        System.out.println("  1    | Cadastrar Avião");
        System.out.println("  2    | Reservar Assentos Disponiveis");
        System.out.println("  3    | Consultar Avião");
        System.out.println("  4    | Consultar Passageiro");
        System.out.println("  5    | Encerrar");

        System.out.println("Digite o código: ");
        codigo = sc.nextInt();

        switch (codigo) {
            case 1:

                System.out.println("--- Cadastrando aviões ---");

                System.out.println("Digite o número do avião: ");
                String numeroDoAviao = sc.next();

                int quantidadeDeAssentos;

                do {

                    System.out.println("Digite o número de assentos: ");
                    quantidadeDeAssentos = sc.nextInt();

                    if (quantidadeDeAssentos > 20) {

                        System.out.println("O número de assentos não pode ser maior que 20");
                        
                    }

                    if (quantidadeDeAssentos <= 0) {

                        System.out.println("O número de assentos não pode ser menor ou igual a 0");
                        
                    }
                    
                } while (quantidadeDeAssentos > 20 || quantidadeDeAssentos <= 0);

                Aviao novoAviao = new Aviao(numeroDoAviao, quantidadeDeAssentos);
                torreG.add(novoAviao);
                
                break;

                case 2:

                    System.out.println("--- Reservando Assentos ---");
                    System.out.print("Digite o número do avião que deseja fazer a reserva: ");
                    String reservaDoAviao = sc.next();
                
                    for (Aviao aviao : torreG) {
                        if (reservaDoAviao.equals(aviao.getNumeroDoAviao())) {
                
                            if (aviao.getQuantidadeDeAssentos() <= 0) {
                                System.out.println("Avião encontrado, mas não há assentos disponíveis.");

                            } else {
                                System.out.println("Avião encontrado!");
                                System.out.println("Número do Avião: " + aviao.getNumeroDoAviao() + "\nAssentos disponíveis: " + aviao.getQuantidadeDeAssentos());
                
                                System.out.print("Digite o nome do passageiro: ");
                                String passageiro = sc.next();
                
                                System.out.print("Digite o número de reservas que deseja: ");
                                int numeroDeReservas = sc.nextInt();
                
                                if (numeroDeReservas > aviao.getQuantidadeDeAssentos()) {
                                    System.out.println("Não é possível realizar a reserva. Há somente " + aviao.getQuantidadeDeAssentos() + " assentos disponíveis.");

                                } else if (numeroDeReservas <= 0) {
                                    System.out.println("O número de reservas não pode ser negativo.");

                                } else {
                                    aviao.setQuantidadeDeAssentos(aviao.getQuantidadeDeAssentos() - numeroDeReservas);
                
                                    for (int i = 0; i < numeroDeReservas; i++) {
                                        aviao.addReserva(passageiro);
                                    }
                
                                    System.out.println("Reserva(s) feita(s) com sucesso para " + passageiro + "!");
                                }
                            }
                            break;
                        }
                    }
                    break;
            

                case 3:

                    System.out.println("--- Consultar Avião ---");
                    System.out.print("Digite o número do avião: ");
                    String consultaAviao = sc.next();
                
                    boolean aviaoEncontrado = false;
                
                    for (Aviao aviao : torreG) {
                        if (aviao.getNumeroDoAviao().equals(consultaAviao)) {
                            aviaoEncontrado = true;
                
                            if (aviao.getReservas().isEmpty()) {
                                System.out.println("Não há reservas para este avião!");
                            } else {
                                System.out.println("Reservas para o avião " + aviao.getNumeroDoAviao() + ":");
                
                                for (Reserva reserva : aviao.getReservas()) { 
                                    System.out.println("- " + reserva.getCodigoReserva() + " | Passageiro: " + reserva.getPassageiro());
                                }
                            }
                            break;
                        }
                    }
                
                    if (!aviaoEncontrado) {
                        System.out.println("Este avião não existe!");
                    }
                    break;
            

            case 4:

                System.out.println("--- Consultar Passageiro ---");
                System.out.print("Digite o nome do passageiro: ");
                String nomePassageiro = sc.next();

                boolean encontrouReservas = false;

                for (Aviao aviao : torreG) {
                    for (Reserva reserva : aviao.getReservas()) {

                        if (reserva.getPassageiro().equalsIgnoreCase(nomePassageiro)) {
                            if (!encontrouReservas) {
                                System.out.println("Reservas encontradas para " + nomePassageiro + ":");
                                encontrouReservas = true;

                            }
                            System.out.println("- " + reserva + " (Avião: " + aviao.getNumeroDoAviao() + ")");
                        }
                    }
                }

                if (!encontrouReservas) {
                    System.out.println("Não há reservas para este passageiro!");
                }

                break;

                
            case 5:
            
                System.out.println("Programa sendo encerrado.");

        
            default:
                break;
        }


        } while (codigo != 5);
    }

    
}
