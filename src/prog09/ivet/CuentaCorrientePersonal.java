package prog09.ivet;

import java.util.Hashtable;

/**
 *
 * @author Ivet
 */
public class CuentaCorrientePersonal extends CuentaCorriente {
    
  private Double comision;

  public CuentaCorrientePersonal(Double comision, Hashtable<String, Double> listaEntidesAutorizadas, Persona persona, Double saldo, String ccc) {
    super(listaEntidesAutorizadas, persona, saldo, ccc);
    this.comision = comision;
  } 

  public Double getComision() {
    return comision;
  }

  public void setComision(Double comision) {
    this.comision = comision;
  }
  
  @Override
  public String toString(){
    return ccc;
  }
}
