public class Player 
{
	
	private String name;
	private char Symbol;
	
	Player(String name,char symbol)
	{
		this.name=name;
		this.Symbol=symbol;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!="")
		this.name = name;
	}
	public char getSymbol() {
		return Symbol;
	}
	public void setSymbol(char symbol) {
		if(symbol!=' ')
		Symbol = symbol;
	}

}
