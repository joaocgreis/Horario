/*
 * Dia.java
 *
 * Created on 25 de Agosto de 2007, 21:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.horario;

/**
 *
 * @author reis
 */
public class Dia {
    
    int _numero;
    
    /** Creates a new instance of Dia */
    public Dia(int numero) {
        _numero = numero;
    }
    
    public Dia(String dia) {
        if(dia.equalsIgnoreCase("Seg")) _numero = 2;
        if(dia.equalsIgnoreCase("Ter")) _numero = 3;
        if(dia.equalsIgnoreCase("Qua")) _numero = 4;
        if(dia.equalsIgnoreCase("Qui")) _numero = 5;
        if(dia.equalsIgnoreCase("Sex")) _numero = 6;
    }

    public int numero(){
        return _numero;
    }
    
    public String toString(){
        return _numero + "ª feira";
    }
    
}
