package model;

/**
 creazione della classe (astratta) generica utente che poi si specilizzerà nella figura di cliente e host (ereditanto gli attributi in comune tra i due )
 */
public abstract class Utente {

    private String nome;
    private String cognome;
    private String eMail;
    private String password;

    /**
     * Instantiates a new Utente.
     *
     * @param nome     the nome
     * @param cognome  the cognome
     * @param eMail    the e mail
     * @param password the password
     */
    public Utente (String nome, String cognome, String eMail, String password){
        this.nome=nome;
        this.cognome=cognome;
        this.eMail=eMail;
        this.password=password;
    }


    /**
     * Mostra dashboard string.
     *
     * @return the string
     */
    public abstract String mostraDashboard (); // metodo  astratto poichè non ha un comportamento predefinito e può cambiare da classe a classe

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets cognome.
     *
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Gets mail.
     *
     * @return the mail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sets cognome.
     *
     * @param cognome the cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Sets mail.
     *
     * @param eMail the e mail
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
