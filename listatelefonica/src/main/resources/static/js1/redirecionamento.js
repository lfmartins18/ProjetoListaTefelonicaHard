
function criarTabela(){
	fetch("/usuario")
	.then(function(response){
		if(response.status >= 200 && response.status <= 300){

			response.json()
			.then(function(data){

				let tb = document.getElementById("usuario");

				tb.innerHTML = "<tr><th>Id</th><th>Nome</th><th>Email</th>" +
				"<th>Senha</th><th>Nascimento</th></tr>"

				for(let i=0; i<data.content.length; i++){

					let p = data.content[i];

					tb.innerHTML += `<tr><th>${p.id}</th><th>${p.nome}</th><th>${p.email}</th><th>${p.senha}</th><th>${p.dataNasc}</th> <th><button onclick="apagarUsuario(${p.id})">Apagar</button></th></tr>`

				}

			});

		}
	}).catch(function(error){
		console.log(error);
	});
}

function apagarUsuario(id){
	fetch("/usuario/"+id,{
		method: "DELETE",
		
	}).then(function (response){
		
		criarTabela();
	}).catch(function (error){
		console.log(error);
	});
}
criarTabela();