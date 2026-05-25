package model;


public class Prenotazione {


        private String data_inizio;
        private String data_fine;
        private boolean stato;
        private int quant_persone;

         private Pagamento pagamento;
         private Cancellazione cancellazione; // Può essere null finché non viene cancellata
         private Cliente cliente;             // Chi ha effettuato la prenotazione
          private Struttura struttura;         // A quale struttura è inviata

        public Prenotazione(String data_inizio, String data_fine, boolean stato, int quant_persone,
        Pagamento pagamento , Cliente cliente, Struttura struttura){
            this.data_inizio = data_inizio;
            this.data_fine = data_fine;
            this.stato = stato;
            this.quant_persone = quant_persone;
            this.pagamento = pagamento;
            this.cancellazione = null;
            this.cliente=cliente;
            this.struttura=struttura;

        }

        public double calcolaPrezzoFinale (double prezzoBase, double moltiplicatoreEvento, boolean isPremium) {
            double totale = prezzoBase * moltiplicatoreEvento;
            if (isPremium) {
                totale = totale * 0.90; //sconto 10%
            }
            return totale;
        }

        public String getData_inizio() { return data_inizio;}
        public void setDataInizio(String data_inizio) { this.data_inizio = data_inizio; }

        public String getData_fine() {return data_fine;}
        public void setData_fine(String data_fine) { this.data_fine = data_fine; }

        public boolean getStato() { return stato;}
        public void setStato(boolean stato) { this.stato = stato; }

        public int getQuant_persone() { return quant_persone;}
        public void setQuant_persone(int quant_persone) { this.quant_persone = quant_persone; }

        public Pagamento getPagamento() { return pagamento;}
        public void setPagamento(Pagamento pagamento) { this.pagamento = pagamento; }

    public Cancellazione getCancellazione() {
        return cancellazione;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Struttura getStruttura() {
        return struttura;
    }

    public void setCancellazione(Cancellazione cancellazione) {
        this.cancellazione = cancellazione;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setStruttura(Struttura struttura) {
        this.struttura = struttura;
    }


    @Override
    public String toString() {
        return "Prenotazione dal " + data_inizio + " al " + data_fine +
                " per " + quant_persone + " persone. " +
                (stato ? "ATTIVA" : "CANCELLATA");
    }



    public void annullaPrenotazione(Cancellazione c) {
        this.stato = false; // La prenotazione non è più attiva
        this.cancellazione = c; // Assegno i dettagli della cancellazione
    }



}
