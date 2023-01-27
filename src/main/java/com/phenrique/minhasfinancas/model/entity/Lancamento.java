package com.phenrique.minhasfinancas.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.phenrique.minhasfinancas.model.enums.StatusLancamento;
import com.phenrique.minhasfinancas.model.enums.TipoLancamento;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "lancamentos", schema = "financas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "mes")
	private Integer mes;
	@Column(name = "ano")
	private Integer ano;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	@Column(name = "valor")
	private BigDecimal valor;
	@Column(name = "data_cadastro")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataCadastro;
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusLancamento status;
}
