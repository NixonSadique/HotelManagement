/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Clientes implements Serializable{
    
    private double preco;
    private String nome;
    private int quarto;
    private String estadia;

    public String getEstadia() {
        return estadia;
    }

    public void setEstadia(String estadia) {
        this.estadia = estadia;
    }
    
    
    public void setPreco(double preco){
        this.preco=preco;
    }
    
    public double getPreco(){
        return preco;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setQuarto(int quarto){
        this.quarto=quarto;
    }
    
    public int getQuarto(){
        return quarto;
    }
}
