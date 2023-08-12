package org.example;

import org.example.models.Game;

import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Let's play tic-tac-toe!");
        System.out.println("Please enter the size of the board : ");
        int size = sc.nextInt();
        System.out.println("Please enter name of Player 1 : ");
        String player1Name = sc.next();
        System.out.println("Please enter name of Player 2 : ");
        String player2Name = sc.next();
        Game game = new Game(size, player1Name, player2Name);
        game.startGame();
    }
}