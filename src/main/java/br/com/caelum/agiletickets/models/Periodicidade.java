package br.com.caelum.agiletickets.models;

import br.com.caelum.agiletickets.domain.CriadorDeSessoes;
import br.com.caelum.agiletickets.domain.CriadorDeSessoesDiaria;
import br.com.caelum.agiletickets.domain.CriadorDeSessoesSemanal;

public enum Periodicidade {
<<<<<<< HEAD
	DIARIA, SEMANAL;
=======
	DIARIA {
		@Override
		public CriadorDeSessoes getCriadorDeSessoes() {
			return new CriadorDeSessoesDiaria();
		}
	}, SEMANAL {
		@Override
		public CriadorDeSessoes getCriadorDeSessoes() {
			return new CriadorDeSessoesSemanal();
		}
	};
	
	public abstract CriadorDeSessoes getCriadorDeSessoes();
>>>>>>> ae9ddae6759f2dfc0cdb4df4ff877b7a56dffcb4
}
