package src;


//Note that we are implementing the behavior that are
//appropriate for the SoldState we are in. In some cases, 
//this behavior includes moving the GumballMachine to
//a new state.
public class SoldState implements State{

	GumballMachine machine;


	// We get passed a reference to the GumballMachine through the constructor. 
	// We just stash this in an instance variable.
	public SoldState(GumballMachine machine) {
		this.machine = machine; 
	}

	// When user inserts quarter, we print a message saying you inserted a quarter. Sets the state of the
	// machine to HasQuarterState.
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		machine.setState(machine.getHasQuarterState()); 
	}

	// Lets user know that they haven't inserted a quarter. Sets the state of the machine to no quarter.
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
		machine.setState(machine.getNoQuarterState());
	}


	// Turning crank
	public void turnCrank() {
		System.out.println("You turned ...");


	}

	// Dispensing gumball, setting the machine state to sold state.
	public void dispense() {
		machine.setState(machine.getSoldState());
	}

}
