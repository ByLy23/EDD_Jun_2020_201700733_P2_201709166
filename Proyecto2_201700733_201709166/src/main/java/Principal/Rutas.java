/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Jacky
 */
public class Rutas {
    String LugarOrigen;
    String LugarDestino;
    String TiempoRuta;
    String tiempoAnterior="0";

    String tiemp;


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
    
    public Rutas(String LugarOrigen, String LugarDestino, String TiempoRuta)
    {
        this.LugarOrigen=LugarOrigen;
        this.LugarDestino=LugarDestino;
        this.TiempoRuta=TiempoRuta;
    }
  
    
    public Rutas()
    {
        this.LugarOrigen="";
        this.LugarDestino="";
        this.TiempoRuta="";
    }
}
