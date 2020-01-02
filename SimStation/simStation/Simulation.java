package simStation;

import framework.Model;

abstract public class Simulation extends Model implements Runnable {
	protected String simName;
	protected Long simClk = 0L;
	protected SimState simState = SimState.READY;
	private Thread simThread;

	public Simulation() { //simulation constructor
		simThread = new Thread(this); //create a new thread
	}

	@Override
	public void run() { //run method
		if (simState == SimState.READY || simState == SimState.STOPPED || simState == SimState.SUSPENDED) { //if the state is Ready, stopped, or suspended
			SimState currentState = simState; //set the current state
		}
		while (simState == SimState.RUNNING) { //while the thread is running
			this.update(); //update
			simClk = simClk + 1; //increment the clock
			this.changed(); //set changed
			try { //try
				simThread.sleep(20); //sleep the thread 
				synchronized(this) { //synchronized
					while(simState == SimState.SUSPENDED) { //while the simulation is suspended
						try { //try
							this.wait(); //wait
						} catch(InterruptedException ie) { //catch the exception
							System.out.println(ie.getMessage()); //print the error message
						}
					} 
				}
			} catch (InterruptedException ie) { //catch the exception
				ie.printStackTrace(); //print the stack trace
			}
		}
	}

	public void start() { //start method
		if (simState == SimState.READY) { //if the state is ready
			simState = SimState.RUNNING; //set the state to running
			simThread.start(); //start the thread
		} else { //else
			simState = SimState.READY; //set the state to ready
		}
	}

	public void stop() { //stop method
		if (simState == SimState.RUNNING) {  //if the state is running
			simState = SimState.STOPPED; //set the state to stopped
			simThread.stop(); //stop the thread
		} else { //else
			simState = SimState.RUNNING; //set the sim state to running
		}
		if (simState == SimState.SUSPENDED) { //if the state is suspended
			simState = SimState.STOPPED; //set the state to stopped
			simThread.stop(); //stop the thread
		} else { //else
			simState = SimState.RUNNING; //set the state to running
		}
	}

	public void suspend() { //suspend method
		if (simState == SimState.RUNNING) { //if teh state is running
			simState = SimState.SUSPENDED; //set the state to suspended
			simThread.suspend(); //suspend the thread
		} else { //else
			simState = SimState.RUNNING; //set the state to running
		}
	}

	public void resume() { //resume method
		if (simState == SimState.SUSPENDED) { //if the state is suspended
			simState = SimState.RUNNING; //set the state to running
			simThread.resume(); //resume the thread
		} else { //else
			simState = SimState.SUSPENDED; //set the state to suspended
		}
	}

	public Long getSimulationClock() { //get clock method
		return this.simClk; //return the clock
	}
	
	abstract public void update(); //abstract update method
}