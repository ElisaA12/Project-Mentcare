package univr;

import javax.persistence.*;
@Entity
public class Paziente{

    @Id
    private  String codFiscale;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String comune;
    private int cap;
    private String provincia;
    private Long telefono1;
    private Long telefono2;
    private String patologia;
    private String descrizione;
    private boolean autosufficiente;
    private String codiceMedico;

    public Paziente() {
    }


    public Paziente(String codFiscale, String nome, String cognome, String username, String password, String indirizzo,
                    String comune, int cap, String provincia, Long telefono1, Long telefono2,
                    String patologia, String descrizione,
                    boolean autosufficiente, String codiceMedico
    ) {
        this.codFiscale=codFiscale;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.comune = comune;
        this.cap = cap;
        this.provincia = provincia;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.nome=nome;
        this.username = username;
        this.password = password;
        this.patologia = patologia;
        this.descrizione = descrizione;
        this.autosufficiente = autosufficiente;
        this.codiceMedico = codiceMedico;

    }
    public String getCodFiscale() {
        return codFiscale;
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Long getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(Long telefono1) {
        this.telefono1 = telefono1;
    }

    public Long getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(Long telefono2) {
        this.telefono2 = telefono2;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isAutosufficiente() {
        return autosufficiente;
    }

    public void setAutosufficiente(boolean autosufficiente) {
        this.autosufficiente = autosufficiente;
    }

    public String getCodiceMedico() {
        return codiceMedico;
    }

    public void setCodiceMedico(String codiceMedico) {
        this.codiceMedico = codiceMedico;
    }

}