/*
 * Hora.java
 *
 * Created on 25 de Agosto de 2007, 21:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package horario.horario;

/**
 *
 * @author reis
 */
public class Hora {
    
    private int _hora;
    private int _minuto;
    
    /** Creates a new instance of Hora */
    public Hora(int hora, int minuto) {
        _hora = hora;
        _minuto = minuto;
    }
    
    public int hora(){
        return _hora;
    }
    
    public int minuto(){
        return _minuto;
    }
    
    public String toString(){
        return String.format("%02d", _hora) + ":"
                + String.format("%02d", _minuto);
    }
    
    public boolean equals(Object o){
        return o instanceof Hora && equals((Hora)o);
    }
    
    public boolean equals(Hora h){
        return (h._hora == _hora) && (h._minuto == _minuto);
    }
    
    public int posicaoHorario(){
        return ((_hora-8)*2)+(_minuto==0?0:1);
    }
}
