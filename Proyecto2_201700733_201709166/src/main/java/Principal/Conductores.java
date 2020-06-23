package Principal;

/**
 *
 * @author Jacky
 */
public class Conductores {

    long DPI;
    String nombre;
    String apellido;
    String licencia;
    String genero;
    String telefono;
    String direccion;

    
    public void setDPI(Integer DPI) {
        this.DPI = DPI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

  


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getDPI() {
        return DPI;
    }

    public void setDPI(long DPI) {
        this.DPI = DPI;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

 

    public Conductores(long dpi, String name, String lastname, String licence, String genre, String phone, String adress )
    {
        this.DPI=dpi;
        this.nombre=name;
        this.apellido=lastname;
        this.licencia=licence;
        this.genero=genre;
        this.telefono=phone;
        this.direccion=adress;
    }
    
    public Conductores()
    {
        this.DPI=0;
        this.nombre="";
        this.apellido="";
        this.licencia="";
        this.genero="";
        this.telefono="";
        this.direccion="";
    }
}
