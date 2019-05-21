package com.example.administrator.myapplication;

public class Person {
    private String name;
    private String age;
    private String sex;

    public Person() {
    }

    public Person(String area) {
        this.area = area;
    }

    ;

    public Person(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.sex = builder.sex;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                ", sex=" + sex +
                +'}';

    }

    public static class Builder {
        private String name;
        private String age;
        private String sex;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }


    String area = "shenzhen";

    public String getArea(String name,int index) {
        System.out.println("Person:" + area + "****" +index+"****"+ name);
        return area + "  " + name;
    }
}
