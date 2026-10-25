package main;

import model.Product;

public class Main{
    public static void main(String[] args){
        Product A = new Product(1234,"Dove","Soap",40,1,1);

        System.out.println(A.getPrice());
        A.setPrice(50);
        System.out.println(A.getPrice());

    }
}