package parse;

public class Parse implements Iparse {
	
	public static final char EOF = (char)-1;
	
	private String input;
	private int position;

	public Parse(String word) {
		this.input = word;
		this.position = 0;
	}
	
	@Override
	public char lookahead() {
		
		
		
		if(this.position < input.length()) {
			char token = input.charAt(this.position);
			while(token == ' ') {
				this.position++;
				token = input.charAt(this.position);
			}
			
			return token;	
			
		} else 
			return EOF;
		
	}

	@Override
	public boolean match(char c) {

		if (lookahead() == c) {
			this.position++;
			return true;
		} else {
			error("Inesperado caracter '" + c + "'");
			return false;
		}
	}

	@Override
	public void error(String s) {
		System.err.println("Erro no endereço: "+ this.position+ " -> " + s);
		System.exit(0);
	}

	@Override
	public boolean parse() {
		E();
		
		return true;
	}
	
	private void E() {
		
		T();
		
		while (lookahead() == '+') {
			match('+');
			T();
			
		}
	}
	
	private void T() {
		
		F();
		T_();
	}
	
	private void T_() {
		if(lookahead() == 'a'  || lookahead() == 'b' || lookahead() == '*') {
			F();
			T_();
		}
	}
	
	private void F() {
		
		P();
		while(lookahead() == '*') {
			match('*');
		}
	}
	private void P() {
		if (lookahead() == 'a') {
			match('a');
		}else if(lookahead() == 'b') {
			match('b');
		} else
			error("Expressão inválida!");

	}

}
