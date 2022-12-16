/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Ana
 * @author Jossie
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] bufer = new byte[1000];
    //Hemos cambiado FileName
    private static String NombreArchivo = "fichero.dat";
    private static FileInputStream StreamEntrada = null;
    private static BufferedInputStream BuferEntrada = null;

    //Hemos cambiado el nombre InicializateFiles
    //En este paso vamos a crear un método
    public static void IniciarArchivos() throws FileNotFoundException
    {
        StreamEntrada = new FileInputStream(NombreArchivo);
        BuferEntrada = new BufferedInputStream(StreamEntrada);
    }

    //Hemos refactorizado ShowFileText
    public static int MostrarTextoDeArchivo() throws IOException
    {
        int total = 0;
        int nLeido = 0;
        while((nLeido = StreamEntrada.read(bufer)) != -1)
        {
            System.out.println(new String(bufer));
            total += nLeido;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            IniciarArchivos();
            
            int total = MostrarTextoDeArchivo();

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( BuferEntrada != null && StreamEntrada != null )
                {
                   
                    StreamEntrada.close();
                    BuferEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
