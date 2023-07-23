package ToyShop;

/**
 * Класс, представляющий игрушку.
 */
public class Toy {
    private int id;         // Идентификатор игрушки
    private String name;    // Название игрушки
    private int quantity;   // Количество игрушек в магазине
    private double weight;  // Частота выпадения игрушки в розыгрыше

    /**
     * Конструктор класса Toy.
     *
     * @param id       идентификатор игрушки
     * @param name     название игрушки
     * @param quantity количество игрушек в магазине
     * @param weight   частота выпадения игрушки в розыгрыше (вес в % от 100)
     */
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    /**
     * Получить идентификатор игрушки.
     *
     * @return идентификатор игрушки
     */
    public int getId() {
        return id;
    }

    /**
     * Получить название игрушки.
     *
     * @return название игрушки
     */
    public String getName() {
        return name;
    }

    /**
     * Получить количество игрушек в магазине.
     *
     * @return количество игрушек в магазине
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Установить количество игрушек в магазине.
     *
     * @param quantity количество игрушек
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Получить частоту выпадения игрушки в розыгрыше.
     *
     * @return частота выпадения игрушки в розыгрыше (вес в % от 100)
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Установить частоту выпадения игрушки в розыгрыше.
     *
     * @param weight частота выпадения игрушки в розыгрыше (вес в % от 100)
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Уменьшить количество игрушек на 1.
     */
    public void decreaseQuantity() {
        this.quantity--;
    }
}
