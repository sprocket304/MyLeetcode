import java.util.Arrays;

class Sudoku {
    public boolean isValidSudoku(char[][] board) {

        // Check rows
        for (int y = 0; y < 9; y++) {
            String row = "";
            for (int j = 0; j < 9; j++) {
                char x = board[y][j];
                if (x != '.') {
                    row += x;
                }
            }
            char[] charRow = row.toCharArray();
            Arrays.sort(charRow);
            for (int i = 0; i < charRow.length - 1; i++) {
                if (charRow[i] == charRow[i + 1]) {
                    return false;
                }
            }
        }

        // Check columns
        for (int x = 0; x < 9; x++) {
            String col = "";
            for (int j = 0; j < 9; j++) {
                char y = board[j][x];
                if (y != '.') {
                    col += y;
                }
            }
            char[] charCol = col.toCharArray();
            Arrays.sort(charCol);
            for (int i = 0; i < charCol.length - 1; i++) {
                if (charCol[i] == charCol[i + 1]) {
                    return false;
                }
            }
        }

        // Check 3x3 sub-boxes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String box = "";
                for (int y = 0; y < 3; y++) {
                    int row = y + (i * 3);
                    for (int x = 0; x < 3; x++) {
                        int col = x + (j * 3);
                        if (board[row][col] != '.') {
                            box += board[row][col];
                        }
                    }

                }
                char[] charBox = box.toCharArray();
                Arrays.sort(charBox);
                for (int k = 0; k < charBox.length - 1; k++) {
                    if (charBox[k] == charBox[k + 1]) {
                        return false;
                    }
                }

            }
        }
        return true;

    }
}