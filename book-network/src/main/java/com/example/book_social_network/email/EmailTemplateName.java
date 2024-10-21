package com.example.book_social_network.email;

public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("activate-account");

    private final String name;
    EmailTemplateName(String name) {
        this.name = name;
    }
}
