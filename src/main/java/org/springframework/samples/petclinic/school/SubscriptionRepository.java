package org.springframework.samples.petclinic.school;


import jdk.jshell.JShell;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.concurrent.Flow;


public interface SubscriptionRepository extends Repository<Subscription, Integer> {
	@Transactional(readOnly = true)
	Collection<Subscription> findAll();

	void save(Subscription subscription);
}
