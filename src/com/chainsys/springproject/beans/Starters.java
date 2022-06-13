package com.chainsys.springproject.beans;

public abstract class Starters {
	public String name;
}

	class Chicken extends Starters {
		public Chicken() {
			name="Honeychicken";
		}
	}

	class Soup extends Starters {
		public Soup() {
		name="Sweetcorn";
		}
	}

	class Vegroll extends Starters {
		public Vegroll() {
			name="EggRoll";
		}
	}
