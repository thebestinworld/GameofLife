package com.gameoflife.model;

public class Board {
	
	private Cell[][] board;
	private int height;
	private int width;
	private int generation;

	public Board(int height,int width,int generation) {
		this.height = height;
		this.width = width;
		this.generation = generation;
		this.board = this.initializeBoard(height,width);

	}
	public Board(boolean[][] booleanBoard,int generation) {
		this.height = booleanBoard.length;
		this.width = booleanBoard[0].length;
		this.board = initBoardByState(booleanBoard);
		this.generation = generation;
	}

	public Board doNext() {
		this.nextGeneration();
		this.updateNextGeneration();
		return this;
	}

    public boolean[][] toBoolean() {
        boolean[][] booleanGrid = new boolean[height][width];

        for(int i = 0;i < height ; i++) {
            for(int j = 0;j < width;j++) {
                if (this.board[i][j].getState()) {
                    booleanGrid[i][j] = true;
                }
            }
        }


        return booleanGrid;
    }

	private Cell[][] initializeBoard(int height,int width ) {
		Cell[][] board = new Cell[height][width];
		for(int i = 0;i < height ; i++) {
			for(int j = 0;j < width;j++) {
				board[i][j] = new Cell(Math.random() < 0.5);
			}
		}
		return board;
	}

	private Cell[][] initBoardByState(boolean[][] booleanBoard) {
		Cell[][] board = new Cell[booleanBoard.length][booleanBoard[0].length];

        for(int i = 0;i < booleanBoard.length ; i++) {
            for(int j = 0;j < booleanBoard[0].length;j++) {
                board[i][j] = new Cell(false);
                if(booleanBoard[i][j]){
                    board[i][j].setNewState(true);
                    board[i][j].updateState();
                }

            }
        }

		return board;
	}

	private void nextGeneration() {
		for (int i = 0; i < this.board.length; i++) 
        { 
            for (int j = 0; j < this.board[0].length; j++) 
            { 
            	int aliveNeighbours = neighborCount(i, j);
            	
            	if      ((board[i][j].getState()) && (aliveNeighbours <  2)) board[i][j].setNewState(false);//Loneliness
                else if ((board[i][j].getState()) && (aliveNeighbours >  3)) board[i][j].setNewState(false);//Overpopulation
                else if ((!board[i][j].getState()) && (aliveNeighbours == 3)) board[i][j].setNewState(true);//Reproduction
            }
        }
	}

	private void updateNextGeneration() {
		for (int i = 0; i < this.board.length; i++) 
        { 
            for (int j = 0; j < this.board[0].length; j++) 
            { 
            	this.board[i][j].updateState();
            }
        }
        this.generation++;

	}

	private int neighborCount(int row, int col) {
        int count = 0;
        
        for(int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < this.board.length) 
                for(int j = col - 1; j <= col + 1; j++) 
                    if (j >= 0 && j < this.board[i].length) 
                        if (i != row || j != col) 
                            if (this.isAlive(i, j)) {
                           	count++;
                            }                           
        }
        
        return count;
    }

	private boolean isAlive(int row, int col) {
        return this.board[row][col].getState();
    }
}
