package com.intelliacademy.lesson.env;

import az.rock.csv4j.annotation.CSVColumn;
import az.rock.csv4j.annotation.CSVModel;
import az.rock.csv4j.annotation.ColumnType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@CSVModel
public class Person implements Comparable<Person> ,Cloneable {

    @CSVColumn(name = "id",type = ColumnType.GUID)
    private UUID id;

    @CSVColumn(name = "first_name")
    private String firstName;

    @CSVColumn(name = "last_name")
    private String lastName;

    @CSVColumn(name = "birthday",type = ColumnType.DATE)
    private Date birthday;

    @CSVColumn(name = "email")
    private String email;

    @CSVColumn(name = "gender")
    private String gender;

    @CSVColumn(name = "city")
    private String city;

    @CSVColumn(name = "address")
    private String address;

    @CSVColumn(name = "salary")
    private String salary;


    public static class PersonRoot {
        private UUID id;
        private String firstName;
        private String lastName;
        private LocalDate birthday;

        private String email;

        private Gender gender;
        private String city;
        private String address;
        private BigDecimal salary;

        private PersonRoot(Person person) {
            this.id = person.getId();
            this.firstName = person.getFirstName();
            this.lastName = person.getLastName();
            this.birthday = person.birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            this.gender = Gender.of(Objects.requireNonNullElse(person.getGender(),"MALE"));
            this.email = person.getEmail();
            this.city = person.getCity();
            this.address = person.getAddress();
            this.salary = parseSalary(person.getSalary());
        }

        private static BigDecimal parseSalary(String salary){
            try {
                return new BigDecimal(salary);
            }catch (NumberFormatException e){
                return BigDecimal.ZERO;
            }
        }

        public static PersonRoot of(Person person) {
            return new PersonRoot(person);
        }

        @Override
        public String toString() {
            return "\n" +
                    "Person {" +"\n" +
                    "   id=" + id + "\n" +
                    "   , firstName='" + firstName + '\'' + "\n" +
                    "   , lastName='" + lastName + '\'' + "\n" +
                    "   , salary='" + salary + '\'' + "\n" +
                    "   , birthday=" + birthday + "\n" +
                    "   , email='" + email + '\'' + "\n" +
                    "   , gender='" + gender + '\'' + "\n" +
                    "   , city='" + city + '\'' + "\n" +
                    "   , address='" + address + '\'' + "\n" +
                    '}';
        }
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSalary() {
        return salary;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public int compareTo(Person o) {
        return Integer.valueOf(this.salary).compareTo(Integer.valueOf(o.salary));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && Objects.equals(birthday, person.birthday) && Objects.equals(email, person.email) && Objects.equals(gender, person.gender) && Objects.equals(city, person.city) && Objects.equals(address, person.address) && Objects.equals(salary, person.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, email, gender, city, address, salary);
    }

    @Override
    public Person clone() {
        return Builder
                .builder()
                .id(this.id)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .birthday(this.birthday)
                .salary(this.salary)
                .birthday(this.birthday)
                .city(this.city)
                .address(this.address)
                .build();
    }


    public static final class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private Date birthday;
        private String email;
        private String gender;
        private String city;
        private String address;
        private String salary;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder salary(String salary) {
            this.salary = salary;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setId(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setBirthday(birthday);
            person.setEmail(email);
            person.setGender(gender);
            person.setCity(city);
            person.setAddress(address);
            person.salary = this.salary;
            return person;
        }
    }
}