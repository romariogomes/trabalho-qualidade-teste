package trabalho;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		List<Integer> firstArray = new ArrayList<Integer>(){{
		    add(0);
		    add(2);
		    add(4);
		    add(6);
		    add(8);
		}};
		
		List<Integer> secondArray = new ArrayList<Integer>(){{
		    add(8);
		    add(6);
		    add(4);
		    add(2);
		    add(0);
		}};
		
		SearchElement searchElement = new SearchElement();
		searchElement.setItems(firstArray);
		
		Scanner scanner = new Scanner(System.in); 
		
		Integer opcao = null;
		Integer key = null;
		SearchType tipoBusca = null;
		
		do {
			
			System.out.println("============ MENU ============= \n");
			System.out.println("Selecione o tipo de busca: \n");
			System.out.println("0 - LessThan \n");
			System.out.println("1 - LessThanEquals \n");
			System.out.println("2 - Equals \n");
			System.out.println("3 - GreaterThanEquals \n");
			System.out.println("4 - GreaterThan \n");
			System.out.println("999 - Sair \n");
			
			System.out.print("Digite aqui sua opção: ");
			opcao = scanner.nextInt();
			
			switch (opcao) {
			
				case 0:
					tipoBusca = SearchType.LessThan;
					break;
				case 1:
					tipoBusca = SearchType.LessThanEquals;
					break;
				case 2:
					tipoBusca = SearchType.Equals;
					break;
				case 3:
					tipoBusca = SearchType.GreaterThanEquals;
					break;
				case 4:
					tipoBusca = SearchType.GreaterThan;
					break;
				default:
					System.out.println("Opção Inválida!");
					break;
			}
			
			System.out.println("Digite o valor: ");
			key = scanner.nextInt();
			
			searchElement.find(firstArray, key, tipoBusca);
			
			System.out.println("Pressione qualquer botão para continuar..");
			System.in.read();
			Runtime.getRuntime().exec("clear");
			
		} while (opcao <= 4);
		
	}
}
