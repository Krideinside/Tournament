package ru.netology.javaqa;

public class Player {
    protected String name;
    protected int strength;

    public Player(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}
