/*
 * EntradaHorario.java
 *
 * Created on September 7, 2007, 4:05 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package horario.escritor;

import horario.horario.*;
import java.util.*;

/**
 *
 * @author reis
 */
public class EntradaHorario {

    private String _cadeira;
    private String _tipo;
    private Tempo _tempo;
    private List<Aula> _aulas;
    private Map<Aula, Integer> _turnos;

    /** Creates a new instance of EntradaHorario */
    public EntradaHorario(String cadeira, String tipo, Tempo tempo) {
        _cadeira = cadeira;
        _tipo = tipo;
        _tempo = tempo;
        _aulas = new ArrayList<Aula>();
        _turnos = new LinkedHashMap<Aula, Integer>();
    }

    public void adicionaAula(Aula aula, int turno) {
        _aulas.add(aula);
        _turnos.put(aula, turno);
    }

    public String cadeira() {
        return _cadeira;
    }

    public String tipo() {
        return _tipo;
    }

    public Tempo tempo() {
        return _tempo;
    }

    public String toString() {
        String s = "EH: " + _cadeira + " " + _tipo + " " + _tempo + ":";
        for (Aula aula : _aulas) {
            s = s.concat(" " + _turnos.get(aula) + "-" + aula.sala());
        }
        return s;
    }

    public List<List<Character>> quadradinhoBonito() {
        int linhas = _tempo.meiasHoras();
        
        int comprimento = 1 + _cadeira.length() + _tipo.length();
        for (Aula a : _aulas) {
            int ac;
            if (_tipo.equals("T")) {  // para nao ter numeros nos labs e praticas
                ac = 5 + _turnos.get(a).toString().length() + a.sala().nome().length();
            } else {
                ac = 4 + a.sala().nome().length();
            }
            if (ac > comprimento) {
                comprimento = ac;
            }
        }
        
        List<List<Character>> lista = new ArrayList<List<Character>>();
        {
            StringBuilder titulo = new StringBuilder();
            titulo.append(_cadeira);
            for (int i = _cadeira.length() + _tipo.length(); i < comprimento; i++) {
                titulo.append('-');
            }
            titulo.append(_tipo);
            List<Character> t_l = new ArrayList<Character>();
            for (Character c : titulo.toString().toCharArray()) {
                t_l.add(c);
            }
            lista.add(t_l);
        }
        for (int i = 1; i < linhas; i++) {
            StringBuilder linha = new StringBuilder();
            if (_aulas.size() > i - 1) {
                linha.append("| ");
                int j; // para ser usado no for em baixo que completa a linha com espaços
                if (_tipo.equals("T")) {  // para nao ter numeros nos labs e praticas
                    linha.append(_turnos.get(_aulas.get(i - 1)).toString());
                    linha.append("-");
                    j = 5 + _turnos.get(_aulas.get(i - 1)).toString().length() + _aulas.get(i - 1).sala().nome().length();
                } else {
                    j = 4 + _aulas.get(i - 1).sala().nome().length();
                }
                linha.append(_aulas.get(i - 1).sala().nome());
                for (; j < comprimento; j++) {
                    linha.append(' ');
                }
                linha.append(" |");
            } else {
                linha.append("|");
                for (int j = 2; j < comprimento; j++) {
                    linha.append(' ');
                }
                linha.append("|");
            }
            List<Character> t_l = new ArrayList<Character>();
            for (Character c : linha.toString().toCharArray()) {
                t_l.add(c);
            }
            lista.add(t_l);
        }

        //for(List<Character> l : lista){
        //    for(Character c : l){
        //        System.out.print(c);
        //    }
        //    System.out.println();
        //}

        if (_aulas.size() > linhas - 1) {
            if (linhas > 1) {
                lista.get(lista.size() - 1).set(0, '+');
            }
        }

        return lista;
    }
}
