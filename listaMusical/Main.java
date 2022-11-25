package listaMusical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author hheri
 */
public class Main {
    public static LinkedList<Artista> listaArtistas = new LinkedList<>();
    public static Artista artistaSelec;
    public static Album albumSelec;
    public static Cancion cancion;

    // Pedir el nombre del fichero
    
    public static String getNombreArchivo() throws IOException {
        BufferedReader bf = new BufferedReader ( new InputStreamReader(System.in) );
        String archivoName; 
        
        System.out.println("Escribe el nombre del archivo: ");
        archivoName = bf.readLine();
        return archivoName;
    }
    
    // Leer el archivo especificado
    
    public static void leerArchivo( String a ) {
        File archivo = null;
        FileReader fReader = null;
        BufferedReader bf = null;
        
        try {
            archivo = new File ( "C:\\ArchivosTXT/" + a + ".txt" );
            fReader = new FileReader ( archivo );
            bf = new BufferedReader ( fReader );
            String linea;
            
            while ( ( linea = bf.readLine() ) != null ) {
                System.out.println( linea );
            }
            
        } catch ( Exception e ) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        } finally {
            try {
                // Si se logró abrir el archivo, debemos cerrarlo
                if ( null != fReader ) {
                    fReader.close();
                }
            } catch( Exception e2 ) {
                System.out.println("Error al cerrar el archivo");
                e2.printStackTrace();
            }
        }
    }
    
    /*** A R T I S T A S ***/

    
    // Escribir en el archivo especificado
    
    public static String escribirArchivo ( String name ) {
        FileWriter archivo = null;
        PrintWriter pWriter = null;
        BufferedReader bf = new BufferedReader ( new InputStreamReader ( System.in ) );
        String entrada = null;
        
        try {
            archivo = new FileWriter ( "C:\\ArchivosTXT/" + name + ".txt" );
            pWriter = new PrintWriter ( archivo );
            entrada = bf.readLine();
            pWriter.println( entrada );
            
        } catch ( Exception e ) {
            System.out.println("Error al escribir el archivo");
            e.printStackTrace();
        } finally {
            try {
                // Cerrar el archivo si es que se pudo abrir para escritura
                if ( null != archivo ) {
                    archivo.close();
                }
            } catch ( Exception e2 ) {
                System.out.println("Error al cerrar el archivo: " + name);
                e2.printStackTrace();
            }
        }
        return entrada;
    }
    
    
    // Leer lista de artistas
    public static void getListaArtistas() {
        System.out.println("Lista de Artistas: ");
        for (int i = 0; i < listaArtistas.size(); i++) {
            System.out.println(i + " - " + listaArtistas.get(i).getArtistaNombre() );
        }
    }
    
    // Eliminar elemento de la lista de artistas
    
    public static void eliminarArtista() throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader( System.in ));
        int index; // Variable para obtener el indice del valor a eliminar
        
        System.out.println("Ingresa el número del artista que quieres eliminar: ");
        getListaArtistas();
        index = Integer.parseInt(bf.readLine());
        listaArtistas.remove(index);
        System.out.println("¡Artista Eliminado!");
    }
    
    /*** A L B U M E S ***/
    
    // Agregar album
    
    public static void agregarAlbum() throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader ( System.in ));
        int index;
        
        // Propiedades del disco
        String albumInput;
        String yearInput;
        
        System.out.println("Lista de artistas.\nEscribe el numero del artista donde quieres añadir un album");
        for (int i = 0; i < listaArtistas.size(); i++) {
            System.out.println(i + " - " + listaArtistas.get(i).getArtistaNombre() );
        }
        index = Integer.parseInt(bf.readLine());
        artistaSelec = listaArtistas.get( index ); // Obtener artista de la lista
        System.out.println("Escribe el nombre del album: ");
        albumInput = bf.readLine();
        
        System.out.println("Escribe el año de publicación: ");
        yearInput = bf.readLine();
        Album album = new Album( albumInput, yearInput );   
        
        artistaSelec.agregarAlbum( album ); //Añadir datos a la lista de albumes
        System.out.println("¡Album Guardado!");
    }
    
    // Ver albumes
    
    public static void getAlbumes() throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader ( System.in ));
        int index;
        
        System.out.println("Lista de artistas.\nEscribe el numero del artista para ver sus discos: ");
        for (int i = 0; i < listaArtistas.size(); i++) {
            System.out.println(i + " - " + listaArtistas.get(i).getArtistaNombre() );
        }
        index = Integer.parseInt(bf.readLine());
        artistaSelec = listaArtistas.get( index ); // Obtener artista de la lista
        System.out.println("Lista de albumes de " + artistaSelec.getArtistaNombre());
        artistaSelec.getAlbumes();
        
    }
    
    // Eliminar album
    
    public static void eliminarAlbum() throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader ( System.in ));
        int index;
        
        getAlbumes();
        System.out.println("Escribe el numero del album para eliminar: ");
        index = Integer.parseInt(bf.readLine());
        artistaSelec.eliminarAlbum( index );
        System.out.println("¡Album eliminado!");
    }
    
    /*** C A N C I O N E S ***/
    
    public static void agregarCancion() throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader ( System.in ));
        int index;
        
        // Propiedades de la cancion
        String nombreCancion;
        
        getAlbumes();
        System.out.println("Selecciona un album para agregar canciones: ");
        artistaSelec.getAlbumes();
        index = Integer.parseInt( bf.readLine() );
        albumSelec = artistaSelec.getAlbum( index ); // Seleccionar el album de la lista
        
        System.out.println("Nombre de la cancion: ");
        nombreCancion = escribirArchivo ( "canciones" );
        
        cancion = new Cancion ( nombreCancion );
        albumSelec.agregarCancion( cancion );
        
    }
    
    public static void verCanciones() throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader ( System.in ));
        int index;
        
        System.out.println("Lista de artistas.\nEscribe el numero del artista donde quieres añadir una cancion");
        for (int i = 0; i < listaArtistas.size(); i++) {
            System.out.println(i + " - " + listaArtistas.get(i).getArtistaNombre() );
        }
        index = Integer.parseInt(bf.readLine());
        artistaSelec = listaArtistas.get( index ); // Obtener artista de la lista
        
        System.out.println("Selecciona el album: ");
        
        artistaSelec.getAlbumes();
        index = Integer.parseInt( bf.readLine() );
        albumSelec = artistaSelec.getAlbum( index ); // Seleccionar el album de la lista
        albumSelec.getCanciones();
    }
    
    public static void eliminarCancion() throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader ( System.in ));
        int index;
        
        verCanciones();
        System.out.println("Selecciona una canción para eliminar: ");
        index = Integer.parseInt( bf.readLine() );
        albumSelec.eliminarCancion( index );
    }

    
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader ( new InputStreamReader ( System.in ) );
        String res;
        String YesNo = null;
        // String archivoName; Variable para leer el archivo
        String artistaNombre;
        
        
        do {
            System.out.println("¿Qué quieres hacer?");
            res = bf.readLine();

            switch ( res ) {
                
            /**** Artistas ****/
                
            case "agregar artista": {
                System.out.println("Escribe el nombre del artista que quieres agregar: ");
                artistaNombre = escribirArchivo ( "artistas" );
                listaArtistas.add( new Artista ( artistaNombre ) );

                System.out.println("Artista Guardado");
            break;
            }
            
            case "ver artistas": {
                getListaArtistas();
                break;
            }
            
            case "eliminar artista" : {
                eliminarArtista();
                break;
            
            }


            /****  Album  ****/
            
            case "agregar album": {
                agregarAlbum();
                break;
            }
            
            case "ver album": {
                getAlbumes();
                break;
            }
            
            case "eliminar album": {
                eliminarAlbum();
                break;
            }
            
            /****  Canciones  ****/
            
            case "agregar cancion": {
                agregarCancion();
                break;
            }
            
            case "ver cancion": {
                verCanciones();
                break;
            }
            
            case "eliminar cancion": {
                eliminarCancion();
                break;
            }

            
            default:
                System.out.println("Opción no válida");
        }
            System.out.println( "¿Deseas Continuar? y/n" );
            YesNo = bf.readLine();
            
        } while ( YesNo.equals("y") );
    }
}
