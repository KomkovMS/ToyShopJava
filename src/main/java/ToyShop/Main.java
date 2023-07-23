package ToyShop;

import java.util.List;

/**
 * Главный класс приложения для розыгрыша игрушек в магазине детских товаров.
 */
public class Main {
    /**
     * Главный метод приложения.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addOrUpdateToy(
                1,
                "Набор LEGO Star Wars",
                5,
                10.0);
        toyStore.addOrUpdateToy(
                2,
                "Настольная игра Monopoly",
                3,
                15.0);
        toyStore.addOrUpdateToy(
                3,
                "Радиоуправляемая машина car toy",
                8,
                20.0);
        toyStore.addOrUpdateToy(
                4,
                "Кукла Barbie doll",
                7,
                12.5);
        toyStore.addOrUpdateToy(
                5,
                "Пистолет игрушечный Nerf gun",
                4,
                8.0);

        List<Toy> prizeToys = toyStore.drawToys(3);

        toyStore.writeToTextFile(prizeToys);

        for (Toy prizeToy : prizeToys) {
            System.out.println("Призовая игрушка: " + prizeToy.getName());
        }
    }
}
