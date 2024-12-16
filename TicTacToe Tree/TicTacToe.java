
public class TicTacToe {
	public static ArrayTree<TicTacToePosition> gameTree = new ArrayTree<TicTacToePosition>(9, 500_000_000);

	public static void main(String[] args) {
		// TicTacToePosition a = new TicTacToePosition(" ");
		// gameTree.addRoot(a);
		// GenTree a = new GenTree(gameTree);
		// populate(0,'x');
		// evaluatePosition(0);
		char[] charArray = { 'o', 'o', 'x', 'o', 'x', 'o', 'o', 'o', 'x' };
		if (evaluate(charArray) == 1) {
			System.out.println("Human wins");
		} else
			System.out.println("AI wins");
	}

	public static void populate(int node, char c) {
		TicTacToePosition position = gameTree.get(node);
		String board = position.board;
		int count = 0;
		char[] charArray = board.toCharArray();
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == ' ') {
				charArray[i] = c;
				board = String.valueOf(charArray);
				TicTacToePosition childTicTacToePosition = new TicTacToePosition(board);

				gameTree.addChild(node, count, childTicTacToePosition);
				charArray[i] = ' ';
				int childNode = (9 * node) + count + 1;
				count++;
				if (c == 'x') {
					populate(childNode, 'o');
				} else {
					populate(childNode, 'x');
				}
			}
		}
	}

	public boolean isMovesLeft(int node) {
		TicTacToePosition position = gameTree.get(node);
		String board = position.board;

		char[] charArray = board.toCharArray();
		for (int i = 0; i < 9; i++) {
			if (charArray[i] == ' ') {
				return true;
			}
		}
		return false;
	}

	public static int evaluatePosition(int node) {
		TicTacToePosition position = gameTree.get(node);
		String board = position.board;
		char[] charArray = board.toCharArray();
		for (int i = 0; i < 3; i += 3) {
			if (charArray[i] == charArray[i + 1] && charArray[i + 2] == charArray[i + 2]) {// check horizontally
				if (charArray[i] == 'x') {
					return -1;
				} else if (charArray[i] == 'o') {
					return 1;
				}
			}

			if (charArray[i] == charArray[i + 3] && charArray[i + 3] == charArray[i + 6]) {// check vertically
				if (charArray[i] == 'x') {
					return -1;
				} else if (charArray[i] == 'o') {
					return 1;
				}
			}

		}

		for (int i = 0; i <= 2; i += 2) {
			if (i == 0) {
				if (charArray[i] == charArray[i + 4] && charArray[i + 4] == charArray[i + 8]) {
					if (charArray[i] == 'x') {
						return -1;
					} else if (charArray[i] == 'o') {
						return 1;
					}
				}
			}
			if (i == 2) {
				if (charArray[i] == charArray[i + 2] && charArray[i + 2] == charArray[i + 4]) {
					if (charArray[i] == 'x') {
						return -1;
					} else if (charArray[i] == 'o') {
						return 1;
					}
				}
			}
		}

		return 0;
	}

	public static int evaluate(char charArray[]) {
		for (int i = 0; i < 3; i += 3) {
			if (charArray[i] == charArray[i + 1] && charArray[i + 2] == charArray[i + 2]) {// check horizontally
				if (charArray[i] == 'x') {
					return -1;
				} else if (charArray[i] == 'o') {
					return 1;
				}
			}

			if (charArray[i] == charArray[i + 3] && charArray[i + 3] == charArray[i + 6]) {// check vertically
				if (charArray[i] == 'x') {
					return -1;
				} else if (charArray[i] == 'o') {
					return 1;
				}
			}

		}

		for (int i = 0; i <= 2; i += 2) {
			if (i == 0) {
				if (charArray[i] == charArray[i + 4] && charArray[i + 4] == charArray[i + 8]) {
					if (charArray[i] == 'x') {
						return -1;
					} else if (charArray[i] == 'o') {
						return 1;
					}
				}
			}
			if (i == 2) {
				if (charArray[i] == charArray[i + 2] && charArray[i + 2] == charArray[i + 4]) {
					if (charArray[i] == 'x') {
						return -1;
					} else if (charArray[i] == 'o') {
						return 1;
					}
				}
			}
		}

		return 0;
	}

	public int minimax(int node, int level, boolean isMax) {
		int child = 9 * node + 1;
		int bestScore;
		if (isMovesLeft(node) == false) {
			return evaluatePosition(node);
		}
		/*
		 * if (level % 2 == 0) { result = 1000000; } else result = -1000000;
		 */

		if (isMax) {
			bestScore = -100000;
			for (int i = 0; i < 9; i++) {
				bestScore = Math.max(bestScore, minimax(child, level + 1, false));
			}
			return bestScore;
		}

		else {
			bestScore = 100000;
			for (int i = 0; i < 9; i++) {
				bestScore = Math.min(bestScore, minimax(child, level + 1, true));
			}
			return bestScore;
		}

	}
}
