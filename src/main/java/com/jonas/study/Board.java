package com.jonas.study;

import java.util.Arrays;

public class Board {
    int[][] squares = new int[9][9];

    public Board() {
        Arrays.stream(squares).forEach(row ->
                Arrays.fill(row, 0));
    }


    public void printBoard() {
        System.out.println("     0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 ");
        System.out.println("   -------------------------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print(i+"  | ");
            this.printRow(squares[i]);
            System.out.println();
            if(i==2 || i==5){
                System.out.println("   - - - - - - - - - - - - - - - - - - ");
            }
        }
        System.out.println("   -------------------------------------");


    }

    private void printRow(int[] row){
        for (int i = 0; i < 9; i++){
            if(i==0){
                System.out.print(row[i]==0? " ":row[i]);
                continue;
            }
            if(i==3 || i==6){
                System.out.print(" | "+(row[i]==0? " ":row[i]));
                continue;
            }
            if(i==8){
                System.out.print("   "+(row[i]==0? " ":row[i])+ " | ");
                continue;
            }
            System.out.print("   "+(row[i]==0? " ":row[i]));
        }
    }

    private void addNumber(Cell cell){
        squares[cell.row()][cell.col()] = cell.num();
    }

    public void attempAdd(Cell cell){
        try{
            if(checkRow(cell) && checkCol(cell) && checkQuadrant(cell) && this.squares[cell.row()][cell.col()]==0) {
                this.addNumber(cell);
            }
//            else{
//                System.out.println("Adicao invalida!!!");
//            }
        }catch(Exception e){
            System.out.println("Tentativa invalida");
        }
    }

    private boolean checkRow(Cell cell){
        for(int x = 0; x < 9; x++){
            if(this.squares[cell.row()][x] == cell.num()){
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(Cell cell){
        for(int x = 0; x < 9; x++){
            if(this.squares[x][cell.col()] == cell.num()){
                return false;
            }
        }

        return true;
    }

    public boolean checkQuadrant(Cell cell){
        int[] quadrant = detectQuadrant(cell);
        for(int x = 0;x<3;x++){
            for(int y = 0;y<3;y++){
                if(this.squares[x+quadrant[0]][y+quadrant[1]] == cell.num()){
                    return false;
                }
            }
        }
        return true;
    }


    private int[] detectQuadrant(Cell cell){
        int[] quadrant = new int[2];
        if(cell.row() >2 && cell.row()<6){
            quadrant[0] = 3;
        }
        if(cell.row()>5){
            quadrant[0] = 6;
        }
        if(cell.col() >2 && cell.col()<6){
            quadrant[1] = 3;
        }
        if(cell.col()>5){
            quadrant[1] = 6;
        }
        return quadrant;
    }

    public boolean isSolved(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.squares[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public Double percentageSolved(){
        int totalNonEmpty = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.squares[i][j] != 0){
                    totalNonEmpty++;
                }
            }
        }
        return (double)(totalNonEmpty/81.0)*100;
    }

    public Board copy() {
        Board newBoard = new Board();
        newBoard.squares = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newBoard.squares[i][j] = this.squares[i][j];
            }
        }
        return newBoard;
    }

}
