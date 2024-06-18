/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorHotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author HP
 */
public class FicheiroClientes {
    
    
    public static void guardar(Serializable obj) throws FileNotFoundException, IOException{
        ObjectOutputStream oos= null;
        
        try{
           oos= new ObjectOutputStream (new FileOutputStream(new File("CLIENTE.DAT")));
           oos.writeObject(obj);
        }
        finally{
            if(oos!=null){
                oos.close();
            }
        }
    }
    
    public static Object ler() throws FileNotFoundException, IOException, ClassNotFoundException{
        Object obj;
        ObjectInputStream ois= null;
        
        try{
           ois = new ObjectInputStream(new FileInputStream(new File("CLIENTE.DAT")));
           obj = ois.readObject();
           return obj;
        }
        finally{
            if(ois!= null){
                ois.close();
            }
            
        }
    }
}
