package com.chainsys.springproject.beans;

public class Movie {
	public String title;
	public String director;
	public Movie(String filmtitle,String filmdirector) {
		title=filmtitle;
		director=filmdirector;
		System.out.println(title);
		System.out.println(director);
		//this.title=title; // this title is global variable, and title is a local variable
		// as there are no local ariabkes by name title, are director so, here table implicitly
		//if the parameter names are similar to the global variables
		// Then there is an ambiguity between the local variable (parameter) and global variable
		// hence this.prefix is used for Referring the global variable
		// title=title will be referring the local variable on both side of the = operator (x=x) self assigning
		
		
	}

}
