package com.example.georgesamuel.dubaihotels.designPatterns.model;

public class User {
    private String firstName;
    private String lastName;
    private String age;

    private User(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String age;

        public Builder setFirstName(String fName){
            this.firstName = fName;
            return this;
        }

        public Builder setLastName(String lName){
            this.lastName = lName;
            return this;
        }

        public Builder setAge(String age){
            this.age = age;
            return this;
        }

        public User create(){
            User user = new User(this);
            if(user.firstName.isEmpty()){
                throw new IllegalStateException("First name con't be empty");
            }
            if(user.lastName.isEmpty()){
                throw new IllegalStateException("Last name con't be empty");
            }
            return user;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }
}
