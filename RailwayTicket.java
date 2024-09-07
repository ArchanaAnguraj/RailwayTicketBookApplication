package com.zoho.advance.Railway;

import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;

public class RailwayTicket {
	
	public static void main( String[]args)
	{
		reservationSystem rs=new reservationSystem();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("\n Railway Ticket Reservation System");
			System.out.println("1. For booking Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. Print Booked Tickets");
			System.out.println("4. Print available ticktes");
			System.out.println("5. Exit");
			
			System.out.println("Enter your Choice");
			int n=sc.nextInt();
			sc.nextLine();
			System.out.println("----------------------------");
	
			
			switch(n)
			{
			case 1:
				rs.bookTicket();
				break;
			case 2:
				rs.cancelTicket();
			   break;
			case 3:
				rs.printBookedTickets();
				break;
			case 4:
				rs.printAvailableTickets();
			   break;
			case 5:
			  System.out.println("exit the application!!thank you");
			  System.exit(0);
			default:
				System.out.println("Invaild choice");
				
			}
		}
	}

}
