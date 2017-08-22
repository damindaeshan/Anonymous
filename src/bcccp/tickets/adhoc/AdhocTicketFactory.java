package bcccp.tickets.adhoc;

public class AdhocTicketFactory implements IAdhocTicketFactory {

	@Override
	public IAdhocTicket make(String carparkId, int ticketNo) {
		
		SimpleDateFormat simple_date_format = new SimpleDateFormat("dd:MM:YYYY HH:mm:ss");
        
        	long system_time = System.currentTimeMillis();
        
        	String create_barcode = Integer.toString(ticketNo) + "/" + carparkId + "/" + simple_date_format.format(system_time);
        
        	AdhocTicket create_new_ticket = new AdhocTicket(carparkId, ticketNo, create_barcode);
        
        	create_new_ticket.enter(system_time);
        
        	return create_new_ticket;
	}


}
