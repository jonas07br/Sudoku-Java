package com.jonas.study;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Solver {
    public final Board board = new Board();
    double bestScore = 0;
    Random rand = new Random();

    public void solve(Board baseBoard){

        Instant startTime = Instant.now();
        Instant endTime = Instant.now();

        int attemp = 0;

        while (true) {

            Board board = baseBoard.copy();

            rand.setSeed(System.currentTimeMillis()+attemp);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board.squares[i][j] == 0) {
                        int randomNum = rand.nextInt(200);
                        for(int k = 1; k < 10; k++) {
                            int value = ((randomNum+k+9)%9)+1;
                            try{
                                board.attempAdd(new Cell(i, j, value));
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                            if(board.squares[i][j] != 0) {
                                break;
                            }
                        }
                    }
                }
            }
            attemp++;
            if(bestScore >=98.0) {
                board.printBoard();
            }
            if(board.isSolved()) {
                baseBoard = board.copy();
                endTime = Instant.now();
                break;
            }
            if(attemp>900000){
                System.out.println("Too many attemps");
                System.out.println("Best score: " + bestScore);
                break;
            }
        }
        System.out.println("Solved in:"+ Duration.between(startTime,endTime).toSeconds()+" seconds");
        System.out.println("Attempts: " + attemp);
        baseBoard.printBoard();
        System.out.println("-----------------Solved-----------------");

    }
}
