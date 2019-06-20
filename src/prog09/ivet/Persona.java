package prog09.ivet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Ivet
 */
public class Persona {
  private String nombre;
  private String apellidos;
  private LocalDate fechaNacim;
  private Double saldoInicial;

  public Persona(String nombre, String apellidos, LocalDate fechaNacim, Double saldoInicial) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechaNacim = fechaNacim;
    this.saldoInicial = saldoInicial;
  }
  
  public Persona(){
    
  }

  protected String getNombre (){
    return nombre;
  }

  protected String getApellidos (){
    return apellidos;
  }

  protected LocalDate getFechaNacim (){
    return this.fechaNacim;
  }

  protected void setNombre (String nombre){
    this.nombre= nombre;
  }

  protected void setApellidos (String apellidos){
    this.apellidos= apellidos;
  }

  protected void setFechaNacim (LocalDate fechaNacim){
    this.fechaNacim= fechaNacim;
  }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
  
  
  
  @Override
  public String toString() {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
    return nombre + " " + apellidos + ", "+ " " + formatoFecha.format(fechaNacim);
  }
}
