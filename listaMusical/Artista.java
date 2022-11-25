package listaMusical;

import java.util.LinkedList;

/**
 *
 * @author hheri
 */
public class Artista {
    private String nombreArtista;
    
    public Artista ( String nombre ) {
        this.nombreArtista = nombre;
        LinkedList<Album> listaAlbumes = new LinkedList<>();
    }
    
    public String getArtistaNombre() { return this.nombreArtista; }
    
    
}
