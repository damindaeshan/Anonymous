package bcccp.tickets.adhoc;

import java.util.List;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private IAdhocTicketFactory factory;
	private int currentTicketNo;

	//Declaration of the list variable
	private List<IAdhocTicket> issued_Adhoc_Tickets;
	
	//This is the constructor of this class and this will create an arraylist
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		this.issued_Adhoc_Tickets = new ArrayList<IAdhocTicket>();
		this.factory = factory;
                this.currentTicketNo = 0;
	}



	@Override
	public IAdhocTicket createTicket(String carparkId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
