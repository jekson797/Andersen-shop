package by.andersenlab.shop.products;

import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.enums.MemoryDriveType;
import by.andersenlab.shop.enums.ProductGroup;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GameConsoleProduct extends Product {

    private MemoryDriveType driveType;
    private int memorySize;
    private int controllersAmount;
    private Set<String> gamesIncluded;

    public GameConsoleProduct(GameConsoleBuilder builder) {
        super(builder.name, ProductGroup.GAME_CONSOLE, builder.price, builder.currency);
        this.driveType = builder.driveType;
        this.memorySize = builder.memorySize;
        this.controllersAmount = builder.controllersAmount;
        this.gamesIncluded = builder.gamesIncluded;
    }

    public MemoryDriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(MemoryDriveType driveType) {
        this.driveType = driveType;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getControllersAmount() {
        return controllersAmount;
    }

    public void setControllersAmount(int controllersAmount) {
        this.controllersAmount = controllersAmount;
    }

    public Set<String> getGamesIncluded() {
        return gamesIncluded;
    }

    public void setGamesIncluded(Set<String> gamesIncluded) {
        this.gamesIncluded = gamesIncluded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameConsoleProduct that = (GameConsoleProduct) o;
        return memorySize == that.memorySize &&
                controllersAmount == that.controllersAmount &&
                driveType == that.driveType &&
                Objects.equals(gamesIncluded, that.gamesIncluded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driveType, memorySize, controllersAmount, gamesIncluded);
    }

    @Override
    public String toString() {
        return "Id: " + getProductId() +
                " | Group: " + ProductGroup.GAME_CONSOLE +
                " | Name: " + getName() +
                " | Drive type: " + driveType +
                " | Memory: " + memorySize + " GB" +
                " | Controllers amount: " + controllersAmount +
                " | Included games: " + gamesIncluded.stream().
                    reduce((total, game) -> total + "; " + game).orElse("None") +
                " | Price: " + getPrice() + " " + getCurrency();
    }

    public static class GameConsoleBuilder {

        private String name;
        private MemoryDriveType driveType;
        private int memorySize;
        private int controllersAmount;
        private Set<String> gamesIncluded = new HashSet<>();
        private BigDecimal price;
        private Currency currency;

        public GameConsoleBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public GameConsoleBuilder buildDriveType(MemoryDriveType driveType) {
            this.driveType = driveType;
            return this;
        }

        public GameConsoleBuilder buildMemorySize(int memorySize) {
            this.memorySize = memorySize;
            return this;
        }

        public GameConsoleBuilder buildControllersAmount(int controllersAmount) {
            this.controllersAmount = controllersAmount;
            return this;
        }

        public GameConsoleBuilder addIncludedGame(String game) {
            gamesIncluded.add(game);
            return this;
        }

        public GameConsoleBuilder buildPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public GameConsoleBuilder buildCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public GameConsoleProduct build() {
            return new GameConsoleProduct(this);
        }
    }
}
