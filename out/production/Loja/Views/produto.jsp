<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Cadastro de Produtos</title>
	</head>

	<body>
		<h1>Cadastro de Produto</h1>
		<p> Nome: ${produto.nome}</p>
		<p> Preço: ${produto.preco}</p>

		<form>
			<label for="nome">Nome</label>
			<input name="nome" type="text">
			<br><br>
			<label for="descricao">Descrição</label>
			<input name="descricao" type="text">
			<br><br>
			<label for="preco">Preço</label>
			<input name="preco" type="text">
			<br><br>
			<label for="quantidade">Quantidade</label>
			<input name="quantidade" type="text">
			<br><br>
			<button type="submit">Cadastrar</button>
		</form>
	</body>

</html>