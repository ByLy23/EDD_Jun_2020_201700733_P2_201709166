package Principal;

/**
 *
 * @author Jacky
 */
public class Conductores {

    long DPI;
    String nombre;
    String apellido;
    long licencia;
    String genero;
    int telefono;
    String direccion;

    public Conductores(long dpi) {
        this.DPI = dpi;
    }

    public Conductores(long dpi, String name, String lastname, long licence, String genre, int phone, String adress )
    {
        this.DPI=dpi;
        this.nombre=name;
        this.apellido=lastname;
        this.licencia=licence;
        this.genero=genre;
        this.telefono=phone;
        this.direccion=adress;
    }
}
