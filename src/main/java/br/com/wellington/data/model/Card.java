package br.com.wellington.data.model;

import java.io.Serializable;

import br.com.wellington.data.model.enumType.ClassCardEnum;
import br.com.wellington.data.model.enumType.TypeCardEnum;

public class Card implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private int atack;
	
	private int defense;
	
	private TypeCardEnum type;
	
	private ClassCardEnum classCard;
	
	public Card() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAtack() {
		return atack;
	}

	public void setAtack(int atack) {
		this.atack = atack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public TypeCardEnum getType() {
		return type;
	}

	public void setType(TypeCardEnum type) {
		this.type = type;
	}

	public ClassCardEnum getClassCard() {
		return classCard;
	}

	public void setClassCard(ClassCardEnum classCard) {
		this.classCard = classCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atack;
		result = prime * result + ((classCard == null) ? 0 : classCard.hashCode());
		result = prime * result + defense;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (atack != other.atack)
			return false;
		if (classCard == null) {
			if (other.classCard != null)
				return false;
		} else if (!classCard.equals(other.classCard))
			return false;
		if (defense != other.defense)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
}
