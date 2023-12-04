package com.example.Game;

import com.example.Board.Board;
import com.example.Board.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Game2048 implements Game {

    GameHelper helper = new GameHelper();

    Board board;

    Random random = new Random();

    public Game2048(Board board) {
        this.board = board;

    }


    @Override
    public void init() {
        board.fillBoard(asList(2, 4, null, 8));
    }

    @Override
    public boolean canMove() {
        return !board.availableSpace().isEmpty();
    }

    @Override
    public boolean move(Direction direction) {
        if (!canMove()) {
            return false;
        }
        List<Integer> newBoardValues = new ArrayList<>();
        switch (direction) {

            case LEFT:
                for (int i = 0; i < board.getHeight(); i++) {
                    List<Integer> list = helper.moveAndMergeEqual(board.getValues(board.getRow(i)));
                    newBoardValues.addAll(list);
                }
                board.fillBoard(newBoardValues);
                break;
            case RIGHT:
                for (int i = 0; i < board.getHeight(); i++) {
                    List<Integer> list = helper.moveAndMergeEqual(board.getValues(board.getRow(i)));
                    Collections.reverse(list);//как я понял при свайпе вправо здесь происзодит реверс
                    newBoardValues.addAll(list);
                }
                board.fillBoard(newBoardValues);
                break;
            case UP:
                for (int i = 0; i < board.getWidth(); i++) {
                    helper.moveAndMergeEqual(board.getValues(board.getColumn(i)));
                    //добавить в список (столбцов)
                }
                //по-хорошему здесь должен быть метод fillBoard, только заполняющий не построчно, а
                // по столбцам
                break;
            case DOWN:
                for (int i = 0; i < board.getWidth(); i++) {
                    List<Integer> list =  helper.moveAndMergeEqual(board.getValues(board.getColumn(i)));
                    Collections.reverse(list);
                    //добавить в список (столбцов)
                }
                //по-хорошему здесь должен быть метод fillBoard, только заполняющий не построчно, а
                // по столбцам
                break;
        }

        //board.fillBoard(newBoardValues);//перезаполнение поля
        return true;
    }

    @Override
    public void addItem() {
        List<Key> emptyKeys = board.availableSpace();
        for (Key key : emptyKeys) {
            board.addItem(key, getRandomValue());

        }
    }

    private Integer getRandomValue() {
        int randomVal = random.nextInt(10);
        //как я проверил, в 90 % случаев выпадает 2, в остальные 10 % - 4
        if (randomVal == 9) {
            return 4;
        } else {
            return 2;
        }
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
