package bcccp.carpark;

import java.util.List;

import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
/**
 * this file use for implement the coding for the car park. It has register(), deregister(), 
 * issueAdhocTicket(), isFull(), etc
 */
public class Carpark implements ICarpark {
	
	private List<ICarparkObserver> observers;
	private String carparkId;
	private int capacity;
	private int numberOfCarsParked;
	private IAdhocTicketDAO adhocTicketDAO;
	private ISeasonTicketDAO seasonTicketDAO;
	
	//Implement constructor
	public Carpark(){
		
	}
	
	// Created constructor
	public Carpark(String name, int capacity, 
			IAdhocTicketDAO adhocTicketDAO, 
			ISeasonTicketDAO seasonTicketDAO) {
		this.carparkId = name;
		this.capacity = capacity;
		this.adhocTicketDAO = adhocTicketDAO;
		this.seasonTicketDAO = seasonTicketDAO;
	}



	@Override
	public void register(ICarparkObserver observer) {
		File writeUsageFile = new File("../Anonymous/CarParkData.txt");
		if(writeUsageFile.exists()) {
			try {
				PrintWriter writeFile = new PrintWriter(writeUsageFile);
				writeFile.print(carparkId);
				writeFile.print("\t");
				writeFile.print(observer);	
				writeFile.print("Registared");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



	@Override
	public void deregister(ICarparkObserver observer) {
		File writeUsageFile = new File("../Anonymous/CarParkData.txt");
		if(writeUsageFile.exists()) {
			try {
				PrintWriter writeFile = new PrintWriter(writeUsageFile);
				writeFile.print(carparkId);
				writeFile.print("\t");
				writeFile.print(observer);	
				writeFile.print("Unregisterd");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



	@Override
	public String getName() {
		return carparkId;
	}



	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public IAdhocTicket issueAdhocTicket() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void recordAdhocTicketEntry() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public IAdhocTicket getAdhocTicket(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public float calculateAddHocTicketCharge(long entryDateTime) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void recordAdhocTicketExit() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void registerSeasonTicket(ISeasonTicket seasonTicket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deregisterSeasonTicket(ISeasonTicket seasonTicket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean isSeasonTicketValid(String ticketId) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isSeasonTicketInUse(String ticketId) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void recordSeasonTicketEntry(String ticketId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void recordSeasonTicketExit(String ticketId) {
		// TODO Auto-generated method stub
		
	}

	
	

}
