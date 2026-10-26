package model;

public class Product{
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private int lowStockThreshold;

    public Product(int id, String name, String category, double price, int quantity, int lowStockThreshold){

        if(id <= 0){
            throw new IllegalArgumentException("Product ID cannot be negative or zero");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(category == null || category.isBlank()){
            throw new IllegalArgumentException("Category cannot be empty");
        }
        if(price <= 0){
            throw new IllegalArgumentException("Price cannot be negative or zero");
        }
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be in negative");
        }
        if(lowStockThreshold < 0 ){
            throw new IllegalArgumentException("LowStockThreshold cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.lowStockThreshold = lowStockThreshold;
    }

    public int getID(){
        return  id;
    }

    public void setID(int setID){
        if(setID <= 0){
            throw new IllegalArgumentException("Product ID cannot be negative or zero");
        }
        this.id = setID;
    }

    public String getName(){
        return  name;
    }

    public void setName(String setName){
        if(setName == null || setName.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = setName;
    }


    public String getCategory(){
        return category;
    }

    public void setCategory(String setCategory){
        if( setCategory == null || setCategory.isBlank()){
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category;
    }

    public double getPrice(){

        return price;
    }

    public void setPrice(double setPrice){
        if(setPrice <= 0){
            throw new IllegalArgumentException("Price cannot be negative or zero");
        }
        this.price = setPrice;
    }

    public int getQuantity(){

        return quantity;
    }

    public void setQuantity(int setQuantity){
        if(setQuantity <= 0){
            throw new IllegalArgumentException("Quantity cannot be negative or zero");
        }
        this.quantity = setQuantity;
    }

    public int getLowStockThreshold(){
        return lowStockThreshold;
    }

    public void setLowStockThreshold(int setLowStockThreshold){
        if(lowStockThreshold > 0){
            throw new IllegalArgumentException("LowStockThreshold cannot be negative");
        }
        this.lowStockThreshold = setLowStockThreshold;
    }
}