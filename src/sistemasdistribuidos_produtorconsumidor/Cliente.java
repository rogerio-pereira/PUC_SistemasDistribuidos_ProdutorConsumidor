 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidos_produtorconsumidor;

/**
 *
 * @author farofa
 */
public class Cliente {
    Servidor server;

    public Cliente(Servidor server) 
    {
        this.server = new Servidor();
    }
    
    public void produz(String msg)
    {
        Requisicao req = new Requisicao(msg);
        
        if(this.server.requisita(req))
            System.out.println("Requisicao OK");
        else
            System.out.println("Requisicao Falhou");
    }
    
}
