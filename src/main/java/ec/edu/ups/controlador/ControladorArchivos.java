package ec.edu.ups.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Estudiantes
 */
public class ControladorArchivos {

    private String ruta;
    private String archivos;
    
    private Map<String, String> hola;
    
    public ControladorArchivos() {
        
    }
    
    public String encriptarNombreArchivo(String nombre){
        
        
        
        return null;
    }
    
    public void llenarDiccionario(){
        String[] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
        "o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] encriptado = {"","8",};
    }
    
    public void crearArchivoDeTexto(String rutas,String nombre, String texto){
        try{
            File archivo = new File(rutas + File.separator + nombre);
            String rutaCompleta=archivo.getAbsolutePath();
            
            String ruta=rutaCompleta;
            System.out.println(ruta);
            FileWriter archivoEscritura= new FileWriter(ruta,true);
            BufferedWriter escritura= new BufferedWriter(archivoEscritura);
            escritura.append(texto+"\n");
            escritura.close();
            archivoEscritura.close();
        }catch(FileNotFoundException e1){
            System.out.println("Ruta de archivo no encontrada");
        }catch(IOException e2){
            System.out.println("Error de escritura");
        }catch(Exception e3){
            System.out.println("Error General");
        }
    }
}
