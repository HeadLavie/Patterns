import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {

    public static class CityGenerator {

        public static String[] cities = {"Казань", "Липецк", "Москва", "Псков", "Воронеж", "Белгород"};

        public static String getRandomCity() {
            Random random = new Random();
            int randomIndex = random.nextInt(cities.length);
            return cities[randomIndex];
            //return cities[new Random().nextInt(cities.length)];
        }
    }

    static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public static String generateCity(String locale) {
        return faker.address().cityName();
    }

    public static String generateName(String locale) {
        return faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}