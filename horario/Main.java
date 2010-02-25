/*
 * Main.java
 *
 * Created on 25 de Agosto de 2007, 21:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario;

import horario.horario.*;
import horario.visitor.*;
import horario.leitor.*;
import horario.escritor.*;

import java.io.*;

/**
 *
 * @author reis
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    static Horario testeHorario(){
        Horario horario = new Horario();
        Cadeira cadeira = Cadeira.novaCadeira("TESTE0T0");
        horario.adicionaCadeira(cadeira);
        Turno turno = new Turno("TESTE0T0");
        cadeira.adicionaTurno(turno);
        turno.adicionaTurma(new Turma("TurmaTeste"));
        turno.adicionaAula(new Aula(new Dia(2), new Tempo(new Hora(8, 00),
                new Hora(19, 30)), new Sala("SalaTeste")));
        return horario;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Horario horario = new Horario();
        //horario = testeHorario();
        
        InputStream input = null;
        PrintStream output = null;
        switch(args.length){
            case 0:
                input = System.in;
                output = System.out;
                break;
            case 1:
                try {
                    input = new FileInputStream(args[0]);
                } catch (FileNotFoundException ex) {
                    System.err.println("Ficheiro não encontrado.");
                    System.exit(1);
                }
                output = System.out;
                break;
            case 2:
                try {
                    input = new FileInputStream(args[0]);
                } catch (FileNotFoundException ex) {
                    System.err.println("Ficheiro de entrada não encontrado.");
                    System.exit(2);
                }
                try {
                    output = new PrintStream(args[1]);
                } catch (FileNotFoundException ex) {
                    System.err.println("Ficheiro de saida não encontrado.");
                    System.exit(3);
               }
                break;
            default:
                System.err.println("Utilizar sem argumentos, com nome de ficheiro de entrada ou com nome de tudo.");
                for(String s : args) System.err.println(s);
                System.exit(4);
                break;
        }
        
        
        HorarioLeitor hl = new HorarioLeitor(input);
        try {
            horario = hl.lerHorario();
        } catch (NumberFormatException ex) {
            // Something very very strange..
            System.exit(5);
        } catch (ParseException ex) {
            System.err.println("Erro na análise sintática: " + ex.getMessage());
            System.exit(6);
        } catch (TokenMgrError ex) {
            System.err.println("Erro na análise lexical: " + ex.getMessage());
            System.exit(7);
        }
        
        Turno.confirma_nomes();
        Turma.confirma_nomes();
        
        //PrintStrings printStrings = new PrintStrings(false);
        //horario.accept(printStrings);
        
        TipoDiaSeparador tds_t = new TipoDiaSeparador("T");
        horario.accept(tds_t);
        output.println("Teoricas:");
        //for(EntradaHorario eh : tds_t.entradas(2)){
        //    System.out.println(eh.toString());
        //}
        EmpilhadoraHorario emp_t = new EmpilhadoraHorario(output);
        emp_t.empilha(tds_t);
        emp_t.escreve();
        
        output.println();
        
        TipoDiaSeparador tds_pb = new TipoDiaSeparador("PB");
        horario.accept(tds_pb);
        output.println("Problemas:");
        EmpilhadoraHorario emp_pb = new EmpilhadoraHorario(output);
        emp_pb.empilha(tds_pb);
        emp_pb.escreve();
        
        output.println();
        
        TipoDiaSeparador tds_l = new TipoDiaSeparador("L");
        horario.accept(tds_l);
        output.println("Laboratorios:");
        EmpilhadoraHorario emp_l = new EmpilhadoraHorario(output);
        emp_l.empilha(tds_l);
        emp_l.escreve();
        
        output.println();
        
        TipoDiaSeparador tds = new TipoDiaSeparador();
        horario.accept(tds);
        output.println("Tudo:");
        EmpilhadoraHorario emp = new EmpilhadoraHorario(output);
        emp.empilha(tds);
        emp.escreve();
    }
    
}
