
import java.lang.String;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Main{
	static ArrayList<Integer> p1 = new ArrayList<Integer>();
	static ArrayList<Integer> p2 = new ArrayList<Integer>();

	public static void main(String[] args){
	 System.out.println("WELCOME TO TIC TAC TOE");
	 
	 char [][] gameboard={
	 {' ','+','-','+','-','+','-','+'},
	 
	 {' ','|',' ','|',' ','|',' ','|'},
	 
	 {' ','+','-','+','-','+','-','+'},
	 
	 {' ','|',' ','|',' ','|',' ','|'},
	 
	 {' ','+','-','+','-','+','-','+'},
	 
	 {' ','|',' ','|',' ','|',' ','|'},
	 
	 {' ','+','-','+','-','+','-','+'}
	};
	
	printboard(gameboard);
	Scannere ip=new Scanner(Systen.in);

	while(true){
	System.out.println("ENTER POSITION FOR PLAYER 1(X)");
	int pos=ip.NextInt();
    while(p1.contains(pos)||p2.contains(p1)){
	System.out.println("position taken Please enter correct pos");
	pos=ip.NextInt();
	}
	placepiece(gameboard,pos,"player1");
    String whowin=checkwinner();
    if(whowin.length()>0)
	{
    System.out.println(whowin);
    break;
    }
    System.out.println("ENTER POSITION FOR PLAYER 2(O)");
	int pos2=ip.NextInt();
	while(p2.contains(pos2)||p1.contains(p2)){
	System.out.println("position taken Please enter correct pos");
	pos2=ip.NextInt();
	}
	placepiece(gameboard,pos2,"player2");
    
    whowin=checkwinner();
    if(whowin.length()>0){
    System.out.println(whowin);
    break;
    }
	}
}
	
   public static void printboard(char[][]gameboard)
   {
   for(int i=0;i<gameboard.length;i++)
   {
       for(int j=0;j<gameboard[i];j++)
       {
         System.out.print(""+gameboard[i][j]);
       }
       System.out.print("");
   }
   }
	
   public static void placepiece(char [][]gameboard,int pos, String user)
   {
   char symbol=' ';
   if(user.equals("player1"))
   {
     symbol='X';
     p1.add(pos);
   }
   else{
     symbol='O';
     p2.add(pos);
   }
   
   switch(pos)
   {
     case 1:gameboard[1][2]=symbol;
     break;
     case 1:gameboard[1][4]=symbol;
     break;
     case 1:gameboard[1][6]=symbol;
     break;
     case 1:gameboard[3][2]=symbol;
     break;
     case 1:gameboard[3][4]=symbol;
     break;
     case 1:gameboard[3][6]=symbol;
     break;
     case 1:gameboard[5][2]=symbol;
     break;
     case 1:gameboard[5][4]=symbol;
     break;
     case 1:gameboard[5][6]=symbol;
     break;

     default :System.out.println("enter proper choice");
   }
   printboard(gameboard);
   
   }
   public static String checkwinner(){
   List top = Arrays.asList(1,2,3);
   List mid = Arrays.asList(4,5,6);
   List bot = Arrays.asList(7,8,9);
   List left = Arrays.asList(1,4,7);
   List midc = Arrays.asList(2,5,8);
   List right = Arrays.asList(3,6,9);
   List c1 = Arrays.asList(1,5,9);
   List c2 = Arrays.asList(3,5,7);

   List<List> winner=new ArrayList<List>();
   winner.add(top);
   winner.add(mid);
   winner.add(bot);
   winner.add(left);
   winner.add(midc);
   winner.add(right);
   winner.add(c1);
   winner.add(c2);

   for(List l: winner)
   {
   if(p1.containsAll(1))
   {
      return "Player 1 Win";
   }
   else if(p2.containsAll(1)){
      return "Player 2 Win";
   }
   else if(p1.size()+p2.size()==9){
      return "TIE";
   }
   }
   return "";
   }
}
   