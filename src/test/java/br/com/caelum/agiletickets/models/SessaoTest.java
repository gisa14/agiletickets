package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {


	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
<<<<<<< HEAD
	public void verificarSeQuantidadeDeIngressosIgualQuantidadeDisponivel() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(3);

		Assert.assertTrue(sessao.podeReservar(3));
	}
	
=======
	public void deveVenderSeingressoDisponiveisIgualAoSolicitado() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);
		Assert.assertTrue(sessao.podeReservar(sessao.getIngressosDisponiveis()));
	}
>>>>>>> ae9ddae6759f2dfc0cdb4df4ff877b7a56dffcb4
}
