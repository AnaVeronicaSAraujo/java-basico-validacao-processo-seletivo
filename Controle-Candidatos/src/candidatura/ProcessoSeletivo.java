package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	
	public static void main(String[] args) {

        verificarCandidato(1900.0); // Chamando o para verificarCandidato
        case2();
        case3();
	}
		
	// CASE 1:

	public static void verificarCandidato(double salarioPretendido) {
		System.out.println("----------------------------CASE1-------------------------------------");

		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		}
		else if(salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO COM A CONTRA PROPOSTA");
		}
		else {
			System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
		}
	}
	
	//CASE 2:
		public static void case2() {
			System.out.println("----------------------------CASE2-------------------------------------");

			double salarioBase = 2000.0;
			String [] candidatos = {"ANA","VERONICA","VITÓRIA","MARIANA","GABRIEL","RAFAEL","MAURA","MICHAEL"};
			int totalSelecionados = 0;
			int proximoCandidato = 0; 
			while(totalSelecionados <5 && proximoCandidato < candidatos.length) {
				String candidato = candidatos[proximoCandidato++];
				double valorPretendido = valorPretendido();
				System.out.println("O candidato " + candidato + " está pedindo " + valorPretendido);
				if(valorPretendido > salarioBase) {
					System.out.println("QUE PENA!! O candidato " + candidato + " NÃO foi selecionado ");
					
				}else {
					System.out.println("LEGAL!! O candidato " + candidato + " foi selecionado ");
					totalSelecionados++;
				}
				
			}
			System.out.println("Total de candidatos selecionados: " + totalSelecionados);
			System.out.println("Total de consultados: " + proximoCandidato);

		}
		static double valorPretendido() {
		     return ThreadLocalRandom.current().nextDouble(1800, 2200);

		}
		
		//CASE 3: IMPRIMINDO LISTA DOS CANDIDATOS 
		
		static void case3() {
			System.out.println("----------------------------CASE3/4-------------------------------------");

			String [] candidatosSelecionados = {"ANA","VERONICA","VITÓRIA","MARIANA","GABRIEL"};
			
			System.out.println("Lista dos Candidatos Selecionados");
			
			for(String candidato: candidatosSelecionados) {
				System.out.println(candidato);
				case4(candidato);

			}	
		}

			static void case4(String candidato) {			
				int tentativasRealizadas = 1;
				boolean continuarTentando = true;
				boolean atendeu=false;
				do {
					atendeu= atender();
					continuarTentando = !atendeu;
					if(continuarTentando)
						tentativasRealizadas++;
					else
						System.out.println("CONTATO REALIZADO COM SUCESSO");
					
				}while(continuarTentando && tentativasRealizadas<3);
				
				if(atendeu)
					System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
				else
					System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
				
				
			}
				static boolean atender() {
				return new Random().nextInt(3)==1;	
			}
		}

