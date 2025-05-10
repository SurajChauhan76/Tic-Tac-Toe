import java.util.Scanner;

public class Main {
    static char[][] board = new char[3][3];

    public static void fillBoard(char[][] board, int option, boolean player){
        switch (option) {
            case 1:
                if (player) {
                    board[0][0] = 'X';
                } else {
                    board[0][0] = 'O';
                }
                break;
            case 2:
                if (player) {
                    board[0][1] = 'X';
                } else {
                    board[0][1] = 'O';
                }
                break;
            case 3:
                if (player) {
                    board[0][2] = 'X';
                } else {
                    board[0][2] = 'O';
                }
                break;
            case 4:
                if (player) {
                    board[1][0] = 'X';
                } else {
                    board[1][0] = 'O';
                }
                break;
            case 5:
                if (player) {
                    board[1][1] = 'X';
                } else {
                    board[1][1] = 'O';
                }
                break;
            case 6:
                if (player) {
                    board[1][2] = 'X';
                } else {
                    board[1][2] = 'O';
                }
                break;
            case 7:
                if (player) {
                    board[2][0] = 'X';
                } else {
                    board[2][0] = 'O';
                }
                break;
            case 8:
                if (player) {
                    board[2][1] = 'X';
                } else {
                    board[2][1] = 'O';
                }
                break;
            case 9:
                if (player) {
                    board[2][2] = 'X';
                } else {
                    board[2][2] = 'O';
                }
                break;
        }
    }

    public static boolean boardResult(char[][] board){
        if((board[0][0]==board[0][1] && board[0][0]==board[0][2] && board[0][0]=='X') || (board[1][0]==board[1][1] && board[1][0]==board[1][2] && board[1][0]=='X') || (board[2][0]==board[2][1] && board[2][0]==board[2][2] && board[2][0]=='X') || (board[0][0]==board[1][0] && board[0][0]==board[2][0] && board[0][0]=='X') || (board[0][1]==board[1][1] && board[0][1]==board[2][1] && board[0][1]=='X') || (board[0][2]==board[1][2] && board[0][2]==board[2][2] && board[0][2]=='X') || (board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]=='X') || (board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]=='X')){
            System.out.println("===========================");
            displayBoard();
            System.out.println("Player-X wins!");
            return true;
        }
        if((board[0][0]==board[0][1] && board[0][0]==board[0][2] && board[0][0]=='O') || (board[1][0]==board[1][1] && board[1][0]==board[1][2] && board[1][0]=='O') || (board[2][0]==board[2][1] && board[2][0]==board[2][2] && board[2][0]=='O') || (board[0][0]==board[1][0] && board[0][0]==board[2][0] && board[0][0]=='O') || (board[0][1]==board[1][1] && board[0][1]==board[2][1] && board[0][1]=='O') || (board[0][2]==board[1][2] && board[0][2]==board[2][2] && board[0][2]=='O') || (board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]=='O') || (board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]=='O')){
            System.out.println("===========================");
            displayBoard();
            System.out.println("Player-O wins!");
            return true;
        }
        return false;
    }

    public static void displayBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void playGame(char[][] board, char choice){
        displayBoard();
        boolean player = choice == 'X' || choice == 'x';
        int option;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Player-1: ");
            option = sc.nextInt();
            count++;
            fillBoard(board, option, player);
            if(boardResult(board)) break;
            displayBoard();

            if(count == 9){
                System.out.println("Draw!");
                break;
            }

            System.out.print("Player-2: ");
            option = sc.nextInt();
            count++;
            fillBoard(board, option, !player);
            if(boardResult(board)) break;
            displayBoard();
        }while (count<=9);
    }
    public static void main(String [] args){
        System.out.print("Player-1 enter your choice(X or O): ");
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().charAt(0);
        System.out.println("Instructions\nYou need to enter the respective positons(1-9)");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        playGame(board,choice);
    }
}
