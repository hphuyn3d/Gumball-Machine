package src;


//Note that we are implementing the behavior that are
// appropriate for the SoldOutState we are in. In some cases, 
// this behavior includes moving the GumballMachine to
// a new state.
public class SoldOutState implements State{

	GumballMachine machine;


	// We get passed a reference to the GumballMachine through the constructor. 
	// We just stash this in an instance variable.
	public SoldOutState(GumballMachine machine) {
		this.machine = machine; 
	}

	// Denies user of inserting a quarter when the machine is out of gumballs
	// Sets state of machine to NoQuarterState
	public void insertQuarter() {
		System.out.println("You can't insert a Quarter, the machine is sold out of gumballs!");
		machine.setState(machine.getNoQuarterState()); 
	}

	// You can't get your money back if you never gave it to us! 
	public void ejectQuarter() {
		System.out.println("You never inserted a quarter because the machine is sold out");

	}

	// You can't get a gumball becuase there are no more gumballs left
	public void turnCrank() {
		System.out.println("You turned but there are no gumballs");
	}

	// No gumballs to dispense
	public void dispense() {
		System.out.println("Sorry out of gumballs.");
	}

}
