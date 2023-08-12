package org.example.models;

import java.util.Deque;

public class Board {

    private int size;

    private PlayingPiece[][] playingBoard;

    public Board(int size) {
        this.size = size;
        this.playingBoard = new PlayingPiece[size][size];
    }

    public void makeMove(Player player, int row, int col){
        this.playingBoard[row][col] = player.getPlayerPiece();
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getPlayingBoard() {
        return playingBoard;
    }

    public void printBoard() {
       System.out.println(playingBoard[0][0] == null ? ' ' : playingBoard[0][0].getPieceType().toString()   + "|" + playingBoard[0][1] == null ? ' ' : playingBoard[0][1].getPieceType().toString()   + "|" + playingBoard[0][2] == null ? ' ' : playingBoard[0][2].getPieceType().toString());
       System.out.println("___");
       System.out.println(playingBoard[1][0] == null ? ' ' : playingBoard[1][0].getPieceType().toString()   + "|" + playingBoard[1][1] == null ? ' ' : playingBoard[1][1].getPieceType().toString()   + "|" + playingBoard[1][2] == null ? ' ' : playingBoard[1][2].getPieceType().toString());
       System.out.println("___");
       System.out.println(playingBoard[2][0]  == null ? ' ' : playingBoard[2][0].getPieceType().toString()  + "|" + playingBoard[2][1] == null ? ' ' : playingBoard[2][1] .getPieceType().toString()  + "|" + playingBoard[2][2] == null ? ' ' : playingBoard[2][2].getPieceType().toString());
    }
}
