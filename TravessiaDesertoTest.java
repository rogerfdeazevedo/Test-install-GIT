package com.senac.jogos;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TravessiaDesertoTest {
	boolean resultado;
	TravessiaDeserto jogo;

	// TESTING METHOD AVANÇAR

	@Before
	public void setUpAvancar() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testAvancar() {
		// TESTANDO AVANÇAR NA POS == 0
		jogo.initGame();
		jogo.avancar();
		assertEquals(5, jogo.getFuel());
		assertEquals(1, jogo.getPos());
		// TESTANDO AVANÇAR NA POS==10
		jogo.getMap()[1] = 10;
		for (int i = 0; i <= 10; i++) {
			jogo.carregar();
		}
		for (int a = 0; a <= 9; a++) {
			jogo.avancar();
		}
		assertEquals(11, jogo.getPos());
	}

	@After
	public void tearDownAvancar() {
		jogo = null;
	}

	// TESTANDO O MÉTODO VOLTAR

	@Before
	public void setUpVoltar() {
		jogo = new TravessiaDeserto();
	}

	@Test
	public void testVoltar() {
		// TESTANDO O MÉTODO VOLTAR NA POS==0
		jogo.initGame();
		jogo.voltar();
		assertEquals(0, jogo.getPos());
		// TESTANDO O MÉTODO VOLTAR NA POS==1
		jogo.avancar();
		jogo.voltar();
		assertEquals(0, jogo.getPos());
		// TESTANDO O MÉTODO VOLTAR NA POS==10
		jogo.getMap()[0] = 5;
		for (int a = 0; a <= 5; a++) {
			jogo.carregar();
		}
		for (int i = 0; i <= 9; i++) {
			jogo.avancar();
		}
		jogo.voltar();
	}

	@After
	public void tearDownVoltar() {
		jogo = null;
	}

	// TESTANDO O MÉTODO DESCARREGAR

	@Before
	public void setUpDescarregar() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testDescarregar() {
		// TESTANDO DESCARREGAR FUEL==0
		jogo.descarregar();
		assertEquals(0, jogo.getFuel());
		// TESTANDO DESCARREGAR POS==0
		jogo.initGame();
		jogo.descarregar();
		assertEquals(5, jogo.getFuel());
		assertEquals(0, jogo.getPos());
		// TESTANDO DESCARREGAR POS==1
		jogo.avancar();
		assertEquals(4, jogo.getFuel());
		assertEquals(1, jogo.getPos());
		jogo.descarregar();
		assertEquals(3, jogo.getFuel());
		assertEquals(1, jogo.getPos());
		// TESTANDO DESCARREGAR POS==2
		jogo.avancar();
		assertEquals(2, jogo.getFuel());
		assertEquals(2, jogo.getPos());
		jogo.descarregar();
		assertEquals(1, jogo.getFuel());
		assertEquals(2, jogo.getPos());
		// PREPARANDO DESCARREGAR POS==3
		jogo.getMap()[2] = 5;
		assertEquals(5, jogo.getMap()[2]);
		for (int i = 0; i <= 6; i++) {
			jogo.carregar();
		}
		assertEquals(6, jogo.getFuel());
		// TESTANDO DESCARREGAR POS==3
		jogo.avancar();
		jogo.descarregar();
		assertEquals(4, jogo.getFuel());
		// TESTANDO DESCARREGAR POS==4
		jogo.avancar();
		jogo.descarregar();
		assertEquals(2, jogo.getFuel());
		// TESTANDO DESCARREGAR POS==5
		jogo.avancar();
		jogo.descarregar();
		assertEquals(0, jogo.getFuel());
		// PREPARANDO PARA TESTAR POS 6
		jogo.getMap()[5] = 6;
		for (int i = 0; i <= 5; i++) {
			jogo.carregar();
		}
		assertEquals(6, jogo.getFuel());
		// TESTANDO DESCARREGAR POS==5
		jogo.descarregar();
		assertEquals(5, jogo.getFuel());
		jogo.avancar();
		// TESTANDO DESCARREGAR POS==6
		jogo.descarregar();
		assertEquals(3, jogo.getFuel());
		jogo.avancar();
		// TESTANDO DESCARREGAR POS==7
		jogo.descarregar();
		assertEquals(1, jogo.getFuel());
		jogo.avancar();
		// PREPARANDO PARA TESTAR POS 8
		jogo.getMap()[8] = 6;
		for (int i = 0; i <= 6; i++) {
			jogo.carregar();
		}
		// TESTANDO DESCARREGAR POS==8
		jogo.descarregar();
		assertEquals(5, jogo.getFuel());
		jogo.avancar();
		// TESTANDO DESCARREGAR POS==9
		jogo.descarregar();
		assertEquals(3, jogo.getFuel());
		jogo.avancar();
		assertEquals(10, jogo.getPos());
		// NÃO É POSSIVEL DESCARREGAR NA POS 10
	}

	@After
	public void tearDownDescarregar() {
		jogo = null;
	}

	// TESTANDO O MÉTODO CARREGAR

	@Before
	public void setUpCarregar() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testCarregar() {
		// TESTANDO CARREGAR NA POS == 0
		jogo.initGame();
		jogo.carregar();
		assertEquals(6, jogo.getFuel());
		// TESTANDO CARREGAR COM 0 DE RESERVA NA POS == 1
		jogo.avancar();
		jogo.carregar();
		assertEquals(5, jogo.getFuel());
		// PRERANDO CENÁRIO PARA TESTAR CARRGAR COM RESERVA >0 NA POS ==1
		jogo.getMap()[1] = 2;
		// TESTANDO CARRGAR COM RESERVA >0 NA POS ==1
		jogo.carregar();
		assertEquals(6, jogo.getFuel());
		// PREPARANDO CENÁRIO PARA TESTAR CARREGAR COM 0 DE RESERVA NA POS ==9
		jogo.getMap()[1] = 5;
		for (int i = 0; i <= 5; i++) {
			jogo.carregar();
		}
		for (int e = 0; e <= 7; e++) {
			jogo.avancar();
		}
		jogo.getMap()[9] = 0;
		// TESTANDO CARREGAR COM 0 DE RESERVA NA POS == 9
		jogo.carregar();
		assertEquals(3, jogo.getFuel());
	}

	@After
	public void tearDownCarregar() {
		jogo = null;
	}

	// TESTANDO O MÉTODO ISWINNER

	@Before
	public void setUpWinner() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testWinner() {
		jogo.initGame();
		for (int i = 1; i < 7; i++) {
			jogo.avancar();
			assertEquals(false, jogo.isWinner());
		}
		jogo.getMap()[6] = 6;
		for (int a = 0; a < 4; a++) {
			jogo.carregar();
		}
		for (int a = 0; a < 3; a++) {
			jogo.avancar();
			assertEquals(false, jogo.isWinner());
		}
		assertEquals(1, jogo.getFuel());
		assertEquals(9, jogo.getPos());
		assertEquals(false, jogo.isWinner());

		// AMBIENTE PRONTO
		jogo.avancar();
		assertEquals(true, jogo.isWinner());

	}

	@After
	public void tearDownWinner() {
		jogo = null;
	}

	//TESTANDO O MÉTODO ISGAMEOVER
	public void setUpGameOver() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testGameOver() {
		jogo.initGame();
		for (int i = 1; i < 7; i++) {
			jogo.avancar();			
		}		
		assertEquals(true, jogo.isGameOver());
	}

	@After
	public void tearDownGameOver() {
		jogo = null;
	}

	
}
