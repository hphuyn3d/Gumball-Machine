package src;
// Importing random number generator to pick winner.
import java.util.Random;


//Note that we are implementing the behavior that are
//appropriate for the SoldOutState we are in. In some cases, 
//this behavior includes moving the GumballMachine to
//a new state.
public class WinnerState implements State {

	GumballMachine machine;


	// We get passed a reference to the GumballMachine through the constructor. 
	// We just stash this in an instance variable.
	public WinnerState(GumballMachine machine) {
		this.machine = machine; 
	}


	// If someone inserts a quarter we print a message saying "You inserted a quarter". 
	// Sets the state of the machine to HasQuarterState.
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		machine.setState(machine.getHasQuarterState()); 
	}


	// Prints out a mesage telling user that they haven't inserted a quarter when they try to eject it.
	// Sets the state of the machine to NoQuarterState
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
		machine.setState(machine.getNoQuarterState());
	}

	// Turn crank for gumball. Uses a random number generator from 1-10 to see if the user is the lucky winner.
	public void turnCrank() {
		Random generator = new Random();
		int winner = generator.nextInt(10);
		System.out.println(winner);
		System.out.println("You turned ...");


	}


	// If the user is the lucky winner, we print out a message telling them that 
	// they won two gumballs. Sets the machine state to SoldState.
	public void dispense() {
		System.out.println("YOU'RE A WINNER!! You get 2 gumballs.");
		machine.setState(machine.getSoldState());

	}

}
