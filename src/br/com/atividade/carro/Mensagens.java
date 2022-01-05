package br.com.atividade.carro;

public enum Mensagens {
	ERRO_LIGAR_DIFERENTE_PONTO_NEUTRO("Para ligar, o carro precisa estar em ponto neutro"),
	ERRO_ALTERAR_STATUS_MARCHA("Erro ao alterar status da marcha"),
	ERRO_CAPACIDADE_MAXIMA_TANQUE("Capacidade maxima do tanque atingida"),
	ERRO_QUANTIDADE_INVALIDA_COMBUSTIVEL("Quantidade invalida de combustivel"),
	STATUS_COMBUSTIVEL_VAZIO("O tanque esta vazio"),
	STATUS_COMBUSTIVEL_RESERVA("O tanque esta na reserva"),
	STATUS_COMBUSTIVEL_MEIO_TANQUE("O tanque esta em meio tanque"),
	STATUS_COMBUSTIVEL_CHEIO("O tanque esta cheio"),
	ERRO_SEM_COMBUSTIVEL("O carro está sem combustivel"),
	ERRO_DESLIGADO("O carro esta desligado"),
	ERRO_PONTO_MORTO("O carro esta em ponto morto"),
	ERRO_VELOCIDADE_MAXIMA("Velocidade maxima alcancada"),
	ERRO_MARCHA_ESTADO_DIRIGIVEL("A marcha precisa estar no modo Dirigível"),
	ERRO_MARCHA_INVALIDA("valor de marcha inválido para este carro"),
	RE("RE"), NEUTRO("NEUTRO"), DIRIGIVEL("DIRIGIVEL");
	private String msg;
	
	private Mensagens(String msg) {
		this.msg = msg;
	}
	public String getMsg(){
		return this.msg;
	}
}
