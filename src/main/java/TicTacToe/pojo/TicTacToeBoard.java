package TicTacToe.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TicTacToeBoard {
    private final Integer size;
    private String[][] ticTacToe;

    public void createTicTacToe() {
        ticTacToe = new String[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                ticTacToe[0][0] = "_";
            }
        }
    }
}
