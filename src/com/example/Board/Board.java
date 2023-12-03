package com.example.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Key, Integer> getBoard() {
        return board;
    }

    private final Map<Key, Integer> board = new HashMap<>();


    public Board(int weight, int height) {
        this.width = weight;
        this.height = height;
    }

    public abstract void fillBoard(List<Integer> list);

    public abstract List<Key> availableSpace();

    public abstract void addItem(Key key, Integer value);

    public abstract Key getKey(int i, int j);

    public abstract Integer getValue(Key key);

    public abstract List<Key> getColumn(int j);

    public abstract List<Key> getRow(int i);

    public abstract boolean hasValue(Integer value);

    public abstract List<Integer> getValues(List<Key> keys);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Key, Integer> entry : board.entrySet()) {
            Key key = entry.getKey();
            Integer value = entry.getValue();
            result.append("Key: ").append(key).append(" val = ").append(value).append("\n");
        }
        return result.toString();
    }
}
