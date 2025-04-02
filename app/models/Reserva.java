package app.models;

public class Reserva {
    private String passageiro;
    private String codigoReserva;

    public Reserva(String passageiro, String codigoReserva) {
        this.passageiro = passageiro;
        this.codigoReserva = codigoReserva;
    }

    public String getPassageiro() {
        return passageiro;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }
    
    public String toString() {
        return "Reserva: " + codigoReserva + " | Passageiro: " + passageiro;
    }
}
