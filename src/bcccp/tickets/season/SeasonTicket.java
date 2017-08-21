package bcccp.tickets.season;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeasonTicket implements ISeasonTicket {
	
	private List<IUsageRecord> usages;
	private IUsageRecord currentUsage = null;
	
	private String ticketId;
	private String carparkId;
	private long startValidPeriod;
	private long endValidPeriod;
	
	public SeasonTicket (String ticketId, 
			             String carparkId, 
			             long startValidPeriod,
			             long endValidPeriod) {
		
		this.ticketId = ticketId;
		this.carparkId = carparkId;
		this.startValidPeriod = startValidPeriod;
		this.endValidPeriod = endValidPeriod;
	}
	
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public void setCarparkId(String carparkId) {
		this.carparkId = carparkId;
	}

	public void setStartValidPeriod(long startValidPeriod) {
		this.startValidPeriod = startValidPeriod;
	}

	public void setEndValidPeriod(long endValidPeriod) {
		this.endValidPeriod = endValidPeriod;
	}

	@Override
	public String getId() {	
		return this.ticketId;
	}

	@Override
	public String getCarparkId() {
		
		return this.carparkId;
	}

	@Override
	public long getStartValidPeriod() {
		
		return this.startValidPeriod;
	}

	@Override
	public long getEndValidPeriod() {
		
		return this.endValidPeriod;
	}

	@Override
	public boolean inUse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recordUsage(IUsageRecord record) {
		File writeUsageFile = new File("../Anonymous/UsageRecordData.txt");
		if(writeUsageFile.exists()) {
			try {
				PrintWriter writeFile = new PrintWriter(writeUsageFile);
				writeFile.print(record.getSeasonTicketId());
				writeFile.print("\t");
				writeFile.print(record.getStartTime());
				writeFile.print("\t");
				writeFile.print(record.getEndTime());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public IUsageRecord getCurrentUsageRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endUsage(long dateTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IUsageRecord> getUsageRecords() {
		// TODO Auto-generated method stub
		return null;
	}


}
