//*******************************************
/* in this i have considered capital characters as black piece */
/* and small characters as white piece */
/* player one is going to move first means black is going to make first move*/
/* player two is going to move after black or player one */
/* for player one i have initialized p as 1*/
/* and for player two i have initialized p as 2*/
/* according to that isCheck() method going to verify which player have made move recently*/
//*******************************************

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Chess{

	public static void main(String[] args) {
		// System.out.println("***** Chess Board *****");
		displayBoard();
		// System.out.println("---------------------------------------------------");

		// running infinite loop to play alternatively by player1 one and palyer2
		// we have to run loop until check mate
		// check mate is boolean variable if check mate gets true then while loop become
		// false and exit the loop
		// At exit of while loop the last value of p means which player played last move
		// So which player made last move is going to win and p is storing the integer
		// value of player as 1 or 2
//		while(!isCheckmate) {
		while (true) {
			player = 1;
			Player1();
			player = 2;
			Player2();
		}
//			System.out.println("###Game Over###");
//			System.out.println("Player"+p +" win by Check mate");
	}

	// p==1 means player one have completed its move
//if condition gets false it means player 2 has payed its move
	private static boolean isKingGettingCheck() {
		Arrays.fill(possibleCheckPosition, 0);
		checkIndex = 0;
//		System.out.println("\nisCheck method started;");

		int ki = 0, kj = 0;
		char q = 'w', r = 'w', b = 'w', h = 'w', p = 'w', k = 'w';

		// player 1 is playing Capital characters if p=1 it means it played by player
		// one which are capital characters
		if (player == 2) {
			int flag = 0;
			for (int a = 0; a < board.length; a++) {
				for (int z = 0; z < board.length; z++) {
					if (board[a][z] == 'k') {
						ki = a;
						kj = z;
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					break;
				}
			}
			q = 'Q';
			b = 'B';
			r = 'R';
			h = 'H';
			p = 'P';
			k = 'K';
		}
		// player two playing small characters if p=2 it means it played by player two
		// which are small characters
		else if (player == 1) {
			int flag = 0;
			for (int a = 0; a < board.length; a++) {
				for (int z = 0; z < board.length; z++) {
					if (board[a][z] == 'K') {
						ki = a;
						kj = z;
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					break;
				}
			}
			q = 'q';
			b = 'b';
			r = 'r';
			h = 'h';
			p = 'p';
			k = 'k';
		}

//		System.out.println("***************************************");
		// Diagonal position from Right Top to Left Down
		// From Current Piece Position To Right Side's Top
		for (int i1 = ki, j1 = kj; 0 <= i1 - 1 && 7 >= j1 + 1; i1--, j1++) {
			if (board[i1 - 1][j1 + 1] != empty) {
				if (board[i1 - 1][j1 + 1] == q || board[i1 - 1][j1 + 1] == b || board[i1 - 1][j1 + 1] == p) {
					{
						possibleCheckPosition[checkIndex] = (i1) * 10 + j1 + 2;
						checkIndex++;
					}
					break;
				}
			}
		}

		// From Current Piece Position To Left Side's Bottom
		for (int i1 = ki, j1 = kj; 7 >= i1 + 1 && 0 <= j1 - 1; i1++, j1--) {
			if (board[i1 + 1][j1 - 1] != empty) {
				if (board[i1 + 1][j1 - 1] == q || board[i1 + 1][j1 - 1] == b) {
					possibleCheckPosition[checkIndex] = (i1 + 2) * 10 + j1;
					checkIndex++;
				}
				break;
			}
		}

		// Diagonal positions from Left Top To Right Down
		// From Current Piece Position To Left Side's Top
		for (int i1 = ki, j1 = kj; 0 <= i1 - 1 && 0 <= j1 - 1; i1--, j1--) {
			if (board[i1 - 1][j1 - 1] != empty) {
				if (board[i1 - 1][j1 - 1] == q || board[i1 - 1][j1 - 1] == b || board[i1 - 1][j1 - 1] == p) {
					possibleCheckPosition[checkIndex] = (i1) * 10 + j1;
					checkIndex++;
				}
				break;
			}
		}

		// From Current Piece Position To Right Side's Bottom
		for (int i1 = ki, j1 = kj; 7 >= i1 + 1 && 7 >= j1 + 1; i1++, j1++) {
			if (board[i1 + 1][j1 + 1] != empty) {
				if (board[i1 + 1][j1 + 1] == q || board[i1 + 1][j1 + 1] == b) {
					possibleCheckPosition[checkIndex] = (i1 + 2) * 10 + j1 + 2;
					checkIndex++;
				}
				break;
			}

		}

		// Possible horizontal check positions
		// Towards Left
		for (int j1 = kj - 1; 0 <= j1 && j1 <= 7; j1--) {
			if (board[ki][j1] != empty) {
				if (board[ki][j1] == q || board[ki][j1] == r) {
					possibleCheckPosition[checkIndex] = (ki + 1) * 10 + (j1 + 1);
					checkIndex++;
				}
				break;
			}
		}

		// Towards Right
		for (int j1 = kj + 1; 0 <= j1 && j1 <= 7; j1++) {
			if (board[ki][j1] != empty) {
				if (board[ki][j1] == q || board[ki][j1] == r) {
					possibleCheckPosition[checkIndex] = (ki + 1) * 10 + (j1 + 1);
					checkIndex++;

				}
				break;
			}
		}

		// vertical possible position for checks
		// Upward Direction
		for (int i1 = ki - 1; 0 <= i1 && i1 <= 7; i1--) {
			if (board[i1][kj] != empty) {
				if (board[i1][kj] == q || board[i1][kj] == r) {
					possibleCheckPosition[checkIndex] = (i1 + 1) * 10 + kj + 1;
					checkIndex++;
				}
				break;
			}
		}

		// Downward Direction
		for (int i1 = ki + 1; 0 <= i1 && i1 <= 7; i1++) {
			if (board[i1][kj] != empty) {
				if (board[i1][kj] == q && board[i1][kj] == r) {
					possibleCheckPosition[checkIndex] = (i1 + 1) * 10 + kj + 1;
					checkIndex++;
				}
				break;
			}
		}

		// Horse Moves
		int[] iValues = { -2, +2, -1, +1 };
		// To calculate Horse Moves without using multiple if statements
		for (int i = 0; i < iValues.length; i++) {
			for (int j = 0; j < iValues.length; j++) {
				if (iValues[i] != -iValues[j] && k != j) {
					if (ki + iValues[i] >= 0 && ki + iValues[i] <= 7 && kj + iValues[j] >= 0 && kj + iValues[j] <= 7) {
						if (board[ki + iValues[i]][kj + iValues[j]] != empty) {
							if (board[ki + iValues[i]][kj + iValues[j]] == h) {
								possibleCheckPosition[checkIndex] = (ki + iValues[i] + 1) * 10 + kj + iValues[j] + 1;
								checkIndex++;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < possibleCheckPosition.length; i++) {
			if (possibleCheckPosition[i] != 0) {
				System.out.println(Arrays.toString(possibleCheckPosition));
				return true;
			}
		}

		System.out.println(Arrays.toString(possibleCheckPosition));
		return false;
	}

	// p==1 means player one have completed its move
//if condition gets false it means player 2 has payed its move
	private static boolean isKingGettingCheck(int ki, int kj) {
		Arrays.fill(possibleCheckPosition, 0);
		checkIndex = 0;
		System.out.println("\nisCheck method started;");

		char q = 'w', r = 'w', b = 'w', h = 'w', p = 'w', k = 'w';

		// player 1 is playing Capital characters if p=1 it means it played by player
		// one which are capital characters
		if (player == 2) {
			q = 'Q';
			b = 'B';
			r = 'R';
			h = 'H';
			p = 'P';
			k = 'K';
		}
		// player two playing small characters if p=2 it means it played by player two
		// which are small characters
		else if (player == 1) {
			q = 'q';
			b = 'b';
			r = 'r';
			h = 'h';
			p = 'p';
			k = 'k';
		}

		System.out.println(q);
		System.out.println(b);
		System.out.println(r);
		System.out.println(h);
		System.out.println(p);
		System.out.println(k);

		System.out.println("***************************************");
		// Diagonal position from Right Top to Left Down
		// From Current Piece Position To Right Side's Top
		for (int i1 = ki, j1 = kj; 0 <= i1 - 1 && 7 >= j1 + 1; i1--, j1++) {
			if (board[i1 - 1][j1 + 1] != empty) {
				if (board[i1 - 1][j1 + 1] == q || board[i1 - 1][j1 + 1] == b || board[i1 - 1][j1 + 1] == p) {
					{
						System.out.println(board[i1 - 1][j1 + 1]);
						possibleCheckPosition[checkIndex] = (i1) * 10 + j1 + 2;
						checkIndex++;
					}
					break;
				}
			}
		}

		// From Current Piece Position To Left Side's Bottom
		for (int i1 = ki, j1 = kj; 7 >= i1 + 1 && 0 <= j1 - 1; i1++, j1--) {
			if (board[i1 + 1][j1 - 1] != empty) {
				if (board[i1 + 1][j1 - 1] == q || board[i1 + 1][j1 - 1] == b) {
					System.out.println(board[i1 + 1][j1 - 1]);
					possibleCheckPosition[checkIndex] = (i1 + 2) * 10 + j1;
					checkIndex++;
				}
				break;
			}
		}

		// Diagonal positions from Left Top To Right Down
		// From Current Piece Position To Left Side's Top
		for (int i1 = ki, j1 = kj; 0 <= i1 - 1 && 0 <= j1 - 1; i1--, j1--) {
			if (board[i1 - 1][j1 - 1] != empty) {
				if (board[i1 - 1][j1 - 1] == q || board[i1 - 1][j1 - 1] == b || board[i1 - 1][j1 - 1] == p) {
					System.out.println(board[i1 - 1][j1 - 1]);
					possibleCheckPosition[checkIndex] = (i1) * 10 + j1;
					checkIndex++;
				}
				break;
			}
		}

		// From Current Piece Position To Right Side's Bottom
		for (int i1 = ki, j1 = kj; 7 >= i1 + 1 && 7 >= j1 + 1; i1++, j1++) {
			if (board[i1 + 1][j1 + 1] != empty) {
				if (board[i1 + 1][j1 + 1] == q || board[i1 + 1][j1 + 1] == b) {
					System.out.println(board[i1 + 1][j1 + 1]);
					possibleCheckPosition[checkIndex] = (i1 + 2) * 10 + j1 + 2;
					checkIndex++;
				}
				break;
			}

		}

		// Possible horizontal check positions
		// Towards Left
		for (int j1 = kj - 1; 0 <= j1 && j1 <= 7; j1--) {
			if (board[ki][j1] != empty) {
				if (board[ki][j1] == q || board[ki][j1] == r) {
					System.out.println(board[ki][j1]);
					possibleCheckPosition[checkIndex] = (ki + 1) * 10 + (j1 + 1);
					checkIndex++;
				}
				break;
			}
		}

		// Towards Right
		for (int j1 = kj + 1; 0 <= j1 && j1 <= 7; j1++) {
			if (board[ki][j1] != empty) {
				if (board[ki][j1] == q || board[ki][j1] == r) {
					System.out.println(board[ki][j1]);
					possibleCheckPosition[checkIndex] = (ki + 1) * 10 + (j1 + 1);
					checkIndex++;

				}
				break;
			}
		}

		// vertical possible position for checks
		// Upward Direction
		for (int i1 = ki - 1; 0 <= i1 && i1 <= 7; i1--) {
			if (board[i1][kj] != empty) {
				if (board[i1][kj] == q || board[i1][kj] == r) {
					System.out.println(board[i1][kj]);
					possibleCheckPosition[checkIndex] = (i1 + 1) * 10 + kj + 1;
					checkIndex++;
				}
				break;
			}
		}

		// Downward Direction
		for (int i1 = ki + 1; 0 <= i1 && i1 <= 7; i1++) {
			if (board[i1][kj] != empty) {
				if (board[i1][kj] == q && board[i1][kj] == r) {
					System.out.println(board[i1][kj]);
					possibleCheckPosition[checkIndex] = (i1 + 1) * 10 + kj + 1;
					checkIndex++;
				}
				break;
			}
		}

		// Horse Moves
		int[] iValues = { -2, +2, -1, +1 };
		// To calculate Horse Moves without using multiple if statements
		for (int i = 0; i < iValues.length; i++) {
			for (int j = 0; j < iValues.length; j++) {
				if (iValues[i] != -iValues[j] && k != j) {
					if (ki + iValues[i] >= 0 && ki + iValues[i] <= 7 && kj + iValues[j] >= 0 && kj + iValues[j] <= 7) {
						if (board[ki + iValues[i]][kj + iValues[j]] != empty) {
							if (board[ki + iValues[i]][kj + iValues[j]] == h) {
								chesspiece[index] = (ki + iValues[i] + 1) * 10 + kj + iValues[j] + 1;
								index++;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < possibleCheckPosition.length; i++) {
			if (possibleCheckPosition[i] != 0) {
				System.out.println("King getting check from opponents chess piece");

				System.out.println(ki + 1 + "==" + (kj + 1));
				System.out.println("isCheck method endeded;\n" + board[ki][kj]);
				return true;
			}
		}

		System.out.println(Arrays.toString(possibleCheckPosition));

		System.out.println("\nisCheck method ended;");
		return false;
	}

	// *******************************************************************
//********************* PLAYER ONE MOVE METHOD **********************
//To move only by player one
	private static void Player1() {
		isMoveDone = false;
		empty = '.';
		// to run infinite loop
		for (;;) {
			System.out.println("\nEnter valid piece Position (capital characters)");
			int piece = sc.nextInt();
			i = (piece / 10) - 1;
			j = (piece % 10) - 1;
			// check for valid position if yes then check for piece present on that position
			if (i >= 0 && i <= 7 && j <= 7 && j >= 0) {

				// checking piece present or not if yes then proceed further
				ch = board[i][j];
				if (ch != empty && ch <= 82) {
					System.out.println("piece present on position is : " + ch);
					switch (ch) {
					case 'Q':
						QUEEN();
						break;

					case 'K':
						kingMoves('a', 'r', 'k');
						break;

					case 'R':
						ROOK();
						break;

					case 'B':
						BISHOP();
						break;

					case 'H':
						horseMoves('a', 'r', 'k');
						break;

					case 'P':
						PAWN();
						break;
					}
				}
			}
			if (isMoveDone == true) {
				break;
			}
		}
	}

//*******************************************************************
//********************* PLAYER TWO MOVE METHOD **********************
//To move only by player two
	private static void Player2() {
		isMoveDone = false;
		empty = '.';
		// to run infinite loop
		for (;;) {
			System.out.println("\nEnter valid piece Position (small character)");
			int piece = sc.nextInt();
			i = (piece / 10) - 1;
			j = (piece % 10) - 1;
			// check for valid position if yes then check for piece present on that position
			if (i >= 0 && i <= 7 && j <= 7 && j >= 0) {

				// checking piece present or not if yes then proceed further
				ch = board[i][j];
				if (ch != empty && ch >= 97) {
					System.out.println("piece present on position is : " + ch);
					switch (ch) {
					case 'q':
						queen();
						break;

					case 'k':
						kingMoves('A', 'R', 'K');
						break;

					case 'r':
						rook();
						break;

					case 'b':
						bishop();
						break;

					case 'h':
						horseMoves('A', 'R', 'K');
						break;

					case 'p':
						pawn();
						break;
					}
				}
			}
			if (isMoveDone == true) {
				break;
			}
		}
	}

//*******************************************************************
//********************** BLACK HOURSE METHOD ************************

	public static void horseMoves(char a, char b, char c) {

		index = 0;
		Arrays.fill(chesspiece, 0);

		int[] iValues = { -2, +2, -1, +1 };
		// To calculate Horse Moves without using multiple if statements
		for (int k = 0; k < iValues.length; k++) {
			for (int l = 0; l < iValues.length; l++) {
				if (iValues[k] != -iValues[l] && k != l) {
					if (i + iValues[k] >= 0 && i + iValues[k] <= 7 && j + iValues[l] >= 0 && j + iValues[l] <= 7) {
						if (board[i + iValues[k]][j + iValues[l]] == empty) {
							swapPossibleMove(i + iValues[k], j + iValues[l]);
						} else if (board[i + iValues[k]][j + iValues[l]] >= a
								&& board[i + iValues[k]][j + iValues[l]] <= b
								&& board[i + iValues[k]][j + iValues[l]] != c) {
							swapPossibleMove(i + iValues[k], j + iValues[l]);
						}
					}
				}
			}
		}

		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise executce if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}

	}

//*******************************************************************
//********************* BLACK KING METHOD ***************************

	private static void kingMoves(char a, char b, char c) {
		Arrays.fill(chesspiece, 0);
		index = 0;

		int[] iValues = { -1, 1, 0 };

		for (int k = 0; k < iValues.length; k++) {
			for (int l = 0; l < iValues.length; l++) {
				if (iValues[k] != 0 || iValues[l] != 0) {
					if (i + iValues[k] >= 0 && i + iValues[k] <= 7 && j + iValues[l] >= 0 && j + iValues[l] <= 7) {
						if (board[i + iValues[k]][j + iValues[l]] == empty) {
							swapPossibleMove(i + iValues[k], j + iValues[l]);
						} else if (board[i + iValues[k]][j + iValues[l]] >= a
								&& board[i + iValues[k]][j + iValues[l]] <= b
								&& board[i + iValues[k]][j + iValues[l]] != c) {
							swapPossibleMove(i + iValues[k], j + iValues[l]);
						}
					}
				}
			}
		}

		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise execute if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("\nThere is no any valid move :(");
		}
	}

//*******************************************************************
//********************* BLACK PWAN METHOD ***************************

//Method of PAWN to calculate valid Moves
	public static void PAWN() {
		// reinitializing pawn Move array
		Arrays.fill(chesspiece, 0);
		index = 0;

		// if there no any piece present on forward Move
		if (board[i + 1][j] == empty) {
			if (i == 1) {
				// Pawn is present at starting Move then it have 2 steps
				// 1 box forward
				swapPossibleMove((i + 1), j);
				// 2 box forward
				swapPossibleMove((i + 2), j);
			} else {
				// if it is not at start Move then it will have only one box forward
				swapPossibleMove((i + 2), j);
			}
		}

		// it is used to calculate move to kill by pawn
		int[] iValues = { 1, -1 };

		for (int k = 0; k < 2; k++) {
			if (i - 1 >= 0 && i + 1 <= 7 && j + iValues[k] >= 0 && j + iValues[k] <= 7) {
				if (board[i + 1][j - iValues[k]] >= 97 && board[i + 1][j - iValues[k]] <= 114) {
					swapPossibleMove(i + 1, j - iValues[k]);
				}
			}
		}

		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise execute if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}

	}

//*******************************************************************
//********************* WHITE PAWN METHOD ***************************

//Method of pawn to calculate valid Moves
	public static void pawn() {
		// reinitializing pawn Move array
		Arrays.fill(chesspiece, 0);
		index = 0;

		// if there no any piece present on forward Move
		if (board[i - 1][j] == empty) {
			if (i == 6) {
				// Pawn is present at starting Move then it have 2 steps
				// 1 box forward
				swapPossibleMove((i - 1), j);
				// 2 box forward
				swapPossibleMove((i - 2), j);
			} else {
				// if it is not at start Move then it will have only one box forward
				swapPossibleMove((i - 1), j);
			}
		}

		// it is used to calculate move to kill by pawn
		int[] iValues = { 1, -1 };

		for (int k = 0; k < 2; k++) {
			if (i - 1 >= 0 && i + 1 <= 7 && j + iValues[k] >= 0 && j + iValues[k] <= 7) {
				if (board[i - 1][j - iValues[k]] >= 65 && board[i - 1][j - iValues[k]] <= 82) {
					swapPossibleMove((i), j - iValues[k]);
				}
			}
		}

		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise execute if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}

	}

//*******************************************************************
//********************* BLACK BISHOP METHOD *************************

	private static void BISHOP() {
		Arrays.fill(chesspiece, 0);
		index = 0;

		diagonalLeftUpRightDownMoves('a', 'r', 'k');
		diagonalLeftDownRightUpMoves('a', 'r', 'k');

		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}
	}

//*******************************************************************
//********************* WHITE BISHOP METHOD *************************

	private static void bishop() {
		Arrays.fill(chesspiece, 0);
		index = 0;

		diagonalLeftUpRightDownMoves('A', 'R', 'K');
		diagonalLeftDownRightUpMoves('A', 'R', 'K');
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}
	}

//*******************************************************************
//********************* BLACK QUEEN METHOD **************************

	private static void QUEEN() {

		// reinitializing rook array and index
		Arrays.fill(chesspiece, 0);
		index = 0;

		// calling method and updating value of index which is returned by respective
		// methods

		verticalMoves('a', 'r', 'k');
		horizontalMoves('a', 'r', 'k');

		diagonalLeftUpRightDownMoves('a', 'r', 'k');
		diagonalLeftDownRightUpMoves('a', 'r', 'k');
		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise execute if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}
	}

//*******************************************************************
//********************* WHITE QUEEN METHOD **************************

	private static void queen() {

		// reinitializing rook array and index
		Arrays.fill(chesspiece, 0);
		index = 0;

		// calling method and updating value of index which is returned by respective
		// methods

		verticalMoves('A', 'R', 'K');
		horizontalMoves('A', 'R', 'K');

		diagonalLeftUpRightDownMoves('A', 'R', 'K');
		diagonalLeftDownRightUpMoves('A', 'R', 'K');
		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise execute if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}
	}

//*******************************************************************
//******************* BLACK ROOK METHOD *****************************

	private static void ROOK() {

		// reinitializing rook array and index
		Arrays.fill(chesspiece, 0);
		index = 0;

		// calling method and updating value of index which is returned by respective
		// methods

		verticalMoves('a', 'r', 'k');
		horizontalMoves('a', 'r', 'k');

		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise execute if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}
	}

//*******************************************************************
//********************* WHITE ROOK METHOD ***************************

	private static void rook() {

		// reinitializing rook array and index
		Arrays.fill(chesspiece, 0);
		index = 0;

		// calling method and updating value of index which is returned by respective
		// methods
		verticalMoves('A', 'R', 'K');
		horizontalMoves('A', 'R', 'K');

		// displayMoves() return flag if flag is 0 means there is no any valid Move
		// if there is no any valid Move then execute else otherwise execute if
		if (flagCount()) {
			validMove();
		} else {
			System.out.println("There is no any valid move :(");
		}

	}

	private static void diagonalLeftDownRightUpMoves(char a, char b, char c) {

		// From Current Piece Position To Right Side's Top
		for (int i1 = i, j1 = j; 0 <= i1 - 1 && 7 >= j1 + 1; i1--, j1++) {
			if (board[i1 - 1][j1 + 1] == '.') {
				swapPossibleMove((i1 - 1), j1 + 1);
			} else if (board[i1 - 1][j1 + 1] >= a && board[i1 - 1][j1 + 1] <= b && board[i1 - 1][j1 + 1] != c) {
				{
					swapPossibleMove((i1 - 1), j1 + 1);
				}
				break;
			} else {
				break;
			}
		}

		// From Current Piece Position To Left Side's Bottom
		for (int i1 = i, j1 = j; 7 >= i1 + 1 && 0 <= j1 - 1; i1++, j1--) {
			if (board[i1 + 1][j1 - 1] == '.') {
				chesspiece[index] = (i1 + 2) * 10 + j1;
				index++;
			} else if (board[i1 + 1][j1 - 1] >= a && board[i1 + 1][j1 - 1] <= b && board[i1 + 1][j1 - 1] != c) {
				{
					swapPossibleMove(i1 + 1, j1 - 1);
				}
				break;
			} else {
				break;
			}
		}
	}

	private static void diagonalLeftUpRightDownMoves(char a, char b, char c) {

		// From Current Piece Position To Left Side's Top
		for (int i1 = i, j1 = j; 0 <= i1 - 1 && 0 <= j1 - 1; i1--, j1--) {
			if (board[i1 - 1][j1 - 1] == '.') {
				swapPossibleMove(i1 - 1, j1 - 1);
			} else if (board[i1 - 1][j1 - 1] >= a && board[i1 - 1][j1 - 1] <= b && board[i1 - 1][j1 - 1] != c) {
				{
					swapPossibleMove(i1 - 1, j1 - 1);
				}
				break;
			} else {
				break;
			}
		}

		// From Current Piece Position To Right Side's Bottom
		for (int i1 = i, j1 = j; 7 >= i1 + 1 && 7 >= j1 + 1; i1++, j1++) {
			if (board[i1 + 1][j1 + 1] == '.') {
				swapPossibleMove(i1 + 1, j1 + 1);
			} else if (board[i1 + 1][j1 + 1] >= a && board[i1 + 1][j1 + 1] <= b && board[i1 + 1][j1 + 1] != c) {
				{
					swapPossibleMove(i1 + 1, j1 + 1);
				}
				break;
			} else {
				break;
			}
		}

	}

	private static void horizontalMoves(char a, char b, char c) {

		// Towards Left
		for (int j2 = j - 1; 0 <= j2 && j2 <= 7; j2--) {
			if (board[i][j2] == empty) {
				swapPossibleMove(i, j2);
			} else if (board[i][j2] >= a && board[i][j2] <= b && board[i][j2] != c) {
				swapPossibleMove(i, j2);
				break;
			} else {
				break;
			}
		}

		// Towards Right
		for (int j2 = j + 1; 0 <= j2 && j2 <= 7; j2++) {
			if (board[i][j2] == empty) {
				swapPossibleMove(i, j2);
			} else if (board[i][j2] >= a && board[i][j2] <= b && board[i][j2] != c) {
				swapPossibleMove(i, j2);
				break;
			} else {
				break;
			}
		}
	}

	private static void verticalMoves(char a, char b, char c) {
		// Upward Direction
		for (int i2 = i - 1; 0 <= i2 && i2 <= 7; i2--) {
			if (board[i2][j] == empty) {
				swapPossibleMove(i2, j);
			} else if (board[i2][j] >= a && board[i2][j] <= b && board[i2][j] != c) {
				swapPossibleMove(i2, j);
				break;
			} else {
				break;
			}
		}

		// Downward Direction
		for (int i2 = i + 1; 0 <= i2 && i2 <= 7; i2++) {
			if (board[i2][j] == empty) {
				swapPossibleMove(i2, j);
			} else if (board[i2][j] >= a && board[i2][j] <= b && board[i2][j] != c) {
				swapPossibleMove(i2, j);
				break;
			} else {
				break;
			}
		}
	}

//*******************************************************************
//***** CHECK FOR VALID MOVE OR ENTERED MOVE IS POSSIBLE OR NOT *****
//*******************************************************************

//to check move is valid or not
	private static void validMove() {
		// printing valid moves
		System.out.println("Printing valid moves");
		displayMoves();
		System.out.println("Please select one Move");
		// storing input in swap variable
		int swap = sc.nextInt();
		boolean b = false;
		// verifying input data or swap value is present in array or not of respective
		// piece
		for (int array : chesspiece) {
			if (array == swap) {
				b = true;
			}
		}

		// it's not necessary to use this one because already i have added king
		// condition
//		if (board[si][sj] == 'K' || board[si][sj] == 'k') {
//			System.out.println("You can't eliminate king directly");
//			System.out.println("It's Against chess rules you can give check to king");
//			System.out.println("Please enter valid choice except to eliminate king directly");
//			validMove();
//		} else
//		
		// here i have assigning new value to static variable named as king and KING
		// because every time at checking of getting check or not for that kings
		// position is required

		if (b) {
			Swap(swap);
		} else {
			System.out.println("Invalid choice :(, Let's try again");
			validMove();
		}
	}

//*******************************************************************
//*********************** TO SWAP CHESS PIECE ***********************	
//*******************************************************************		
	// Common method for every piece which takes first argument as where to swap
	// Move and second argument is current Move of piece
	private static void Swap(int swapMove) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		int si = (swapMove / 10) - 1;
		int sj = (swapMove % 10) - 1;

		char CH = board[i][j];
		board[i][j] = empty;
		board[si][sj] = CH;

		System.out.println(ch + " is moved");
		isMoveDone = true;
		System.out.println("\n");
		displayBoard();
		System.out.println(isKingGettingCheck());
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}

	private static void swapPossibleMove(int si, int sj) {

		char piece = board[si][sj];
		char CH = board[i][j];
		board[i][j] = empty;
		board[si][sj] = CH;
		boolean b = isKingGettingCheck();
		System.out.println("getting check     " + b);
		if (!b) {
			chesspiece[index] = (si + 1) * 10 + (sj + 1);
			index++;
		}

		board[i][j] = CH;
		board[si][sj] = piece;

	}

//*******************************************************************
//*********************** GLOBAL VARIABLE DECLARATION *****************	
//*******************************************************************		
	// we taking array of 27 because there only one piece which is queen which can
	// have maximum 27 moves
	static int[] chesspiece = new int[35];
	static int[] possibleCheckPosition = new int[10];
	// increasing array size because to store value of check method 35 is maximum
	// moves

	// index for chess piece array
	static int index;
	static int checkIndex;

	// the i and j is used for board[i][j]
	static int i, j;

	// to fetch character on current position
	static char ch;

	// to check move is done or not
	static boolean isMoveDone = false;

	// to store empty position of board and also used to verify isCheck conditions
	static char empty = '.';

	// p variable used to identify which player played last move
	static int player;

	// to store the position of king
	static int KING = 15;
	static int king = 85;

	// to taking input from user
	static Scanner sc = new Scanner(System.in);

//*******************************************************************
//*********************** CHESS BOARD DECLARATION AT START **********	
//*******************************************************************		
	// Board at start
	static char[][] board = { { 'R', 'H', 'B', 'Q', 'K', 'B', 'H', 'R' },
			{ 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
//			{ empty, empty, empty, empty, empty, empty, empty, empty },
			{ empty, empty, empty, empty, empty, empty, empty, empty },
			{ empty, empty, empty, empty, empty, empty, empty, empty },
			{ empty, empty, empty, empty, empty, empty, empty, empty },
			{ empty, empty, empty, empty, empty, empty, empty, empty },
	
//		{ empty, empty, empty, empty, empty, empty, empty, empty },
			{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
			{ 'r', 'h', 'b', 'q', 'k', 'b', 'h', 'r' }, };

//*******************************************************************
//*********************** TO DIPLAY CHESS BOARD *********************	
//*******************************************************************
	// to print board
	public static void displayBoard() {
		System.out.println("------------------------------------------------------------");
		for (int i = 0; i <= 7; i++) {
			// to display position of piece on chess board
			for (int j = 0; j <= 7; j++) {
				char ch = board[i][j];
				System.out.print(ch + "\t");
			}
			System.out.println();
			// to print position of piece on chess board
			for (int j = 1; j <= 8; j++) {
				// here printing i+1 because i start from 0
				System.out.print(i + 1 + "" + j + "\t");
			}
			System.out.println();
			System.out.println("------------------------------------------------------------");
		}
	}

//*******************************************************************
//*********************** TO DIPLAY AVAILABLE MOVES *****************	
//*******************************************************************
	// to print valid Move array
	public static void displayMoves() {
		// to count non zero array elements
		for (int i = 0; i < 35; i++) {
			// if the array element is not 0 then print it
			if (chesspiece[i] != 0) {
				System.out.print(chesspiece[i] + "\t");
			} else {
				break;
			}
		}
		System.out.println();
		// return non zero array element count
	}

//*******************************************************************
//*********************** TO CHECK NO OF AVILABLE MOVES *************	
//*******************************************************************
	// if it return 0 it means there is no move available or we can say that
	// chess piece array is empty
	// if there is no move available then we have to choose another piece
	public static boolean flagCount() {
		// to count non zero array elements
		for (int i = 0; i < 35; i++) {
			// if the array element is not 0 then increment flag
			if (chesspiece[i] != 0) {
				return true;
			}
		}
		// return non zero array element count
		return false;
	}
}