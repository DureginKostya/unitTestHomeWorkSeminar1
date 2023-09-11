/*Задание 1.
В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент скидки
и возвращает сумму с учетом скидки. Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
Не забудьте написать тесты для проверки этого поведения.
*/

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        assertThat(Calculator.calculatingDiscount(500,10)).isEqualTo(450);
        assertThat(Calculator.calculatingDiscount(600.5,15)).isEqualTo(510.425);
        assertThat(Calculator.calculatingDiscount(250,0)).isEqualTo(250);
        assertThat(Calculator.calculatingDiscount(300,100)).isEqualTo(0);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-55, 10)
        ).isInstanceOf(ArithmeticException.class).hasMessage("Invalid value purchaseAmount");
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(0, 10)
        ).isInstanceOf(ArithmeticException.class).hasMessage("Invalid value purchaseAmount");
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(120, 110)
        ).isInstanceOf(ArithmeticException.class).hasMessage("Invalid value discountAmount");
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(160, -10)
        ).isInstanceOf(ArithmeticException.class).hasMessage("Invalid value discountAmount");

        System.out.println(Calculator.calculatingDiscount(500,10));
        System.out.println(Calculator.calculatingDiscount(600.5,15));
        System.out.println(Calculator.calculatingDiscount(250,0));
        System.out.println(Calculator.calculatingDiscount(300,100));
//        System.out.println(Calculator.calculatingDiscount(-55,10));
//        System.out.println(Calculator.calculatingDiscount(0,10));
//        System.out.println(Calculator.calculatingDiscount(120,110));
//        System.out.println(Calculator.calculatingDiscount(160,-10));
    }
}