package br.com.atividade.carro;

public class Marcha {
	/**
	 * controla se a marcha do carro está em N(neutro), D(dirigível), R(ré) e o valor de marcha
	 */
	private StatusMarcha status; 
	private Integer valorMarcha; 
	Marcha(){
		this.status = StatusMarcha.NEUTRO;
		this.valorMarcha = 0;
	}
	  
	public void setStatus(StatusMarcha status) {
		this.status = status;
		if(this.status != StatusMarcha.DIRIGIVEL) {
			this.valorMarcha = 0;
		}
	}
	public void setValorMarcha(Integer valor) throws Exception {
		if(this.status != StatusMarcha.DIRIGIVEL) {
			throw new Exception(Mensagens.ERRO_MARCHA_ESTADO_DIRIGIVEL.getMsg());
		}
		if(valor >6 || valor<1) {
			throw new Exception(Mensagens.ERRO_MARCHA_ESTADO_DIRIGIVEL.getMsg());
		}
		this.valorMarcha = valor;
	}
	public StatusMarcha getStatus() {
		return this.status;
	}
	public Integer getValorMarcha() {
		return this.valorMarcha;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(this.status == StatusMarcha.RE)
			return (Mensagens.RE.getMsg());
		if(this.status == StatusMarcha.NEUTRO)
			return(Mensagens.NEUTRO.getMsg());
		if(this.status==StatusMarcha.DIRIGIVEL) {
			return(Mensagens.DIRIGIVEL.getMsg() +" e na "+ + this.getValorMarcha() + "a Marcha");
		}
		return(Mensagens.ERRO_MARCHA_INVALIDA.getMsg());
	}
	
	
}
