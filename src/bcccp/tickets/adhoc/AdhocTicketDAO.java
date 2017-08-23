package bcccp.tickets.adhoc;

/*
    Full Name : Jayasinghalage Pradeep Lakshitha
    CSU ID    : 11617040
    Subject   : Professional Programming Practice

    Brief Description of the program :

    This is the AdhocTicketDAO java class of the Barchester City Council Car Park System.
    This class contains an overrided constructor and three methods such as
    createTicket(), findTicketByBarcode() and getCurrentTickets().
    createTicket() method will create a ticket using carparkId and 
    findTicketByBarcode() method will use to search generated ticket by 
    using barcode. Also getCurrentTickets() method will return the generated tickets.


    Assignment No. 2

*/

import java.util.List;
import java.util.ArrayList;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private IAdhocTicketFactory factory;
	private int currentTicketNo;

	//Declaration of the list variable
	private List<IAdhocTicket> issued_Adhoc_Tickets;
	
	//This is the constructor of this class and this will create an arraylist
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		this.issued_Adhoc_Tickets = new ArrayList<IAdhocTicket>();
		this.factory = factory;
                this.currentTicketNo = 1;
	}



	@Override
	public IAdhocTicket createTicket(String carparkId) {
		
		IAdhocTicket ticket = factory.make(carparkId, currentTicketNo++);

    		list.add(ticket);

    		return ticket;
	}



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		
		IAdhocTicket ticket = null;

   		Iterator<IAdhocTicket> itr = list.iterator();

    			while (itr.hasNext()) {

      				if (itr.next().getBarcode().equals(barcode)) {

        				ticket = itr.next();

        			break;
      				}
    			}

    	return ticket;
	}



	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		return list.stream().filter(c -> c.isCurrent() == true).collect(Collectors.toList());
  
	}

	
	
}
