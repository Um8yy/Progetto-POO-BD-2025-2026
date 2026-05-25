package model;

public class Servizio {


        private boolean parcheggio;
        private boolean piscina;
        private boolean palestra;
        private boolean wifi;
        private boolean spa;
        private Pensione pensione;



        public Servizio(boolean parcheggio, boolean piscina, boolean palestra, boolean wifi, boolean spa, Pensione pensione){
            this.parcheggio = parcheggio;
            this.piscina = piscina;
            this.palestra = palestra;
            this.wifi = wifi;
            this.spa = spa;
            this.pensione = pensione;
        }

    public boolean isParcheggio() {
        return parcheggio;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public boolean isPalestra() {
        return palestra;
    }

    public boolean isWifi() {
        return wifi;
    }

    public boolean isSpa() {
        return spa;
    }

    public Pensione getPensione() {
        return pensione;
    }

    public boolean verificaServizio (String servizioDaCercare) {
            if(servizioDaCercare.equalsIgnoreCase("parcheggio")) return parcheggio;
            if(servizioDaCercare.equalsIgnoreCase("piscina")) return piscina;
            if(servizioDaCercare.equalsIgnoreCase("palestra")) return palestra;
            if(servizioDaCercare.equalsIgnoreCase("WI-FI")) return wifi ;
            if(servizioDaCercare.equalsIgnoreCase("spa")) return spa ;
            return false;
        }

    public String elencoServiziAttivi() {
        String risultato = "";
        if (parcheggio == true) {
            risultato = risultato + "Parcheggio ";
        }
        if (piscina == true) {
            risultato = risultato + "Piscina ";
        }
        if (palestra == true) {
            risultato = risultato + "Palestra ";
        }
        if (wifi == true) {
            risultato = risultato + "Wi-Fi ";
        }
        if (spa == true) {
            risultato = risultato + "SPA ";
        }
        if (risultato.equals("")) {
            return "Nessun servizio disponibile";
        }
        return risultato;
    }

    public String servizioSoloColazione (){
            String risultato = " ";
            if(pensione==Pensione.SOLO_COLAZIONE){
                 risultato += "Solo colazione";
            }
            risultato += "non specificato";
            return risultato;
    }



}

