import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice(List<Product> products) {
        // Допишите реализацию метода самостоятельно
        if (products.isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (products.size() > 1) {
            Comparator<Product> comparator = Comparator.comparing(Product::getCost);
            products.sort(comparator);
        }
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct(List<Product> products) {
        // Допишите реализацию метода самостоятельно
        sortProductsByPrice(products);
        return products.get(products.size() - 1);
    }

}
