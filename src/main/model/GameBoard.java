/*
 * Copyright (c) 2022  L. Rastorguev
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package main.model;

import java.util.Arrays;

/**
 * @author L. Rastorguev
 **/
public final class GameBoard {

    private static final int BOARD_SIZE = 3;

    private static final int MAX_MOVES = BOARD_SIZE * BOARD_SIZE;

    private final char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    private int numberMoves = 0;

    public GameBoard() {

        for (char[] line : board) {

            Arrays.fill(line, ' ');

        }

    }

    public boolean setMove(final PlayersMove move) {

        int row = BOARD_SIZE - 1 - (move.field - 1) / BOARD_SIZE;
        int col = (move.field - 1) % BOARD_SIZE;

        boolean result = false;

        if (board[row][col] == ' ') {

            board[row][col] = move.value;

            result = true;

            numberMoves++;

        }

        return result;

    }

    public ResultMove getResultMove() {

        char valueDiagonal10 = board[0][0];
        char valueDiagonal20 = board[BOARD_SIZE - 1][0];

        boolean winDiagonal1 = valueDiagonal10 != ' ';
        boolean winDiagonal2 = valueDiagonal20 != ' ';

        for (int i = BOARD_SIZE - 1; i >= 0; i--) {

            char valueRow0 = board[i][0];
            char valueCol0 = board[0][i];

            boolean winRow = valueRow0 != ' ';
            boolean winColumn = valueCol0 != ' ';

            for (int j = 1; j < board[i].length; j++) {

                if (!(winRow || winColumn || winDiagonal1 || winDiagonal2)) {
                    break;
                }

                if (winRow && (valueRow0 != board[i][j])) {
                    winRow = false;
                }

                if (winColumn && (valueCol0 != board[j][i])) {
                    winColumn = false;
                }

                if (winDiagonal1 && (valueDiagonal10 != board[j][j])) {
                    winDiagonal1 = false;
                }

                if (winDiagonal2 && (valueDiagonal20 != board[i - j][j])) {
                    winDiagonal2 = false;
                }

            }

            if (winRow || winColumn || winDiagonal1 || winDiagonal2) {
                return new ResultMove(ResultMove.WIN);
            }

        }

        if (numberMoves == MAX_MOVES) {
            return new ResultMove(ResultMove.DRAW);
        }

        return new ResultMove(ResultMove.GAME_CONTINUES);

    }

    public String getStringBoard() {
        return getBoard(board);
    }

    public String getRulesGame() {

        StringBuilder result = new StringBuilder();

        int value = MAX_MOVES;

        result.append("Use the following mapping table to specify a cell using numbers from 1 to ").append(value).append(":\n");

        int[][] boardRules = new int[BOARD_SIZE][BOARD_SIZE];

        for (int[] line : boardRules) {

            for (int i = line.length - 1; i >= 0; i--) {

                line[i] = value--;

            }

        }

        result.append(getBoard(boardRules));

        return result.toString();
    }

    public int getMaxMoves() {
        return MAX_MOVES;
    }

    private String getBoard(char[][] board) {

        StringBuilder result = new StringBuilder();

        int sizeField = String.valueOf(MAX_MOVES).length() + 1;

        String separator = "-".repeat((sizeField + 2) * BOARD_SIZE + 1);

        for (int i = 0; i < BOARD_SIZE; i++) {

            result.append(separator).append("\n");

            for (int j = 0; j < BOARD_SIZE; j++) {
                result.append("|").append(String.format("%" + sizeField + "s", board[i][j])).append(" ");
            }

            result.append("|\n");
        }

        result.append(separator).append("\n");

        return result.toString();
    }

    private String getBoard(int[][] board) {

        StringBuilder result = new StringBuilder();

        int sizeField = String.valueOf(MAX_MOVES).length() + 1;

        String separator = "-".repeat((sizeField + 2) * BOARD_SIZE + 1);

        for (int i = 0; i < BOARD_SIZE; i++) {

            result.append(separator).append("\n");

            for (int j = 0; j < BOARD_SIZE; j++) {
                result.append("|").append(String.format("%" + sizeField + "s", board[i][j])).append(" ");
            }

            result.append("|\n");
        }

        result.append(separator).append("\n");

        return result.toString();
    }
}
