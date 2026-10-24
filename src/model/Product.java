package model;

public class Product{
    int id;
    private String name;
    String category;
    private double price;
    private int quantity;
    int lowStockThreshold;

    public Product(int id, String name, String category, double price, int quantity, int lowStockThreshold){

        if(id <= 0 ){
            throw new IllegalArgumentException("Product id cannot be negative");
        }

        if(name == null || name.isBlank() || category == null || category.isBlank()){
            throw new IllegalArgumentException("Name & Category cannot be empty");
        }

        if(price <= 0 || quantity <= 0 || lowStockThreshold <= 0 ){
            throw new IllegalArgumentException("Price, Quantity & LowStockThreshold cannot be empty");
        }
        this.id = id;
        this.name = name;
        this.category=category;
        this.price = price;
        this. quantity = quantity;
        this. lowStockThreshold = lowStockThreshold;
    }

    public String getName(){
        return name;
    }

    public void setName(String setName){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = setName;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double setPrice){
        if(setPrice <= 0 ){
            throw new IllegalArgumentException("P2rice cannot be in negative");
        }
        this.price = setPrice;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int setQuantity){
        if(setQuantity <= 0)
                throw new IllegalArgumentException("Quantity cannot be in negative");
        this.quantity = setQuantity;
    }

}