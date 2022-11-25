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
    
    // Añadir album
    public static void añadirAlbum() {
        System.out.println("Lista de artistas.\nEscribe el numero del artista donde quieres añadir un album");
        for (int i = 0; i < listaArtistas.size(); i++) {
            System.out.println(i + " - " + listaArtistas.get(i).getArtistaNombre() );
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader ( new InputStreamReader ( System.in ) );
        String res;
        String YesNo = null;
        // String archivoName; Variable para leer el archivo
        String artistaNombre;
        
        res = bf.readLine();
        
        do {
            switch ( res ) {
            case "nuevo artista":
                // Pedir nombre del archivo que se almacena en la variable archivoName
                //archivoName = getNombreArchivo();
                artistaNombre = escribirArchivo ( "artistas" );
                listaArtistas.add( new Artista ( artistaNombre ) );

                System.out.println("Artista Guardado");
            break;
            
            case "add album":
                añadirAlbum();
                break;
            
            default:
                System.out.println("Opción no válida");
        }
            System.out.println( "¿Deseas Continuar?" );
            YesNo = bf.readLine();
            
        } while ( YesNo.equals("y") );
        
        
        
        
             
        
        
        
        // Metodos con el archivo especificado
        //leerArchivo ( archivoName );
        
        
    }
}
