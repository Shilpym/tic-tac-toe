package org.example.models;

public class Player {

    private String playerId;

    private PlayingPiece playerPiece;

    public Player(String playerId, PlayingPiece playingPiece) {
        this.playerId = playerId;
        this.playerPiece = playingPiece;
    }

    public String getPlayerId() {
        return playerId;
    }

    public PlayingPiece getPlayerPiece() {
        return playerPiece;
    }
}
