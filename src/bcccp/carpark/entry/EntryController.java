//File : EntryController.java
//Course Name : ITC 515 Professional Programming Principal
//Assessment Item : Assignment 2
//Instructor Name : Recep Ulusoy
//Date : 21 August 2017
//Due on : 25 August 2017
//Student Id : 11619843
//Student Name : Gulani Senthuran

package bcccp.carpark.entry;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

/**
 * This file used to Enter the car from the car park. This file has setState method to set the state of the car park, 
 * log method used to create the log file, ticketInserted method, ticketTaken method, carEventDetected method, 
 * buttonPushed method, notifyCarparkEvent method used when the car exit,
 * change the state accordingly.
 * 
 * @author 11619843
 *
 */
public class EntryController 
		implements ICarSensorResponder,
				   ICarparkObserver,
		           IEntryController {
	
	private IGate entryGate;
	private ICarSensor outsideSensor; 
	private ICarSensor insideSensor;
	private IEntryUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long entryTime;
	private String seasonTicketId = null;

	private enum STATE {IDLE, BLOCKED, EXITED, REJECTED, WAITING, EXITING, PROCESSED, TAKEN, ISSUED, VALIDATED, FULL}
	private STATE state;
	private STATE initState;

	public EntryController(Carpark carpark, IGate entryGate, 
			ICarSensor os, 
			ICarSensor is,
			IEntryUI ui) {
		this.carpark = carpark;
		this.entryGate = entryGate;
		this.outsideSensor = os;
		this.insideSensor = is;
		this.ui = ui;
		
	}



	@Override
	public void buttonPushed() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketInserted(String barcode) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void notifyCarparkEvent() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method used to create the log file
	 * 
	 * @param message
	 */
	private void log(String message) {
		System.out.println("Exit Controller : " + message);
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		
	}

}
