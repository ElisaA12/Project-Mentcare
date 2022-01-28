package univr;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appuntamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codFiscalePaziente;
    private String codFiscalePersonale;
    private String nomePaziente;
    private String cognomePaziente;
    private String nomePersonale;
    private String cognomePersonale;
    private Long ambulatorio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String indirizzo;
    private String descrizione;

    public Appuntamento() {
    }

    public Appuntamento(String codFiscalePaziente, String codFiscalePersonale, String nomePaziente,
                        String cognomePaziente, String nomePersonale, String cognomePersonale,
                        Long ambulatorio, Date data, String indirizzo, String descrizione) {
        this.codFiscalePaziente = codFiscalePaziente;
        this.codFiscalePersonale = codFiscalePersonale;
        this.nomePaziente = nomePaziente;
        this.cognomePaziente = cognomePaziente;
        this.nomePersonale = nomePersonale;
        this.cognomePersonale = cognomePersonale;
        this.ambulatorio = ambulatorio;
        this.data = data;
        this.indirizzo = indirizzo;
        this.descrizione = descrizione;
    }

    public Long getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Long ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public String getCodFiscalePersonale() {
        return codFiscalePersonale;
    }

    public void setCodFiscalePersonale(String codFiscalePersonale) {
        this.codFiscalePersonale = codFiscalePersonale;
    }

    public String getCodFiscalePaziente() {
        return codFiscalePaziente;
    }

    public void setCodFiscalePaziente(String codFiscalePaziente) {
        this.codFiscalePaziente = codFiscalePaziente;
    }

    public String getCognomePaziente() {
        return cognomePaziente;
    }

    public void setCognomePaziente(String cognomePaziente) {
        this.cognomePaziente = cognomePaziente;
    }

    public String getNomePaziente() {
        return nomePaziente;
    }

    public void setNomePaziente(String nomePaziente) {
        this.nomePaziente = nomePaziente;
    }

    public String getCognomePersonale() {
        return cognomePersonale;
    }

    public void setCognomePersonale(String cognomePersonale) {
        this.cognomePersonale = cognomePersonale;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNomePersonale() {
        return nomePersonale;
    }

    public void setNomePersonale(String nomePersonale) {
        this.nomePersonale = nomePersonale;
    }

}
