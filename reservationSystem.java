package com.zoho.advance.Railway;

import java.util.ArrayList;
import java.util.Scanner;

public class reservationSystem {
	Scanner sc=new Scanner(System.in);
	private int totalBreth=3;
	private int lowerBreth=1;
	private int middleBreth=1;
	private int upperBreth=1;
	private int RACticket=1;
	private int waitingList=1;
	
	ArrayList<Passenger>bookTickets=new ArrayList<Passenger>();
	ArrayList<Passenger>RACTickets=new ArrayList<Passenger>();
	ArrayList<Passenger>waitingListTicket=new ArrayList<Passenger>();
	
	
	public void bookTicket()
	{

		System.out.println("Enter passenger name");
		String name=sc.nextLine();
		System.out.println("Enter the passenger age");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Gender(M/F)");
		String gender=sc.nextLine().toUpperCase();
		System.out.println("Enter the berth preferance");
		String  berthPreferance=sc.nextLine().toLowerCase();
		
		if(waitingList==0)
		{
			System.out.println("Ticket full You cant buy ticket !!!!");
		}
		if(berthPreferance.equals("lower"))
		{
			if(lowerBreth>0)
			{
				lowerBreth--;
			}
			else
			{
				System.out.println("---------------------------------------------");
				System.out.println("Lower breth is not Available.Suggesting available berth");
				availablBirth(name,age,gender);
				return ;
				
			}
		}
		else if(berthPreferance.equals("middle"))
		{
			if(middleBreth>0)
			{
				middleBreth--;
			}
			else
			{
				System.out.println("---------------------------------------------");
				System.out.println("Middle breth is not Available.Suggesting available berth");
			    availablBirth(name,age,gender);
				return ;
			}
		}
		else if(berthPreferance.equals("upper"))
		{
			if(upperBreth>0)
				upperBreth--;
			else
			{
				System.out.println("---------------------------------------------");
				System.out.println("Upper breth is not Available.Suggesting available berth");
				availablBirth(name,age,gender);
				return ;
			}
		}
		else
		{
			System.out.println("invaild");
			return ;
		}
		
	
	if(age>5)
	{
		if(totalBreth>0)
		{
			bookTickets.add(new Passenger(name, age, gender, berthPreferance));
			totalBreth--;
			System.out.println("bookedSuccssFully !");
			System.out.println("------------------------------");
			return ;
			
		}
		else if(RACticket>0)
		{
			RACTickets.add(new Passenger(name, age, gender, berthPreferance));
			RACticket--;
			System.out.println("bookedSuccssFully !(RAC)");
			System.out.println("------------------------------");
			return ;
			
		}
		else
		{
			waitingListTicket.add(new Passenger(name, age, gender, berthPreferance));
			waitingList--;
			System.out.println("bookedSuu=ccesFully !(wl)");
			System.out.println("-------------------------------------");
			return ;
		}
		
	}
	}
	public void availablBirth(String name,int age,String gender)
	{
		if(lowerBreth>0)
		{
			System.out.println("1. Lower");
		}
		if(middleBreth>0)
		{
			System.out.println("2. Middle");
		}
		if(upperBreth>0)
		{
			System.out.println("3. upper");
		}
		if(lowerBreth==0 && upperBreth==0 && middleBreth==0)
			System.out.println("4. Book on RAC");
		
		
		System.out.println("Enter the choice");
		int n=sc.nextInt();
		sc.nextLine();
		
		
		switch(n)
		{
		case 1:
			lowerBreth--;
			bookTickets.add(new Passenger(name, age, gender, "lower"));
			totalBreth--;
			System.out.println("Ticket Booked SuccesFully");
			System.out.println("---------------------");
			break;
		case 2:
			middleBreth--;
			bookTickets.add(new Passenger(name, age, gender, "middle"));
			totalBreth--;
			System.out.println("Ticket Booked SuccesFully");
			System.out.println("---------------------");
			break;
	    
		case 3:
			upperBreth--;
			bookTickets.add(new Passenger(name, age, gender, "upper"));
			totalBreth--;
			System.out.println("Ticket Booked SuccesFully");
			System.out.println("---------------------");
			break;
		case 4:
			if(RACticket>0) {
			RACticket--;
			RACTickets.add(new Passenger(name, age, gender, "side"));
			System.out.println("Ticket Booked SuccesFully(RAC)");
			System.out.println("---------------------");
			break;
			}
			else
			{
				System.out.println("-------------------------------------------");
				System.out.println("There is no ticket available in RAC!! if you want you can Book WAITING LIST!!");
				System.out.println("Pleas say yes to WAITING LIST");
				String res=sc.next().toLowerCase();
				if(res.equals("yes"));
				{
					waitingListTicket.add(new Passenger(name, age, gender, "waiting list"));
					waitingList--;
					System.out.println("Ticket Booked SuccesFully(WL)");
					break;
					
				}
			
				
			}
			default:
				System.out.println("invalid");
				System.exit(0);
		}
	}
	
