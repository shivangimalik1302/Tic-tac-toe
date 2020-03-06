import java.util.*;
public class Controller 
{
	private Player player1,player2;
	private Board board;
	
	public static void main(String args[])
	{
		Controller c1=new Controller();
		c1.startGame();
	}
	
	
	public void startGame()
	{
		Scanner sc=new Scanner(System.in);
		player1= takeInput(1);
		player2=takeInput(2);
		
		while(player1.getSymbol()==player2.getSymbol())
		{
			System.out.println("Symbol already taken. Please enter another symbol!");
			char a=sc.next().charAt(0);
			player2.setSymbol(a);
		}
		
		board=new Board(player1.getSymbol(),player2.getSymbol());
		
		boolean player1turn=true;
		
		int status=Board.Incomplete;
		while(status==Board.Invalid || status==Board.Incomplete)
		{
			if(player1turn)
			{
				System.out.println("Player 1-"+player1.getName()+"'s turn");
				System.out.println("Enter x cordinate");
				int x=sc.nextInt();
				System.out.println("Enter y cordinate");
				int y=sc.nextInt();
				status= board.move(player1.getSymbol(),x,y);
				if(status==5)
				{
					System.out.println("Enter x and y cordinates again");
				}
				else
				{
					player1turn=false;
					board.print();
				}
			}
			else
			{
				System.out.println("Player 2-"+player2.getName()+"'s turn");
				System.out.println("Enter x cordinate");
				int x=sc.nextInt();
				System.out.println("Enter y cordinate");
				int y=sc.nextInt();
				status= board.move(player2.getSymbol(),x,y);
				if(status==5)
				{
					System.out.println("Enter x and y cordinates again");
				}
				else
				{
					player1turn=true;
					board.print();
				}
			}
		}
		if(status==1)
		{
			System.out.println("Player 1- "+player1.getName()+" wins");
		}
		else if(status==2)
		{
			System.out.println("Player 1- "+player1.getName()+" wins");
		}
		else if(status==3)
		{
			System.out.println("draw");
		}
			
	}


	


	private Player takeInput(int num) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter player "+num + "'s name");
		String name=sc.nextLine();
		System.out.println("Enter player "+num + "'s symbol");
		char a=sc.next().charAt(0);
		
		Player p=new Player(name,a);
		return p;
	}
}
