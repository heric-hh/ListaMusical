package listaMusical;

import java.util.LinkedList;

/**
 *
 * @author hheri
 */
public class Artista {
    private String nombreArtista;
    LinkedList<Album> listaAlbumes;
    
    public Artista() {}
    
    public Artista ( String nombre ) {
        this.nombreArtista = nombre;
        listaAlbumes = new LinkedList<>(); // Iniciar lista ligada de albumes
    }
    
    public String getArtistaNombre() { return this.nombreArtista; }
    
    public void agregarAlbum( Album a ) {
        this.listaAlbumes.add( a );
    }
    
    public void getAlbumes() {
        for (int i = 0; i < listaAlbumes.size(); i++) {
            System.out.println(i + " - " + listaAlbumes.get(i).getNombreAlbum() + " - " + listaAlbumes.get(i).getYearAlbum());
        }
    }
    
    public void eliminarAlbum( int i) {
        this.listaAlbumes.remove( i );
    }
    
    public Album getAlbum ( int i ) {
        return this.listaAlbumes.get ( i );
    }
}
