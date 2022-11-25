package listaMusical;

import java.util.LinkedList;

/**
 *
 * @author hheri
 */
public class Album {
    private String nombreAlbum;
    private String year;
    LinkedList<Cancion> listaCancion;
    
    public Album (String nombre, String year) {
        this.nombreAlbum = nombre;
        this.year = year;
        listaCancion = new LinkedList<>();
    }
    
    public String getNombreAlbum() { return this.nombreAlbum; }
    
    public String getYearAlbum() { return this.year; }
    
    public void agregarCancion( Cancion c ) {
        this.listaCancion.add ( c );
    }
    
    public void getCanciones() {
        for (int i = 0; i < listaCancion.size(); i++) {
            System.out.println(i + " - " + listaCancion.get(i).getNombreCancion());
        }
    }
    
    public void eliminarCancion( int i ) {
        this.listaCancion.remove ( i );
    }
        
}
