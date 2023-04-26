import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa implements Comparable<Pessoa>{

	protected String nome;
	protected LocalDate data_nascimento;

	public Pessoa(String nome, LocalDate data_nascimento) {
		super();
		this.nome = nome;
		this.data_nascimento = data_nascimento;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected LocalDate getData_nascimento() {
		return data_nascimento;
	}

	protected void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String toString() {

		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "nome= " + nome + ", data_nascimento= " + data_nascimento.format(f);
	}
	
	public int getIdade() {
        LocalDate atual = LocalDate.now();
        return (atual.getYear() - data_nascimento.getYear());
    }

	@Override
	public int compareTo(Pessoa o) {
		 return this.getNome().compareTo(o.getNome());
    }
		
	}

	

	
	

