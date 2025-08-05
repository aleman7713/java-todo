import aleman.todo.Todo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Todo todo = new Todo();
        boolean isLoop = true;

        while (isLoop) {
            todo.printMenu();

            String str = scanner.nextLine();
            int choose = Integer.parseInt(str);
            System.out.println("Ваш выбор: " + choose + "\n");

            switch (choose) {
                case 0:
                    isLoop = false;
                    break;
                case 1:
                    System.out.print("Введите название задачи: ");
                    str = scanner.nextLine();
                    todo.addTask(str);
                    System.out.println("\nДобавлено!");
                    todo.printTodoList();
                    break;
                case 2:
                    todo.printTodoList();
                    break;
                case 3:
                    System.out.print("Введите номер для удаления: ");
                    str = scanner.nextLine();
                    int id = Integer.parseInt(str);
                    if (todo.deleteTaskByID(id)) {
                        System.out.println("\nУдалено!");
                    } else {
                        System.out.println("\nВведён несуществующий индекс!");
                    }
                    todo.printTodoList();
                    break;
                case 4:
                    System.out.print("Введите задачу для удаления: ");
                    str = scanner.nextLine();
                    if (todo.deleteTaskByName(str)) {
                        System.out.println("\nУдалено!");
                    } else {
                        System.out.println("\nЗадача не найдена!");
                    }
                    todo.printTodoList();
                    break;
                case 5:
                    System.out.print("Введите ключевое слово для удаления: ");
                    str = scanner.nextLine();
                    if (todo.deleteTaskByText(str)) {
                        System.out.println("\nУдалено!");
                    } else {
                        System.out.println("\nЗадачи не найдены!");
                    }
                    todo.printTodoList();
                    break;
            }
        }

        scanner.close();
    }
}
