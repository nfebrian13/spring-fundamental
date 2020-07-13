package com.securing.apis.config;

import java.util.UUID;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.securing.apis.model.Resolution;
import com.securing.apis.model.User;
import com.securing.apis.repository.ResolutionRepository;
import com.securing.apis.repository.UserRepository;

@Component
public class ResolutionInitializer implements SmartInitializingSingleton {
	private final ResolutionRepository resolutions;
	private final UserRepository users;
	private final PasswordEncoder passwordEncoder;

	public ResolutionInitializer(ResolutionRepository resolutions, UserRepository users,
			PasswordEncoder passwordEncoder) {
		this.resolutions = resolutions;
		this.users = users;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void afterSingletonsInstantiated() {
		UUID joshId = UUID.fromString("219168d2-1da4-4f8a-85d8-95b4377af3c1");
		UUID carolId = UUID.fromString("328167d1-2da3-5f7a-86d7-96b4376af2c0");

		this.resolutions.save(new Resolution("Read War and Peace", joshId));
		this.resolutions.save(new Resolution("Free Solo the Eiffel Tower", joshId));
		this.resolutions.save(new Resolution("Hang Christmas Lights", joshId));

		this.resolutions.save(new Resolution("Run for President", carolId));
		this.resolutions.save(new Resolution("Run a Marathon", carolId));
		this.resolutions.save(new Resolution("Run an Errand", carolId));

		User josh = new User(joshId, "josh", this.passwordEncoder.encode("joash"));
		User carol = new User(carolId, "carol", this.passwordEncoder.encode("carol"));
		this.users.save(josh);
		this.users.save(carol);
		
	}
}
