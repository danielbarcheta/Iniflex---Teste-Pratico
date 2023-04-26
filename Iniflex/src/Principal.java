import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

public class Principal {

	public static void main(String[] args) {

		/*
		 * Para atender as requisicoes, foi utilizado uma LinkedList. Poderia se ter
		 * implementado tambem um Arraylist
		 */

		List<Funcionario> funcionarios = new LinkedList<>();

		/* 3.1: Adicionando as entradas da tabela */
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2020, 10, 18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("Joao", LocalDate.of(1990, 05, 12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 2), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		funcionarios
				.add(new Funcionario("Alice", LocalDate.of(1995, 01, 5), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heltor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios
				.add(new Funcionario("Heloisa", LocalDate.of(2003, 05, 24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2779.93"), "Gerente"));

		/* 3.2: Removendo o funcionario Joao utilizando lambda */
		funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
		System.out.println("\n-->Imprimindo os funcionarios inseridos na lista<-- \n");

		
		/* 3.3: Imprimindo os funcionarios presentes na LinkedList no formato
		 * requisitado
		 */
		for (Funcionario valor : funcionarios) {
			System.out.println(valor);
		}

		/* 3.4: Atualizando o salario dos funcionarios com 10% de aumento */
		BigDecimal aumento = new BigDecimal(10);
		for (Funcionario valor : funcionarios) {
			valor.AtualizaSalario(aumento);
		}

		// Obs: Imprimindo os funcionarios novamente com os valores atualizados(a fins
		// de correcao).

		System.out.println("\n-->Imprimindo todos os funcionarios com salario atualizado<--\n");
		for (Funcionario valor : funcionarios) {
			System.out.println(valor);
		}

		
		/* 3.5 e 3.6: Passando os funcionarios num Map e imprimindo-os agrupando-os por funcao */
		 

		System.out.println("\n-->Imprimindo os funcionarios agrupados por Funcao<--\n");

		// -> PASSO 1: AGRUPA-LOS EM ARRAYS DE ACORDO COM A FUNCAO
		Map<String, List<Funcionario>> grupo = new HashMap<>();
		for (Funcionario temp : funcionarios) {
			String funcao = temp.getFuncao();
			if (!grupo.containsKey(funcao)) {
				grupo.put(funcao, new ArrayList<Funcionario>());
			}
			grupo.get(funcao).add(temp);

		}
		// -> PASSO 2: IMPRIMIR CADA UM DESSES ARRAYS(isto e, cada um dos valores de
		// cada key que os representa)

		for (Entry<String, List<Funcionario>> pair : grupo.entrySet()) {
			System.out.println(pair.getKey());
			System.out.println(pair.getValue() + "\n");
		}

		/* 3.8: Imprimindo funcionarios aniversariantes nos meses 11 e 12 */

		System.out.println("\n-->Impressao dos funcionarios aniversariantes nos meses 10 e 12<--\n");
		for (Funcionario funcionario : funcionarios) {
			LocalDate dataNascimento = funcionario.getData_nascimento();
			int mes = dataNascimento.getMonthValue();
			if (mes == 10 || mes == 12) {
				System.out.println(funcionario.getNome());
			}

		}

		/* 3.9 Encontrando o funcionario que possui maior idade */

		// -> PASSO 1: Encontrar a maior idade dentre os funcionarios da LinkedList criada

		int maxIdade = 0;
		for (Funcionario F : funcionarios) {

			int atual = F.getIdade();
			if (atual > maxIdade) {
				maxIdade = atual;

			}

		}

		// -> PASSO 2: Iterar sobre a lista para encontrar o funcionario que possui esta
		// idade e printa-lo
		Iterator<Funcionario> it = funcionarios.iterator();
		while (it.hasNext()) {

			Funcionario maisvelho = it.next();

			if (maisvelho.getIdade() == maxIdade) {

				System.out.println("\n->O funcionario mais velho possui " + maxIdade + " anos. " + "Seus dados: \n"
						+ "Nome: " + maisvelho.getNome() + " Idade: " + maisvelho.getIdade());
				break;

			}

		}

		/* 3.10: Imprimindo a lista de funcionarios por ordem alfabetica */
		System.out.println("\n-->Imprimindo a lista em ordem alfabetica:\n");
		Collections.sort(funcionarios); // A classe "Pessoa" implementa o metodo compareTo atraves do nome.
		System.out.println(funcionarios);

		/* 3.11: Imprimindo o total dos salarios dos funcionarios */
		System.out.println("\n-->Imprimindo a soma dos salarios dos funcionarios:\n");
		BigDecimal totalSalario = new BigDecimal("0");
		for (Funcionario funcionario : funcionarios) {
			totalSalario = totalSalario.add(funcionario.getSalario());
		}
		System.out.println("Total de salários: " + totalSalario);

		
		/* 3.12: Imprimindo quantos salarios minimos ganha cada funcionario (Considerando o aumento!). */
		System.out.println("\nQuantos salários mínimos ganha cada funcionario:");
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome() + ": " + (funcionario.getSalario()).intValue() / 1212);
		}

	}
}
