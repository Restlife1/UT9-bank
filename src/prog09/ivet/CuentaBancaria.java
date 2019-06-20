package prog09.ivet;

/**
 *
 * @author Ivet
 */
public abstract class CuentaBancaria {

  protected Persona titular;
  protected Double saldo;
  protected String ccc;

  public CuentaBancaria(Persona persona, Double saldo, String ccc) {
    this.titular = persona;
    this.saldo = saldo;
    this.ccc = ccc;
  }

  public void realizarIngreso(Double cantidad) {
    saldo += cantidad;
  }

  public boolean retirarEfectivo(Double cantidad) {
    if (cantidad <= saldo) {
      saldo -= cantidad;
      return true;
    } else {
      return false;
    }
  }

  public Persona getTitular() {
    return titular;
  }

  public void setTitular(Persona titular) {
    this.titular = titular;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public String getCcc() {
    return ccc;
  }

  public void setCcc(String ccc) {
    this.ccc = ccc;
  }
  
  @Override
  public String toString(){
    return ccc;
  }
  
}