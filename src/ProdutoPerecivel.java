import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
    
    private static final double desconto = 0.25;
    private static final int prazo_desconto = 7;
    private LocalDate dataDeValidade;

    public ProdutoPerecivel (String desc, double precoCusto, double margemLucro, LocalDate validade) {
        super(desc, precoCusto, margemLucro);
        this.dataDeValidade = validade;
        if ( validade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("O Produto Não Existe");
        }
        dataDeValidade = validade;
    }

    public double valorDeVenda() {
        if (LocalDate.now().until(dataDeValidade).getDays() <= prazo_desconto) {
            return (precoCusto * (1.0 + margemLucro)) * (1-desconto);
        }
        return (precoCusto * (1.0 + margemLucro));
    }

    public String toString() {
        return super.toString();
    }

        /**
    * Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas
    decimais.
    * Data de validade vai no formato dd/mm/aaaa
    * @return Uma string no formato "2; descrição;preçoDeCusto;margemDeLucro;dataDeValidade"
    */
    @Override
    public String gerarDadosTexto() {
        
    }
}
