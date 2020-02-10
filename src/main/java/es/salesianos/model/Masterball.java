package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel1")
public class Masterball extends AbstractBall{
 
	public  Masterball() {
		 rate = 100;
	}
}
