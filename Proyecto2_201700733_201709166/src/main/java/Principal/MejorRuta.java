/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author byron
 */
public class MejorRuta {
      public MejorRuta(String origen,String destino, String tiempo){
       int time= Integer.parseInt(tiempoAnterior)+Integer.parseInt(tiempo);
       this.tiemp= tiempoAnterior+tiempo;
       tiempoAnterior=String.valueOf(time);
       this.LugarDestino=destino;
       this.LugarOrigen=origen;
    }

    public String getLugarOrigen() {
        return LugarOrigen;
    }

    public void setLugarOrigen(String LugarOrigen) {
        this.LugarOrigen = LugarOrigen;
    }

    public String getLugarDestino() {
        return LugarDestino;
    }

    public void setLugarDestino(String LugarDestino) {
        this.LugarDestino = LugarDestino;
    }

    public String getTiempoRuta() {
        return TiempoRuta;
    }

    public void setTiempoRuta(String TiempoRuta) {
        this.TiempoRuta = TiempoRuta;
    }

    public String getTiempoAnterior() {
        return tiempoAnterior;
    }

    public void setTiempoAnterior(String tiempoAnterior) {
        this.tiempoAnterior = tiempoAnterior;
    }

    public String getTiemp() {
        return tiemp;
    }

    public void setTiemp(String tiemp) {
        this.tiemp = tiemp;
    }
      
    String LugarOrigen;
    String LugarDestino;
    String TiempoRuta;
    String tiempoAnterior="0";

    String tiemp;
}
