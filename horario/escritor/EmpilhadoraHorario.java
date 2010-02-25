/*
 * EmpilhadoraHorario.java
 *
 * Created on September 8, 2007, 1:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.escritor;

import horario.visitor.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author reis
 */
public class EmpilhadoraHorario extends Empilhadora<Character> {
    
    PrintStream _output;
    
    /** Creates a new instance of EmpilhadoraHorario */
    public EmpilhadoraHorario(PrintStream output) {
        super(' ');
        _output = output;
    }
    
    public void empilha(TipoDiaSeparador tds){
        adiciona(1, "08:00");
        adiciona(3, "09:00");
        adiciona(5, "10:00");
        adiciona(7, "11:00");
        adiciona(9, "12:00");
        adiciona(11, "13:00");
        adiciona(13, "14:00");
        adiciona(15, "15:00");
        adiciona(17, "16:00");
        adiciona(19, "17:00");
        adiciona(21, "18:00");
        adiciona(23, "19:00");
        adiciona(24, " ");
        
        separador('|');
        adiciona(0, "Segunda");
        for(EntradaHorario eh : tds.entradas(2)){
            adiciona(eh.tempo().inicio().posicaoHorario()+1, eh.quadradinhoBonito());
        }
        
        separador('|');
        adiciona(0, "Terca");
        for(EntradaHorario eh : tds.entradas(3)){
            adiciona(eh.tempo().inicio().posicaoHorario()+1, eh.quadradinhoBonito());
        }
        
        separador('|');
        adiciona(0, "Quarta");
        for(EntradaHorario eh : tds.entradas(4)){
            adiciona(eh.tempo().inicio().posicaoHorario()+1, eh.quadradinhoBonito());
        }
        
        separador('|');
        adiciona(0, "Quinta");
        for(EntradaHorario eh : tds.entradas(5)){
            adiciona(eh.tempo().inicio().posicaoHorario()+1, eh.quadradinhoBonito());
        }
        
        separador('|');
        adiciona(0, "Sexta");
        for(EntradaHorario eh : tds.entradas(6)){
            adiciona(eh.tempo().inicio().posicaoHorario()+1, eh.quadradinhoBonito());
        }
    }
    
    private void adiciona(int posicao, String s){
        List<List<Character>> tmp = new ArrayList<List<Character>>();
        tmp.add(new ArrayList<Character>());
        for(Character c : s.toCharArray()){
            tmp.get(0).add(c);
        }
        adiciona(posicao, tmp);
    }
    
    public void escreve(){
        for(List<Character> l : _pilha){
            for(Character c : l){
                _output.print(c);
            }
            _output.println();
        }
    }
    
}
