package com.chainsys.springproject.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//not working from java9
public class AnnotationLc {
	public AnnotationLc() {
		System.out.println("Annatation object created"+ hashCode());
	}
	@PostConstruct
	public void start() {
		System.out.println("Start AnnotationLc...");
	}
	@PreDestroy
	public void stop() {
		System.out.println("Stop AnnotationLc...");
	}
	public void print() {
		System.out.println("Print");
	}

}
