package es.salesianos.model;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
public class Pokeball {
	private int number;
	private String name;
	public int rate;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Boolean moreBalls(Pokeball pokeball) {
		return true;
	}
}
