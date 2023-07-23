package ToyShop;

import ToyShop.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс, представляющий магазин игрушек.
 */
public class ToyStore {
    private List<Toy> toys;

    /**
     * Конструктор класса ToyStore.
     * Создает пустой список игрушек.
     */
    public ToyStore() {
        this.toys = new ArrayList<>();
    }

    /**
     * Добавить новую игрушку или обновить существующую.
     *
     * @param id       идентификатор игрушки
     * @param name     название игрушки
     * @param quantity количество игрушек в магазине
     * @param weight   частота выпадения игрушки в розыгрыше (вес в % от 100)
     */
    public void addOrUpdateToy(int id, String name, int quantity,
                               double weight) {
        if (quantity < 0 || weight < 0) {
            System.out.println("Ошибка: количество и вес игрушки не может " +
                    "быть отрицательным.");
            return;
        }

        Toy existingToy = findToyById(id);
        if (existingToy != null) {
            existingToy.setWeight(weight);
            existingToy.setQuantity(quantity);
        } else {
            Toy newToy = new Toy(id, name, quantity, weight);
            toys.add(newToy);
        }
    }

    /**
     * Розыгрыш призовых игрушек.
     *
     * @param numToys количество призовых игрушек для розыгрыша
     * @return список призовых игрушек
     */
    public List<Toy> drawToys(int numToys) {
        if (numToys <= 0) {
            System.out.println("Ошибка: количество призовых игрушек должно " +
                    "быть больше 0.");
            return null;
        }

        List<Toy> prizeToys = new ArrayList<>();
        for (int i = 0; i < numToys; i++) {
            Toy prizeToy = drawToy();
            if (prizeToy != null) {
                prizeToys.add(prizeToy);
            }
        }
        return prizeToys;
    }

    private Toy drawToy() {
        if (toys.isEmpty()) {
            System.out.println("Нет доступных игрушек для розыгрыша.");
            return null;
        }

        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        double currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber < currentWeight) {
                Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1,
                        toy.getWeight());
                toy.decreaseQuantity();
                if (toy.getQuantity() == 0) {
                    toys.remove(toy);
                }
                return prizeToy;
            }
        }

        Toy lastToy = toys.get(toys.size() - 1);
        Toy prizeToy = new Toy(lastToy.getId(), lastToy.getName(), 1,
                lastToy.getWeight());
        lastToy.decreaseQuantity();
        if (lastToy.getQuantity() == 0) {
            toys.remove(lastToy);
        }
        return prizeToy;
    }

    private Toy findToyById(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public void writeToTextFile(List<Toy> prizeToys) {
        try (FileWriter writer = new FileWriter("prize_toys.txt",
                true)) {
            for (Toy toy : prizeToys) {
                writer.write(toy.getId() + " " + toy.getName() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }
}
