package br.com.atividade.carro;

public class Marcha {
	/**
	 * controla se a marcha do carro est� em N(neutro), D(dirig�vel), R(r�) e o valor de marcha
	 */
	private Integer status; // 0 para N, 1 para dirig�vel e -1 para R
	private Integer valorMarcha; // quando valorMarcha for 0, o status � diferente de dirig�vel. o range da marcha vai de 1 a ;
	
	Marcha(){
		this.status = 0;
		this.valorMarcha = 0;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
		if(this.status != 1) {
			this.valorMarcha = 0;
		}
	}
	public void setValorMarcha(Integer valor) throws Exception {
		if(this.status != 1) {
			throw new Exception(Mensagens.ERRO_MARCHA_ESTADO_DIRIGIVEL.getMsg());
		}
		if(valor >6 || valor<1) {
			throw new Exception(Mensagens.ERRO_MARCHA_ESTADO_DIRIGIVEL.getMsg());
		}
		this.valorMarcha = valor;
	}
	public Integer getStatus() {
		return this.status;
	}
	public Integer getValorMarcha() {
		return this.valorMarcha;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(this.status == -1)
			return (Mensagens.RE.getMsg());
		if(this.status == 0)
			return(Mensagens.NEUTRO.getMsg());
		if(this.status==1) {
			return(Mensagens.DIRIGIVEL.getMsg() +" e na "+ + this.getValorMarcha() + "a Marcha");
		}
		return(Mensagens.ERRO_MARCHA_INVALIDA.getMsg());
	}
	
	
}
