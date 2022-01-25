package univr.structure;

public interface Infermiere extends Staff{

    String somministraFarmaco(String codPaziente, String codPersonale, String codFarmaci);

}