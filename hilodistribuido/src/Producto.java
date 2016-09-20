
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Producto {
    private int producto;
    private int limite=10;
    
    public synchronized void sacaProducto() throws InterruptedException{
        if (producto>0){
            producto=producto-1;
            notify();
        }
        else
            wait();
    }
    
    public synchronized void meteProducto(){
        if(producto<limite){
            producto=producto+1;
            notify();
        }
        else
            try {
                wait();
        } catch (InterruptedException ex) {
           // Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized int getProducto(){
        return producto;
    }
}
