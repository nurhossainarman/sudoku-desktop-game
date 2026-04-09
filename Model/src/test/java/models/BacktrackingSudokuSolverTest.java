package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sudoku.model.exceptions.FillingBoardSudokuException;
import sudoku.model.models.SudokuBoard;
import sudoku.model.solver.BacktrackingSudokuSolver;

public class BacktrackingSudokuSolverTest {

    @Test
    void solvedBoardShouldBeValidAndFull() throws FillingBoardSudokuException {
        // Arrange
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());

        // Act
        board.solveGame();

        // Assert
        assertTrue(board.isValidSudoku(), "Board should be valid after solving");
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                assertNotEquals(0, board.getField(c, r).getValue(),
                        "Cell (" + c + "," + r + ") should not be 0 after solving");
            }
        }
    }
}
