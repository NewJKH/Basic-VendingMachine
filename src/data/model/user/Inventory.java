package data.model.user;

import data.abs.Product;

import java.util.Map;

public record Inventory(Map<Product,Integer> hold) {
}
