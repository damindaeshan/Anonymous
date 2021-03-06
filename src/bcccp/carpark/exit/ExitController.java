//File : ExitController.java
//Course Name : ITC 515 Professional Programming Principal
//Assessment Item : Assignment 2
//Instructor Name : Recep Ulusoy
//Date : 21 August 2017
//Due on : 25 August 2017
//Student Id : 11619843
//Student Name : Gulani Senthuran

package bcccp.carpark.exit;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

/**
 * This file used to Exit the car from the car park. This file has setState method to set the state of the car park, 
 * log method used to create the log file, ticketInserted method, ticketTaken method, carEventDetected used when the car exit,
 * change the state accordingly.
 * 
 * @author 11619843
 *
 */
public class ExitController implements ICarSensorResponder, IExitController {
	
	private IGate exitGate;
	private ICarSensor insideSensor;
	private ICarSensor outsideSensor; 
	private IExitUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long exitTime;
	private String seasonTicketId = null;
	
	private enum STATE {IDLE, BLOCKED, EXITED, REJECTED, WAITING, EXITING, PROCESSED, TAKEN, ISSUED, VALIDATED, FULL }
	private STATE state;
	private STATE initState;

	/**
	 * Create ExitController constructor with five parameters.
	 * 
	 * @param carpark
	 * @param exitGate
	 * @param is
	 * @param os
	 * @param ui
	 */
	public ExitController(Carpark carpark, IGate exitGate, ICarSensor is, ICarSensor os, IExitUI ui) {
		this.carpark = carpark;
		this.exitGate = exitGate;
		this.outsideSensor = os;
		this.insideSensor = is;
		this.ui = ui;

		initState = STATE.IDLE;
		setState(STATE.IDLE);
		
	}

	/**
	 * This method used to set the state when car entering an exiting
	 * 
	 * @param idle
	 */
	private void setState(STATE newState) {
		switch (newState) {
		case BLOCKED:
			log("set State : BLOCKED");
			state = STATE.BLOCKED;
			ui.display("BLOCKED");
			break;
		case IDLE:
			log("set State : IDLE");
			state = STATE.IDLE;
			ui.display("IDLE");
			break;
		case EXITED:
			log("set State : EXITED");
			state = STATE.EXITED;
			ui.display("EXITED");
			break;
		default:
			break;
			// In-progress to do the other status
			// Need to do EXITED, REJECTED, WAITING, EXITING, PROCESSED, TAKEN, ISSUED, VALIDATED, FULL
			// status as like above
		}
	}

	/**
	 * This method used to create the log file
	 * 
	 * @param message
	 */
	private void log(String message) {
		System.out.println("Exit Controller : " + message);
	}

	/**
	 * This method is override method and used to set the status of the car park
	 * when ticket inserted.
	 */
	@Override
	public void ticketInserted(String ticketStr) {
		if (state.equals(STATE.WAITING)) {
			if (ticketStr.substring(0, 1).equals('A')) {
				adhocTicket = carpark.getAdhocTicket(ticketStr);
				if (adhocTicket != null && adhocTicket.isPaid()) {
					setState(STATE.PROCESSED);
				} else {
					setState(STATE.REJECTED);
				}
			} else if (carpark.isSeasonTicketValid(ticketStr) && carpark.isSeasonTicketInUse(ticketStr)) {
				setState(STATE.PROCESSED);
				seasonTicketId = ticketStr;
			} else {
				ui.beep();
				setState(STATE.REJECTED);
			}
		} else {
			ui.beep();
			ui.discardTicket();
			setState(STATE.REJECTED);
		}
	}

	/**
	 * This method is override method and used to set the status of the car park
	 * when ticket taken.
	 */
	@Override
	public void ticketTaken() {
		if (state.equals(STATE.PROCESSED)) {
			exitGate.raise();
			setState(STATE.TAKEN);
		} else if (state.equals(STATE.REJECTED)) {
			setState(STATE.WAITING);
		} else {
			ui.beep();
		}
	}


	/**
	 * This method used to set the status of the car park
	 * when car event is detected according to the detectedId, detected or not,
	 * inside or outside sensor Id
	 */
	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		log("Car Event Detected: " + detectorId + "Car Detected" + detected);
		switch (state) {
		case BLOCKED:
			if (detectorId.equals(insideSensor.getId()) && !detected) {
				setState(initState);
			}
			break;
		case IDLE:
			if (detectorId.equals(insideSensor.getId()) && detected) {
				setState(STATE.WAITING);
			} else if (detectorId.equals(outsideSensor.getId()) && detected) {
				setState(STATE.BLOCKED);
			}
			// In-progress to do the further development
		default:
			break;
		}
	}
	
}
