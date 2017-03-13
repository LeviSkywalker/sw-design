package br.impacta.edu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import static java.lang.System.out;
public class AgendaApp {
	private static Scanner entrada = new Scanner(System.in);
	private static List<Contato> contatos = new ArrayList<>();
	public static void main(String[] args){
		boolean sair = false;
		while(!sair) {
			int opcao = apresentarMenuPrincipal();
			switch(opcao){
			case 1: inserirContato(); break;
			case 2: buscarContato(); break;
			case 3: sair = true; break;
			default:out.println("ERRO:op��o inv�lida!");
			}
		}
out.println("\nFim do programa!");		
	}
	
	private static int apresentarMenuPrincipal() {
		boolean inteiro= false;
		int opcao = 0;
		while (!inteiro) {
			out.println("\nAGENDA TELEF�NICA!");
			out.println("(1) Inserir");
			out.println("(2) Buscar");
			out.println("(3) Sair");
			out.println("Escolha uma op��o");
			String s = entrada.nextLine();
			try{
				opcao = Integer.parseInt(s);
				inteiro = true;
			}catch(Exception e){
		out.println("ERRO: op��o deve ser um valor inteiro!");
			}
			}
		return opcao;
	}
	private static void inserirContato(){
		out.println("\nINSER��O DE NOVO CONTATO:");
		String nome = lerNome();
		String telefone = lerTelefone();
		Contato c = new Contato(nome, telefone);
		if(contatos.contains(c)){
			out.println("Este contato j� existe");
		}
		else{
			contatos.add(c);
			out.print("contato inserido");
			
		}
	}
	private static String lerNome() {
		boolean valido = false;
		String nome = "";
		while(!valido){
			out.println("Nome: ");
			nome = entrada.nextLine();
			if (nome.length()==0 || nome.length()>200) {
				System.out.println("ERRO: nome de tamanho inv�lido");
			}else{valido = true;}
			
		}
		return nome;
	}
		private static String lerTelefone(){
			boolean valido = false;
			String telefone = "";
				while(!valido){
				System.out.println("Telefone: ");
				telefone = entrada.nextLine();
				if (telefone.length()==0 || telefone.length()>25) {
					System.out.println("ERRO: telefone de tamanho inv�lido!");
				}else{valido = true;}
			}
			return telefone;
			
		}

		private static void buscarContato() {
			System.out.println("BUSCA CONTATOS: ");
			String nome = lerNome();
			List<Contato> resultado = new ArrayList<>();
			for (Contato c: contatos) {
				if (nome.equals(c.getNome())) {
					resultado.add(c);
				}
			}
			if (resultado.size() == 0) {
				System.out.println("N�o h� contato com este nome!");
			}else{
				System.out.println("\nResultado da Busca:");
				for (Contato c: resultado) {
					System.out.println(c);
					
				}
				
				
			}
		}





}		


		
	
	
	
	
	

