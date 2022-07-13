package TicTacToe.controller.impl;

import TicTacToe.controller.TicTacToeLogic;
import TicTacToe.pojo.TicTacToeBoard;
import org.javatuples.Pair;

public class MinimaxLogic implements TicTacToeLogic {
    @Override
    public Pair<Integer, Integer> getMove(TicTacToeBoard ticTacToeBoard) {
        String[][] board = ticTacToeBoard.getTicTacToe();
        int size = ticTacToeBoard.getSize();
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j].equals("_")) {
                }
            }
        }
        return null;
    }

    private Integer getOptimalMoveForBoard(TicTacToeBoard ticTacToeBoard, String playerTurn) {
        String nextPlayerTurn = (playerTurn.equals("X")) ? "O" : "X";
        String[][] board = ticTacToeBoard.getTicTacToe();
        int size = ticTacToeBoard.getSize();
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j].equals("_")) {
                    board[i][j] = playerTurn;

                }
            }
        }
        return 0;
    }
}
