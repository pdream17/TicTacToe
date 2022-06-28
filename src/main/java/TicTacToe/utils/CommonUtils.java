package TicTacToe.utils;

import TicTacToe.pojo.TicTacToeBoard;
import lombok.val;
import org.javatuples.Pair;

import java.util.List;

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
}
