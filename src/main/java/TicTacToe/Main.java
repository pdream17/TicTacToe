package TicTacToe;

import TicTacToe.controller.TicTacToeLogic;
import TicTacToe.controller.impl.MinimaxLogic;
import TicTacToe.pojo.TicTacToeBoard;
import TicTacToe.utils.CommonUtils;
import org.javatuples.Pair;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(size);
        ticTacToeBoard.createTicTacToe();

        TicTacToeLogic ticTacToeLogic = new MinimaxLogic();
        int playCount = 0;
        while (true) {
            String[] userPosition = scanner.next().split(" ");
            Pair<Integer, Integer> playedPosition = new Pair<Integer, Integer>(Integer.valueOf(userPosition[0]), Integer.valueOf(userPosition[1]));
            ticTacToeBoard.getTicTacToe()[playedPosition.getValue0()][playedPosition.getValue1()] = "X";
            playCount++;
            if (CommonUtils.isGameFinished(ticTacToeBoard, playedPosition)) {
                System.out.println("Player Wins");
                break;
            }

            playedPosition = ticTacToeLogic.getMove(ticTacToeBoard);
            ticTacToeBoard.getTicTacToe()[playedPosition.getValue0()][playedPosition.getValue1()] = "O";
            playCount++;
            if (CommonUtils.isGameFinished(ticTacToeBoard, playedPosition)) {
                System.out.println("Computer Wins");
                break;
            }
            if (playCount == size*size) {
                System.out.println("Match Drawn");
                break;
            }
        }
    }
}
