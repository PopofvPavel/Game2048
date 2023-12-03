package com.example;

import com.example.Board.Board;
import com.example.Board.Key;
import com.example.Board.SquareBoard;
import com.example.Game.Game;
import com.example.Game.Game2048;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class TestClass {
    public static void main(String[] args) {
        Board board = new SquareBoard(4);
        Game game2048 = new Game2048(board);
        System.out.println(game2048.canMove());
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(7);
        board.fillBoard(list);
        System.out.println(board.getBoard());
        System.out.println("Available keys = " + board.availableSpace());
        board.addItem(new Key(3, 3), 15);
        System.out.println(board.getBoard());
        System.out.println(board.getKey(0,0));
        System.out.println(board.getValue(new Key(0,0)));
        System.out.println(board.getValue(new Key(3,3)));
        System.out.println(board.getValue(new Key(2,2)));
        System.out.println("Get column = " + board.getColumn(0));
        System.out.println("Get column = " + board.getColumn(1));
        System.out.println("Get column = " + board.getColumn(3));
        System.out.println("Get row = " + board.getRow(0));
        System.out.println("Get row = " + board.getRow(1));
        System.out.println("Get row = " + board.getRow(3));
        System.out.println(board.hasValue(5));
        System.out.println(board.hasValue(15));
        System.out.println(board.hasValue(-15));
        System.out.println(board.hasValue(3));
        System.out.println(board.hasValue(7));
        System.out.println(board.hasValue(null));
        System.out.println(board.getValues(asList(new Key(0,0), new Key(3,3),new Key(1,1))));

    }
}
