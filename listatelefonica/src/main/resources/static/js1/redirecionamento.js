
function criarTabela(){
	fetch("/usuario")
	.then(function(response){
		if(response.status >= 200 && response.status <= 300){

			response.json()
			.then(function(data){

				let tb = document.getElementById("usuario");

				tb.innerHTML = "<tr><th>Nome</th><th>Email</th>" +
				"<th>Senha</th><th>Nascimento</th></tr>"

				for(let i=0; i<data.content.length; i++){

					let p = data.content[i];

					tb.innerHTML += `<tr><th>${p.nome}</th><th>${p.email}</th><th>${p.senha}</th><th>${p.dataNasc}</th></tr>`

				}

			});

		}
	}).catch(function(error){
		console.log(error);
	});
}
criarTabela();