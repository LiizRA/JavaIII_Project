package org.springframework.samples.petclinic.school;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import java.util.Collection;

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


}
