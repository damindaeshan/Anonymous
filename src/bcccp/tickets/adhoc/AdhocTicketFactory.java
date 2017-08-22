package bcccp.tickets.adhoc;

public class AdhocTicketFactory implements IAdhocTicketFactory {

	@Override
	public IAdhocTicket make(String carparkId, int ticketNo) {
		
		//This Statement will create a pattern of Date and Time
		SimpleDateFormat simple_date_format = new SimpleDateFormat("dd:MM:YYYY HH:mm:ss");
        
		//This Statement will get the current milliseconds of date and time
        	long system_time = System.currentTimeMillis();
        
		//This Satement will create a barcode by including ticketNo, carparkId and the date and time
        	String create_barcode = Integer.toString(ticketNo) + "/" + carparkId + "/" + simple_date_format.format(system_time);
        
		/*This Statement will call to the overrided constructor of AdhockTicket by parsing
		the carparkId, ticketNo and create_barcode through the argument list
		*/
        	AdhocTicket create_new_ticket = new AdhocTicket(carparkId, ticketNo, create_barcode);
        
		//This Statement will set the time, when entering to the car park
        	create_new_ticket.enter(system_time);
        
		//This Statement will return the new ticket
        	return create_new_ticket;
	}


}
