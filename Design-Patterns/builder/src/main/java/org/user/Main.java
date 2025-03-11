package org.user;

public class Main {
    public static void main(String[] args) {

        // =========================================================================================== //
        // ================================= Regular Object initializing ============================= //
        // ================== You made a constructor depends on the variables you do need ============ //
        // =========================================================================================== //
        User userName = new User(1L, "username", "email");
        System.out.println(userName);
        System.out.println("=====================");
        // ================================================================================================================= //
        // =========================================== Builder Pattern initializing ======================================== //
        // You initialize the object with the necessary variables without the need to made a custom class for each variation
        // ================================================================================================================== //
        UserBuilder usernameBuilder = new UserBuilder.Builder()
                .setId(1L)
                .setUsername("userName Builder")
                .setEmail("Email")
                .build();

        System.out.println(usernameBuilder);
    }
}