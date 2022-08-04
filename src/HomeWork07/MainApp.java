package HomeWork07;

public class MainApp {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        DatabaseRepositorySQLiteImpl databaseRepositorySQLite = new DatabaseRepositorySQLiteImpl();
        databaseRepositorySQLite.createTableIfNotExists();
        userInterface.runApplication();

    }
}
