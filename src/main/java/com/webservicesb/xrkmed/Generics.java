package com.webservicesb.xrkmed;

public class Generics<K, T> {
	
	public Generics(){
		super();
	}
	
	public <J extends Comparable<J>> J get(K type, T value) {
		if(value instanceof String) {
			return (J) new Object();
		}
		
		return null;
	}
	
	public <J> boolean run(K v, T k) {
		J type = get(v, k);
		if(type != null) {
			return true;
		}
		
		return false;
	}

}
