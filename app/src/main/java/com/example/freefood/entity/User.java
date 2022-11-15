package com.example.freefood.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
@PrimaryKey(autoGenerate = true)
public int uid;
@ColumnInfo(name="name")
public String nom;
@ColumnInfo(name="password")
public String password;
@ColumnInfo(name="contact")
public String contact;
@ColumnInfo(name="email")
public String email;
@ColumnInfo(name="description")
public String description;
@ColumnInfo(name="adresse")
public String adresse;
@ColumnInfo(name="type")
public Type type;

    public User(String nom, String password, String contact, String email, String description, String adresse,Type type) {
        this.nom = nom;
        this.password = password;
        this.contact = contact;
        this.email = email;
        this.description = description;
        this.adresse = adresse;
        this.type=type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        type = type;
    }

}
