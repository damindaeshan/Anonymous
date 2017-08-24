package bcccp.tickets.season;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.IUsageRecordFactory;

public class SeasonTicketDAO implements ISeasonTicketDAO {

	private IUsageRecordFactory factory;

	
	
	public SeasonTicketDAO(IUsageRecordFactory factory) {
		//TOD Implement constructor
	}



	@Override
	public void registerTicket(ISeasonTicket ticket) {
		
		SeasonTicket seasonTick = new SeasonTicket();
		seasonTick.setTicketId(ticket.getId());
		seasonTick.setCarparkId(ticket.getCarparkId());
		seasonTick.setStartValidPeriod(ticket.getStartValidPeriod());
		
	}


	@Override
	public void deregisterTicket(ISeasonTicket ticket) {
		SeasonTicket seasonTick = new SeasonTicket();
		seasonTick.setTicketId(ticket.getId());
		seasonTick.setCarparkId(ticket.getCarparkId());
		seasonTick.setStartValidPeriod(ticket.getStartValidPeriod());
		seasonTick.setEndValidPeriod(ticket.getEndValidPeriod());
		
	}



	@Override
	public int getNumberOfTickets() {
		int countLines = 0;
		try {
			Scanner readUsageRecord = new Scanner(new File("../Anonymous/SeasonTicketData.txt"));
			
			while(readUsageRecord.hasNext()){
				countLines++;
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countLines;
	}



	@Override
	public ISeasonTicket findTicketById(String ticketId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void recordTicketEntry(String ticketId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void recordTicketExit(String ticketId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
