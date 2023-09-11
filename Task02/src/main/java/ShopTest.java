/*Задание 2.
Мы хотим улучшить функциональность нашего интернет-магазина. Ваша задача - добавить два новых метода в класс Shop:
Метод sortProductsByPrice(), который сортирует список продуктов по стоимости. Метод getMostExpensiveProduct(), который
возвращает самый дорогой продукт.
Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное
содержимое корзины).
Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
*/

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    public static void main(String[] args) {
        Shop intShop = new Shop();
        List<Product> myBasket = new ArrayList<>();
        List<String> listTitle = new ArrayList<>();
        List<Integer> listCost = new ArrayList<>();
        myBasket.add(new Product(25, "potato"));
        myBasket.add(new Product(50, "cucumber"));
        myBasket.add(new Product(60, "tomato"));
        myBasket.add(new Product(120, "pumpkin"));
        myBasket.add(new Product(70, "zucchini"));
        myBasket.add(new Product(30, "bread"));
        myBasket.add(new Product(80, "butter"));
        myBasket.add(new Product(130, "grape"));
        myBasket.add(new Product(65, "sour cream"));
        myBasket.add(new Product(100, "apple"));
        myBasket.add(new Product(90, "banana"));
        myBasket.add(new Product(40, "milk"));
        intShop.setProducts(myBasket);
        assertThat(intShop.getProducts())
                .isNotEmpty()
                .hasSize(12);
        for (int i = 0; i < intShop.getProducts().size(); i++) {
            System.out.println(intShop.getProducts().get(i).getTitle() + " " + intShop.getProducts().get(i).getCost());
        }
        System.out.println("------------------");
        intShop.sortProductsByPrice(myBasket);
        for (int i = 0; i < intShop.getProducts().size(); i++) {
            listTitle.add(intShop.getProducts().get(i).getTitle());
            listCost.add(intShop.getProducts().get(i).getCost());
            System.out.println(intShop.getProducts().get(i).getTitle() + " " + intShop.getProducts().get(i).getCost());
        }
        System.out.println("------------------");
        assertThat(listTitle)
                .containsSequence("potato", "bread", "milk", "cucumber", "tomato", "sour cream", "zucchini",
                        "butter", "banana", "apple", "pumpkin", "grape");
        assertThat(listCost)
                .containsSequence(25, 30, 40, 50, 60, 65, 70, 80, 90, 100, 120, 130);
        Product maxCost = intShop.getMostExpensiveProduct(myBasket);
        System.out.println("Самый дорогой продукт: " + maxCost.getTitle() + " " + maxCost.getCost());
        assertThat(maxCost.getTitle()).isEqualTo("grape");
        assertThat(maxCost.getCost()).isEqualTo(130);
        myBasket.clear();
        assertThatThrownBy(() ->
                intShop.sortProductsByPrice(myBasket)
        ).isInstanceOf(RuntimeException.class).hasMessage("List is empty");
    }
}
