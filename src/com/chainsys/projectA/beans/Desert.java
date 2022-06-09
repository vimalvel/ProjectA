package com.chainsys.projectA.beans;

public abstract class Desert {
	public String name;
}

class Icecream extends Desert {
	public Icecream() {
		name="CHOCOLATE";
	}
}

class Sweets extends Desert {
	public Sweets() {
		name="RASAGULLA";
	}
}

class Cakes extends Desert {
	public Cakes() {
		name="RUSSIANVELVET";
	}
	public Cakes(String name) {
		this.name=name;
	}
}
