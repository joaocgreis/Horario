/*
 * TipoDiaSeparador.java
 *
 * Created on September 7, 2007, 4:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.visitor;

import horario.horario.*;
import horario.escritor.*;
import java.util.*;

/**
 *
 * @author reis
 */
public class TipoDiaSeparador implements HorarioVisitor {
    
    private Set<EntradaHorario> _segunda;
    private Set<EntradaHorario> _terca;
    private Set<EntradaHorario> _quarta;
    private Set<EntradaHorario> _quinta;
    private Set<EntradaHorario> _sexta;
    private String _cadeiraActual;
    private String _tipo;
    
    /** Creates a new instance of TipoDiaSeparador */
    public TipoDiaSeparador(String tipo) {
        _segunda = new LinkedHashSet<EntradaHorario>();
        _terca = new LinkedHashSet<EntradaHorario>();
        _quarta = new LinkedHashSet<EntradaHorario>();
        _quinta = new LinkedHashSet<EntradaHorario>();
        _sexta = new LinkedHashSet<EntradaHorario>();
        _cadeiraActual = null;
        _tipo = tipo;
    }
    
    public TipoDiaSeparador() {
        _segunda = new LinkedHashSet<EntradaHorario>();
        _terca = new LinkedHashSet<EntradaHorario>();
        _quarta = new LinkedHashSet<EntradaHorario>();
        _quinta = new LinkedHashSet<EntradaHorario>();
        _sexta = new LinkedHashSet<EntradaHorario>();
        _cadeiraActual = null;
        _tipo = null;
    }
    
    private Set<EntradaHorario> entrada(int i){ // Porcaria da semana ter dias...
        switch(i){
            case 2:
                return _segunda;
            case 3:
                return _terca;
            case 4:
                return _quarta;
            case 5:
                return _quinta;
            case 6:
                return _sexta;
        }
        return null; // besta
    } // pois isso culpa as semanas..
    
    public void visit(Horario horario) {
        for(Cadeira cadeira : horario.cadeiras()){
            cadeira.accept(this);
        }
    }
    
    public void visit(Cadeira cadeira) {
        _cadeiraActual = cadeira.nome();
        for(Turno turno : cadeira.turnos()){
            turno.accept(this);
        }
        _cadeiraActual = null;
    }
    
    public void visit(Turno turno) {
        if(_cadeiraActual == null){
            //KAPOOTNIK
            System.err.println("KAPOOTNIK2134795794236236452");
        }
        if(_tipo!=null && ! turno.tipo().equals(_tipo)) return;
        aulas:
        for(Aula aula : turno.aulas()){
            for(EntradaHorario entrada : entrada(aula.dia().numero())){
                if(entrada.tempo().equals(aula.tempo())){
                    if(entrada.cadeira().equals(_cadeiraActual)){
                        entrada.adicionaAula(aula,turno.numero());
                        continue aulas;
                    }
                }
            }
            EntradaHorario eh = new EntradaHorario(_cadeiraActual, turno.tipo(), aula.tempo());
            eh.adicionaAula(aula,turno.numero());
            entrada(aula.dia().numero()).add(eh);
        }
    }
    
    public Set<EntradaHorario> entradas(int i){
        return entrada(i);
    }
    
}
