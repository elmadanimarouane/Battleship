package elmadani.marouane;

import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Battleship game !");
        System.out.println("Type 1 if you want to play against a second player, or 2 if you want to play against an AI");
        int choice = sc.nextInt();
        if(choice == 1){
            Main2Players.main(args);
        }
        else if(choice == 2){
            MainVSAI.main(args);
        }
    }
}
