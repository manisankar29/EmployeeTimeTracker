package com.timetracker.model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String employeeId;
    private String idProof;
    private String phoneNumber;
    private String email;
    private String role;

    public User() {}

    public User(String username, String password, String name, String employeeId, String idProof, String phoneNumber, String email, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.employeeId = employeeId;
        this.idProof = idProof;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }

    // Getters and setters
    // ...
}
