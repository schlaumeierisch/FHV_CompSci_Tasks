package com.example.mywebpage.guestbook;

public class GuestbookEntry {

    private final String name;
    private final String email;
    private final String comment;

    public GuestbookEntry(String name, String email, String comment) {
        this.name = name;
        this.email = email;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }

}
