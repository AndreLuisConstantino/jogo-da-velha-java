import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		String simboloAdversario;
		
		Boolean game = true;
		
		String vitoria = "";
		
		char simboloAtual = 'X';
		
		Scanner scanner = new Scanner(System.in);
        
        Campo[][] velha = new Campo[3][3];
        
        iniciarJogo(velha);
        
        while (game) {
        	desenhaJogo(velha);
        	vitoria = verificaVitoria(velha);
        	if (!vitoria.equals("")) {
        		System.out.printf(vitoria);
        		break;
        	}
        	try {
        		if (verificarJogada(velha, jogar(scanner, simboloAtual), simboloAtual)) {
        			if (simboloAtual == 'X') {
        				simboloAtual = 'O';
        			} else {
        				simboloAtual = 'X';
        			}
        		}
        		
        	} catch (Exception e) {
				System.out.printf("erro");
			}
        }
        System.out.printf("Fim do jogo!");
	}
	
	public static void desenhaJogo(Campo[][] velha) {
		//limparTela();
		System.out.println("    0    1    2\n");
		System.out.printf ("0    %c | %c | %c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
		System.out.println("     -------------");
		System.out.printf ("1    %c | %c | %c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
		System.out.println("     -------------");
		System.out.printf( "2    %c | %c | %c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
	}
	
	public static void limparTela() {
		for (int cont = 0; cont < 200; cont++) {
			System.out.println("");
		}
	}
	
	public static int[] jogar(Scanner scanner, char simboloAtual) {
		int p[] = new int[2];
		
		System.out.printf("%s %c%n", "Quem joga: ", simboloAtual);
		System.out.print("Informa a linha: ");
		p[0] = scanner.nextInt();
		System.out.print("Informe a coluna: ");
		p[1] = scanner.nextInt();
		
		return p;
	}
	
	public static void iniciarJogo(Campo[][] velha) {
		for (int l = 0; l < 3; l++) {
			for (int c=0; c < 3; c++) {
				velha[l][c] = new Campo();
			}
		}
	}
	
	public static String verificaVitoria(Campo[][] velha) {

	    for (int i = 0; i < 3; i++) {
	        if ((velha[i][0].getSimbolo() == 'X' && velha[i][1].getSimbolo() == 'X' && velha[i][2].getSimbolo() == 'X') || (velha[i][0].getSimbolo() == 'O' && velha[i][1].getSimbolo() == 'O' && velha[i][2].getSimbolo() == 'O')) {
	            return "Jogador " + velha[i][0].getSimbolo() + " venceu na linha " + i;
	        }
	    }

	    for (int i = 0; i < 3; i++) {
	        if ((velha[0][i].getSimbolo() == 'X' && velha[1][i].getSimbolo() == 'X' && velha[2][i].getSimbolo() == 'X') || (velha[0][i].getSimbolo() == 'O' && velha[1][i].getSimbolo() == 'O' && velha[2][i].getSimbolo() == 'O')) {
	            return "Jogador " + velha[0][i].getSimbolo() + " venceu na coluna " + i;
	        }
	    }

	    if ((velha[0][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X') || (velha[0][0].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O')) {
	        return "Jogador " + velha[0][0].getSimbolo() + " venceu na diagonal principal";
	    }

	    if ((velha[0][2].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][0].getSimbolo() == 'X') || (velha[0][2].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][0].getSimbolo() == 'O')) {
	        return "Jogador " + velha[0][2].getSimbolo() + " venceu na diagonal secundária";
	    }

	    return "";
	}

	
	public static Boolean verificarJogada(Campo[][] velha, int p[], char simboloAtual) {
		if (velha[p[0]][p[1]].getSimbolo() == ' ') {
			velha[p[0]][p[1]].setSimbolo(simboloAtual);
			return true;
		} else {
			return false;
		}
	}
}
