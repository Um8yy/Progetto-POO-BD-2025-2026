package model;

public abstract class Utente {

    private String nome;
    private String cognome;
    private String eMail;
    private String password;

    public Utente (String nome, String cognome, String eMail, String password){
        this.nome=nome;
        this.cognome=cognome;
        this.eMail=eMail;
        this.password=password;
    }

    /*public boolean login (String emailInserita , String passInserita){
        return eMail.equals(emailInserita) && password.equals(passInserita); // restituisce true in questo modo
    }*/


    public abstract String mostraDashboard (); // metodo  astratto poichè non ha un comportamento predefinito e può cambiare da classe a classe

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
