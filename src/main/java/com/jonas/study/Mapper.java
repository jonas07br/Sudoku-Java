package com.jonas.study;

import java.util.List;
import java.util.stream.Stream;

public class Mapper {
    public static List<Cell> mapArgsToCells(String[] args){
        return Stream.of(args)
                .map(arg -> arg.split(";"))
                .map(arg ->{
                    return new Cell(
                            Integer.parseInt(arg[0].split(",")[0]),
                            Integer.parseInt(arg[0].split(",")[1]),
                            Integer.parseInt(arg[1].split(",")[0])
                    );
                }).toList();
    }

    public static Cell mapInputToCell(String input){
        int row = Integer.parseInt(input.split(",")[0]);
        int col = Integer.parseInt(input.split(",")[1]);
        int num = Integer.parseInt(input.split(",")[2]);
        return new Cell(row, col, num);
    }
}
