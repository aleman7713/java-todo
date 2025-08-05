package aleman.todo;

import java.util.ArrayList;
import java.util.List;

public class Todo {
    private List<String> todoList;

    public Todo() {
        todoList = new ArrayList<>(30);
    }

    public void printMenu() {
        System.out.println();
        System.out.println("------------------");
        System.out.println("Выберите операцию:");
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
        System.out.println("5. Удаление по ключевому слову");
        System.out.println("------------------");
    }

    public void addTask(String task) {
        todoList.add(task);
    }

    public void printTodoList() {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < todoList.size(); i++)
            System.out.println((i + 1) + ". " + todoList.get(i));
    }

    public boolean deleteTaskByText(String text) {
        List<Integer> list = new ArrayList<>();
        int index = 0;

        for (int i = todoList.size() - 1; i > -1; i--) {
            if (todoList.get(i).contains(text)) {
                index = i + 1;
                list.add(index);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            deleteTaskByID(list.get(i));
        }

        return !list.isEmpty();
    }

    public boolean deleteTaskByID(int index) {
        index--;
        if ((index > -1) && (index < todoList.size())) {
            todoList.remove(index);
            return true;
        }
        return false;
    }

    public boolean deleteTaskByName(String task) {
        int index = getIndex(task);
        return deleteTaskByID(index);
    }

    private int getIndex(String task) {
        int index = 0;

        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).compareTo(task) == 0) {
                index = i + 1;
                break;
            }
        }

        return index;
    }
}
