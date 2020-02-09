package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;

	@Autowired
	private Bag bag;

	private Weapon primary;
	private Weapon secondary;
	private Item item;
	private Pokemon pokemon;
	private List <Pokemon> pokemons= new ArrayList<Pokemon>(); 
	
	private List <Pokeball> pokeballs= new ArrayList<Pokeball>(); 
	
	private Pokeball pokeball;
	
	public Bag getBag() {
		return bag;
	}
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	public Weapon getPrimary() {
		return primary;
	}
	public void setPrimary(Weapon primary) {
		this.primary = primary;
	}
	public Weapon getSecondary() {
		return secondary;
	}
	public void setSecondary(Weapon secondary) {
		this.secondary = secondary;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List <Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(List <Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	
	public void addPokemons(Pokemon pokemons) {
		this.pokemons.add(pokemons);
	}
	public Pokemon getPokemon() {
		return pokemon;
	}
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	public List <Pokeball> getPokeballs() {
		return pokeballs;
	}
	public void setPokeballs(List <Pokeball> pokeballs) {
		this.pokeballs = pokeballs;
	}
	
	public void addPokeballs(Pokeball pokeball) {
		this.pokeballs.add(pokeball);
	}
	public Pokeball getPokeball() {
		return pokeball;
	}
	public void setPokeball(Pokeball pokeball) {
		this.pokeball = pokeball;
	}
}
