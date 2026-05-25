package model;

public class Pagamento {

    private String coordinate_bancarie;
    private boolean stato;
    private double importo;
    private String data_pagamento;

    public Pagamento(String coordinate_bancarie, boolean stato, double importo, String data_pagamento) {
        this.coordinate_bancarie = coordinate_bancarie;
        this.stato = stato;
        this.importo = importo;
        this.data_pagamento = data_pagamento;
    }

    public String getCoordinate_bancarie() { return coordinate_bancarie;}
    public boolean getStato() { return stato;}
    public double getImporto() { return importo;}
    public String getData_pagamento() { return data_pagamento;}


    public void setStato(boolean stato) { this.stato = stato;}



    public void elaboraPagamento(String dataOdierna) {
        this.stato = true; // Il pagamento va a buon fine
        this.data_pagamento = dataOdierna;
    }

    @Override
    public String toString() {
        return "Pagamento di " + importo + "€ tramite " + coordinate_bancarie +
                ". Stato: " + (stato ? "Completato in data " + data_pagamento : "In attesa");
    }
}
