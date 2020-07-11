package ec.edu.ups.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Controlador Archivos.
 * 
 * Esta clase permite encriptar el mensaje ingresado ademas crea un archivo en 
 * el cual es guardado en cualquier ruta que decida el usuario.
 * @author Romel Avila, Sebastian Uyaguari
 */
public class ControladorArchivos {

    private String ruta;
    private File archivo;
    
    private Map<String, String> diccionarioEncriptado;
    
    /**
    * Metodo ControladorArchivos (Constructor).
    * El metodo constructor inicializa el atributo diccionarioEncriptado, ademas 
    * llena el diccionario con los datos correspondientes para poder encriptar.
    */
    public ControladorArchivos() {
        diccionarioEncriptado = new HashMap<>();
        llenarDiccionario();
    }
    
    /**
     * Metodo encriptarMensajeArchivo.
     * El metodo encripta el mensaje recibido como parametro cambiando las letras
     * por un caracter especifico para despues retornar el 
     * @param mensaje
     * @return retorna una variable tipo String: textoEncriptado
     */    
    public String encriptarMensajeArchivo(String mensaje){
      
        String textoEncriptado="";
        
        for (int i = 0; i < mensaje.length(); i++) {
            String letra = mensaje.charAt(i)+"";
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
    
    /**
     * Metodo llenarDiccionario.
     * Este metodo tiene la funcion de llenar el diccionario mediante dos vectores,
     * el cual el primero es para asignar la clave o llave mientras que el segundo
     * es para asignar el velor.
     */
    public void llenarDiccionario(){
        String[] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
        "o","p","q","r","s","t","u","v","w","x","y","z"," "};
        String[] encriptado = {"!","]","^","æ","ü","×","¢","þ","@","§","«",
            "A","¥","~","c","r","z","W","8","ç","2","L","f","&","#","[","-"};
        for (int i = 0; i < 26; i++) {
            diccionarioEncriptado.put(letras[i], encriptado[i]);
        }
        
    }
    
    /**
     * Metodo crearArchivoDeTexto.
     * El metodo realiza la creacion del archivo con la informacion que es 
     * recibida mediante parametros y es colocada en un solo archivo para ser 
     * guardado en un solo archivo.
     * @param rutas
     * @param nombre
     * @param texto 
     */
    public void crearArchivoDeTexto(String rutas,String nombre, String texto){
        try{
            archivo = new File(rutas + File.separator + nombre);
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
