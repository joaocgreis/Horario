/*
 * Sala.java
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
public class Sala {
    
    public static final String SEM_SALA = " ";
    
    private String _nome;
    
    /** Creates a new instance of Sala */
    public Sala(String nome) {
        _nome = nome;
    }
    
    /** Creates a new instance of Sala */
    public Sala() {
        _nome = SEM_SALA;
    }
    
    public String nome(){
        return _nome;
    }
    
    public String toString(){
        return _nome;
    }
    
}
