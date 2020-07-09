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
    
    private Map<String, String> diccionarioEncriptado;
    
    public ControladorArchivos() {
        llenarDiccionario();
    }
    
    public String encriptarNombreArchivo(String nombre){
        
        String textoEncriptado="";
        
        for (int i = 0; i < nombre.length(); i++) {
            String letra = nombre.charAt(i)+"";
            if(!letra.equals(" ")){
                for (Map.Entry<String, String> entry : diccionarioEncriptado.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if(letra.equals(key)){
                        textoEncriptado+=value;
                        }
                    }     
            }else{
                textoEncriptado+="-";
            } 
        }

        
        return textoEncriptado;
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
            
            System.out.println(rutaCompleta);
            FileWriter archivoEscritura= new FileWriter(rutaCompleta,true);
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
