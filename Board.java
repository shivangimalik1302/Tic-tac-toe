public class Board 
{
	private int size=3;
	private char board[][];
	private char symbol1,symbol2;
	int count;
	public final static int Player1win=1;
	public final static int Player2win=2;
	public final static int Draw=3;
	public final static int Incomplete=4;
	public final static int Invalid=5;
	
	
	
	Board(char symb1,char symb2)
	{
		board=new char[size][size];
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				board[i][j]=' ';
			}
		}
		this.symbol1=symb1;
		this.symbol2=symb2;
	}

	public int move(char symbol, int x, int y) 
	{
		if(x<0 || y<0 || x>=board.length || y>=board.length || board[x][y]!=' ')
		{
			return Invalid;
		}
		board[x][y]=symbol;
		count++;
		
		if(board[x][0]==board[x][1] && board[x][1]==board[x][2] && board[x][0]!=' ')
		{
			return symbol== symbol1 ? 1 : 2;
		}
		
		if(board[0][y]==board[1][y] && board[1][y]==board[2][y] && board[0][y]!=' ')
		{
			return symbol== symbol1 ? 1 : 2;
		}
		
		if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!=' ')
		{
			return symbol== symbol1 ? 1 : 2;
		}
		if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2]!=' ')
		{
			return symbol== symbol1 ? 1 : 2;
		}
		if(count==board.length*board.length)
		{
			return 3;
		}
		return 4;
	}

	public void print() 
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
