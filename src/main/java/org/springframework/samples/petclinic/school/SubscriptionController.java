package org.springframework.samples.petclinic.school;


import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;

//import static sun.rmi.transport.TransportConstants.Return; // ????


@Controller
public class SubscriptionController {


	private final SubscriptionRepository subscriptionRepository;


	public SubscriptionController(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}


	@GetMapping("/pricing")
	public String showPricingTable(Model model) {
		Collection<Subscription> subscriptions = subscriptionRepository.findAll();
		model.addAttribute("subscriptions", subscriptions.stream().toList());
		return "schools/pricing"; // changed Return for return
	}

	@GetMapping("/subscriptions/new")
	public String initCreationForm(Map<String, Object> model) {
		Subscription subscription = new Subscription();
		model.put("subscription", subscription);
		return "schools/createOrUpdateSubscriptionForm";
	}

	@PostMapping("/subscriptions/new")
	public String processCreationForm(@Valid Subscription subscription, BindingResult result) {
		if (result.hasErrors()) {
			return "schools/createOrUpdateSubscriptionForm";
		}
		subscriptionRepository.save(subscription);
		return "redirect:/pricing";
	}




}
