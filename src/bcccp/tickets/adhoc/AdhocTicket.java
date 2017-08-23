package bcccp.tickets.adhoc;

/*
    Full Name : Jayasinghalage Pradeep Lakshitha
    CSU ID    : 11617040
    Subject   : Professional Programming Practice

    Brief Description of the program :

    This is the AdhocTicket java class of the Barchester City Council Car Park System.
    This program will issue tickets for casual capark users.


    Assignment No. 2

*/

import java.util.Date;

public class AdhocTicket implements IAdhocTicket {
	
	//Start - Variable Declaration 
	private String carparkId;
	private int ticketNo;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;
	//End - Variable Declaration

	//Define an enum
	private enum TICKET_STATE {Ticket_Issued, Car_Parked, Ticket_Paid, Car_Exited}

	//Define an enum variable
    	private TICKET_STATE ticket_State;
	
	//Overrided constructor 
	public AdhocTicket(String carparkId, int ticketNo, String barcode) {
		this.carparkId = carparkId;
        	this.ticketNo = ticketNo;
        	this.barcode = barcode;
		this.ticket_State = TICKET_STATE.Ticket_Issued;
	}


	//This overrided method will return the ticket no 
	public int getTicketNo() {
		return this.ticketNo;
	}


	//This overrided method will return the barcode 
	public String getBarcode() {
		return this.barcode;
	}


	//This overrided method will return the car park id
	public String getCarparkId() {
		return this.carparkId;
	}


	//This overrided method will set the entry date and time
	public void enter(long dateTime) {
		this.entryDateTime = dateTime;
		
	}


	//This overrided method will return the entry date and time 
	public long getEntryDateTime() {
		Date d = new Date();
		return d.getTime();
	}


	//This overrided method will return the status
	public boolean isCurrent() {
		return entryDateTime > 0 && paidDateTime == 0;
	}


	//This overrided method will set the payment
	public void pay(long dateTime, float charge) {
		paidDateTime = dateTime;

    		this.charge = charge;
		
	}


	//This overrided method will return the paid date and time
	public long getPaidDateTime() {
		return this.paidDateTime;
	}


	//This overrided method will return the paid status
	public boolean isPaid() {
		return paidDateTime > 0;
	}


	//This overrided method will return the charge
	public float getCharge() {
		return this.charge;
	}


	//This overrided method will set the exit date and time
	public void exit(long dateTime) {
		exitDateTime = dateTime;
		
	}


	//This overrided method will return the exit date and time
	public long getExitDateTime() {
		return this.exitDateTime;
	}


	//This overrided method will return the status of exit
	public boolean hasExited() {
		return exitDateTime > 0;
	}

	
	
}
