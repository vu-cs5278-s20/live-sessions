package edu.vanderbilt.cs.live7.withoutpatterns;

import java.util.UUID;

public class Concierge {

	public static class Directions {
		public final String text;
		
		public Directions(String t) {
			this.text = t;
		}
	}
	
	public static class Confirmation {
		
		public final String code;
		
		public Confirmation() {
			code = UUID.randomUUID().toString();
		}
	}
	
	public Confirmation bookTickets(String event, String seatCategory, int count) {
		return null;
	}
	
	public Confirmation makeReservation(String restaurant, int guests) {
		return null;
	}
	
	public Directions getDirections(String destination) {
		return null;
	}
	
	// TODO 1: 
	//
	// Add a new capability to the concierge that is attached to a keyword and arguments.
	//
	//
	// TODO 2: 
	//
	// Add the ability to book vacation packages with the command "package <pkg_id>".
	// A vacation package should include booking a restaurant, an event, and providing
	// directions to the restaurant and the event.
	//
	//
	// TODO 3: 
	//
	// Add support for users to send requests in a new language.
	// 
	// TODO 4:
	//
	// Your concierge agent is going to be used by multiple organizations. Some of the
	// organizations use Travelocity to book restaurants / events and some use Priceline
	// to book restaurants / events. Also, some of the organizations prefer Google Maps,
	// while some operate in China and want Baidu's equivalent. Provide support for each
	// organization's preferences.
	//
	
	
	public String handleRequest(String guestRequest) {
		
		guestRequest = guestRequest.toLowerCase().trim();
		
		String[] tokens = guestRequest.split(" ");
		String cmd = tokens[0];
		
		String result = "I don't know how to handle that request for you.";
		
		if(cmd.equals("book")) {
			String event = tokens[1];
			String seatCategory = tokens[2];
			int count = Integer.parseInt(tokens[3]);
			
			Confirmation conf = bookTickets(event, seatCategory, count);
			result = "Your confirmation code is: " + conf.code;
		}
		else if(cmd.equals("reserve")) {
			String restaurant = tokens[1];
			int guests = Integer.parseInt(tokens[2]);
			
			Confirmation conf = makeReservation(restaurant, guests);
			result = "Your confirmation code is: " + conf.code;
		}
		else if(cmd.equals("directions to")) {
			String destination = tokens[1];
			Directions dir = getDirections(destination);
			result = "Your directions to "+destination+" are: "+dir.text;
		}
		return result;
	}
}
