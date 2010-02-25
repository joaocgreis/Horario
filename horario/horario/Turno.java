/*
 * Turno.java
 *
 * Created on 25 de Agosto de 2007, 21:40
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
public class Turno implements horario.visitor.HorarioVisitable {

    private String _tipo;
    private int _numero;
    private Set<Aula> _aulas;
    private Set<Turma> _turmas;

    static List<String> _todos_os_nomes = new LinkedList<String>();
    public static void confirma_nomes() {
        System.out.println("Confirmar se todos os nomes de turnos são nomes de turnos:");
        for(String s : _todos_os_nomes){
            System.out.println(" - " + s);
        }
        System.out.println();
    }

    /** Creates a new instance of Turno */
    private Turno(String tipo, int numero) {
        _tipo = tipo;
        _numero = numero;
        _aulas = new LinkedHashSet<Aula>();
        _turmas = new LinkedHashSet<Turma>();
    }

    public Turno(String id) {
        _todos_os_nomes.add(id);
        if (id.matches(".+T\\d\\d")) {
            _tipo = "T";
        } else if (id.matches(".+P\\d\\d") || id.matches(".+PB\\d\\d")) {
            _tipo = "PB";
        } else if (id.matches(".+L\\d\\d")) {
            _tipo = "L";
        }
        _numero = Integer.parseInt(id.substring(id.length()-2,id.length()));
        /*
        System.out.println("| Tipo: " + _tipo);
        System.out.println("| Numero de turno: " + _numero);
        System.out.println("\\-------------------");
        */
        _aulas = new LinkedHashSet<Aula>();
        _turmas = new LinkedHashSet<Turma>();
    }

    public void adicionaAula(Aula aula) {
        _aulas.add(aula);
    }

    public void adicionaTurma(Turma turma) {
        _turmas.add(turma);
    }

    public String tipo() {
        return _tipo;
    }

    public int numero() {
        return _numero;
    }

    public Set<Aula> aulas() {
        return _aulas;
    }

    public Set<Turma> turmas() {
        return _turmas;
    }

    public String toString() {
        return "Turno numero " + _numero + " do tipo " + _tipo + " com " + _aulas.size() + " aula(s) e " + _turmas.size() + " turma(s).";
    }

    public void accept(HorarioVisitor horarioVisitor) {
        horarioVisitor.visit(this);
    }
}
