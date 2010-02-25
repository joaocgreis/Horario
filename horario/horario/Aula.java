/*
 * Aula.java
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
public class Aula {
    
    Dia _dia;
    Tempo _tempo;
    Sala _sala;
    
    /** Creates a new instance of Aula */
    public Aula(Dia dia, Tempo tempo, Sala sala) {
        _dia = dia;
        _tempo = tempo;
        _sala = sala;
    }
    
    public Dia dia(){
        return _dia;
    }
    
    public Tempo tempo(){
        return _tempo;
    }
    
    public Sala sala(){
        return _sala;
    }
    
    public String toString(){
        return "Aula de " + _dia + " " + _tempo + " na sala " + _sala + ".";
    }
    
}
