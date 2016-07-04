/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import com.br.lp3.rmi.MensagemImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everson
 */
public class RMIServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("Chat", new MensagemImpl());
            System.out.println("Serviço Registrado com Sucesso");
        
        } catch (RemoteException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
