/*
 * PrintStrings.java
 *
 * Created on 26 de Agosto de 2007, 2:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.visitor;

import horario.horario.*;

/**
 *
 * @author reis
 */
public class PrintStrings implements HorarioVisitor {
    
    private boolean _mostraTurmas;
    
    /** Creates a new instance of PrintStrings */
    public PrintStrings(boolean mostraTurmas) {
        _mostraTurmas = mostraTurmas;
    }
    
    public void visit(Horario horario){
        System.out.println(horario);
        for(Cadeira cadeira : horario.cadeiras()){
            cadeira.accept(this);
        }
    }
    
    public void visit(Cadeira cadeira){
        System.out.print("  ");
        System.out.println(cadeira);
        for(Turno turno : cadeira.turnos()){
            turno.accept(this);
        }
    }
    
    public void visit(Turno turno){
        System.out.print("      ");
        System.out.println(turno);
        for(Aula aula : turno.aulas()){
            System.out.print("        ");
            System.out.println(aula);
        }
        if(_mostraTurmas){
            for(Turma turma : turno.turmas()){
                System.out.print("        ");
                System.out.println(turma);
            }
        }
    }
    
}
