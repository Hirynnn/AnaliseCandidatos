import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AnalisarCandidatos {
    // Criando lista para armazenar os dados
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Integer> numeros = new ArrayList<>();
    static ArrayList<Double> salarios = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // criando try
        try {
            Scanner sc = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("PROCESSO DE SELEÇÃO DE CANDIDATOS");
            // declarando variavel do while
            String acao = "a";
            // Criando while para continuar adicionando usuarios sem precisar reiniciar o
            // programa
            while (!acao.equals("0")) {
                System.out.println(
                        "Digite 1 para adicionar um candidato | digite 2 para imprimir os candidatos selecionados | Digite 3 para fechar o sistema");
                acao = sc.nextLine();
                // Regra para finalizar o sistema
                if (acao.equals("3")) {
                    System.out.println("Fechando o programa !");
                    break;
                    // Regras para chamar os metodos
                } else if (acao.equals("1")) {
                    System.out.print("Nome do candidato: ");
                    String nome = sc.nextLine();
                    System.out.print("Salário Pretendido: ");
                    double salarioPretendido = sc.nextDouble();
                    System.out.print("Número do telefone: ");
                    int numero = sc.nextInt();
                    sc.nextLine(); // Consumindo a quebra de linha

                    analisarCandidato(nome, salarioPretendido, numero);
                } else if (acao.equals("2")) {
                    escolhidos();
                }
                sc.close();
            }
        } // Criando regra excecao
        catch (java.util.InputMismatchException e) {
            System.out.println("Digite os dados corretamente ! ");
        }

    }

    // metodo para avaliar a pessoa
    static void analisarCandidato(String nome, double salarioPretendido, int numero) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
            // Adicionando os dados dos selecionados no array
            nomes.add(nome);
            numeros.add(numero);
            salarios.add(salarioPretendido);
            // Adicionando os dados dos selecionados no array
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
            nomes.add(nome);
            numeros.add(numero);
            salarios.add(salarioPretendido);
        } else {
            System.out.println("AGUARDANDO OS DEMAIS CANDIDATOS");
        }

    }

    // Metodo para printar todos os selecionados
    public static void escolhidos() {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Nome: " + nomes.get(i) + " | Salario Pretendido: " + salarios.get(i) + " | Telefone: "
                    + numeros.get(i));
        }

    }

}
