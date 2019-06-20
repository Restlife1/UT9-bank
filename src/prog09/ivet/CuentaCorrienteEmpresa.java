package prog09.ivet;

import java.util.Hashtable;

/**
 *
 * @author Ivet
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    
  private Double descubiertoMax;
  private Double interesDescubierto;
  private Double comisionDescubierto;

    public CuentaCorrienteEmpresa(Double descubiertoMax, Double interesDescubierto, Double comisionDescubierto, Hashtable<String, Double> listaEntidesAutorizadas, Persona persona, Double saldo, String ccc) {
        super(listaEntidesAutorizadas, persona, saldo, ccc);
        this.descubiertoMax = descubiertoMax;
        this.interesDescubierto = interesDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }


  @Override
  public String toString(){
    return ccc;
  }
}
