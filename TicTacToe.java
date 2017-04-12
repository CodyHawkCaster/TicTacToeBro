/*
Connor Flynn
Walton High School
4/10/17
*/

import java.util.Scanner;

public class TicTacToe
{
   public static void main(String[] args)
   {  
      System.out.println("Hello! Welcome to Connor Flynn's TicTacToe!");
      System.out.println("You will see a board with numbers 1 - 9, each numbers represents a space where you can palce your mark");
      System.out.println("Type a number that corresponds to the square and your X or O will be placed there!");
      System.out.println("Get 3 Xs in a row for X to win!");
      System.out.println("Get 3 Os in a row for O to win!");
      
      
      String[][] myArray = { {" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
      String[][] nums = { {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
      display(nums);
      
      
      Scanner input = new Scanner (System.in);
      System.out.println("Player 1, where would you like to place X? (1-9)");
      int location = input.nextInt();
      location = Check(location);//checks to see if valid location
      Xloc(myArray, location);
      display(myArray);//prints board
      
      
      int i;
      for(i = 1; i < 5; i++)//loops for all turns after first
      {
         System.out.println("Player 2, where would you like to place O? (1-9)");
         location = input.nextInt();
         location = Check(location);//checks to see if valid location
         Oloc(myArray, location);//does method to find where the user wants to place O
         display(myArray);
         if(i >= 3)//this is the first time player 2 can win
            if(winningO(myArray))
            {
               System.out.println("Player 2 (O) Wins!");
               break;
            }
         
         
         System.out.println("Player 1, where would you like to place X? (1-9)");
         location = input.nextInt();
         location = Check(location);//checks to see if valid location
         Xloc(myArray, location);
         display(myArray);
         if(i >= 2)//first time player 1 can win
            if(winningX(myArray))
            {
               System.out.println("Player 1 (X) Wins!");
               break;
            }
      }
      if(i == 5)
         System.out.println("Cats Game! no one wins =(");
   }
   
   public static void display(String[][] myArray)//prints the board
   {
      System.out.println();
      System.out.println(myArray[0][0] + "|" + myArray[0][1] + "|" + myArray[0][2]);
      System.out.println("-+-+-");  // dashes between rows
      System.out.println(myArray[1][0] + "|" + myArray[1][1] + "|" + myArray[1][2]);
      System.out.println("-+-+-");
      System.out.println(myArray[2][0] + "|" + myArray[2][1] + "|" + myArray[2][2]);
      System.out.println();
   }
   
   public static void Xloc(String[][] myArray, int location)//method to find where the user wants to place X
   {
      if(location == 1) //changes location's address to X row 1, column 1
    		if(Space(myArray, 0, 0))// if the space is not already filled fill space     	
				myArray[0][0] = "X";
         else
            TestRunAgainX(myArray, location);
      else if(location == 2)//row 1, column 2
         if(Space(myArray, 0, 1))
            myArray[0][1] = "X";
         else
            TestRunAgainX(myArray, location);
      else if(location == 3)//row 1, column 3
         if(Space(myArray, 0, 2))
            myArray[0][2] = "X";
         else
            TestRunAgainX(myArray, location);
         
         
      else if(location == 4)//row 2, column 1
         if(Space(myArray, 1, 0))
            myArray[1][0] = "X";
         else
            TestRunAgainX(myArray, location);
      else if(location == 5)//row 2, column 2
         if(Space(myArray, 1, 1))
            myArray[1][1] = "X";
         else
            TestRunAgainX(myArray, location);
      else if(location == 6)//row 2, column 3
         if(Space(myArray, 1, 2))
            myArray[1][2] = "X";
         else
            TestRunAgainX(myArray, location);

         
      else if(location == 7)//row 3, column 1
         if(Space(myArray, 2, 0))
            myArray[2][0] = "X";
         else
            TestRunAgainX(myArray, location);
      else if(location == 8)//row 3, column 2
         if(Space(myArray, 2, 1))
            myArray[2][1] = "X";
         else
            TestRunAgainX(myArray, location);
      else if(location == 9)//row 3, column 3
         if(Space(myArray, 2, 2))
            myArray[2][2] = "X";
         else
            TestRunAgainX(myArray, location);
   }
   
   public static void Oloc(String[][] myArray, int location)//method to find where the user wants to place O
   {
      if(location == 1) //changes location's address to O row 1, column 1
         if(Space(myArray, 0, 0))
            myArray[0][0] = "O";
         else
            TestRunAgainO(myArray, location);
      else if(location == 2)//row 1, column 2
         if(Space(myArray, 0, 1))
            myArray[0][1] = "O";
         else
            TestRunAgainO(myArray, location);
      else if(location == 3)//row 1, column 3
         if(Space(myArray, 0, 2))
            myArray[0][2] = "O";
         else
            TestRunAgainO(myArray, location);
      
      
      else if(location == 4)//row 2, column 1
         if(Space(myArray, 1, 0))
            myArray[1][0] = "O";
         else
            TestRunAgainO(myArray, location);
      else if(location == 5)//row 2, column 2
         if(Space(myArray, 1, 1))
            myArray[1][1] = "O";
         else
            TestRunAgainO(myArray, location);
      else if(location == 6)//row 2, column 3
         if(Space(myArray, 1, 2))
            myArray[1][2] = "O";
         else
            TestRunAgainO(myArray, location);
         
         
      else if(location == 7)//row 3, column 1
         if(Space(myArray, 2, 0))
            myArray[2][0] = "O";
         else
            TestRunAgainO(myArray, location);
      else if(location == 8)//row 3, column 2
         if(Space(myArray, 2, 1))
            myArray[2][1] = "O";
         else
            TestRunAgainO(myArray, location);      
      else if(location == 9)//row 3, column 3
         if(Space(myArray, 2, 2))
            myArray[2][2] = "O";
         else
            TestRunAgainO(myArray, location);
   }
   
   public static int Check(int x)//checks to see if locations is between [1, 9]
   {
      Scanner input = new Scanner (System.in);
      while(!(x >= 1 && x <= 9))
		{
         System.out.println();
			System.out.println("Invalid input: " + x);// tells them that this input is wrong
			System.out.println("Please enter a correct number [1, 9] : ");//gives them a second chance
			x = input.nextInt();
		}
      return x;
   }
   
   public static boolean winningX(String[][] myArray)// checks if X has 3 any way
   {
      if(myArray[0][0] == "X" && myArray[0][1] == "X" && myArray[0][2] == "X")//checks rows
         return true;
      else if(myArray[1][0] == "X" && myArray[1][1] == "X" && myArray[1][2] == "X")
         return true;
      else if(myArray[2][0] == "X" && myArray[2][1] == "X" && myArray[2][2] == "X")
         return true;
         
      else if(myArray[0][0] == "X" && myArray[1][0] == "X" && myArray[2][0] == "X")//checks collunms
         return true;
      else if(myArray[0][1] == "X" && myArray[1][1] == "X" && myArray[2][1] == "X")
         return true;
      else if(myArray[0][2] == "X" && myArray[1][2] == "X" && myArray[2][2] == "X")
         return true;
         
      else if(myArray[0][0] == "X" && myArray[1][1] == "X" && myArray[2][2] == "X")//checks diagnols
         return true;
      else if(myArray[0][2] == "X" && myArray[1][1] == "X" && myArray[2][0] == "X")
         return true;
      else
         return false;
   }
   
   public static boolean winningO(String[][] myArray)//checks to see if O has 3 in any way
   {
      if(myArray[0][0] == "O" && myArray[0][1] == "O" && myArray[0][2] == "O")//checks rows
         return true;
      else if(myArray[1][0] == "O" && myArray[1][1] == "O" && myArray[1][2] == "O")
         return true;
      else if(myArray[2][0] == "O" && myArray[2][1] == "O" && myArray[2][2] == "O")
         return true;
         
      else if(myArray[0][0] == "O" && myArray[1][0] == "O" && myArray[2][0] == "O")//checks collunms
         return true;
      else if(myArray[0][1] == "O" && myArray[1][1] == "O" && myArray[2][1] == "O")
         return true;
      else if(myArray[0][2] == "O" && myArray[1][2] == "O" && myArray[2][2] == "O")
         return true;
         
      else if(myArray[0][0] == "O" && myArray[1][1] == "O" && myArray[2][2] == "O")//checks diagnols
         return true;
      else if(myArray[0][2] == "O" && myArray[1][1] == "O" && myArray[2][0] == "O")
         return true;
      else
         return false;
   }
	
	public static boolean Space(String[][] myArray, int row, int column)//checks if space has already been used
	{
		if(myArray[row][column] == " ")
			return true;
		else
  			return false;
	}
   
   public static int repeat(int location)
   {
      String[][] nums = { {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
			
		Scanner input = new Scanner (System.in);
			
      System.out.println();
		System.out.println("Sorry Space " + location + " is already taken");// tells them that this input is wrong
		System.out.println("Please enter a number that has not already been taken [1, 9]: ");//gives them a second chance
		display(nums);
		location = input.nextInt();
      location = Check(location);
      return location;
   }
   
   public static void TestRunAgainX(String[][] myArray, int location)
   {
      location = repeat(location);//tells user place is already filled
      Xloc(myArray, location);//runs with new number
   }
   
   public static void TestRunAgainO(String[][] myArray, int location)
   {
      location = repeat(location);//tells user place is already filled
      Oloc(myArray, location);//runs with new number
   }
}
