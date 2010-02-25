/*
 * Empilhadora.java
 *
 * Created on September 8, 2007, 1:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.escritor;

import java.util.*;

/**
 *
 * @author reis
 */
public abstract class Empilhadora<E> {
    
    private E _vazio;
    private int _pos0;

    protected List<List<E>> _pilha;

    /** Creates a new instance of Empilhadora */
    public Empilhadora(E vazio) {
        _vazio = vazio;
        _pilha = new ArrayList<List<E>>();
        _pos0 = 0;
    }

    protected E le(int l, int c){
        if(l >= _pilha.size()) return _vazio;
        if(c >= _pilha.get(l).size()) return _vazio;
        return _pilha.get(l).get(c);
    }
    
    protected void escreve(int l, int c, E e){
        while(l >= _pilha.size()) _pilha.add(new LinkedList<E>());
        while(c >= _pilha.get(l).size()) _pilha.get(l).add(_vazio);
        _pilha.get(l).set(c, e);
    }
    
    protected void cortaPontas(){
        for(List<E> l : _pilha){
            while(l.size()!=0 && l.get(l.size()-1).equals(_vazio)) l.remove(l.size()-1);
        }
    }
    
    protected void adiciona(int posicao, List<List<E>> e){
        int altura = 0;
        int largura = 0;
        
        altura = e.size();
        for(List<E> l : e){
            if(l.size()>largura) largura = l.size();
        }
        
        if(altura<=0 || largura<=0) return;
        
        int sitio = _pos0;
        procuraSitio:
        for(int l=posicao; l<posicao+altura; l++){
            for(int c=sitio; c<sitio+largura+(sitio==0?1:2); c++){
                if( ! le(l,c).equals(_vazio)){
                    sitio = c+1;
                    l=posicao-1;  //MARTELADA COM FORCA... tava a ver k isto saia mt bonito hoje a primeira...
                    continue procuraSitio;
                }
            }
        }
        if(sitio!=0) sitio++;
        
        for(int l=0; l<altura; l++){
            for(int c=0; c<e.get(l).size(); c++){
                escreve(posicao+l, sitio+c, e.get(l).get(c));
            }
        }
    }
    
    protected void separador(E e){
        cortaPontas();
        int max=0;
        for(List<E> l : _pilha){
            if(l.size()>max) max = l.size();
        }
        int sitio = max+1;
        for(int l=0; l<_pilha.size(); l++){
            escreve(l,sitio,e);
        }
        _pos0 = sitio+1;
    }
    
}
