package univr;

import javax.persistence.*;

@Entity
public class FarmaciSomministrati {
    @Id
    private String idFarmaco;
    private String codPaziente;
    private String nome_farmaco;
    private int dose;
    private int numGiorni;
    private String somministratore;
    private boolean somministrato=false;
    private double costo;
    private String codMedico;

    public FarmaciSomministrati() {
    }

    public FarmaciSomministrati(String codPaziente, String idFarmaco, String nome_farmaco,int dose, int numGiorni, String somministratore, boolean somministrato, double costo,String codMedico){
        this.codPaziente=codPaziente;
        this.idFarmaco= idFarmaco;
        this.nome_farmaco=nome_farmaco;
        this.dose=dose;
        this.numGiorni=numGiorni;
        this.somministratore=somministratore;
        this.somministrato=somministrato;
        this.costo=costo;
        this.codMedico=codMedico;
    }

    public int getNumGiorni() {
        return numGiorni;
    }

    public void setNumGiorni(int numGiorni) {
        this.numGiorni = numGiorni;
    }
    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public boolean isSomministrato() {
        return somministrato;
    }

    public void setSomministrato(boolean somministrato) {
        this.somministrato = somministrato;
    }

    public String getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(String codMedico) {
        this.codMedico = codMedico;
    }

    public String getCodPaziente() {
        return codPaziente;
    }

    public void setCodPaziente(String codPaziente) {
        this.codPaziente = codPaziente;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(String idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public String getNome_farmaco() {
        return nome_farmaco;
    }

    public void setNome_farmaco(String nome_farmaco) {
        this.nome_farmaco = nome_farmaco;
    }


    public String getSomministratore() {
        return somministratore;
    }

    public void setSomministratore(String somministratore) {
        this.somministratore = somministratore;
    }
}
