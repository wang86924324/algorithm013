package homework.week4.homework;

public class MinesWeeper {
    int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        // teminate
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        // current logic
        int count = 0;
        board[click[0]][click[1]] = 'B';
        for (int[] direction : directions) {
            int x = click[0] + direction[0];
            int y = click[1] + direction[1];
            // 越界continue
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'M') count++;

        }

        if (count > 0) {
            board[click[0]][click[1]] = (char) (count + '0');
            return board;
        }

        // drill down
        for (int[] direction : directions) {
            int x = click[0] + direction[0];
            int y = click[1] + direction[1];
            // 越界continue
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'E')
                updateBoard(board, new int[]{x, y});
        }

        return board;
    }
}
