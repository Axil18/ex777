import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол");
            String input = scanner.nextLine().trim();
            String[] userData = input.split(" ");

            if (userData.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных. Ожидалось 6 параметров.");
            }

            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date birthDate = dateFormat.parse(userData[3]);

            long phoneNumber = Long.parseLong(userData[4]);

            char gender = userData[5].charAt(0);
            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверное значение пола. Используйте 'f' или 'm'.");
            }

            String fileName = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            String userDataString = lastName + firstName + middleName +
                    dateFormat.format(birthDate) + phoneNumber + gender;
            writer.write(userDataString);
            writer.newLine();
            writer.close();
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Ошибка в формате даты. Используйте формат dd.MM.yyyy.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}