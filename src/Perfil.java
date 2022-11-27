import java.util.Scanner;

public class Perfil {

	String nome;
	String login;
	String senha;

	static Post[] post = new Post[100];
	static int qtdPost = 0;

	static void menuInicialUsuario() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Selecione uma das opções:");
		System.out.println("1 = Postar / 2 = Time Line / 3 = Sair");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			postar();
			break;
		case 2:
			timeline();
			break;
		case 3:
			sair();
		default:
			System.out.println("Digite uma opção valida");
		}
		menuInicialUsuario();
	}
	static void postar() {
		Scanner sc = new Scanner(System.in);
		Post a = new Post();
		System.out.println("Digita a data: Formato (yy/yy/yyyy): ");
		a.data = sc.next();
		System.out.println("Digite a hora: Formato (00:00): ");
		a.hora = sc.next();
		System.out.println("Digite a Postagem: ");
		sc.nextLine();
		a.mensagem = sc.nextLine();
		if (a.data.isEmpty() || a.hora.isEmpty() || a.mensagem.isEmpty()) {
			System.out.println("Todos os campos devem ser preenchidos");
		}
		post[qtdPost] = a;
		qtdPost++;
		
		System.out.println("Postagem realizada com sucesso!");
		menuInicialUsuario();
	}
	static void timeline() {
		System.out.println("Time Line");
		for (int i = 0; i < qtdPost; i++) {
			System.out.println(post[i].data + " ás " + post[i].hora + " - " + post[i].mensagem);
		}
		menuInicialUsuario();
	}
	static void sair() {
		System.out.println("Obrigado, saindo do seu login!");
		RedeSocialNova.menuPrincipal();
	}
}
