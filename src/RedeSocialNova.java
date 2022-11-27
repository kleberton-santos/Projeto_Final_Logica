import java.util.Scanner;

public class RedeSocialNova {
	static int qtdUsuarios = 0;
	static Perfil[] perfis = new Perfil[200];

	public static void main(String[] args) {
		System.out.println("Seja muito bem vindo a rede social Nova");
		System.out.println("Só e possivel acessar a rede social com um cadastro, caso não tenha basta se cadastrar!");
		menuPrincipal();
	}
	
	static void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Principal");
		System.out.println("Digite umas das opções: C = Cadastrar | E = Entrar | F = Fechar");
		String opcao = sc.next().toUpperCase();
		
		switch(opcao) {
		case ("C"):
			CadastroUsuario();
			break;
		case ("E"):
			login();
			break;
		case ("F"):
			sair();
			break;
		default:
			System.out.println("Digite uma opção valida");
			break;			
		}
		menuPrincipal();
	}
	static void CadastroUsuario() {
		Scanner sc = new Scanner(System.in);		
		System.out.println("Tela inicial de cadastro:\nPara realizar seu cadastro preencha as informações: ");
		
		Perfil p = new Perfil();
		System.out.println("Digite seu nome: ");
		p.nome = sc.nextLine();
		System.out.println("Digite seu login: ");
		p.login = sc.nextLine();
		System.out.println("Digite sua senha: ");
		p.senha = sc.nextLine();
		
		if (p.nome.isEmpty() || p.nome.isBlank() || p.login.isEmpty() || p.senha.isEmpty()) {
			System.out.println("O sistema nao aceita campos em branco");
		}
		
		System.out.println("Parabéns cadastro realizado!");
		perfis[qtdUsuarios] = p;
		qtdUsuarios++;
		menuPrincipal();
	}
	
	static void login() 
		throws UsuarioNaoEncontradoException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lista de Usuarios do sistema");
		listaDeUsuarios();
		
		System.out.println("Digite o Login: ");
		String login = sc.next();
		System.out.println("Digite a senha: ");
		String senha = sc.next();
		for (int i = 0; i < qtdUsuarios; i++) {
			if(perfis[i].login.equals(login) && perfis[i].senha.equals(senha)) {
				System.out.println("Bem Vindo a rede social NOVA " + perfis[i].nome);
				Perfil.menuInicialUsuario();
			} else {
				throw new UsuarioNaoEncontradoException();
			}
		}
	}
	
	static void listaDeUsuarios() {
		for(int i = 0; i < qtdUsuarios; i++) {
			Perfil perfil = perfis[i];
			System.out.println(perfil.nome);
		}
	}
	static void sair() {
		System.out.println("Saindo do sistema");
		System.exit(0);
	}
}
