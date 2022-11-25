package listaMusical;

import java.util.LinkedList;

/**
 *
 * @author hheri
 */
public class Artista {
    private String nombreArtista;
    LinkedList<Album> listaAlbumes;
    
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
            System.out.println(listaAlbumes.get(i).getNombreAlbum());
        }
    }
    
}
