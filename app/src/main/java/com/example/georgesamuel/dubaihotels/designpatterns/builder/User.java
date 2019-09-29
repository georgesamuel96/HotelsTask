package com.example.georgesamuel.dubaihotels.designpatterns.builder;

public class User {

    private String firstName;
    private String lastName;
    private int age;

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;

        public Builder setFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(final int age) {
            this.age = age;
            return this;
        }

        public User create() {
            User user = new User();
            user.firstName=this.firstName;
            user.lastName=this.lastName;
            user.age=this.age;
            if (user.firstName==null||user.firstName.isEmpty()) {
                throw new IllegalStateException(
                        "First name can not be empty!");
            }
             return user;
        }
    }
}
