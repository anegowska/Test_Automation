package utility;

import com.github.javafaker.Faker;

public class DataFaker {

    private Faker faker;

    public DataFaker() {
        faker = new Faker();
    }

    public String getFakePassword() {
        return faker.internet().password();
    }

    public String getFakeFirstName() {
        return faker.name().firstName();
    }

    public String getFakeLastName() {
        return faker.name().lastName();
    }

    public String getFakeEmail() {
        return faker.internet().emailAddress();
    }

    public String getFakeAddress() {
        return faker.address().streetAddress();
    }

    public String getFakeCity() {
        return faker.address().city();
    }

    public String getFakeZipCode() {
        return faker.address().zipCode();
    }

    public String getFakePhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static void main(String[] args) {
        DataFaker dataFaker = new DataFaker();
        System.out.println(dataFaker.getFakeCity());
    }
}
