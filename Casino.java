
/*The user will be given $1000 to start and will be able to play a variety of games.
They must bet a dollar amount of money to play and can either lose their bet or win and gain some money.
They can leave the casino after each game, but will be kicked out if they run out of money.*/

//Import scanner and random class
import java.util.Scanner;
import java.util.Random;
public class Casino {
    public static void main(String[] args){

//Instantiate scanner
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);

//Declaring path and the total amount of money that the user starts with
        int path;
        int total = 1000;

//User enters name and a statement with the basic instructions of the casino will be outputted        
        System.out.print("Enter your Name: ");
        String name = reader2.nextLine();
        System.out.println("\nHi " + name +".");
        System.out.println("You have $1000. \nYou can leave the casino at any time, but you will be kicked out once you run out of money."
                + "\nPlease make your bets in positive whole number amounts. \nThanks and have a great time!");

/*The user picks a game from a menu and a switch statement is used to call different methods for each game. The total amount of money is updated
after eachgame*/
        do {
            System.out.print("\nEnter 1 to play the slot machine"
                    + "\nEnter 2 to play Numbered Card Blackjack"
                    + "\nEnter 3 to play Keno"
                    + "\nPress 4 to play Roulette of the Damned"
                    + "\nEnter 5 to leave the Casino"
                    + "\nEnter Here: ");
            path = reader.nextInt();
           
            if (path == 1){
                total += Slots(total);
                System.out.println("\nYou now have: $" + total);
            }
           
            if (path == 2){
                total += Blackjack(total);
                System.out.println("\nYou now have: $" + total);
            }
           
            if (path == 3){
                total -= Keno(total);
                System.out.println("\nYou now have: $" + total);
            }
            if (path == 4){
                total += Roulette(total);
                System.out.println("\nYou now have: $" + total);
            }
        }
        while (path != 5 && total > 0);
        System.out.println("\nGoodbye " + name + "! We hope to see you again!");
    }  

