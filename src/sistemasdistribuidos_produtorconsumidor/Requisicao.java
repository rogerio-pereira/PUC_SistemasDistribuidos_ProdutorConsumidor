/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidos_produtorconsumidor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author farofa
 */
public class Requisicao implements Serializable {
    String timestamp;
    String mensagem;

    @Override
    public String toString() {
        return "Data: "+getTimestamp().toString()+
               "\n" + "Mensagem: "+getMensagem();
    }

    public Requisicao(String mensagem) {
        this.timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTimestamp() {
        return timestamp;
    }
    
    
    
    
}
