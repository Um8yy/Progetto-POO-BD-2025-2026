package model;

public class Cancellazione {
    private String motivo;
    private String data_cancellazione;
    private StatoRimborso stato_rimborso;
    private double percentuale_penale;
    private PoliticaCancellazione politica;

    public Cancellazione(String motivo, String data_cancellazione, StatoRimborso stato_rimborso, PoliticaCancellazione politica) {
        this.motivo = motivo;
        this.data_cancellazione = data_cancellazione;
        this.stato_rimborso = stato_rimborso;
        this.politica = politica;

        this.calcolaPercentualePenale();
    }


    private void calcolaPercentualePenale() {
        switch (this.politica) {
            case PoliticaCancellazione.FLESSIBILE:
                this.percentuale_penale = 0.0;
                break;
            case PoliticaCancellazione.SEMI_FLESSIBILE:
                this.percentuale_penale = 50.0;
                break;
            case PoliticaCancellazione.NON_FLESSIBILE:
                this.percentuale_penale = 100.0;
                break;
        }
    }


    public double getPercentualePenale() { return percentuale_penale; }


    public void setPercentualePenalePersonalizzata(double penale) {
        if(this.politica == PoliticaCancellazione.NON_FLESSIBILE) {
            this.percentuale_penale = penale;
        }
    }
}