//Slots game method
    public static int Slots(int total){

//Instantiating the scanner and random class
        Scanner reader = new Scanner(System.in);
        Random gen = new Random();
       
//Declaring and initializing variables        
        int path3 = 1;
        int bet2 = 0;
        int bet3 = 0;
        int bet4 = 0;

//User chooses from a menu        
        while (path3 == 1) {
            int winLevel = 0;
            System.out.print("\nEnter 1 to place a bet and play"
                + "\nEnter 2 to see the instructions"
                + "\nEnter 3 to leave the game"
                + "\nEnter Here: ");
            int path = reader.nextInt();

//While loop is used to make sure input is one of the choices            
            while ((path < 1)||(path > 3)){
                System.out.print("\nEnter 1 to place a bet and play"
                + "\nEnter 2 to see the instructions"
                + "\nEnter 3 to leave the game"
                + "\nEnter Here: ");
                path = reader.nextInt();
            }

//If the user chooses to bet and play, they enter the amount they want to bet            
            if (path == 1){
                System.out.print("\nEnter the amount of money you would like to bet: ");
                int bet = reader.nextInt();
                System.out.print("\n");

//The wagered amount must be greater than $1 and less than or equal to the total amount of money they currently have                
                while (bet > total || bet < 1){
                    System.out.print("\nEnter the amount of money you would like to bet: ");
                    bet = reader.nextInt();
                    System.out.print("\n");
                }

//An array is created for the first slot with numbers of 1 to 10                
                int [] slot1 = new int [10];
                for (int i = 0; i < 10; i++){
                slot1 [i] = i;
                }

//An array is created for the second slot with numbers of 1 to 10                
                int [] slot2 = new int [10];
                for (int i = 0; i < 10; i++){
                    slot2 [i] = i;
                }

//An array is created for the third slot with numbers of 1 to 10                
                int [] slot3 = new int [10];
                for (int i = 0; i < 10; i++){
                    slot3 [i] = i;
                }

//The slots will be played three times using a for loop                
                for (int i = 1; i <=3; i++){
           
//3 numbers are randomly generated to be used as the index for the arrays                    
                    int one = gen.nextInt(10);
                    int two = gen.nextInt(10);
                    int three = gen.nextInt(10);

//The user must enter 1 to see the results of their slots                    
                    System.out.print("The slots are spinning. Press 1 to stop: ");
                    int spinStop = reader.nextInt();

//Check input using while loop                    
                    while (spinStop != 1){
                        System.out.print("The slots are spinning. Press 1 to stop: ");
                        spinStop = reader.nextInt();
                    }

//Once they enter 1, the slots are outputted to the user                    
                    if (spinStop == 1){
           
                        System.out.println("\n|¯¯¯¯¯¯¯¯|   |¯¯¯¯¯¯¯¯|   |¯¯¯¯¯¯¯¯|"
                           + "\n|        |   |        |   |        |"
                           + "\n|   " + slot1[one]+"    |   |   " + slot2[two]+"    |   |   " + slot3[three]+"    |"
                           + "\n|        |   |        |   |        |"
                           + "\n|________|   |________|   |________|\n");
                    }

//Depending on the numbers of the slots, the user's bet is multiplied or lost by a specific amount                    
                    if (slot1[one] == 7 && slot2[two] == 7 && slot3[three] == 7){
                        System.out.println("You got three 7s!!!");
                        winLevel += 6;
                    }
           
                    else if (slot1[one] == 7 && slot2[two] == 7 || slot1[one] == 7 && slot3[three] == 7 || slot2[two] == 7 && slot3[three] == 7 ){
                        System.out.println("You got two 7s!");
                        winLevel += 2;
                    }
           
                    else if (slot1[one] == slot2[two] && slot1[one] == slot3[three]){
                        System.out.println("You got three of the same!");
                        winLevel += 4;
                    }
           
                    else {
                        System.out.println("YOU GET NOTHING!!! :(");
                        winLevel += 0;
                    }
           
                }

//The difference between their wagered amount and ther new amount of money is calculated                
                bet2 = (bet * winLevel);
                bet4 = bet2 - bet;
               
//The while loop will end and the user will be directed to the main menu                
                path3 = 2;
            }

//If the user chooses to see the instructions, they will be outputted to them. Then, they will be directed back to the menu for the Slots game            
            else if (path == 2){
                System.out.print("\nRules"
                        + "\n¯¯¯¯¯"
                        + "\n1. It's simple. Just make a bet and you'll be able to play the slots three times."
                        + "\n2. Get two 7s and your bet will be multiplied by 2"
                        + "\n3. Get three of the same and your bet will be multiplied by 4"
                        + "\n4. Get three 7s and your bet will be multiplied by 6"
                        + "\n5. The rewards can be stacked (Example: If you get two 7s on one turn and three 7s on another, your bet will be multiplied by 8"
                        + "\n6. Getting no rewards results in you losing your wagered amount of money.\n");
            }

//If they choose to leave the game, the while loop will end and they will return to the main menu            
            else if (path == 3){
                path3 = 2;
            }
        }  
       
//The amount of money they obtained or lost will be returned to the main menu
        return bet4;    
    }
   
   
