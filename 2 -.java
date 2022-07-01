//Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
//N funcionários. Não deve haver repetição de id.
//Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
//Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
//mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
//conforme exemplos.
//Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
//ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
//aumento por porcentagem dada.

package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.funcionario;
public class Program {

	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<funcionario> list = new ArrayList<funcionario>();
		
		System.out.println("Quantos colaboradores serão cadastrados ? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n ; i++) {
			sc.nextLine();
			System.out.println("Colaborador : " + (i+1));
			System.out.println("Digite o ID do colaborador");
			int id = sc.nextInt();
			System.out.println("Digite o Nome do colaborador");
			sc.nextLine();
			String nome = sc.nextLine();			
			System.out.println("Digite o Salario do colaborador");
			Double salario = sc.nextDouble();
			funcionario func = new funcionario(id , nome , salario);
			list.add(func);
		}
		
		System.out.println("Digite o Id que deseja buscar");
		int idColaborador = sc.nextInt();
		int posicao = LocalizarId(list , idColaborador);
		if (posicao == -1) {
			System.out.println("O ID digitado não existe");
		}
		else {
			System.out.println("Qual porcentagem deseja aplicar no salario do colaborador ?");	
			double porcentagem = sc.nextDouble();
			list.get(posicao).aumentoDoSalario(porcentagem);
		}
		
		System.out.println();
		System.out.println("Lista de Funcionarios");
		for (funcionario func : list ) {
			System.out.println(func);
		}
		sc.close();
	}
  // Função auxiliar para localizar o ID
	public static int LocalizarId (List<funcionario> list, int idColaborador) {
		for (int i = 0 ; i < list.size() ; i ++) {
			if (list.get(i).getId() == idColaborador) {
				return i;
			}
		}
		return -1;
	}
}

// Classe funcionario

package entities;
 
 
public class funcionario {
	private Integer id;
	private String nome;
	private Double salario;
	
	
	public funcionario() {
	}
	public funcionario(Integer id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public void aumentoDoSalario (double pontentagemDeAumento) {
		pontentagemDeAumento = pontentagemDeAumento/100;
		salario = (salario * pontentagemDeAumento) + salario;
	
	}
	public String toString() {
		return id + " , " + nome + " , " + String.format("%.2f", salario);
	}

}
