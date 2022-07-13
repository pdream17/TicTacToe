package TicTacToe.utils;

import TicTacToe.pojo.TicTacToeBoard;
import lombok.val;
import org.javatuples.Pair;

public class CommonUtils {

    public static boolean isGameFinished(TicTacToeBoard board, Pair<Integer, Integer> playedPosition) {
        val ticTacToe = board.getTicTacToe();
        boolean isGameFinished = true;
        int column = playedPosition.getValue1();
        int row = playedPosition.getValue0();

        //checkVertical
        for (int i=0; i< board.getSize(); i++) {
            if (!ticTacToe[i][column].equals(ticTacToe[row][column])) {
                isGameFinished = false;
                break;
            }
        }

        if (isGameFinished)
            return isGameFinished;

        isGameFinished = true;

        //checkHorizontal
        for (int i=0; i< board.getSize(); i++) {
            if (!ticTacToe[row][i].equals(ticTacToe[row][column])) {
                isGameFinished = false;
                break;
            }
        }

        if (isGameFinished)
            return isGameFinished;

        //checkDiagonal
        if (row == column || (row + column + 1) == board.getSize()) {
            isGameFinished = true;
            for (int i=0; i< board.getSize(); i++) {
                if (!ticTacToe[i][i].equals(ticTacToe[row][column])) {
                    isGameFinished = false;
                    break;
                }
            }

            if (isGameFinished)
                return isGameFinished;

            isGameFinished = true;
            for (int i=0; i< board.getSize(); i++) {
                if (!ticTacToe[i][board.getSize() - i - 1].equals(ticTacToe[row][column])) {
                    isGameFinished = false;
                    break;
                }
            }
        }
        return isGameFinished;
    }

    private Integer ticTacToeResult(TicTacToeBoard ticTacToeBoard) {
        int size = ticTacToeBoard.getSize();
        String[][] board = ticTacToeBoard.getTicTacToe();

        //check Rows
        for (int i=0; i<size; i++) {
            boolean foundStreak = true;
            for (int j=0; j<size; j++) {
                if (!board[i][j].equals(board[i][0])) {
                    foundStreak = false;
                    break;
                }
            }
            if (foundStreak) {
                if (board[i][0].equals("X")) {
                    return 1;
                } else if (board[i][0].equals("O")) {
                    return -1;
                }
            }
        }

        //check Columns
        for (int j=0; j<size; j++) {
            boolean foundStreak = true;
            for (int i=0; i<size; i++) {
                if (!board[i][j].equals(board[0][j])) {
                    foundStreak = false;
                    break;
                }
            }
            if (foundStreak) {
                if (board[0][j].equals("X")) {
                    return 1;
                } else if (board[0][j].equals("O")) {
                    return -1;
                }
            }
        }

        //check Diagonal
        boolean backwardSlash = true;
        boolean forwardSlash = true;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (i==j && !board[i][j].equals(board[0][0]) && backwardSlash) {
                    backwardSlash = false;
                }
                if (i+j+1==size && !board[i][j].equals(board[0][size-1]) && forwardSlash) {
                    forwardSlash = false;
                }
            }
        }
        if (forwardSlash) {
            if (board[0][size-1].equals("X")) {
                return 1;
            } else if (board[0][size-1].equals("O")) {
                return -1;
            }
        } else if (backwardSlash) {
            if (board[0][0].equals("X")) {
                return 1;
            } else if (board[0][0].equals("O")) {
                return -1;
            }
        }

        if (checkAllSlotsFilled(ticTacToeBoard)) {
            return 0;
        } else {
            return -3;
        }
    }

    private boolean checkAllSlotsFilled(TicTacToeBoard ticTacToeBoard) {
        int size = ticTacToeBoard.getSize();
        String[][] board = ticTacToeBoard.getTicTacToe();
        for (int i = 0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j] == "_") {
                    return false;
                }
            }
        }
        return true;
    }
}
