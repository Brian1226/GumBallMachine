/*
Design a Gumball Vending machine with the following specifications.
Machine has two types of gumballs : Red and Yellow. Red ones are worth a nickel and Yellow ones a dime.
Customer can insert only nickel, dimes or quarters as valid currency. Anything other than that is returned on the push of the dispenses lever.
There are two levers Red and Yellow to dispense respective type of gumballs.
Customer can insert multiple coins until he chooses to hit on the dispenser lever.
Machine vends a single gumball at a time. 
Customer can enter a quarter, choose to dispense two Red gumballs( by hitting the red gumball dispenser lever twice) and hit a "Return My Change" lever to receive the 15 cents in return.
**Assume the machine holds unlimited gumballs and unlimited change of currency to return.
*/

package machines;

import java.util.Scanner;

public class GumBallMachine {

	// Coin types worth
	static final String Nickel = "5";
	static final String Dime = "10";
	static final String Quarter = "25";

	// Gumball cost
	static final String Red_gum_cost = Nickel;
	static final String Yellow_gum_cost = Dime;

	// Amount of money in the machine
	public int balance;

	// Scanner
	Scanner scan = new Scanner(System.in);

	/**
	 * Enter coins into the gumball machine and increase the balance
	 * 
	 * @param N/A
	 * @return N/A
	 */
	public void enterCoin() {
		boolean done = false;
		System.out.println("Insert into machine a Nickel(\"5\"), Dime(\"10\") or Quarters(\"25\") or Exit(\"E\")");
		while (!done) {
			String moneyTemp = scan.nextLine();
			if (moneyTemp.equals(Nickel) || moneyTemp.equals(Dime) || moneyTemp.equals(Quarter)) // only 5, 10, and 25
																								// are allowed
			{
				balance += Integer.parseInt(moneyTemp); // add money to total balance
				System.out.println(moneyTemp + "¢ inserted. Total balance: " + balance + "¢\n");
				System.out.println(
						"Insert into machine a Nickel(\"5\"), Dime(\"10\") or Quarters(\"25\") or Exit(\"E\")");
			} else if (moneyTemp.equals("E") || moneyTemp.equals("e")) // exit insert coin mode
			{
				done = true;
				System.out.println("\nInsert coins (\"I\") or dispense gumballs (\"D\") or Exit(\"E\")");
			} else {
				try {
					// if coin inserted is not 5, 10, or 25 return it
					System.out.println("Coin not accepted. Change returned: " + Integer.parseInt(moneyTemp)
							+ "¢. Please try again\n");
					System.out.println(
							"Insert into machine a Nickel(\"5\"), Dime(\"10\") or Quarters(\"25\") or Exit(\"E\")");
				} catch (Exception e) {
					// invalid actions
					System.out.println("Invalid action. Please try again\n");
					System.out.println(
							"Insert into machine a Nickel(\"5\"), Dime(\"10\") or Quarters(\"25\") or Exit(\"E\")");
				}
			}
		}
	}

	/**
	 * Dispense gumball from the machine and decrease the balance
	 * 
	 * @param N/A
	 * @return N/A
	 */
	public void dispenseGumball() {
		boolean done = false;
		System.out.println("Pick a Gumball color: Red(\"R\") cost 5¢, Yellow(\"Y\") cost 10¢. Exit(\"E\")");
		while (!done) {
			String action = scan.nextLine();
			if (action.equals("r") || action.equals("R")) // pick red color gumball (cost 5¢)
			{
				if (balance >= Integer.parseInt(Red_gum_cost)) {
					balance -= Integer.parseInt(Red_gum_cost); // subtract from balance
					System.out.println("Red gumball dispensed. Leftover balance: " + balance + "¢\n");
					System.out.println("Pick a Gumball color: Red(\"R\") cost 5¢, Yellow(\"Y\") cost 10¢. Exit(\"E\")");
				} else {
					// not enough money in balance
					System.out.println("Not enough balance. Please insert more money.\n");
					System.out.println("Pick a Gumball color: Red(\"R\") cost 5¢, Yellow(\"Y\") cost 10¢. Exit(\"E\")");
				}
			} else if (action.equals("y") || action.equals("Y")) // pick yellow color gumball (cost 10¢)
			{
				if (balance >= Integer.parseInt(Yellow_gum_cost)) {
					balance -= Integer.parseInt(Yellow_gum_cost); // subtract from balance
					System.out.println("Yellow gumball dispensed. Leftover balance: " + balance + "¢\n");
					System.out.println("Pick a Gumball color: Red(\"R\") cost 5¢, Yellow(\"Y\") cost 10¢. Exit(\"E\")");
				} else {
					// not enough money in balance
					System.out.println("Not enough balance. Please insert more money.\n");
					System.out.println("Pick a Gumball color: Red(\"R\") cost 5¢, Yellow(\"Y\") cost 10¢. Exit(\"E\")");
				}
			} else if (action.equals("E") || action.equals("e")) // exit gumball dispensing mode
			{
				done = true;
				System.out.println("\nInsert coins (\"I\") or dispense gumballs (\"D\") or Exit(\"E\")");
			} else {
				// invalid action
				System.out.println("Invalid action. Please try again\n");
				System.out.println("Pick a Gumball color: Red(\"R\") cost 5¢, Yellow(\"Y\") cost 10¢. Exit(\"E\")");
			}
		}
	}

	/**
	 * Gumball machine that is able to accept currencies (coins) and dispense
	 * gumballs
	 * 
	 * @param N/A
	 * @return N/A
	 */
	public void gumball() {
		boolean done = false;
		System.out.println("Insert coins (\"I\") or dispense gumballs (\"D\") or Exit(\"E\")");
		while (!done) {
			String action = scan.nextLine();
			if (action.equals("i") || action.equals("I")) // insert coin mode
			{
				System.out.println("");
				enterCoin();
			} else if (action.equals("d") || action.equals("D")) // dispense gumball mode
			{
				System.out.println("");
				dispenseGumball();
			} else if (action.equals("e") || action.equals("E")) // stop using the gumball machine
			{
				System.out.println("Exited Gumball Machine");
				return;
			} else {
				// invalid action
				System.out.println("Invalid action. Please try again\n");
				System.out.println("Insert coins (\"i\") or dispense gumballs (\"d\") or Exit(\"E\")");
			}
		}
		scan.close();
	}

	public static void main(String[] args) {
		GumBallMachine gum = new GumBallMachine();
		gum.gumball();
	}
}
