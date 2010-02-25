/*
 * HorarioVisitor.java
 *
 * Created on 26 de Agosto de 2007, 2:20
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
public interface HorarioVisitor {
    void visit(Horario horario);
    void visit(Cadeira cadeira);
    void visit(Turno turno);
}
