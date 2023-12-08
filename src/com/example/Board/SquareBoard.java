package com.example.Board;

import java.util.*;

public class SquareBoard extends Board {


    public SquareBoard(int size) {
        super(size, size);

    }

    @Override
    public void fillBoard(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (iterator.hasNext()) {
                    Integer el = iterator.next();
                    this.getBoard().put(new Key(i, j), el);
                } else {
                    this.getBoard().put(new Key(i, j), null);
                }
            }
        }


    }

    @Override
    public List<Key> availableSpace() {
        Map<Key, Integer> board = this.getBoard();
        List<Key> nullKeys = new ArrayList<>();
        for (Key key : board.keySet()) {
            if (board.get(key) == null) {
                nullKeys.add(key);
            }
        }
        return nullKeys;
    }

    @Override

    public void addItem(Key key, Integer value) {
        if (this.getBoard().containsKey(key)) {
            this.getBoard().put(key, value);
        } else {
            throw new IllegalArgumentException("Key not found: " + key);
        }
    }


    @Override
    public Key getKey(int i, int j) {
        Key searchKey = new Key(i, j);
        if (this.getBoard().containsKey(searchKey)) {
            for (Key key : this.getBoard().keySet()) {
                if (key.equals(searchKey)) {
                    return key;
                }
            }
        }
        return null;

    }

    @Override
    public Integer getValue(Key key) {
        if (this.getBoard().containsKey(key)) {
            return this.getBoard().get(key);
        } else {
            throw new IllegalArgumentException("Key not found: " + key);
        }
    }

    @Override
    public List<Key> getColumn(int j) {
        if (j > this.getWidth() - 1 || j < 0) {
            throw new IllegalArgumentException("Illegal column index");
        }
        List<Key> column = new ArrayList<>();
        for (int i = 0; i < this.getHeight(); i++) {
            Key key = new Key(i, j);
            if (this.getBoard().containsKey(key)) {
                column.add(key);
            } else {
                throw new IllegalArgumentException("Key not found: " + key);
            }
        }
        return column;
    }

    @Override
    public List<Key> getRow(int i) {
        if (i > this.getHeight() - 1 || i < 0) {
            throw new IllegalArgumentException("Illegal row index");
        }
        List<Key> row = new ArrayList<>();
        for (int j = 0; j < this.getHeight(); j++) {
            Key key = new Key(i, j);
            if (this.getBoard().containsKey(key)) {
                row.add(key);
            } else {
                throw new IllegalArgumentException("Key not found: " + key);
            }
        }
        return row;
    }


    @Override
    public boolean hasValue(Integer value) {
        return this.getBoard().containsValue(value);

    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> valuesList = new ArrayList<>();
        for (Key key : keys) {
            if (this.getBoard().containsKey(key)) {
                valuesList.add(this.getBoard().get(key));
            } else {
                throw new IllegalArgumentException("Key not found: " + key);
            }
        }
        return valuesList;

    }
}
