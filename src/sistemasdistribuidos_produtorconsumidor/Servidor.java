/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidos_produtorconsumidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author farofa
 */
public class Servidor extends UnicastRemoteObject implements InterfaceRemota
{
    Requisicao buffer[];
    
    int produzido;
    int consumido;
    int autProd;
    int autCons;

    public Servidor() throws RemoteException{
        this.buffer = new Requisicao[4];
        produzido = 0;
        consumido = 0;
    }
    
    @Override
    public boolean requisita(Requisicao r) throws RemoteException 
    {
        try {
            buffer[produzido % 4] = r;
            produzido++;
            autProd++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean podeProduzir(Requisicao r) throws RemoteException
    {
        if(autProd-consumido < 4) {
            return requisita(r);
        }
        else {
            return false;
        }
    }
    
    @Override
    public String consome() throws RemoteException
    {
        String msg;
        
        if(consumido-produzido < 0) {
            Requisicao req = buffer[consumido%4];
            msg = req.toString();
            consumido++;
        }
        else
            msg = "Buffer Vazio";

        return msg;
    }
}
