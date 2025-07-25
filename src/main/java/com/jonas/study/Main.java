package com.jonas.study;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cell> cells = Mapper.mapArgsToCells(args);

        Board board = new Board();
        Solver solver = new Solver();
        Scanner scanner = new Scanner(System.in);

        cells.forEach(board::attempAdd);

        boolean running = true;

        while(running) {
            board.printBoard();
            System.out.println("1-Inserir número");
            System.out.println("2-Usar resolvedor");
            System.out.println("3-Sair");
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    System.out.println("Informe a coordenada e o número que deseja inserir(Ex: 1,1,6");
                    Cell cell = Mapper.mapInputToCell(scanner.nextLine());
                    board.attempAdd(cell);
                    break;
                case "2":
                    solver.solve(board);
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }
}