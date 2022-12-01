package com.example.mobileproject.Model;

public class Data {

    String society;
    String title;
    String descp;
    String skills;
    String duree;

    String id;
    String date;

    public Data(){

    }

    public Data(String societe, String titre, String description, String comprtence, String duree, String id, String date) {
        this.society = societe;
        this.title = titre;
        this.descp = description;
        this.skills = comprtence;
        this.duree = duree;
        this.id = id;
        this.date = date;
    }



    public String getSociete() {
        return society;
    }

    public void setSociete(String societe) {
        this.society = societe;
    }

    public static String getTitre() {
        return title;
    }

    public void setTitre(String titre) {
        this.title = titre;
    }

    public String getDescription() {
        return descp;
    }

    public void setDescription(String description) {
        this.descp = description;
    }

    public String getComprtence() {
        return skills;
    }

    public void setComprtence(String comprtence) {
        this.skills = comprtence;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
