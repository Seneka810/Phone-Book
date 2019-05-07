package entities;

import java.util.Objects;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private int age;
    private String sex;
    private String phone;

    public Customer() {
    }

    public int getId() {
        return this.id;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Customer customer = (Customer)o;
            return this.age == customer.age && Objects.equals(this.surname, customer.surname) && Objects.equals(this.name, customer.name) && Objects.equals(this.sex, customer.sex) && Objects.equals(this.phone, customer.phone);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.surname, this.name, this.age, this.sex, this.phone});
    }
}
