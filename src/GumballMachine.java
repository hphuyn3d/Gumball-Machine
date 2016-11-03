package src;
import java.util.Random;
/**
 * 
 * @author Alex Bindas & Hung Huynh 
 * 11/2/16
 * 
 */
public class GumballMachine {
	// Here are all the states again 
	private State soldOutState; 
	private State noQuarterState; 
	private State hasQuarterState; 
	private State soldState;
	private State winnerState;

	// and the current state of the machine
	private State currentState = soldOutState;

	// count holds the number of gumballs. Initially the 
	// machine is empty
	int count = 0;

	/** constructor takes the initial number of gumballs
	 * and stores it in the instance variable.
	 * It also creates the State instances, one of each
	 * @param numberGumballs the initial count of gumballs 
	 */
	public GumballMachine(int numberGumballs) {
		
		// if there are more than 0 gumballs, we set the state
		// to the NoQuarterState
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		
		this.count = numberGumballs;
		
		if (count > 0){
			currentState = noQuarterState;
		}
		
	}

	// Actions are very easy to implement now. We just delegate 
	// to the current state
	public void insertQuarter() {
		currentState.insertQuarter();
	}

	public void ejectQuarter() { 
		currentState.ejectQuarter();
	}

	// Note that we don't need an action method for
	// dispense() in GumballMachine because it is just an
	// internal action; a user cannot ask the machine
	// to dispense directly. But we do call dispense()
	// on the State object from the turnCrank() method.
	public void turnCrank() {
		
		Random generator = new Random();
		int winner = generator.nextInt(10);
	
		if (count == 0){
			currentState.turnCrank();
			currentState = soldOutState;
			currentState.dispense();
		}
		
		else if (winner == 3 && count > 1){
			currentState.turnCrank();
			currentState = winnerState;
			currentState.dispense();
			this.releaseBall();
			this.releaseBall();
		}
		
		else if (winner == 3 && count == 1){
			currentState.turnCrank();
			currentState = winnerState;
			currentState.dispense();
			this.releaseBall();
			System.out.println("Oops ran out! You won't get your other winning gumball");
		}
		
		else if (currentState == noQuarterState){
			currentState.turnCrank();
			currentState.dispense(); 
		}
		
		else {
		currentState.turnCrank();
		currentState.dispense(); 
		this.releaseBall();
		}
	}


	public void setState(State s) { 
		currentState = s;
	}

	// this is a helper method that releases the ball and
	// decrements the count instance variable
	public void releaseBall() {
		System.out.println("A gumball comes rolling out of the slot..."); 
		if (count != 0)
			count--; 
	}

	public int getCount() { 
		return count;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getSoldState() { 
		return soldState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getWinnerState() { 
		return winnerState;
	}

	public String toString() {
		String s = "\nMighty Gumball, Inc.\n";
		s += "Java enabled Standing Gumball Model #2016\n";
		s += "Inventory: " + count + " gumballs\n";
		if (count == 0)
			s += "Machine is sold out\n";
		else
			s += "Machine is waiting for quarter\n"; return s;
		} 
	}