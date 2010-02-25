/*
 * HorarioVisitable.java
 *
 * Created on 26 de Agosto de 2007, 2:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.visitor;

/**
 *
 * @author reis
 */
public interface HorarioVisitable {
    void accept(HorarioVisitor horarioVisitor);
}
