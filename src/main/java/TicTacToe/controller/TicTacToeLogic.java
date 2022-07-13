package TicTacToe.controller;

import TicTacToe.pojo.TicTacToeBoard;
import org.javatuples.Pair;

public interface TicTacToeLogic {
    Pair<Integer, Integer> getMove(TicTacToeBoard ticTacToeBoard);
}
