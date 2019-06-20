package prog09.ivet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Ivet
 */
public class Prog09Ivet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int opcion = 0;
    
    Scanner tecladoLetras = new Scanner(System.in);
    Scanner tecladoNumeros = new Scanner(System.in);
    ArrayList<CuentaBancaria> cuenta = new ArrayList();
        
    do{ // Se ejecuta hasa que introducimos un 0
        
        System.out.println("Elege una opción"
                + "\n1. Abrir una nueva cuenta."
                + "\n2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).\n" +
                    "3. Obtener los datos de una cuenta concreta.\n" +
                    "4. Realizar un ingreso en una cuenta.\n" +
                    "5. Retirar efectivo de una cuenta.\n" +
                    "6. Consultar el saldo actual de una cuenta.\n" +
                    "7. Salir de la aplicación.");
        
        opcion = tecladoNumeros.nextInt();
        
      switch (opcion){
        case 1:
            
            String nombre, apellidos, tipo;
            String fecha, ccc;
            LocalDate fechaNac = null;
            Double saldoInicial;
            
            System.out.println("Introduzca nombre del titular");
            nombre = tecladoLetras.nextLine();
            
            System.out.println("Introduzca apellidos del titular");
            apellidos = tecladoLetras.nextLine();
            
            System.out.println("Introduzca fecha de nacimiento");
            fecha = tecladoLetras.nextLine();
            fechaNac.parse(fecha);
            
            System.out.println("Introduzca el saldo inicial");
            saldoInicial = tecladoNumeros.nextDouble();
            
            System.out.println("Introducir la cuenta bancaria");
            ccc = tecladoLetras.nextLine();
            
            System.out.println("Tipo de cuenta (Cuenta ahorro, Cuenta corriente personal o Cuenta corriente empresa)");
            tipo = tecladoLetras.nextLine();
            
            if(tipo.equalsIgnoreCase("Cuenta ahorro")){
                
                Double interesRemuneracion;
                System.out.println("Introduce el tipo de interés anual");
                interesRemuneracion = tecladoNumeros.nextDouble();
                
                Persona persona = new Persona(nombre, apellidos, fechaNac, saldoInicial);
                CuentaAhorro cuentaAhorro =  new CuentaAhorro(interesRemuneracion, persona, saldoInicial, ccc);
                cuenta.add(cuentaAhorro);
                
            }else if(tipo.equalsIgnoreCase("Cuenta corriente personal")){
                
                Hashtable<String, Double> listaEntidesAutorizadas = new Hashtable();
                Double comision, maxCantidad;
                String codigoEntidad = "Pedir";
                System.out.println("Introduce la comisión");
                comision = tecladoNumeros.nextDouble();
                
                while(!codigoEntidad.equals("")){       //Mientras no esté vacío me pida :
                    
                    System.out.println("Introduzca la máxima cantidad autorizada");
                    maxCantidad = tecladoNumeros.nextDouble();
                    
                    System.out.println("Introduzca el código de la entidad");
                    codigoEntidad = tecladoNumeros.nextLine();
                    
                    listaEntidesAutorizadas.put(codigoEntidad, maxCantidad);
                    
                }
                
                Persona persona = new Persona(nombre, apellidos, fechaNac, saldoInicial);
                CuentaCorrientePersonal ccp = new CuentaCorrientePersonal(comision, listaEntidesAutorizadas, persona, saldoInicial, ccc);
                cuenta.add(ccp);        //Después de crear el objeto, lo introduzco en el arrayList
                
            }else if(tipo.equalsIgnoreCase("Cuenta corriente empresa")){
                
                Hashtable<String, Double> listaEntidesAutorizadas = new Hashtable();
                Double maxCantidad, descubiertoMax, interesDescubierto, comisionDescubierto;
                String codigoEntidad = "Pedir";
                
                System.out.println("Introduzca el descubierto máximo");
                descubiertoMax = tecladoNumeros.nextDouble();
                
                System.out.println("Introduzca el interes descubierto");
                interesDescubierto = tecladoNumeros.nextDouble();
                
                System.out.println("Introduzca la comisión descubierta");
                comisionDescubierto = tecladoNumeros.nextDouble();
                
                while(!codigoEntidad.equals("")){       //Mientras no esté vacío me pida :
                    
                    System.out.println("Introduzca la máxima cantidad autorizada");
                    maxCantidad = tecladoNumeros.nextDouble();
                    
                    System.out.println("Introduzca el código de la entidad");
                    codigoEntidad = tecladoNumeros.nextLine();
                    
                    listaEntidesAutorizadas.put(codigoEntidad, maxCantidad);
                    
                }
                
                Persona persona = new Persona(nombre, apellidos, fechaNac, saldoInicial);
                CuentaCorrienteEmpresa cce = new CuentaCorrienteEmpresa(descubiertoMax, interesDescubierto, comisionDescubierto, listaEntidesAutorizadas, persona,
                    saldoInicial, ccc);
                cuenta.add(cce);
                
            }
          
          break;
        case 2:
            
            System.out.println("Código | Titular | Saldo inicial");     //Cabecera para el for-each de las cuentas registradas
            for(CuentaBancaria c :  cuenta){
                
                System.out.println(c.getCcc() + " " + c.getTitular() + " " + c.getSaldo());
                
            }
          
          break;
        case 3:
            
            System.out.println("Introduzca la cuenta a consultar");
            String cuentaIntroducida;
            cuentaIntroducida = tecladoLetras.nextLine();
            
            for(CuentaBancaria c :  cuenta){
                
                if(cuentaIntroducida.equalsIgnoreCase(c.getCcc())){
                    
                    System.out.println(c.getCcc() + " " + c.getTitular() + " " + c.getSaldo());
                    
                }                
                
            }
          
          break;
        case 4:
            
            System.out.println("Introduzca la cuenta a ingrear");
            String cuentaIntroducidaIngreso;
            cuentaIntroducidaIngreso = tecladoLetras.nextLine();            
            
            for(CuentaBancaria c :  cuenta){
                
                if(cuentaIntroducidaIngreso.equalsIgnoreCase(c.getCcc())){
                    
                    Double ingreso;
                    System.out.println("Introduzca un ingreso");
                    ingreso = tecladoNumeros.nextDouble();
                    ingreso += c.getSaldo();
                    
                    c.setSaldo(ingreso);
                    
                }                
                
            }
            
          
          break;
        case 5:
            
            System.out.println("Introduzca la cuenta a ingrear");
            String cuentaIntroducidaRetiro;
            cuentaIntroducidaRetiro = tecladoLetras.nextLine();            
            
            for(CuentaBancaria c :  cuenta){
                
                if(cuentaIntroducidaRetiro.equalsIgnoreCase(c.getCcc())){
                    
                    Double retirar;
                    System.out.println("Introduzca saldo a retirar");
                    retirar = tecladoNumeros.nextDouble();
                    retirar = (retirar*(-1)) + c.getSaldo();    //Para hacer retirar negativo multiplico lo que introduzco por si mismo en negativo
                    
                    c.setSaldo(retirar);
                    
                }                
                
            }
          
          break;
        case 6:
            
            System.out.println("Introduzca la cuenta a ingrear");
            String cuentaIntroducidaConsulta;
            cuentaIntroducidaConsulta = tecladoLetras.nextLine();            
            
            for(CuentaBancaria c :  cuenta){
                
                if(cuentaIntroducidaConsulta.equalsIgnoreCase(c.getCcc())){
                    
                    System.out.println("Su saldo es de " + c.getSaldo() + "€");
                    
                }                
                
            }
          
          break;
        case 7:
            System.out.println("Hasta luego!");
          break;
      }
    }while(opcion != 7);
  }
    
}
