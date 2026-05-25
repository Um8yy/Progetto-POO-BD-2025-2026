package model;



public class TariffarioEventiSpeciali {

    private String data_inizio;
    private String data_fine;
    private String nome_evento;
    private double moltiplicatore_prezzo;

    public TariffarioEventiSpeciali(String data_inizio, String data_fine, String nome_evento, double moltiplicatore_prezzo) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.nome_evento = nome_evento;
        this.moltiplicatore_prezzo = moltiplicatore_prezzo;
    }

    public String getData_inizio() { return data_inizio; }
    public void setData_inizio(String data_inizio) { this.data_inizio = data_inizio; }

    public String getData_fine() { return data_fine; }
    public void setData_fine(String data_fine) { this.data_fine = data_fine; }

    public String getNome_evento() { return nome_evento; }
    public void setNome_evento(String nome_evento) { this.nome_evento = nome_evento; }

    public double getMoltiplicatore_prezzo() { return moltiplicatore_prezzo; }
    public void setMoltiplicatore_prezzo(double moltiplicatore_prezzo) { this.moltiplicatore_prezzo = moltiplicatore_prezzo; }


    @Override
    public String toString() {
        return "Evento Speciale: " + nome_evento + " (dal " + data_inizio + " al " + data_fine + "). " +
                "Moltiplicatore prezzo: " + moltiplicatore_prezzo + "x";
    }
}
