/*
 * Turma.java
 *
 * Created on 25 de Agosto de 2007, 21:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package horario.horario;

import java.util.*;

/**
 *
 * @author reis
 */
public class Turma {

    String _nome;
    
    static List<String> _todos_os_nomes = new LinkedList<String>();
    public static void confirma_nomes() {
        System.out.println("Confirmar se todos os nomes de turnas são nomes de turmas:");
        for(String s : _todos_os_nomes){
            System.out.println(" - " + s);
        }
        System.out.println();
    }

    /** Creates a new instance of Turma */
    public Turma(String nome) {
        _todos_os_nomes.add(nome);
        _nome = nome;
    }

    public String nome() {
        return _nome;
    }

    public String toString() {
        return _nome;
    }
}
