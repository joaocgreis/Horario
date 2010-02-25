/*
 * Tempo.java
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
public class Tempo {
    
    Hora _inicio;
    Hora _fim;
    
    /** Creates a new instance of Tempo */
    public Tempo(Hora inicio, Hora fim) {
        _inicio = inicio;
        _fim = fim;
    }
    
    public Hora inicio(){
        return _inicio;
    }
    
    public Hora fim(){
        return _fim;
    }
    
    public String toString(){
        return "das " + _inicio + " às " + _fim;
    }
    
    public boolean equals(Object o){
        return o instanceof Tempo && equals((Tempo)o);
    }
    
    public boolean equals(Tempo t){
        return (t._inicio.equals(_inicio)) && (t._fim.equals(_fim));
    }
    
    public int meiasHoras(){
        return _fim.posicaoHorario() - _inicio.posicaoHorario();
    }
}
