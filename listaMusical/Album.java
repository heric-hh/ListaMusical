package listaMusical;

import java.util.LinkedList;

/**
 *
 * @author hheri
 */
public class Album {
    private String nombreAlbum;
    private String year;
    LinkedList<Cancion> cancion;
    
    public Album (String nombre, String year) {
        this.nombreAlbum = nombre;
        this.year = year;
        cancion = new LinkedList<>();
    }
    
    public String getNombreAlbum() { return this.nombreAlbum; }
    
    public String getYearAlbum() { return this.year; }
        
}