	public void cancelTicket()
	{
		if(bookTickets.isEmpty())
		{
			System.out.println("No tickets to cancle");
		}
		System.out.println("Enter passenger name to cancel");
		String cancelName=sc.nextLine();
		
		Passenger cancledTicket=null;
		for(Passenger ticket:bookTickets )
		{
			if(ticket.name.equals(cancelName))
			{
				cancledTicket=ticket;
				break;
			}
		}
		if(cancledTicket==null) {
			System.out.println("please give corrcet name to cancel");
			return ;
		}
		
		
		bookTickets.remove(cancledTicket);
		totalBreth++;
		
		
		
		if(!RACTickets.isEmpty())
		{
			Passenger confrimTicket=RACTickets.remove(0);
			RACticket++;
			bookTickets.add(new Passenger(confrimTicket.name,confrimTicket.age,confrimTicket.gender,cancledTicket.birthPrefarance));
			totalBreth--;
			System.out.println("ticket canceld"+" " +cancledTicket.name);
			
		}
		else
		{
			System.out.println("ticket cancled"+" "+cancledTicket.name);
		}
		
		if(!waitingListTicket.isEmpty())
		{
			Passenger racCandidate=waitingListTicket.remove(0);
			waitingList++;
			RACTickets.add(new Passenger(racCandidate.name, racCandidate.age, racCandidate.gender, "side lower"));
			RACticket--;
		}
	}
	
	public void printBookedTickets()
	{
		if(bookTickets.isEmpty())
		{
			System.out.println("There is no booked Tickte");
		}
		else
		{
			System.out.println("For confrim ticktes List");
			for(Passenger ticket:bookTickets)
			{
				System.out.println(ticket.name+" "+ticket.age+" "+ticket.gender+" "+ticket.birthPrefarance);
			}
			System.out.println("-----------------------------------");
			if(!RACTickets.isEmpty()) 
			{
			System.out.println("For rac ticktes List");
			for(Passenger ticket:RACTickets)
			{
				System.out.println(ticket.name+" "+ticket.age+" "+ticket.gender+" "+ticket.birthPrefarance);
			}
			System.out.println("-----------------------------------");
			}
			if(!waitingListTicket.isEmpty())
			{
			System.out.println("For rac ticktes List");
			for(Passenger ticket:waitingListTicket)
			{
				System.out.println(ticket.name+" "+ticket.age+" "+ticket.gender+" "+ticket.birthPrefarance);
			}
			}
		}
	}
	public void printAvailableTickets() {
		System.out.println("upperberth"+" "+upperBreth);
		System.out.println("lowerberth"+"  "+lowerBreth);
		System.out.println("middleberth"+" "+middleBreth );
		System.out.println("total" + " "+(upperBreth+lowerBreth+middleBreth));
		System.out.println("TotalRAC"+" "+RACticket);
		System.out.println("WaitingList" +" "+waitingList);
		
		
	}
}
		
	
	
	



