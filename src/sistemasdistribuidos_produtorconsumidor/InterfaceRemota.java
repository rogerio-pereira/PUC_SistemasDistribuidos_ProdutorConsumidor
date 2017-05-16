/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidos_produtorconsumidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author farofa
 */
public interface InterfaceRemota extends Remote{
    public boolean requisita(Requisicao r) throws RemoteException;
    public boolean podeProduzir(Requisicao r) throws RemoteException;
    public String consome() throws RemoteException;
}
