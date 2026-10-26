package service;

import model.Product;
import exception.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class InventoryService {

    private final Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) throws DuplicateProductException {
        int productId = product.getID();

        if (products.containsKey(productId)) {
            throw new DuplicateProductException(
                    "Product with ID " + productId + " already exists.");
        }

        products.put(productId, product);

        System.out.println("Product added successfully!");
    }

    public Product getProductById(int productId) throws ProductNotFoundException {

        if (!products.containsKey(productId)) {throw new ProductNotFoundException(
                    "Product with ID"+productId+"not found.");
        }
        return products.get(productId);
    }

    public Collection<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }


    public List<Product> getProductsByCategory(String category) {

        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products.values()) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                matchingProducts.add(product);
            }
        }

        return matchingProducts;
    }

    public Set<String> getAllCategories() {

        Set<String> categories = new LinkedHashSet<>();

        for (Product product : products.values()) {
            categories.add(product.getCategory());
        }

        return categories;
    }

    public void updateProductQuantity(int productId, int newQuantity) throws ProductNotFoundException {
        if (newQuantity < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative");
        }

        Product product = getProductById(productId);
        product.setQuantity(newQuantity);
        System.out.println("Product quantity updated successfully!");
    }

    public void sellProduct(int productId, int quantity)
            throws ProductNotFoundException, InsufficientStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Sale quantity must be greater than zero.");
        }
        Product product = getProductById(productId);
        if (product.getQuantity() < quantity) {
            throw new InsufficientStockException(
                    "Insufficient stock. Available quantity:"+ product.getQuantity());
        }
        product.setQuantity(product.getQuantity() - quantity);
        System.out.println("Product sold successfully!");
    }

    public void removeProduct(int productId) throws ProductNotFoundException {
        if (!products.containsKey(productId)) {
            throw new ProductNotFoundException(
                    "Product with ID"+productId+"not found.");
        }
        products.remove(productId);
        System.out.println("Product removed successfully!");
    }
}
