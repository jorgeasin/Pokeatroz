package es.salesianos.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import es.salesianos.model.Item;

import es.salesianos.model.Person;
import es.salesianos.model.Pokeball;
import es.salesianos.model.Pokemon;
import es.salesianos.model.Weapon;

@Controller
public class IndexController {

	private static Logger log = LogManager.getLogger(IndexController.class);

	@Autowired
	private Person person;
	@Autowired
	private Person rival;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("person", this.person);
		return modelAndView;
	}

	
	@PostMapping("insert")
	public ModelAndView personInsert(Person personForm) {
		log.debug("personInsert:" + this.person.toString());		
		ModelAndView modelAndView = new ModelAndView("index");
		// this.person=personForm;
		addPageData(personForm);
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@PostMapping("insertP")
	public ModelAndView pokemonInsert(Person personForm) {
		log.debug("personInsert:" + this.person.toString());		
		ModelAndView modelAndView = new ModelAndView("index");
		System.out.println("agrego al ser");
		Pokemon pokemon =  new Pokemon();
		//pokemon = personForm.getPokemon(); esto va que te cagas
		pokemon.setName(personForm.getPokemon().getName());
		pokemon.setHp(personForm.getPokemon().getHp());
		pokemon.setMaxHp(personForm.getPokemon().getHp());
		pokemon.setAttack(personForm.getPokemon().getAttack());
		person.addPokemons(pokemon);
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	private void addPageData(Person personForm) {
		if (!StringUtils.isEmpty(personForm.getName())) {
			person.setName(personForm.getName());
		}
		if (!StringUtils.isEmpty(personForm.getPokeballs())) {
			Pokeball pokeball = new Pokeball();
			
			pokeball.setName(personForm.getPokeball().getName());
			pokeball.setNumber(person.getPokeball().getNumber() + personForm.getPokeball().getNumber());	
			System.out.println("metelo");
			this.person.setPokeball(pokeball);
			this.person.addPokeballs(pokeball);
		}
	}
	
	@PostMapping("switchPokemon")
	public ModelAndView switchWeapon() {
		
		if (this.person.getPokemons().size()>1) {
			Pokemon tmp;
			tmp = this.person.getPokemons().get(0);
			this.person.getPokemons().remove(0);
			this.person.getPokemons().add(tmp);
		}
		else {
			System.out.println("pero tu eres tonto o que te pasa si solo tienes un pokemone a que coño vas a cambiar");
		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("person", this.person);
		return modelAndView;
	}

	@GetMapping("searchPokemon")
	public ModelAndView searchPokemon() {
		rival.setPokemon(addWildPokemon());
		ModelAndView modelAndView = new ModelAndView("cave");
		modelAndView.addObject("person", this.person);
		modelAndView.addObject("rival", this.rival);
		return modelAndView;
	}
	@PostMapping("kidnap")
	public ModelAndView KidnapPoorPokemon(Person personForm) {
		System.out.println("ahora corre");
		ModelAndView modelAndView;
		if (kidnaped()) {
			System.out.println(personForm.getPokeball().getName());
			this.person.addPokemons(rival.getPokemon());
			reduceBalls(personForm);
			System.out.println("secuestro completo");
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("person", this.person);
			return modelAndView;
		}
		else {
			modelAndView = new ModelAndView("cave");
			modelAndView.addObject("person", this.person);
			modelAndView.addObject("rival", this.rival);
			
		}
		return modelAndView;
	}


	private void reduceBalls(Person personForm) {
		for (int i = 0; i < this.person.getPokeballs().size(); i++) {
			if (this.person.getPokeballs().get(i).getName() == personForm.getPokeball().getName())
				this.person.getPokeballs().get(i).setNumber(this.person.getPokeballs().get(i).getNumber()-1);
				if (this.person.getPokeballs().get(i).getNumber()==0) {
					this.person.getPokeballs().remove(0);
				}
		}
		
	}


	private boolean kidnaped() {
		System.out.println(person.getPokeball().getRate());
		if (person.getPokeball().getRate()>= (Math.random())*100) {
			return true;
		}
		else
			return false;
	}


	private Pokemon addWildPokemon() {
		
		Pokemon pokemonWild = new Pokemon();
		pokemonWild.setName("Zubat");
		pokemonWild.setAttack("50");
		pokemonWild.setHp("500");
		return pokemonWild;
		
	}
}
