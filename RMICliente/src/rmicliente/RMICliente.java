/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicliente;

import com.br.lp3.rmi.Mensagem;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everson
 */
public class RMICliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            //172.16.16.181
            Registry registro = LocateRegistry.getRegistry("localhost",1099);
            //Mensagem chat = (Mensagem) registro.lookup("Chat");
            Mensagem servico = (Mensagem) registro.lookup("Chat");
            
            System.out.println("Qual o seu nome?");
            Scanner sc = new Scanner(System.in);
            String nome = sc.nextLine();
            servico.diz(nome, "Hello World");
            servico.diz("chat", nome+" entrou no chat");
            
            System.out.println("Enquanto não digitar 'fim', o programa não irá fechar");
            String msg = "";
            while(!msg.equals("fim")){
                msg = sc.nextLine();
                if(!msg.equals("fim"))servico.diz(nome, msg);
                
                List<String> lista = servico.getMsg();
                for(String msg2 : lista){
                    System.out.println(msg2);
                }
                
            }
            
            servico.diz("chat", nome+" saiu no chat");
            
            //chat.diz("Everson", "Hello Word");
        
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RMICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
