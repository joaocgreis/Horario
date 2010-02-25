/*
 * Horario.java
 *
 * Created on 25 de Agosto de 2007, 21:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.horario;

import horario.visitor.HorarioVisitor;
import java.util.*;

/**
 *
 * @author reis
 */
public class Horario implements horario.visitor.HorarioVisitable {
    
    private Set<Cadeira> _cadeiras;
    
    /** Creates a new instance of Horario */
    public Horario() {
        _cadeiras = new LinkedHashSet<Cadeira>();
    }
    
    public void adicionaCadeira(Cadeira cadeira){
        _cadeiras.add(cadeira);
    }
    
    public Set<Cadeira> cadeiras(){
        return _cadeiras;
    }
    
    public String toString(){
        return "Horario com " + _cadeiras.size() + " cadeira(s).";
    }
    
    public void accept(HorarioVisitor horarioVisitor){
        horarioVisitor.visit(this);
    }
    
}
