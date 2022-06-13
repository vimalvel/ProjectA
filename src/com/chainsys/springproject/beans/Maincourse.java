package com.chainsys.springproject.beans;

public abstract class Maincourse {
	public String name;
}

class SouthIndian extends Maincourse {
	public SouthIndian() {
		name="RICE";
	}
}

class NorthIndian extends Maincourse {
	public NorthIndian() {
		name="CHAPPATHI";
	}
}

class Chinese extends Maincourse {
	public Chinese() {
		name="NOODELS";
	}
}
