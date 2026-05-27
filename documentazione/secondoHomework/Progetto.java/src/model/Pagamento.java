package model;

/**
 La classe si occupa di gestire il pagamento per la struttura da parte del cliente
 */
public class Pagamento {

    private String coordinate_bancarie;
    private boolean stato;
    private double importo;
    private String data_pagamento;

    /**
     * Instantiates a new Pagamento.
     *
     * @param coordinate_bancarie  coordinate bancarie
     * @param stato                stato
     * @param importo              importo
     * @param data_pagamento       data pagamento
     */
    public Pagamento(String coordinate_bancarie, boolean stato, double importo, String data_pagamento) {
        this.coordinate_bancarie = coordinate_bancarie;
        this.stato = stato;
        this.importo = importo;
        this.data_pagamento = data_pagamento;
    }

    /**
     * Gets coordinate bancarie.
     *
     * @return the coordinate bancarie
     */
    public String getCoordinate_bancarie() { return coordinate_bancarie;}

    /**
     * Gets stato.
     *
     * @return the stato
     */
    public boolean getStato() { return stato;}

    /**
     * Gets importo.
     *
     * @return the importo
     */
    public double getImporto() { return importo;}

    /**
     * Gets data pagamento.
     *
     * @return the data pagamento
     */
    public String getData_pagamento() { return data_pagamento;}


    /**
     * Sets stato.
     *
     * @param stato the stato
     */
    public void setStato(boolean stato) { this.stato = stato;}


    /**
     * Elabora pagamento del cliente
     *
     * @param dataOdierna  data odierna (data in cui viene fatto il pagamento) in base allo stato se è andato a buon fine o no
     */
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
