/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DEIRY
 */
public class Lado {

    private String vertice1;
    private String vertice2;
    private int id;

    public Lado() {
        this.vertice1 = "";
        this.vertice2 = "";
        this.id = 0;

    }

    public Lado(String dato1, String dato2, int id) {
        this.vertice1 = dato1;
        this.vertice2 = dato2;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDato1() {
        return vertice1;
    }

    public void setDato1(String dato1) {
        this.vertice1 = dato1;
    }

    public String getDato2() {
        return vertice2;
    }

    public void setDato2(String dato2) {
        this.vertice2 = dato2;
    }

    public void mostrar(){
        System.out.println("Id: "+id+" Vertice1 "+vertice1+" Vertice2 "+vertice2);
    }
}
