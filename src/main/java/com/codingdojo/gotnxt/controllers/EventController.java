package com.codingdojo.gotnxt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.gotnxt.models.Event;
import com.codingdojo.gotnxt.models.User;
import com.codingdojo.gotnxt.services.EventService;
import com.codingdojo.gotnxt.services.UserService;

@Controller
public class EventController {

	@Autowired
	private EventService eventServ;
	
	@Autowired
	private UserService userServ;
	
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
			Long loggedInUserId = (Long) session.getAttribute("userId");
			User loggedInUser = this.userServ.findUserById(loggedInUserId);
			model.addAttribute("user", loggedInUser);
			model.addAttribute("event", this.eventServ.eventsToStart());
			return "dashboard.jsp";
		}
	}
	
	@GetMapping("/portfolio")
	public String portfolio(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
			Long loggedInUserId = (Long) session.getAttribute("userId");
			User loggedInUser = this.userServ.findUserById(loggedInUserId);
			model.addAttribute("user", loggedInUser);
			model.addAttribute("hostEvents", this.eventServ.getHostEvents(loggedInUserId));
			return "portfolio.jsp";
		}
	}
	
	@GetMapping("/archives")
	public String archives(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
			model.addAttribute("event", this.eventServ.eventsCompleted());
			return "past_events.jsp";
		}
	}
	
//	Event Specific
	
	@GetMapping("/event/new")
	public String newEvent(@ModelAttribute("eventForm") Event event,
			HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
			Long loggedInUserId = (Long) session.getAttribute("userId");
			User loggedInUser = this.userServ.findUserById(loggedInUserId);
			model.addAttribute("user", loggedInUser);
			return "newEvent.jsp";
		}
	}
	
	@PostMapping("/event/create")
	public String createEvent(@Valid @ModelAttribute("eventForm") Event event, 
			BindingResult result, Model model)
			 {
		if(result.hasErrors()) {
			return "newEvent.jsp";
		} else {
			this.eventServ.createEvent(event);
			String eventTime = event.getTime();
			model.addAttribute(eventTime);
			return "redirect:/dashboard";
		}
	}


	@GetMapping("/event/{eventId}")
	public String eventPage(@PathVariable("eventId") Long eventId, Model model,
	HttpSession session){
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
			Long userId = (Long) session.getAttribute("userId");
			User loggedinUser = this.userServ.findUserById(userId);
			model.addAttribute("user", loggedinUser);
			model.addAttribute("event", this.eventServ.findEvent(eventId));
			return "event.jsp";			
		}
	}
	
	@GetMapping("/event/{eventId}/edit")
	public String editEvent(@PathVariable("eventId") Long id, Model model,
			HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} else {
		model.addAttribute("event", this.eventServ.findEvent(id));
		return "editEvent.jsp";
		}
	}
	
	@PutMapping("/event/{eventId}/update")
	public String updateEvent(@Valid @ModelAttribute("eventForm") Event event, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editEvent.jsp";
		}else {
			this.eventServ.updateEvent(event);
			return "redirect:/event/{eventId}";
		}
		
	}
	
	@GetMapping("/event/{eventId}/maps")
	public String showMap(@PathVariable("eventId") Long eventId, Model model,HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}else {
			model.addAttribute("event", this.eventServ.findEvent(eventId));
			return "map.jsp";			
		}
	}
	
	@DeleteMapping("/event/{id}/delete")
	public String Destroy(@PathVariable("id") Long id) {
	this.eventServ.deleteEvent(id);
	return "redirect:/dashboard";
	}
	
	
//	Relationships
	@GetMapping("/event/{eventId}/join/{athleteId}")
	public String JoinEvent(@PathVariable("eventId") Long eventId,
			@PathVariable("athleteId") Long athleteId) {
		this.eventServ.addAthletes(eventId, athleteId);
		return "redirect:/event/" + eventId;
	}
	
	@GetMapping("/event/{eventId}/leave/{athleteId}")
	public String LeaveEvent(@PathVariable("eventId") Long eventId,
			@PathVariable("athleteId") Long athleteId) {
		User athlete = this.userServ.findUserById(athleteId);
		this.eventServ.removeAthlete(eventId, athlete);
		return "redirect:/event/" + eventId;
	}
}
