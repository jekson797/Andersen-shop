package by.andersenlab.shop.enums;

public enum ProductGroup {

    PHONE ("Телефон", "PHONE"),
    PC ("Компьютер", "PC"),
    NOTEBOOK ("Ноутбук", "NOTEBOOK"),
    MONITOR ("Монитор", "MONITOR"),
    GAME_CONSOLE ("Игровая приставка", "GAME_CONSOLE"),
    COMPUTER_ACCESSORY ("Компьютерный Аксессуар", "COMPUTER_ACCESSORY");

    private String group;
    private String originalValue;

    ProductGroup(String group, String originalValue) {
        this.group = group;
        this.originalValue = originalValue;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public static ProductGroup fromString(String string) {
        for (ProductGroup productGroup : ProductGroup.values()) {
            if (productGroup.group.equalsIgnoreCase(string)) {
                return productGroup;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return group;
    }
}
