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
    ArrayList<Requisicao> buffer;

    public Servidor() {
        this.buffer = new ArrayList<>();
    }

    @Override
    public boolean requisita(Requisicao r) 
    {
        System.out.println(r.toString());
        try {
            this.buffer.add(r);
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro\nCausa:\n"+e.getCause()+"\n"+"Mensagem:\n"+e.getMessage());
            return false;
        }
    }
    
    public String consome(int i)
    {
        Requisicao req = (Requisicao)this.buffer.get(i);
        this.buffer.remove(i);
        
        String ret = req.toString();
        
        return ret;
    }
}