//Blackjack game method    
    public static int Blackjack(int total3){

//Instantitate the scanner and random class
        Random gen = new Random();
        Scanner reader = new Scanner(System.in);

//Declaring and Initializing variables        
        int path2 = 1;
        int path = 1;
        int bet = 0;
        int path3 = 1;

//Game is inside while loop to allow the user to return to the Blackjack menu after reading the instructions        
//A menu is displayed to the user and they can make a choice        
        while (path3 == 1){
            System.out.print("\nEnter 1 to place a bet and play"
                + "\nEnter 2 to see the instructions"
                + "\nEnter 3 to leave the game"
                + "\nEnter Here: ");
            path = reader.nextInt();

//Input is checked
            while ((path < 1)||(path > 3)){
                System.out.print("\nEnter 1 to place a bet and play"
                + "\nEnter 2 to see the instructions"
                + "\nEnter 3 to leave the game"
                + "\nEnter Here: ");
                path = reader.nextInt();
            }

//If they decide to bet and play, they can bet a dollar amount            
            if (path == 1){
                int total = 0;
                int total2 = 0;
                System.out.print("\nEnter the amount of money you would like to bet: ");
                bet = reader.nextInt();

//While loop used to make sure bet is over $1 and below or equal to the total amount of money they currently have                
                while (bet > total3 || bet < 1){
                    System.out.print("\nEnter the amount of money you would like to bet: ");
                    bet = reader.nextInt();
                }

//An array for a deck of cards is created
                int [] cardNum = new int [52];

//A random number from 1 to 13 is assigned to each element in the deck of cards array                
                for (int i = 0; i < 52 ; i++){
                    cardNum [i] = gen.nextInt(13) + 1;
                }

//2 random numbers from 0 to 52 are generated to use and indices in the arrays                
                int q = gen.nextInt(52);
                int r = gen.nextInt(52);

//If the values of the 2 card numbers total to over 21, new indices are generated                
                while (cardNum[q] + cardNum[r] > 21){
                    q = gen.nextInt(52);
                    r = gen.nextInt(52);
                }
                   
//The two cards that the user has are outputted to the user                    
                System.out.print("\nYour two cards are " + cardNum[q] + " and " + cardNum[r]);

//The total of their cards is calculated and outputted                
                total += cardNum[q];
                total += cardNum[r];
                   
                System.out.println("\nTotal: " + total);
               
//While the user's card total is below 21, they are given several options to choose from              
                while (total < 21){
                   
                    System.out.print("\nHit (Press 1)"
                                + "\nStand (Press 2)"
                                + "\nEnter Here: ");
                    int choice = reader.nextInt();
 
//The user's input is checked                    
                    while (choice < 1 || choice > 2){
                        System.out.print("\nHit (Press 1)"
                                + "\nStand (Press 2)"
                                + "\nEnter Here: ");
                        choice = reader.nextInt();
                    }

//If they choose "hit", they get another card and their total is updated                    
                    if (choice == 1){
                        q = gen.nextInt(52)+ 1;
                        System.out.print("\nYour card is " + cardNum[q] + "\n");
                        total += cardNum[q];
                    }
                   


//If they choose to stand, the computer's turn begins                    
                    if (choice == 2){
                        break;
                    }
                }
               
//If their total is 21, the computer's turn is skipped                    
                if (total == 21){
                    System.out.println("You win!");
                    path3 = 2;
                    break;
                }
                if (total > 21){
                    System.out.println("You lose!");
                    bet *=-1;
                    path3 = 2;
                    break;
                }
               
//Computers turn begins                
                if (path2 == 1){

//Random numbers are generated to be used as indices in the deck of cards array                    
                    q = gen.nextInt(52)+ 1;
                    r = gen.nextInt(52) + 1;
                   
                    if (cardNum[q] + cardNum[r] > 21){
                        q = gen.nextInt(52)+ 1;
                        r = gen.nextInt(52) + 1;
                    }
                   
//The computer's cards are outputted to the user                    
                    System.out.print("\nThe computer's cards are " + cardNum[q] + " and " + cardNum[r] + "\n");
                 
                    total2 += cardNum[q];
                    total2 += cardNum[r];
                   
//The computer continues to get cards until they can't anymore without going over 21
//Depending on who's closer to 21, different outcomes are possible and different dollar amounts are rewarded

//If the computer's total is still below 21, they will keep picking up cards until they can't anymore without going over 21
                    if (total2 <= 21){
                        while (total2 + cardNum[q] <= 21){
                            q = gen.nextInt(52)+1;
                            System.out.println("The computer chose \"Hit\"");
                            System.out.println("The computer got " + cardNum[q]);
                            total2 += cardNum[q];
                        }
                       
//If the user is still closer to 21 than the computer, the computer will pick up another card                        
                        if (21 - total2 > 21 - total){
                            q = gen.nextInt(52)+1;
                            System.out.println("The computer chose \"Hit\"");
                            System.out.println("The computer got " + cardNum[q]);
                            total2 += cardNum[q];
                        }
                    }

//Different outcomes                    
                    if (total == 21){
                        String outcome = "You Win!";
                        System.out.println(outcome);
                        break;
                    }
                       
                    else if (total2 == 21){
                        String outcome = "You Lose!";
                        System.out.println(outcome);
                        bet *= -1;
                        break;
                    }
                       
                    else if ((21 - total) > 0 && 21 - total2 < 0){
                        String outcome = "You Win!";
                        System.out.println(outcome);
                        break;
                    }
                       
                    else if ((21 - total2) > 0 && 21 - total < 0){
                        String outcome = "You Lose!";
                        System.out.println(outcome);
                        bet *= -1;
                        break;
                    }
                   
                    else if ((21 - total) < (21 - total2)){
                        String outcome = "You Win!";
                        System.out.println(outcome);
                        break;
                    }
                   
                    else if ((21 - total2) < (21 - total)){
                        String outcome = "You Lose!";
                        System.out.println(outcome);
                        bet *= -1;
                        break;
                            }
                           
                    else if ((21 - total2) == (21 - total)){
                        String outcome = "You Win!";
                        System.out.println(outcome);
                        break;
                    }
                    break;      
                }            
//While loop will end and the user will return to main menu
                path3 = 2;
            }
           
//If the user decides to see the instructions, they are outputted and they will be returned to the Blackjack menu            
            if (path == 2){
                System.out.print("\nRules"
                        + "\n¯¯¯¯¯"
                        + "\n1. To begin, you are given 2 number cards."
                        + "\n2. Then, you choose to hit or stand"
                        + "\n   Hit = Get another card"
                        + "\n   Stand = Stop picking up cards"
                        + "\n3. The goal of the game is to get a total with your cards as close to 21 without going over"
                        + "\n4. If you go over 21, you lose automatically. If you stand, the computer will start their turn"
                        + "\n5. If the computer gets closer to 21 than you, you lose."
                        + "\n6. If you win, your bet is doubled, but if you lose, you lose your entire bet"
                        + "\n7. You won't lose any money for a tie.\n");
            }
           
//If the user decides to leave the game, the while loop ends and the user will be returned to the main menu            
            if (path == 3){
                path3 = 2;
            }
        }
       
//The amount of money made/lost is returned to the main method        
        return bet;
    }

