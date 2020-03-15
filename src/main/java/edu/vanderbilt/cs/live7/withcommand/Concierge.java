package edu.vanderbilt.cs.live7.withcommand;

public class Concierge {

	private final Interpreter requestInterpreter;
	
	private final ActionFactory actionFactory;

	// TODO 0: 
	//
	// Identify the software design patterns in use by the "withcommand" package.
	//
	//
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
	
	public Concierge(Interpreter requestInterpreter, ActionFactory actionFactory) {
		super();
		this.requestInterpreter = requestInterpreter;
		this.actionFactory = actionFactory;
	}
	
	
	public String handleRequest(String guestRequest) {
		
		Request request = requestInterpreter.parse(guestRequest);
		
		Action action = actionFactory.build(request);
		
		Result result = action.execute();
		
		return result.toHumanReadableString();
		
	}

}
