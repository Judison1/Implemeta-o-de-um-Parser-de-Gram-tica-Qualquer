package parse;

public interface Iparse {
	
	public static final char EOF = (char)-1;
	/*
	* Retorna o token (caractere) da vez. Caso toda a entrada
	* j� tenha sido consumida, retorna EOF. Al�m disso, deve
	* ignorar todos os espa�os em branco da entrada. Funciona
	* como um lexer simplificado.
	*/
	public char lookahead();
	/*
	* Este m�todo deve comparar o lookahead com um outro
	* caractere, se eles forem iguais avan�a para o pr�ximo
	* caractere, caso contr�rio lan�a um erro de sintaxe.
	*/
	public boolean match(char c);
	/*
	* Este m�todo deve imprimir uma mensagem de erro
	* indicando o endere�o do caractere que causou o erro
	* e depois finalizar o programa
	*/
	public void error(String s);
	/*
	* M�todo que inicia a an�lise sint�tica chamando o
	* m�todo que representa o n�o-terminal inicial
	*/
	public boolean parse();
	
}
