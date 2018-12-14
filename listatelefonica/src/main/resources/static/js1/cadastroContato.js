function addContato(){
	let contato = document.getElementById("contato").value;

	let novo_usuario = {
			contato: contato,
	};

	fetch("/login", {
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(novo_usuario)
	
	}).then(function(response){

	}).catch(function(error){
		console.log(error);
	});

}
function criarTabela(){
	fetch("/pessoa")
	.then(function(response){
		if(response.status >= 200 && response.status <= 300){

			response.json()
			.then(function(data){

				let tb = document.getElementById("lista_contato");

				tb.innerHTML = "<tr><th>Id</th><th>Contato</th></tr>"

				for(let i=0; i<data.content.length; i++){

					let p = data.content[i];

					tb.innerHTML += `<tr><th>${p.id}</th><th>${p.contato}</th></tr>`

				}

			});

		}
	}).catch(function(error){
		console.log(error);
	});
}

criarTabela();