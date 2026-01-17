package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Tranzactie
{
    private  int id;
    private double amount;
    private String descriere;
    private TipTranzactie tip;
 private LocalDate data;
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getDescriere() { return descriere; }
    public  TipTranzactie getTip(){return  tip;}
    public int getId(){
        return id;
    }
    public Tranzactie(int id, double amount, String descriere, TipTranzactie tip) {
        this.id = id;
        this.amount = amount;
        this.descriere = descriere;
        this.tip = tip;
        this.data=LocalDate.now();
    }
    public void  afiseazaDetalii(){
        String formatAmount=String.format("%.2f",amount);
        System.out.println("ID: "+id+ " "+data+ " | "+descriere+":"+formatAmount+"RON");
    }


}
