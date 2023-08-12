package org.example.models;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {

    private Board board;

    private Deque<Player> players;

    public Game(int size, String playerA, String playerB) {
        initializeGame(size, playerA, playerB);
    }

    private void initializeGame(int size, String player1Name, String player2Name){
        Player player1 = new Player(player1Name, new PieceA());
        Player player2 = new Player(player2Name, new PieceB());
        players = new ArrayDeque<>();
        players.add(player1);
        players.add(player2);
        this.board = new Board(size);
    }

    public void startGame(){
        Scanner sc= new Scanner(System.in);
        boolean hasWinner = false;
        int size = board.getSize();
        Player player1;
        while (!hasWinner){
            player1 = players.removeFirst();
            System.out.println("Your turn "+ player1.getPlayerId());
            String input = sc.next();
            String[] coordinates = input.split(",");
            int row=0,col=0;
            try {
                row = Integer.parseInt(coordinates[0]);
                col = Integer.parseInt(coordinates[1]);
            }
            catch (NumberFormatException ex){
                System.out.println("Please enter integer values as coordinates");
                players.addFirst(player1);
                continue;
            }
            if(board.getPlayingBoard()[row][col] != null){
                System.out.println("This cell already taken");
                players.addFirst(player1);
                continue;
            }
            board.makeMove(player1, row, col);
            boolean fullRow = true, fullCol= true, dia = false, revDia= false;
            for(int i=0 ;i < size ; i++){
                if(board.getPlayingBoard()[row][i] ==  null || board.getPlayingBoard()[row][i].getPieceType() != player1.getPlayerPiece().getPieceType()){
                    fullRow = false;
                }
            }

            for(int i=0 ;i < size ; i++){
                if(board.getPlayingBoard()[i][col] ==  null || board.getPlayingBoard()[i][col].getPieceType() != player1.getPlayerPiece().getPieceType()){
                    fullCol = false;
                }
            }
            if(row == col) {
                dia = true;
                for (int i = 0; i < size; i++) {
                    if (board.getPlayingBoard()[i][i] == null || board.getPlayingBoard()[i][i].getPieceType() != player1.getPlayerPiece().getPieceType()) {
                        dia = false;
                    }
                }
            }
            if(row == col) {
                revDia = true;
                for (int i = 0; i < size; i++) {
                    if (board.getPlayingBoard()[i][size-1-i] == null || board.getPlayingBoard()[i][size -1 -i].getPieceType() != player1.getPlayerPiece().getPieceType()) {
                        revDia = false;
                    }
                }
            }
            if(fullRow || fullCol || dia || revDia){
                System.out.println(" Player " + player1.getPlayerId() + " is a winner !!");
                return;
            }
            players.addLast(player1);
            board.printBoard();
        }
    }

    public Board getBoard() {
        return board;
    }

    public Deque<Player> getPlayers() {
        return players;
    }
}
