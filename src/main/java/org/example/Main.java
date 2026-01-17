package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Tranzactie> portofel=new ArrayList<>();
        int id=1;
        boolean ruleaza=true;

        while (ruleaza){
            System.out.println("\n--- MENIU PORTOFEL ---");
            System.out.println("1. Adaugă Tranzacție");
            System.out.println("2. Vezi Balanță");
            System.out.println("3. Stergere Tranzactie");
            System.out.println("4: Vezi tranzactii ");
            System.out.println("5. Ieșire");
            try {
                System.out.print("Alege o opțiune: ");

                int optiune = scanner.nextInt();
                scanner.nextLine();
                switch (optiune) {

                    case 1:


                        System.out.println("Introdu descrierea: ");
                        String descriere = scanner.nextLine();
                        System.out.println("Introdu suma: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Alege tipul tranzactiei:");
                        System.out.println("1. Venit ");
                        System.out.println("2. Cheltuiala ");
                        int optiuneSelectata = scanner.nextInt();
                        TipTranzactie tipSelectat = (optiuneSelectata == 1) ? TipTranzactie.VENIT : TipTranzactie.CHELTUIALA;
                        portofel.add(new Tranzactie(id++, amount, descriere, tipSelectat));
                        System.out.println(" Adăugat cu succes!");
                        for (Tranzactie t : portofel) {
                            t.afiseazaDetalii();
                        }
                        break;
                    case 2:
                        double balanta = 0;
                        for (Tranzactie t : portofel) {
                            if (t.getTip() == TipTranzactie.VENIT) {
                                balanta += t.getAmount();
                            } else {
                                balanta -= t.getAmount();
                            }
                        }
                        System.out.println("Balanta finala este: " + balanta + " RON");
                        break;
                    case 3:
                        System.out.print("Introdu ID-ul tranzacției de șters: ");
                        int removeId = scanner.nextInt();
                        boolean remove = portofel.removeIf(t -> t.getId() == removeId);
                        if (remove) {
                            System.out.println(" Tranzacția a fost ștearsă!");
                        } else {
                            System.out.println(" Nu am găsit nicio tranzacție cu acest ID.");
                        }
                    break;
                    case 4:
                        System.out.println("Alege suma peste care vrei sa vezi tranzactiile: ");
                         double sumaAleasa= scanner.nextDouble();
                        for(Tranzactie t:portofel){
                            if (t.getAmount()>sumaAleasa){
                                t.afiseazaDetalii();
                            }
                        }
                        break;
                    case 5:
                        ruleaza = false;
                        System.out.println("La revedere!");
                        break;
                    default:
                        System.out.println("Opțiune invalidă!");
                }
            }catch (Exception e){
                System.out.println(" Eroare: Te rog să introduci doar cifre!");
                scanner.nextLine();
            }

        }




    }
    }
