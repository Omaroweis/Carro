package br.com.testes;

import br.com.atividade.carro.Carro;

public class testeCarro {
	public static void main(String[] args) {
		Carro carro = new Carro("Chevrolet", "Celta", "ABC-123");
		
		try{
			carro.ligar();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try{
			carro.abastecer((float)(35.0));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try{
			carro.setDirigivel();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Float aceleracao = (float) 6;
		try{
			carro.acelerar(aceleracao, 5);
			aceleracao = (float) 3;
			carro.acelerar(aceleracao, 1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(carro);
		
		carro.desligar();
		try{
			carro.setNeutro();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(carro);
		
	}
}
