/*
let xhr = new XMLHttpRequest();

xhr.open('GET', '/pessoa')

xhr.onload = function () {
	if(this.status !=200){
	console.log("Erro!!");
	}
	else{
		console.log(this.responseText);
	
	    let a = JSON.parse(this.responseText);
	    
	    console.log(a);
	}

  };
	xhr.onerror = () => alert('ERROR!');

	xhr.send();
*/

  let xhr2 = new XMLHttpRequest();
  xhr2.open('POST', '/pessoa');
  
  xhr2.onload = function(){
	  if(this.status == 200){
		  console.log("Sucesso");
	      console.log(JSON.parse(this.responseText));
	  }
  };
     xhr2.setRequestHeader('Content-Type', 'application/json');
     
     let new_pessoa = {"contato": "João", "descricao": 10};

     xhr2.send(JSON.stringify(new_pessoa));    
 </script>