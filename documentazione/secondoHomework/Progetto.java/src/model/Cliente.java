package model;

import java.util.ArrayList;


public class Cliente extends Utente {

    private String IdUtente;
    private String numeroTelefono;
    private String IndirizzoDiFatturazione;
    private ArrayList <Recensione> mieRecensioni;
    private ArrayList <Prenotazione> miePrenotazioni;

    // usiamo una variabile d'appoggio
    private Piano mioAbbonamento;
    public void assegnaAbbonamento (Piano a){
        mioAbbonamento=a;
    }

    public  Cliente (String nome, String cognome , String email , String password, String IdUtente, String numeroTelefono, String indirizzoDiFatturazione){

        super (nome, cognome, email, password);

        this.IdUtente=IdUtente;
        this.numeroTelefono=numeroTelefono;
        this.IndirizzoDiFatturazione= IndirizzoDiFatturazione;

        mieRecensioni = new ArrayList<>();
        miePrenotazioni = new ArrayList<>();

        mioAbbonamento=null;

    }


    public String getIdUtente() {
        return IdUtente;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getIndirizzoDiFatturazione() {
        return IndirizzoDiFatturazione;
    }

    public ArrayList<Recensione> getMieRecensioni() {
        return mieRecensioni;
    }

    public ArrayList<Prenotazione> getMiePrenotazioni() {
        return miePrenotazioni;
    }

    public Piano getMioAbbonamento() {
        return mioAbbonamento;
    }

    public void setIdUtente(String idUtente) {
        IdUtente = idUtente;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setIndirizzoDiFatturazione(String indirizzoDiFatturazione) {
        IndirizzoDiFatturazione = indirizzoDiFatturazione;
    }

    public void setMieRecensioni(ArrayList<Recensione> mieRecensioni) {
        this.mieRecensioni = mieRecensioni;
    }

    public void setMiePrenotazioni(ArrayList<Prenotazione> miePrenotazioni) {
        this.miePrenotazioni = miePrenotazioni;
    }

    public void setMioAbbonamento(Piano mioAbbonamento) {
        this.mioAbbonamento=mioAbbonamento;
    }

    @Override
    public String mostraDashboard() {
        String risultato = " --- Dashboard Cliente --- \n";

        risultato += "ID cliente: " + getIdUtente() + "\n";
        risultato += "Nome: " + getNome() + ", Cognome: " + getCognome() + "\n";
        risultato += "Email: " + geteMail() + ", Telefono: " + getNumeroTelefono() + "\n";
        risultato += "Indirizzo di fatturazione: " + getIndirizzoDiFatturazione() + "\n";

        // Controlliamo l'Enum Piano
        if (mioAbbonamento != null) {
            // Stampa direttamente il nome dell'Enum (es. PREMIUM o GRATUITO)
            risultato += "Abbonamento Attivo: Piano " + mioAbbonamento + "\n";
        } else {
            risultato += "Nessun Abbonamento Attivo\n";
        }

        return risultato;
    }
}
