package bcccp.tickets.season;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Usage record class that used to implement Usage record interface 
public class UsageRecord implements IUsageRecord {
	
	String ticketId;
	long startDateTime;
	long endDateTime;
	
	//Constructor for Usage Record class
	public UsageRecord(String ticketId, long startDateTime) {
		this.ticketId = ticketId;
		this.startDateTime = startDateTime;
	}

	public UsageRecord() {
		// TODO Auto-generated constructor stub
	}

	//
	@Override
	public void finalise(long endDateTime) {
		UsageRecord newTicketUsage = new UsageRecord();
		newTicketUsage.ticketId = ticketId;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		newTicketUsage.startDateTime = 1413972425000L;
		newTicketUsage.endDateTime = 1413972425000L;
		
		
	}

	//Method used for access start time
	@Override
	public long getStartTime() {
		
		return this.startDateTime;
	}

	//Method used for access end date time
	@Override
	public long getEndTime() {
		return this.getEndTime();
	}

	//Method used for access season ticket id
	@Override
	public String getSeasonTicketId() {
		return this.ticketId;
	}
	
	
	
}
