import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private static Calendarr calendar;
    public static void main(String[] args) {
        calendar = new Calendarr();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            getTasksForDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        // title input
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine();
        // description input
        System.out.println("Введите описание задачи:");
        String description = scanner.nextLine();
        // isWork input
        boolean isPersonal;
        System.out.println("Эта задача личная?");
        switch (scanner.nextLine()) {
            case "да":
                isPersonal = true;
                break;
            default:
                isPersonal = false;
        }
        // date input
        LocalDateTime date = null;
        System.out.println("Введите дату и время задачи (01.01.2000):");
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDateTime.parse(scanner.nextLine(), Tasks.DATE_TIME_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты");
            }
        }
        // creation of Task
        Tasks task;
        System.out.println("Повторяемость задания:");
        System.out.println("\t • 0 – однократно");
        System.out.println("\t • 1 – ежедневно");
        System.out.println("\t • 2 – еженедельно");
        System.out.println("\t • 3 – ежемесячно");
        System.out.println("\t • 4 – ежегодно");
        switch (scanner.next()) {
            case "1":
                task = new DailyTask(title, description, isPersonal, date);
                break;
            case "2":
                task = new WeeklyTask(title, description, isPersonal, date);
                break;
            case "3":
                task = new MonthlyTask(title, description, isPersonal, date);
                break;
            case "4":
                task = new YearlyTask(title, description, isPersonal, date);
                break;
            default:
                task = new OneTimeTask(title, description, isPersonal, date);
        }
        if (calendar.addTask(task)) {
            System.out.println("Задача добавлена");
        }
    }

    public static void removeTask(Scanner scanner){
        int id = enterId(scanner);
        if (calendar.removeTask(id)) {
            System.out.println("Задача была удалена");
        } else {
            System.out.println("Такой задачи нет");
        }
    }

    private static int enterId(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите ID задачи:");
        boolean shouldEnterAgain = true;
        int id = -1;
        while (shouldEnterAgain) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                shouldEnterAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("Некорректно введен ID");
            }
        }
        return id;
    }

    public static void getTasksForDay(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите дату (формат: 01.01.2000 00:00):");
        LocalDate date = null;
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDate.parse(scanner.nextLine(), Tasks.DATE_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты");
            }
        }
        System.out.println(calendar.getTasksForOneDay(date));
    }

    private static void printMenu() {
        System.out.println(
                        "1. Добавить задачу " + "\n" +
                        "2. Удалить задачу " + "\n" +
                        "3. Получить задачу на указанный день " + "\n" +
                        "0. Выход "
        );
    }
}