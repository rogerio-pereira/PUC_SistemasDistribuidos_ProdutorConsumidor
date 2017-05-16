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
            System.out.println("Requisicao OK\n");
            return true;
        } catch (Exception e) {
            System.out.println("Erro\nCausa:\n"+e.getCause()+"\n"+"Mensagem:\n"+e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean podeProduzir(Requisicao r) throws RemoteException
    {
        System.out.println("Produzido: "+produzido+" - Consumido: "+consumido);
        if(autProd-consumido < 4) {
            return requisita(r);
        }
        else {
            System.out.println("Buffer Cheio\n");
            return false;
        }
    }
    
    @Override
    public void consome() throws RemoteException
    {
        //THREAD
        /*int op = 1;
        do {
            switch(op) {
                case 0: break;
                case 1: {*/
                try {
                    if(consumido-produzido < 0) {
                        Requisicao req = buffer[consumido%4];
                        System.out.println(req.toString()+"\n");
                        consumido++;
                        //break;
                    }
                    else
                        System.out.println("Buffer Vazio"+"\n");
                } catch (Exception e) {
                    System.out.println("Erro\nCausa:\n"+e.getCause()+"\n"+"Mensagem:\n"+e.getMessage());
                }
                    
                /*}
                default:
                    System.out.println("Digite 0 para sair e 1 para consumir");
            }    
        }while(op!=0);*/
    }
}
