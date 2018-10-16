package com.gameoflife.dto;

import org.springframework.stereotype.Component;

@Component
public class BoardDTO {
    private boolean[][] board;
    private int generation;



    public boolean[][] getBoard() {
        return board;
    }

    public void setBoard(boolean[][] board) {
        this.board = board;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }


}
