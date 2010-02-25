/*
 * Cadeira.java
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
public class Cadeira implements horario.visitor.HorarioVisitable {
    
    static private Map<String, Cadeira> mapaCadeiras
            = new HashMap<String, Cadeira>();
    
    static private Cadeira novaCadeira(String nome, int numero) {
        String idCadeira = new String(nome);
        idCadeira.concat(Integer.toString(numero));
        
        Cadeira cadeira = mapaCadeiras.get(idCadeira);
        if(cadeira == null){
            cadeira = new Cadeira(nome, numero);
            mapaCadeiras.put(idCadeira, cadeira);
        }
        return cadeira;
    }
    
    static public Cadeira novaCadeira(String id) {
        String nome = id.split("-|[0-9]", 2)[0];
        int numero = 0;
        /*
        System.out.println("/-------------------");
        System.out.println("| " + id);
        System.out.println("| Nome: " + nome);
        System.out.println("| Numero da cadeira:" + numero);
        */
        return novaCadeira(nome, numero);
    }
    
    private String _nome;
    private int _numero;
    private Set<Turno> _turnos;
    
    /** Creates a new instance of Cadeira */
    private Cadeira(String nome, int numero) {
        _nome = nome;
        _numero = numero;
        _turnos = new LinkedHashSet<Turno>();
    }
    
    public void adicionaTurno(Turno turno){
        _turnos.add(turno);
    }
    
    public String nome(){
        return _nome;
    }
    
    public int numero(){
        return _numero;
    }
    
    public Set<Turno> turnos(){
        return _turnos;
    }
    
    public String toString(){
        return "Cadeira \"" + _nome + "\" #" + _numero + " com " + _turnos.size() + " turno(s).";
    }
    
    public void accept(HorarioVisitor horarioVisitor){
        horarioVisitor.visit(this);
    }
    
}
