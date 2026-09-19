/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;

/**
 *
 * @author rasta
 */
public class Cliente {
    
     //Variables - Atributos
    public String nombreCliente; 
    public String memberID;
    private char memberType;
    public String RTN;
    private int Edad;

    //Constructor 1
    public Cliente(){
        this.nombreCliente = "Luis";
        this.memberID = "03879";
        this.memberType = 'P';
        this.RTN = "08011999164866";
        this.Edad = 26;
    }// fin constructor 1 
    
    public Cliente(String nombreCliente, String memberID, char memberType, String RTN, int Edad) {
        this.nombreCliente = nombreCliente;
        this.memberID = memberID;
        this.memberType = memberType;
        this.RTN = RTN;
        this.Edad = Edad;
        
    }//fin constructor 2 
    
    // funcinoes/metodos
    
        public void setEdad(int Edad) {
        if (Edad >= 0 && Edad <= 120) {
            this.Edad = Edad;
        } else {
            System.out.println("Error: la edad no puede ser negativa, ni mayor a 120.");
        }
    }
    /// fin de setEdad
public int getEdad() {
    return this.Edad;
}// fin getEdad
    

    public void setmemberType(char memberType){
        if (memberType == 'B'|| memberType == 'P'){
            this.memberType = memberType;
    } else {
            System.out.println("Su membresia debe ser Personal o Business");
            } 
    }// fin setmemberType
    public char getmemberType(){
        return this.memberType;
    }
}//Fin de class cliente
