import global.MyFileWriter;

import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static global.Vars.allToys;
import static global.Vars.winsToys;

public class Main {

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        // Создаем произвольные игрушки
        Toy car = new Toy(1, "Машинка", 10, 20);
        Toy bear = new Toy(2, "Плюшевый медведь", 3, 5);
        Toy lego = new Toy(3, "Конструктор", 4, 10);
        Toy doll = new Toy(4, "Кукла", 10, 30);
        Toy kitchen = new Toy(5, "Игрушечная кухня", 6, 20);
        Toy sword = new Toy(6, "Игрушечный меч", 5, 8);

        // добавляем созданные игрушки в общий список с новым весом
        addToListWithNewChance(car, 35);
        addToListWithNewChance(bear, 50);
        addToListWithNewChance(lego, 1);
        addToListWithNewChance(doll, 7);
        addToListWithNewChance(kitchen, 45);
        addToListWithNewChance(sword, 6);

        // показываем общий список игрушек
        System.out.println("Все имеющиеся игрушки: ");
        showNewList(allToys);

        // формируем список призовых игрушек (пусть это будут с шансом выпадания до 10%)
        List<Toy> addedWinners = selectToyByMinWeight(allToys, 10);
        winsToys.addAll(addedWinners);

        // показываем список призовых игрушек
        System.out.println("\u001B[33mПризовые игрушки: ");
        showNewList(winsToys);

        // выбираем призовую игрушку на выдачу из призового списка (случайным образом)
        Toy givedWinner = selectRandomToy(winsToys);
        // удаляем выданную игрушку из списка к выдаче
        winsToys.remove(givedWinner);

        // отображаем информацию о призовой игрушке на выдачу
        System.out.println("\u001B[32mИ игрушка для победителя это: " + givedWinner.info());

        // пишем информацию в текстовый файл
        MyFileWriter.writeToy(givedWinner);

    }

    private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minChance) {
        List<Toy> result = new ArrayList<>();
        for (Toy currentToy : allToys) {
            if (currentToy.getChance() <= minChance) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewChance(Toy newToy, int newChance) {
        newToy.setChance(newChance);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<Toy> myList) {
        int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("Игрушка [" + i + "]: " + myList.get(i).getName());
            System.out.println();
        }
        System.out.println("");
    }
}