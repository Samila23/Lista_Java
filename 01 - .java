// Criar no lista, inserir novos elementos na lista, deletar elementos , verificar tamanho da lista , filtrar através de predicados.

package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//Lista não aceita tipos primitivos, tipos precisar se wrapper
		List<String> list = new ArrayList<String>(); 
		
		System.out.println("*****Criando uma lista e inserindo novos elementro em uma lista já existente*****");
		//para adicionar uma nova lista
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Ana");
		list.add("Joao");
		list.add("Rui");
		list.add("Bruno");
		//Inserir um novo elemento em "X" posição
		list.add(2,"Marcos");
		list.add(4,"Josefa");

		// nesse caso usar o for each
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("*****Para Saber o tamanho da Lista*****");
		System.out.println(list.size());
		
		System.out.println("*****Remoções*****");
		// remover item "X" da lista: pela posição ,pela descrição ou predicado  
		list.remove("5");// que esteja na posição 5
		list.remove("Alex");// que seja descrito como Alex
		list.removeIf(x -> x.charAt(0) == 'M'); // lambida // Todos que iniciem com M
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("*****Para Saber o tamanho da Lista*****");
		System.out.println(list.size());
		
		System.out.println("*****Para Saber a posição de um elemento*****");
		System.out.println("Descricao: " + list.indexOf("Bob"));
		
		System.out.println("Para Filtrar todos que se inicial com J");
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'J').collect(Collectors.toList());
		for (String x : result) {
			System.out.println(x);
		}

}
}
