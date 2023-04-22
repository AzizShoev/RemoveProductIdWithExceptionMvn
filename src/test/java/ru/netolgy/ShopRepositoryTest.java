package ru.netolgy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveItemWithId() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(11, "Футболка", 400);
        Product product1 = new Product(7, "Отвертка", 750);
        Product product2 = new Product(14, "Стакан гранёный", 130);

        repository.add(product);
        repository.add(product1);
        repository.add(product2);

        repository.remove(7);

        Assertions.assertArrayEquals(new Product[]{product, product2}, repository.findAll());
    }

    @Test
    public void shouldRemoveNotFoundIdItem() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(11, "Футболка", 400);
        Product product1 = new Product(7, "Отвертка", 750);
        Product product2 = new Product(12, "Стакан гранёный", 130);

        repository.add(product);
        repository.add(product1);
        repository.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(90));
    }

    @Test
    public void shouldFindAllAddedProductsInRepository() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(11, "Футболка", 400);
        Product product1 = new Product(7, "Отвертка", 750);
        Product product2 = new Product(14, "Стакан гранёный", 130);

        repository.add(product);
        repository.add(product1);
        repository.add(product2);

        Assertions.assertArrayEquals(new Product[]{product, product1, product2}, repository.findAll());
    }

    @Test
    public void shouldFindAlreadyExistsInRepository() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(11, "Футболка", 400);
        Product product1 = new Product(7, "Отвертка", 750);
        Product product2 = new Product(14, "Стакан гранёный", 130);

        repository.add(product);
        repository.add(product1);
        repository.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repository.add(product2));
    }
}