//Keno game method    
    public static int Keno(int total){
       
//Instantiate scanner and random class
        Scanner reader = new Scanner(System.in);
        Random gen = new Random();
       
//Declaring and initializing variables        
        int bet;
        bet = 0;
        int count = 0;
        int path3 = 1;

//Game is in while loop to allow the user to return to the game's menu after seeing the instructions
//The menu is displayed to the user and they make a choice
        while (path3 == 1){
            System.out.print("\nEnter 1 to place a bet and play"
                + "\nEnter 2 for the instructions"
                + "\nEnter 3 to leave the game"
                + "\nEnter Here: ");
            int path = reader.nextInt();

//Check input            
            while (path < 1 || path > 3){
                System.out.print("\nEnter 1 to place a bet and play"
                + "\nEnter 2 for the instructions"
                + "\nEnter 3 to leave the game"
                + "\nEnter Here: ");
                path = reader.nextInt();
            }

//If they choose to bet and play, they can bet a dollar amount            
            if (path == 1){
                System.out.print("\nEnter the dollar amount you would like to bet: ");
                bet = reader.nextInt();
                System.out.print("\n");
       
//If their bet is less than $1 or greater than the total money they currently have, they bet again        
                while (bet > total || bet < 1){
                    System.out.print("\nEnter the dollar amount you would like to bet: ");
                    bet = reader.nextInt();
                    System.out.print("\n");
                }

//An array is created to hold the user's 10 inputted variables                
                int [] choices = new int [10];

//User enters 10 numbers from 1-40 to fill the array                
                for (int i = 0; i < 10; i++){
                    System.out.print("Enter a number from 1 to 40: ");
                    choices[i] = reader.nextInt();
                   
                    while (choices[i] < 1 || choices[i] > 40){
                        System.out.print("\n¯\\_(⊙︿⊙)_/¯\n\n");
                        System.out.print("Please enter a number from 1 to 40: ");
                        choices[i] = reader.nextInt();
                    }
                }

//10 random numbers from 1-40 are generated and outputted to the user                
                int [] comp = new int [10];
                System.out.println("\nThe random numbers chosen are: ");
           
                for (int i = 0; i < 10; i++){
                    comp[i] = gen.nextInt(40) + 1;
                    if (i >=0 && i <= 8){
                        System.out.print(comp[i] + ", ");
                    }
               
                    if (i == 9){
                        System.out.print(comp[i]);
                    }
                }
           
                for (int i = 0; i < 10; i++){
                    for (int p = 0; p < 10; p ++){
                        if (choices[i] == comp[p]){
                            count ++;
                        }
                    }
                }

//The amount of numbers the user matched are outputted to the user                
                System.out.println("\n\nYou matched a total of " + count + " number(s)");

//Depending on the amount of numbers matched, they make different amounts of money.                
                if (count >=2 && count < 4){
                    bet *= -1;
                }
                if (count >=4 && count < 6){
                    bet *= -2;
                }
                if (count >=6 && count < 8){
                    bet *= -3;
                }
                if (count >= 8 && count < 10){
                    bet *= -4;
                }
                if (count == 10){
                    bet *= -5;
                }
                else {
                    bet *= 1;
                }
               
//The while loop ends and the user returns to main menu                
                path3 = 2;
            }

//If the user decides to see the intructions, they are outputted to them and they return to game's menu            
            if (path == 2){
                System.out.print("\nRules"
                        + "\n¯¯¯¯¯"
                        + "\n1. To begin, you choose 10 numbers ranging from 1 to 40."
                        + "\n2. Then, 10 more numbers from 1 to 40 are randomly generated"
                        + "\n3. Depending on the amount of numbers you are able to match, your bet is multiplied accordingly"
                        + "\n4. 2 to 3 matched numbers = You obtain a dollar amount equal to your bet"
                        + "\n5. 4 to 5 matched numbers = You obtain a dollar amount 2 times your bet"
                        + "\n6. 6 to 7 matched numbers = You obtain a dollar amount 3 times your bet"
                        + "\n7. 8 to 9 matched numbers = You obtain a dollar amount 4 times your bet"
                        + "\n8. 10 matched numbers = You obtain a dollar amount 5 times your bet\n");  
            }

//If they choose to leave the game, the while loop ends and they return to main menu            
            if (path == 3){
                path3 = 2;
            }
       
        }

//The amount of money gained/lost is returned to main method
        return bet;
    }
   
