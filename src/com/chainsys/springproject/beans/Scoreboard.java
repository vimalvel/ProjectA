package com.chainsys.springproject.beans;

public class Scoreboard {
	public int targetscore;
	private Scoreboard() {
		System.out.println("scoreboard object is created");
	}
	private Scoreboard(int runs) {
		targetscore=runs;
		System.out.println("Scoreboard object is created" + runs);
		
	}
	// factory method - the method is static
	public static Scoreboard createObject() {
		return new Scoreboard();
	}
	public static Scoreboard createObject(int runs) {
		return new Scoreboard(runs);
	}

}
