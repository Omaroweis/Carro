package br.com.atividade.carro;
import java.util.Random;
public class Carro {
	private String marca;
	private String modelo;
	private String placa;
	private Boolean Isligado;
	private Marcha marcha;
	private Float combustivel;
	private Integer contaGiro;
	private Float velocidade;
	
	public Carro(){
		this.Isligado = false;
		this.combustivel = (float) 0;
		this.contaGiro = 0;
		this.marcha = new Marcha();
		this.velocidade = (float) 0;
		this.marca = "";
		this.modelo = "";
		this.placa = "";
	}
	public Carro(String marca, String modelo, String placa){
		this.Isligado = false;
		this.combustivel = (float) 0;
		this.contaGiro = 0;
		this.marcha = new Marcha();
		this.velocidade = (float) 0;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}
	

			
	private void aumentarMarcha() {
		try {
			this.marcha.setValorMarcha(this.marcha.getValorMarcha() + 1);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private void reduzirMarcha() {
		try {
			this.marcha.setValorMarcha(this.marcha.getValorMarcha() - 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private void alterarStatusMarcha(Integer status) {
		this.marcha.setStatus(status);
		
		this.contaGiro = 0;
		
	}
		
	/**
	 * calcula qual sera a velocidade resultante, admitindo a velocidade atual + a influencia da aceleracao recebida
	 * @param aceleracao em M/S
	 * @param tempo -> tempo em segundos em que o pedal da aceleraçao se manteve ativo
	 * @return
	 */
	private float calculaVelocidade(float aceleracao, Integer tempo) {
		return this.velocidade + aceleracao*tempo;
	}
	              
	private void calcularContaGiro(Float aceleracao) {
				
		if(aceleracao >0 && aceleracao < 1.5) {
			this.contaGiro = 1;
		}
		else {
			if(aceleracao <2.5) {
				this.contaGiro = 2;
			}
			else {
				if(aceleracao <5) {
					this.contaGiro = 3;
				}
				else {
					this.contaGiro = 4;
				}
			}
		}

	}
	private void alterarMarcha() {
		if(this.contaGiro >= 3)
		{
			this.aumentarMarcha();
		}
		else if(this.contaGiro <= 2) {
			this.reduzirMarcha();
		}
	}
	private void calculaConsumo(Integer distancia) { // 1L por km
		this.combustivel-= (float)(distancia/10);
	}
	
	public void ligar() throws Exception {
		if(this.marcha.getStatus() != 0)
			throw new Exception(Mensagens.ERRO_LIGAR_DIFERENTE_PONTO_NEUTRO.getMsg());
		
		
		this.Isligado = true;
		this.combustivel = (float) (this.combustivel - 0.3);
	}
	public void desligar() {
		this.parar();
		this.Isligado = false;
		
	}
	public void parar() {
		this.velocidade = (float) 0;
		this.contaGiro = 0;
		try{
			this.marcha.setValorMarcha(1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void setNeutro() throws Exception {
		if(this.marcha.getStatus() == 0)
			throw new Exception(Mensagens.ERRO_ALTERAR_STATUS_MARCHA.getMsg());
		this.alterarStatusMarcha(0);
	}
	public void setDirigivel() throws Exception {
		if(this.marcha.getStatus() == 1)
			throw new Exception(Mensagens.ERRO_ALTERAR_STATUS_MARCHA.getMsg());
		
		this.alterarStatusMarcha(1);
		this.aumentarMarcha();
	}
	public void setRe() throws Exception {
		if(this.marcha.getStatus() == -1)
			throw new Exception(Mensagens.ERRO_ALTERAR_STATUS_MARCHA.getMsg());
		this.alterarStatusMarcha(-1);
	}
	/**
	 * 
	 * @param quantidadeCombustivel em L
	 * @throws Exception 
	 */
	public void abastecer(Float quantidadeCombustivel) throws Exception {
		if(this.combustivel+quantidadeCombustivel > 50)
			throw new Exception(Mensagens.ERRO_CAPACIDADE_MAXIMA_TANQUE.getMsg());
		if(quantidadeCombustivel <= 0)
			throw new Exception(Mensagens.ERRO_QUANTIDADE_INVALIDA_COMBUSTIVEL.getMsg());
		
		this.combustivel+=quantidadeCombustivel;
	}
	
	public String getStatusCombustivel() {
		if(this.combustivel == 0)
			return (Mensagens.STATUS_COMBUSTIVEL_VAZIO.getMsg());
		else if(this.combustivel<11)
			return (Mensagens.STATUS_COMBUSTIVEL_RESERVA.getMsg());
		else if(this.combustivel <26)
			return(Mensagens.STATUS_COMBUSTIVEL_MEIO_TANQUE.getMsg());
		else return(Mensagens.STATUS_COMBUSTIVEL_CHEIO.getMsg());
	}
	public float getVelocidadeKmH() {
		return (float) (this.velocidade *3.6);
	}
	public float getVelocidadeMS() {
		return this.velocidade;
	}
	// ---------------------------------//
	/**
	 * @param aceleracao
	 * @param tempo
	 * @throws Exception
	 */
	public void acelerar(Float aceleracao, Integer tempo) throws Exception {
		if(this.combustivel == 0) {
			throw new Exception(Mensagens.ERRO_SEM_COMBUSTIVEL.getMsg());
		}
		if(this.Isligado == false) {
			throw new Exception(Mensagens.ERRO_DESLIGADO.getMsg());
		}
		if(this.marcha.getStatus() == 0) {
			throw new Exception(Mensagens.ERRO_PONTO_MORTO.getMsg());
		}
		if(calculaVelocidade(aceleracao, tempo) * 3.6 > 120) {
			throw new Exception(Mensagens.ERRO_VELOCIDADE_MAXIMA.getMsg());
		}
		Random r = new Random();
		Integer distancia = r.nextInt(20); // em metros
				
		if(this.marcha.getStatus() == 1) {
			calcularContaGiro(aceleracao);
			alterarMarcha();
			calculaConsumo(distancia);
			this.velocidade = calculaVelocidade(aceleracao, tempo);
		}
		if(this.marcha.getStatus() ==-1) {
			this.contaGiro = 0;
			
			calculaConsumo(distancia);
			
		}

	}
	@Override
	public String toString() {
		if(this.Isligado) {
			 return (this.marca + " " + this.modelo + " " + this.placa + " " + ", está a " + this.getVelocidadeKmH() + " KM/H" + " Com combustivel = "+ this.combustivel + "L,  E está " +  "Ligado. O status da marcha eh: " + this.marcha.toString());
		}
		return  (this.marca + " " + this.modelo + " " + this.placa + " " + ", está a " + this.getVelocidadeKmH() + " KM/H" + " Com combustivel = "+ this.combustivel + "L,  E está " + "Desligado. O status da marcha eh: " + this.marcha.toString());
	}
	
}
