package src;


//Note that we are implementing the behavior that are
// appropriate for the HasQuarterState we are in. In some cases, 
// this behavior includes moving the GumballMachine to
// a new state.
public class HasQuarterState implements State { 

	GumballMachine machine;

	// we get passed a reference to the GumballMachine through the constructor. 
	// We just stash this in an instance variable.
	public HasQuarterState(GumballMachine machine) {
		this.machine = machine; 
	}


	// If someone tries to insert another quarter when the Gumball Machine already has a 
	// quarter in it, we print out a messeage saying you can't insert another quarter 
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
		machine.setState(machine.getHasQuarterState()); 
	}

	// Your quarter is being returned
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		machine.setState(machine.getNoQuarterState());

	}

	// turn the crank with the quarter
	public void turnCrank() {
		System.out.println("You turned");

	}

	// dispense gumball
	public void dispense() {
		machine.setState(machine.getSoldState());
	} 

}
