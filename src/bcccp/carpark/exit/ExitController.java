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

public class ExitController 
		implements ICarSensorResponder,
		           IExitController {
	
	private IGate exitGate;
	private ICarSensor insideSensor;
	private ICarSensor outsideSensor; 
	private IExitUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long exitTime;
	private String seasonTicketId = null;
	
	

	public ExitController(Carpark carpark, IGate exitGate, 
			ICarSensor is,
			ICarSensor os, 
			IExitUI ui) {
		this.carpark = carpark;
		this.exitGate = exitGate;
		this.outsideSensor = os;
		this.insideSensor = is;
		this.ui = ui;
		
	}



	@Override
	public void ticketInserted(String ticketStr) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		
	}

	
	
}
