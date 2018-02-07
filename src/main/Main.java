package main;

import parse.Parse;

public class Main {

	public static void main(String[] args) {
	
		Parse parse = new Parse("a*+a");
		
		parse.parse();
		System.out.println(parse.lookahead());
		
	}

}
