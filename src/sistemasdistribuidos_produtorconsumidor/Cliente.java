 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidos_produtorconsumidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farofa
 */
public class Cliente{
    private static InterfaceRemota server;
    private static Requisicao req;
    
    public void produz(String msg)
    {
        Requisicao req = new Requisicao(msg);
        
        try {
            server.podeProduzir(req);
        } catch (RemoteException e) {
            System.out.println("Erro\nCausa:\n"+e.getCause()+"\n"+"Mensagem:\n"+e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException,
                                                    MalformedURLException,
                                                    RemoteException{
        Requisicao req = new Requisicao("teste");
        
        server = (InterfaceRemota) Naming.lookup("rmi://localhost/enderecoObjeto");
        server.podeProduzir(req);
    }
}
