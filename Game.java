

import java.util.Scanner;
public class Game {

    private Player p1, p2;
    private Board board;
    public static void main(String args[]){ 
        Game tictactoe = new Game();
        tictactoe.startGame();
    }
    private Player input(int num){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Player " + num + "'s name: ");
        String name = s.nextLine();
        System.out.println("Enter Player " + num + "'s symbol: ");
        char symbol = s.next().charAt(0);
        Player info = new Player(name, symbol); //passing the variables name and symbol to method "Player"
        return info;    
    }
    public void startGame(){
        Scanner in = new Scanner(System.in);
        p1 = input(1);
        p2 = input(2);
        while(p1.getSymbol() == p2.getSymbol()){ //checks if the symbol is already taken by player 1
            System.out.println("pick another symbol. This one is already taken.");
            char symbol = in.next().charAt(0);
            p2.Symb(symbol);
        }
        // Creating the Board
        board = new Board(p1.getSymbol(), p2.getSymbol());
        // executing the Game
        boolean player1Turn = true; //true is for player 1's turn, false is for player 2's turn
        int status = Board.notFull; 
        while(status == Board.notFull || status == Board.wrong){  
            if(player1Turn){
                System.out.println(p1.getName() + "'s turn");
                System.out.println("Enter row number (first row is written as 0): ");
                int x = in.nextInt();
                System.out.println("Enter column number (first column is written as 0): ");
                int y = in.nextInt();
                 status =  board.moving(p1.getSymbol(), x, y); //checking if its valid move or not
                if(status != Board.wrong){
                    player1Turn = false;
                    board.print();
                }else{
                    System.out.println("Invalid Move, Try again.");
                }
            }else{
                    System.out.println(p2.getName() + "'s turn");
                    System.out.println("Enter x: ");
                    int x = in.nextInt();
                    System.out.println("Enter y: ");
                    int y = in.nextInt();
                     status =  board.moving(p2.getSymbol(), x, y);
                    if(status != Board.wrong){
                        player1Turn = true;
                        board.print();
                    }else{
                        System.out.println("Invalid Move, try Again.");
                    }                
            }
        }
        if(status == Board.p1Wins){ //checks which of the players has won and displays message
            System.out.println("Player 1: " + p1.getName() +" wins.");
        }else if(status == Board.p2Wins){
            System.out.println("Player 2: " + p2.getName() +" wins.");
        }else{
            System.out.println("It is a draw.");
        }
    }
}