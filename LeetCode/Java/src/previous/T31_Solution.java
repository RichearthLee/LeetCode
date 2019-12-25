package previous;

public class T31_Solution {
	private int rownum = 0;
	private int colnum = 0;

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		 rownum = board.length;
		 colnum = board[0].length;


		for (int i = 0; i < rownum; ++i) {
			DFS(board, i, 0);
			DFS(board, i, colnum - 1);
		}
		for (int i = 0; i < colnum; ++i) {
			DFS(board, 0, i);
			DFS(board, rownum - 1, i);
		}

		for (int i = 0; i < rownum; ++i) {
			for (int j = 0; j < colnum; ++j) {
				if (board[i][j] == 'O')board[i][j] = 'X';
				if (board[i][j] == '*')board[i][j] = 'O';
			}
		}

	}

	private void DFS(char[][] board, int row, int col) {
		if (board[row][col] == 'O') {
			board[row][col] = '*';
			if (row > 1) {
				DFS(board, row - 1, col);
			}
			if (row < rownum - 1) {
				DFS(board, row + 1, col);
			}
			if (col > 1) {
				DFS(board, row, col - 1);
			}
			if (col < colnum - 1) {
				DFS(board, row, col + 1);
			}
		}
	}
	/*
	 * 
	 * public int rowNum = 0; public int colNum = 0; public void solve(char[][]
	 * board) { if(board == null || board.length <= 0|| board[0].length <= 0){
	 * return; } rowNum = board.length; colNum = board[0].length; for(int i = 0; i <
	 * colNum; i++){ dfs(board, 0, i); dfs(board, rowNum-1, i); } for(int i = 0; i <
	 * rowNum; i++){ dfs(board, i, 0); dfs(board, i, colNum-1); } for(int i = 0; i <
	 * rowNum; i++){ for(int j = 0; j < colNum; j++){ if(board[i][j] == 'O'){
	 * board[i][j] = 'X'; } } } for(int i = 0; i < rowNum; i++){ for(int j = 0; j <
	 * colNum; j++){ if(board[i][j] == '*'){ board[i][j] = 'O'; } } } } private void
	 * dfs(char[][] board, int row, int col) { // TODO Auto-generated method stub
	 * if(board[row][col] == 'O'){ board[row][col] = '*'; if(row > 1){ dfs(board,
	 * row-1, col); } if(col > 1){ dfs(board, row, col-1); } if(row < rowNum-1){
	 * dfs(board, row+1, col); } if(col < colNum-1){ dfs(board, row, col+1); } } }
	 * 
	 */
}
