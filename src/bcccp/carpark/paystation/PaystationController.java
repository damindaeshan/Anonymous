package bcccp.carpark.paystation;

import bcccp.carpark.ICarpark;
import bcccp.tickets.adhoc.IAdhocTicket;

public class PaystationController 
		implements IPaystationController {
	
	private IPaystationUI ui;	
	private ICarpark carpark;

	private IAdhocTicket  adhocTicket = null;
	private float charge;
	
	 public PaystationController() {
		
	}
		
	public PaystationController(ICarpark carpark, IPaystationUI ui) {
		this.carpark = carpark;
		this.ui = ui;
	}

	@Override
	public void ticketInserted(String barcode) {
		if (state.equals(STATE.WAITING)) {
			if (carpark.isSeasonTicketValid(barcode) && !carpark.isSeasonTicketInUse(barcode)) {
				 
			}
		} else {
			ui.beep();
		}
	}

	@Override
	public void ticketPaid() {
		// If the the car has session ticket car is eligible to park.
		// It should be paid the ticket
	}

	@Override
	public void ticketTaken() {
		if (state.equals(STATE.ISSUED) || state.equals(STATE.VALIDATED)) {
			setState(STATE.TAKEN);
		} else {
			ui.beep();
		}
	}	
	
}
