package model;

import java.util.ArrayList;


/**
 * Creazione del cliente che può effettuare prenotaizoni , sottoscrivere abbonamento (sia gratis che premium) e fare le recensioni alla struttura
 */
public class Cliente extends Utente {

    private String IdUtente;
    private String numeroTelefono;
    private String IndirizzoDiFatturazione;
    private ArrayList <Recensione> mieRecensioni;
    private ArrayList <Prenotazione> miePrenotazioni;

    // usiamo una variabile d'appoggio
    private Piano mioAbbonamento;

    /**
     * Assegna abbonamento.
     *
     * @param a the a
     */
    public void assegnaAbbonamento (Piano a){
        mioAbbonamento=a;
    }

    /**
     * Instantiates a new Cliente.
     *
     * @param nome                     nome
     * @param cognome                  cognome
     * @param email                    email
     * @param password                 password
     * @param IdUtente                 id utente
     * @param numeroTelefono           numero telefono
     * @param indirizzoDiFatturazione  indirizzo di fatturazione
     */
    public  Cliente (String nome, String cognome , String email , String password, String IdUtente, String numeroTelefono, String indirizzoDiFatturazione){

        super (nome, cognome, email, password);

        this.IdUtente=IdUtente;
        this.numeroTelefono=numeroTelefono;
        this.IndirizzoDiFatturazione= IndirizzoDiFatturazione;

        mieRecensioni = new ArrayList<>();
        miePrenotazioni = new ArrayList<>();

        mioAbbonamento=null;

    }


    /**
     * Gets id utente.
     *
     * @return the id utente
     */
    public String getIdUtente() {
        return IdUtente;
    }

    /**
     * Gets numero telefono.
     *
     * @return the numero telefono
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Gets indirizzo di fatturazione.
     *
     * @return the indirizzo di fatturazione
     */
    public String getIndirizzoDiFatturazione() {
        return IndirizzoDiFatturazione;
    }

    /**
     * Gets mie recensioni.
     *
     * @return the mie recensioni
     */
    public ArrayList<Recensione> getMieRecensioni() {
        return mieRecensioni;
    }

    /**
     * Gets mie prenotazioni.
     *
     * @return the mie prenotazioni
     */
    public ArrayList<Prenotazione> getMiePrenotazioni() {
        return miePrenotazioni;
    }

    /**
     * Gets mio abbonamento.
     *
     * @return the mio abbonamento
     */
    public Piano getMioAbbonamento() {
        return mioAbbonamento;
    }

    /**
     * Sets id utente.
     *
     * @param idUtente the id utente
     */
    public void setIdUtente(String idUtente) {
        IdUtente = idUtente;
    }

    /**
     * Sets numero telefono.
     *
     * @param numeroTelefono the numero telefono
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * Sets indirizzo di fatturazione.
     *
     * @param indirizzoDiFatturazione the indirizzo di fatturazione
     */
    public void setIndirizzoDiFatturazione(String indirizzoDiFatturazione) {
        IndirizzoDiFatturazione = indirizzoDiFatturazione;
    }

    /**
     * Sets mie recensioni.
     *
     * @param mieRecensioni the mie recensioni
     */
    public void setMieRecensioni(ArrayList<Recensione> mieRecensioni) {
        this.mieRecensioni = mieRecensioni;
    }

    /**
     * Sets mie prenotazioni.
     *
     * @param miePrenotazioni the mie prenotazioni
     */
    public void setMiePrenotazioni(ArrayList<Prenotazione> miePrenotazioni) {
        this.miePrenotazioni = miePrenotazioni;
    }

    /**
     * Sets mio abbonamento.
     *
     * @param mioAbbonamento the mio abbonamento
     */
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


        if (mioAbbonamento != null) {

            risultato += "Abbonamento Attivo: Piano " + mioAbbonamento + "\n";
        } else {
            risultato += "Nessun Abbonamento Attivo\n";
        }

        return risultato;
    }
}
