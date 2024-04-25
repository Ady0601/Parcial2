/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica_Negocio;

/**
 *
 * @author 1002963131
 */
public class Contacto {
    private String Nombre;
    private int Num_Cel;

    public Contacto() {
    }

    public Contacto(String Nombre, int Num_Cel) {
        this.Nombre = Nombre;
        this.Num_Cel = Num_Cel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNum_Cel() {
        return Num_Cel;
    }

    public void setNum_Cel(int Num_Cel) {
        this.Num_Cel = Num_Cel;
    }
    
    
    
}
