/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidos_produtorconsumidor;

import java.util.ArrayList;

/**
 *
 * @author farofa
 */
public class Servidor extends Thread implements InterfaceRemota
{
    Requisicao buffer[];

    public Servidor() {
        buffer = new Requisicao[4];
    }

    @Override
    public boolean requisita(Requisicao r) 
    {
        //int posicao = posicaoBuffer;
        
        try {
            if(podeProduzir()) {
                //sim
                buffer[posicao%4] = r;
                return true;
            }
            else
                return false;
        } catch (Exception e) {
            System.out.println("Erro\nCausa:\n"+e.getCause()+"\n"+"Mensagem:\n"+e.getMessage());
            return false;
        }
    }
    
    public boolean podeProduzir()
    {
        return true;
        
        return false;
    }
    
    public String consome(int i)
    {
        Requisicao req = buffer[i];
        String ret = req.toString();
        
        return ret;
    }
}
