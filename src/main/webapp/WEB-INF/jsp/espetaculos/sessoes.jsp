<html>
	<head>
		<title>${espetaculo.nome}</title>
	</head>
	<body>
		<h2>Criar novas sess�es</h2>
		<form action="/espetaculo/${espetaculo.id}/sessoes" method="post">
			<label for="inicio">In�cio</label>
			<input type="text" name="inicio" id="inicio"/>
						
			<label for="fim">Fim</label>
			<input type="text" name="fim" id="fim"/>
			
			<label for="horario">Hor�rio</label>
			<input type="text" name="horario" id="horario"/>
			
			<label for="periodo">Periodicidade</label>
			<select name="periodo" id="periodo">
				<option value="DIARIA">Di�ria</option>		
				<option value="SEMANAL">Semanal</option>			
			</select>
<<<<<<< HEAD
=======
			
>>>>>>> ae9ddae6759f2dfc0cdb4df4ff877b7a56dffcb4
			<input type="submit" value="Criar"/>
		</form>
	
	</body>
</html>