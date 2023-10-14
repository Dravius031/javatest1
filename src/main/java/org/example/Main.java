package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Main {
    public static void main(String[] args) {
    Player[] players = new Player[] {
         new Man("van", 10,10),
         new Cat("kuzya", 5,15),
         new Robot("rara", 50,50)
    };
    Trial[] trials = new Trial[] {
         new Wall(7),
         new Wall(12),
         new Wall(17)
    };
    for (Player player: players){
        int i=0;
        while (player.success && i < trials.length){
            if (trials[i].getClass().equals(Wall.class)) {
                player.jump(trials[i].getParam());
            } else {
                player.run(trials[i].getParam());
            }
            i++;
        }
        if (player.success) {
            System.out.println(player.name + " win");
        } else {
            System.out.println(player.name + " defeat");
        }
    }

    }
}

class Player {

    String name;
    int runP;
    int jumpP;
    boolean success;
    Player(String name, int runP, int jumpP)
    {
        this.name = name;
        this.runP = runP;
        this.jumpP= jumpP;
        success = true;
    }


    public void run(int length){
        success = runP > length;
        if (success) {
            System.out.println("successfully run");
        }
        else{
            System.out.println("failure run");
        }
    }

    public void jump(int height){
        success = jumpP > height;
        if (success) {
            System.out.println("successfully jump");
        }
        else{
            System.out.println("failure jump");
        }
    }
}
class Man extends Player{
    Man(String name, int runP, int jumpP) {
        super(name, runP, jumpP);
    }
}

class Cat extends Player{
    Cat(String name, int runP, int jumpP) {
        super(name, runP, jumpP);
    }
}

class Robot extends Player{
    Robot(String name, int runP, int jumpP) {
        super(name, runP, jumpP);
    }
}
@AllArgsConstructor
@Getter
@Setter
class Trial {
    int param;
}

class Track extends Trial {

    Track(int length)
    {
        super(length);
    }
}

class Wall extends Trial {

    Wall(int height)
    {
        super(height);
    }
}