//Roulette game method
    public static int Roulette(int total){
       Scanner reader = new Scanner(System.in);
       Random gen = new Random();
       int path3 = 1;
       int beteven = 0;
       int betodd = 0;
       int betnum = 0;
       int choice2 = 1;
       int bet1 = 0;
       int choice = 0;
       int num = 37;
       int money = 0;
       int count = 0;
       int betColour = 0;

//User chooses from Roulette menu and the input is checked      
       while (path3 == 1) {
           System.out.print("\nEnter 1 to make a bet: "
                   + "\nEnter 2 to see the instructions: "
                   + "\nEnter 3 to leave the game: "
                   + "\nEnter Here: ");
           int path = reader.nextInt();
           
            while (path < 1 || path > 3){
                System.out.print("\nEnter 1 to make a bet: "
                   + "\nEnter 2 to see the instructions: "
                   + "\nEnter 3 to leave the game: "
                   + "\nEnter Here: ");
                path = reader.nextInt();
           }

//If they choose to bet, they are sent to a menu where they choose what to bet on            
           if (path == 1){
 
//Do while loop allows user to bet on multiple things  
//User cannot bet on the same choice twice
               do {
                   System.out.print("\nEnter 1 to bet on even/odd (2x bet)"
                           + "\nEnter 2 to make a bet on the number (4x bet)"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                   int betChoice = reader.nextInt();
                   
                   while (betChoice < 1 || betChoice > 3){
                       System.out.print("\nEnter 1 to bet on even/odd (2x bet)"
                           + "\nEnter 2 to make a bet on the number (4x bet)"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                       betChoice = reader.nextInt();
                   }
                   
                   while ((betChoice == 1) && (beteven > 0 || betodd > 0)){
                       System.out.print("\nEnter 1 to bet on even/odd (2x bet)"
                           + "\nEnter 2 to make a bet on the number (4x bet)"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                       betChoice = reader.nextInt();
                       
                       while (betChoice < 1 || betChoice > 3){
                       System.out.print("\nEnter 1 to bet on even/odd (2x bet)"
                           + "\nEnter 2 to make a bet on the number (4x bet)"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                       betChoice = reader.nextInt();
                       }
                   }
                   
                   while ((betChoice == 2) && (betnum > 0)){
                       System.out.print("\nEnter 1 to bet on even/odd"
                           + "\nEnter 2 to make a bet on the number"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                       betChoice = reader.nextInt();
                       
                       while (betChoice < 1 || betChoice > 3){
                       System.out.print("\nEnter 1 to bet on even/odd (2x bet)"
                           + "\nEnter 2 to make a bet on the number (4x bet)"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                       betChoice = reader.nextInt();
                       }
                   }
                   
                   while ((betChoice == 3) && (betColour > 0)){
                       System.out.print("\nEnter 1 to bet on even/odd "
                           + "\nEnter 2 to make a bet on the number"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                       betChoice = reader.nextInt();
                       
                       while (betChoice < 1 || betChoice > 3){
                       System.out.print("\nEnter 1 to bet on even/odd (2x bet)"
                           + "\nEnter 2 to make a bet on the number (4x bet)"
                           + "\nEnter 3 to make a bet on the colour"
                           + "\nEnter Here: ");
                       betChoice = reader.nextInt();
                       }
                   }

//Even/odd bets                  
                   if (betChoice == 1){
                       System.out.print("\nEnter 1 to bet on even"
                               + "\nEnter 2 to bet on odd"
                               + "\nEnter Here: ");
                       bet1 = reader.nextInt();
                       
                       while (bet1 < 1 || bet1 > 2){
                            System.out.print("\nEnter 1 to bet on even"
                               + "\nEnter 2 to bet on odd"
                               + "\nEnter Here: ");
                            bet1 = reader.nextInt();
                       }
                       
                       if (bet1 == 1){
                           System.out.print("\nEnter how much you would like to bet: ");
                           beteven = reader.nextInt();
                           
                           while (beteven + betnum + betColour > total  || beteven < 1){
                                System.out.print("\nEnter how much you would like to bet: ");
                                beteven = reader.nextInt();
                           }
                       }
                       
                       if (bet1 == 2){
                           System.out.print("\nEnter how much you would like to bet: ");
                           betodd = reader.nextInt();
                           
                           while (betodd + betnum + betColour > total || betodd < 1){
                                System.out.print("\nEnter how much you would like to bet: ");
                                betodd = reader.nextInt();
                           }
                       }
                   }
 
//Specific number bets                  
                   if (betChoice == 2){
                       System.out.print("\nEnter the number from 0 to 36: ");
                       num = reader.nextInt();
                       
                       while (num < 0 || num > 36){
                            System.out.print("\nEnter the number from 0 to 36: ");
                            num = reader.nextInt();
                       }
                       
                       System.out.print("\nEnter how much you would like to bet: ");
                       betnum = reader.nextInt();
                       
                       while (beteven + betodd + betnum + betColour > total || betnum < 1){
                            System.out.print("\nEnter how much you would like to bet: ");
                            betnum = reader.nextInt();
                       }
                   }
     
//Colour bets                  
                   if (betChoice == 3){
                       System.out.print("\nEnter 1 to bet on green (3x bet)"
                               + "\nEnter 2 to bet on red (2x bet)"
                               + "\nEnter 3 to bet on black (2x bet)"
                               + "\nEnter Here: ");
                       choice = reader.nextInt();
                       
                       while (choice < 1 || choice > 3){
                           System.out.print("\nEnter 1 to bet on green (3x bet)"
                               + "\nEnter 2 to bet on red (2x bet)"
                               + "\nEnter 3 to bet on black (2x bet)"
                               + "\nEnter Here: ");
                           choice = reader.nextInt();
                       }
                       
                        if (choice == 1){
                           System.out.print("\nEnter how much you would like to bet: ");
                            betColour = reader.nextInt();
                           
                            while (beteven + betodd + betnum + betColour > total || betColour < 1){
                                System.out.print("\nEnter how much you would like to bet: ");
                                betColour = reader.nextInt();
                            }
                        }
                       
                        if (choice == 2){
                           System.out.print("\nEnter how much you would like to bet: ");
                            betColour = reader.nextInt();
                           
                            while (beteven + betodd + betnum + betColour > total || betColour < 1){
                                System.out.print("\nEnter how much you would like to bet: ");
                                betColour = reader.nextInt();
                            }
                        }
                       
                        if (choice == 3){
                           System.out.print("\nEnter how much you would like to bet: ");
                            betColour = reader.nextInt();
                           
                            while (beteven + betodd + betnum + betColour > total || betColour < 1){
                                System.out.print("\nEnter how much you would like to bet: ");
                                betColour = reader.nextInt();
                            }
                        }
                    }
 
//If the user bets on 3 sections or reaches a total bet equal to the amount of money they have, the loop is broken                  
                   count ++;
                   if (count == 3){
                       break;
                   }
                   if (betColour + betnum + beteven + betodd == total){
                       break;
                   }
                   
//User can continue with the game or make another bet                  
                   System.out.print("\nEnter 1 to make another bet and another integer to see your fate: ");
                   choice2 = reader.nextInt();
                }
                while (choice2 == 1);

//A random colour and number are generated              
               int randNum = gen.nextInt(37);
               String [] colours = new String [100];

/*To make different colours more likely, all even numbers that are not multiples of 10 are black.
All odd numbers are red. All multiples of 10 are green*/
               for (int i = 0; i < 100; i ++){
                   if ((i % 2 == 0) && ((i/10) % 2 != 0)){
                       colours[i] = "black";
                   }
                   if ((i % 2 != 0) && ((i/10) % 2 != 0)){
                       colours[i] = "red";
                   }
                   if (((i/10) % 2 == 0)){
                       colours[i] = "green";
                   }
               }
               
               int colourNum = gen.nextInt(100);

//The random colour and number are outputted              
               System.out.println("\nYou have gotten a " + colours[colourNum] + " " + randNum);

//Depending on the bets made and the outputted colour and number,the bet is multiplied accordingly              
               if (bet1 == 1 && randNum % 2 == 0){
                   System.out.println("You matched even!");
                   beteven*=1;
                   money += beteven;
               }
               if (bet1 == 2 && randNum % 2 != 0){
                   System.out.println("You matched odd!");
                   betodd *=1;
                   money += betodd;
               }
               if (num == randNum){
                   System.out.println("You matched the number!");
                   betnum *=4;
                   money += betnum;
               }
               if (choice == 1 && colours[colourNum].equals("green")){
                   System.out.println("You matched green!");
                   betColour*=3;
                   money += betColour;
               }
               if (choice == 2 && colours[colourNum].equals("red")){
                   System.out.println("You matched red!");
                   betColour*=1;
                   money += betColour;
               }
               if (choice == 3 && colours[colourNum].equals("black")){
                   System.out.println("You matched black!");
                   betColour*=1;
                   money += betColour;
               }
               if (bet1 == 1 && randNum % 2 != 0){
                   System.out.println("You didn't match even");
                   beteven*=-1;
                   money += beteven;
               }
               if (bet1 == 2 && randNum % 2 == 0){
                   System.out.println("You didn't match odd");
                   betodd *=-1;
                   money += betodd;
               }
               if ((betnum > 0) && (num != randNum)){
                   System.out.println("You didn't match the number");
                   betnum *=-1;
                   money += betnum;
               }
               if (choice == 1 && !colours[colourNum].equals("green")){
                   System.out.println("You didn't match the colour");
                   betColour*=-1;
                   money += betColour;
               }
               if (choice == 2 && !colours[colourNum].equals("red")){
                   System.out.println("You didn't match the colour");
                   betColour*=-1;
                   money += betColour;
               }
               if (choice == 3 && !colours[colourNum].equals("black")){
                   System.out.println("You didn't match the colour");
                   betColour*=-1;
                   money += betColour;
               }

//User returns to main menu              
               path3 = 2;
               }

//If user chooses to see instructions, they are outputted          
           if (path == 2){
               System.out.print("\nRules"
                              + "\n¯¯¯¯¯"
                        + "\n1. Place one bet or more on either"
                       +  "\n   I) A colour (Black, Red or Green),"
                        + "\n   II)A specific number(0-36)"
                        + "\n   III) Whether the number will be even/odd"
                        + "\n2. Then roll your number to see if you have won or lost money.\n");
//The user returns to the game menu              
           }

//If the user decides to leave the game, the user is returned to the main menu          
           if (path == 3){
               path3 = 2;
           }
           
        }
       
//The amount of money made/lost is returned to the main method      
        return money;
    }
}