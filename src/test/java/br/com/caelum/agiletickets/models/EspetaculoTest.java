package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;


import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	@Test
	public void espetaculoCriaSessoesComDataInicioMaiorQueDataFimRetornaZeroSessoes(){
		Espetaculo espetaculo = new Espetaculo();
		List<Sessao> sessoes = espetaculo.criaSessoes(new LocalDate(2013, 12, 1), new LocalDate(2013, 11, 1), new LocalTime(17,0), Periodicidade.DIARIA);
		Assert.assertEquals(sessoes.size(),0);
	}
	
	@Test
	public void espetaculoCriaSessoesComDataInicioIgualADataFimRetorna1Sessao(){
		Espetaculo espetaculo = new Espetaculo();
		LocalDate dataAtual = new LocalDate();
		LocalTime horaEspetaculo = new LocalTime(21,0);
		List<Sessao> sessoes = espetaculo.criaSessoes(dataAtual, dataAtual, horaEspetaculo, Periodicidade.DIARIA);
		Assert.assertEquals(sessoes.size(),1);
		sessoes = espetaculo.criaSessoes(dataAtual, dataAtual, horaEspetaculo, Periodicidade.SEMANAL);
		Assert.assertEquals(sessoes.size(),1);
	}
	
	@Test
	public void espetaculoCriaSessoesComDataFinal7DiasDepoisDaInicialSemanalRetorna2Sessoes(){
		Espetaculo espetaculo = new Espetaculo();
		LocalDate dataAtual = new LocalDate();
		LocalTime horaEspetaculo = new LocalTime(21,0);
		List<Sessao> sessoes = espetaculo.criaSessoes(dataAtual, dataAtual.plusDays(7), horaEspetaculo, Periodicidade.SEMANAL);
		Assert.assertEquals(sessoes.size(),2);
	}
	
	@Test
	public void espetaculoCriaSessoesComDataFinal7DiasDepoisDaInicialDiarioRetorna8Sessoes(){
		Espetaculo espetaculo = new Espetaculo();
		LocalDate dataAtual = new LocalDate();
		LocalTime horaEspetaculo = new LocalTime(21,0);
		List<Sessao> sessoes = espetaculo.criaSessoes(dataAtual, dataAtual.plusDays(7), horaEspetaculo, Periodicidade.DIARIA);
		Assert.assertEquals(sessoes.size(),8);
	}
	
	@Test
	public void espetaculoCriaSessoesComAlgumaEntradaNullLancaException(){
		try {
			
//			Assert.fail();
		} catch (Exception e) {
		}
	}
}
