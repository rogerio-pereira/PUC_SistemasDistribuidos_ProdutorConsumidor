/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidos_produtorconsumidor;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

/**
 *
 * @author farofa
 */
public class SistemasDistribuidos_ProdutorConsumidor {

    private static Registry registro;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws RemoteException {
        try {
            //Requisicao req = new Requisicao(null);
        
            Servidor server = new Servidor();

            registro = java.rmi.registry.LocateRegistry.createRegistry(1099);
            registro.rebind("enderecoObjeto", server);
        } catch (Exception e) {
            System.out.println("Mensagem: "+e.getMessage()+"\nCausa: "+e.getCause());
        }
        
    }
    
}
