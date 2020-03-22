package br.com.emprestimo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cliente")
@Entity
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name="nome")
	private String  nome;

	@Column(name="endereco")
	private String endereco;

	@Column(name="rendimento_mensal")
	private Float rendimento_mensal;

	@Column(name="risco")
	private Character risco;

	@Column(name="possui_emprego", columnDefinition="BIT")
	private boolean possui_emprego;

	@Column(name="valor_tot_patrimonio")
	private Float valor_tot_patrimonio;

	@Column(name="valor_tot_dividas")
	private Float valor_tot_dividas;

	@Column(name="valor_emprestimo_solicitado")
	private Float valor_emprestimo_solicitado;

	@Column(name="num_parcelas")
	private Integer num_parcelas;

	@Column(name="valor_emprestimo_final")
	private Float valor_emprestimo_final;

}
