import java.util.Scanner;

import br.ufpa.user.Customer;
import br.ufpa.user.Manager;
import br.ufpa.user.User;

public class SignUp {
	private static Scanner input = new Scanner(System.in);
	
	public static void signup() throws Exception {
		System.out.print("\nPerfil (gestor ou cliente): ");
		String profile = input.nextLine();
		
		while(!Storage.profiles.contains(profile)) {
			System.out.print("\nEste perfil n�o existe. Digite 'gestor' ou 'cliente': ");
			profile = input.nextLine();
		}
		
		System.out.print("\nNome: ");
		String name = input.nextLine();
		
		System.out.print("\nLogin: ");
		String login = input.nextLine();
		
		System.out.print("\nSenha: ");
		String password = input.nextLine();
		
		User user = null;
		
		switch(profile) {
			case "gestor":
				user = new	Manager(name, login, password);
				break;
			case "cliente":
				user = new Customer(name, login, password);
				break;
		}
		
		if(user != null && user.validate()) {
			Storage.users.add(user);
			
			System.out.println("\nUsu�rio " + user.getName() + " criado com sucesso!");
		} else {
			throw new Exception("\nOcorreu um erro ao criar o usu�rio. Tente novamente.");
		}
	}
}
