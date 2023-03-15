
public class Player {
    //Basically a getter and setter funtion for player, name and symbol
    private String name;
    private char symbol;
    
    public Player(String name, char symbol){ //setting the name and symbol of function
        Name(name);
        Symb(symbol);
    }
    public void Name(String name) {
        
        if(!name.isEmpty()) { //checking if the name is entered by the user or not
            this.name = name; 
        }
    }
    public String getName() {
        return this.name;
    }
    public void Symb(char symbol) {
        if(symbol != '\0') {
            this.symbol = symbol; 
        }
    }
    public char getSymbol() {
        return this.symbol;
    }
}