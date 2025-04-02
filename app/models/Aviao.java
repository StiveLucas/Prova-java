package app.models;

import java.util.ArrayList;

public class Aviao {
    private String numeroDoAviao;
    private int quantidadeDeAssentos;
    private ArrayList<Reserva> reservas;

    public Aviao(String numeroDoAviao, int quantidadeDeAssentos) {
        this.numeroDoAviao = numeroDoAviao;
        this.quantidadeDeAssentos = quantidadeDeAssentos;
        this.reservas = new ArrayList<>();
    }

    public String getNumeroDoAviao() {
        return numeroDoAviao;
    }

    public int getQuantidadeDeAssentos() {
        return quantidadeDeAssentos;
    }

    public void setQuantidadeDeAssentos(int quantidadeDeAssentos) {
        this.quantidadeDeAssentos = quantidadeDeAssentos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(String passageiro) {
        String codigoReserva = "R" + (reservas.size() + 1);
        reservas.add(new Reserva(passageiro, codigoReserva));
    }

    public String toString() {
        return "Número do avião: " + numeroDoAviao + "\nQuantidade de Assentos: " + quantidadeDeAssentos + "\n";
    }
}
