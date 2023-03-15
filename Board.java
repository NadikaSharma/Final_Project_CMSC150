
//this class prints board and checks winning, draw or wrong input conditions
public class Board {
    //Creating objects below:
    private char board[][];
    private int size = 3;
    private char p1Sign, p2Sign; 
    private int count;
    //making objects to check conditions during the game below:
    public final static int p1Wins = 1;
    public final static int p2Wins = 2;
    public final static int draw = 3;
    public final static int notFull = 4;
    public final static int wrong = 5;

    public Board(char p1Sign, char p2Sign){
        board = new char[size][size];
        for(int i =0; i < size; i++){
            for(int j =0; j < size; j++){
                board[i][j] = ' ';
            }
        }
        this.p1Sign = p1Sign;
        this.p2Sign = p2Sign;
    }
    public int moving(char symbol, int x, int y) {
        //checking if the move is valid or the board is full
        if(x < 0 || x >= size || y < 0 || y >= size || board[x][y] != ' '){
            return wrong;
        }

        board[x][y] = symbol;
        count++; //counting available spots on board
        // To check Row:
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){ 
            return symbol == p1Sign ? p1Wins : p2Wins; //if symbol is equal to p1's sign, p1 wins or p2 wins
        }
        //To check Column:
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
            return symbol == p1Sign ? p1Wins : p2Wins;
        }
        //To check first Diagonal(from upper left to bottom right:)
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            return symbol == p1Sign ? p1Wins : p2Wins;
        }
        //To check second Diagonal(from upper right to bottom left:)
        if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            return symbol == p1Sign ? p1Wins : p2Wins;
        }
        if(count == size * size){ //As the game ends and no one wins, we need to return something.
            return draw;
        }
        return  notFull;

    }
    public void print() { //printing the board
        System.out.println("-----------");
        for(int i =0; i < size; i++){
            for(int j =0; j < size; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------");
        
        }
        System.out.println(); //adding a space
      
    }
}