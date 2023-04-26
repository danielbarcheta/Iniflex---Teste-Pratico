import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

	private BigDecimal salario;
	private String funcao;

	public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
		super(nome, data_nascimento);
		this.salario = salario;
		this.funcao = funcao;

	}

	protected BigDecimal getSalario() {
		return salario;
	}

	protected void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	protected String getFuncao() {
		return funcao;
	}

	protected void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {

		String sal_formatado = NumberFormat.getCurrencyInstance().format(this.salario);
		return super.toString() + " salario=" + sal_formatado + ", função= " + funcao;
	}

	protected void AtualizaSalario(BigDecimal porcentagem) {
		BigDecimal temp = new BigDecimal(100);
		porcentagem = porcentagem.add(temp);
		porcentagem = porcentagem.divide(temp);
		this.salario = this.salario.multiply(porcentagem);
	}

	

	
}
