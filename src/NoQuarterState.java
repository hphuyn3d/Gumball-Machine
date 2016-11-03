package src;

// Note that we are implementing the behavior that are
// appropriate for the NoQuarterState we are in. In some cases, 
// this behavior includes moving the GumballMachine to
// a new state.
public class NoQuarterState implements State { 

	GumballMachine machine;

	// we get passed a reference to the GumballMachine through the constructor. 
	// We just stash this in an instance variable.
	public NoQuarterState(GumballMachine machine) {
		this.machine = machine; 
	}


	// If someone inserts a quarter, we print a message saying that the quarter was accepted, and then change the
	// machine's state to HasQuarterState
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		machine.setState(machine.getHasQuarterState() ); 
	}

	// you can't get money back if you never gave it to us!
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	// you can't get a gumball if you don't pay us
	public void turnCrank() {
		System.out.println("You turned, but there is no quarter");
	}

	// we can't be dispensing gumballs without payment
	public void dispense() {
		System.out.println("You need to pay first");
	} 

}
