var botao = document.querySelector("#btn-atualizar");

botao.addEventListener('click', () => {
    // O elemento que chama essa função perde suas ações padrões
    var form = document.querySelector("#form-contato");
    var painelDeErros = document.querySelector("#painel-erros");
    var ulErros = document.querySelector("#mensagemErros");
    var contato = obterUsuario(form);
    var erros = getErros(usuario);
    
    if(erros.length > 0){ 
        painelDeErros.className = "list-group-item list-group-item-warning list-group pl-4";
        console.log("oi");
        ulErros.className = "text-danger";
        ulErros.textContent = "";
        event.preventDefault();
        for(let i = 0; i < erros.length; i++){
            var li = document.createElement("li");
            // inserir no texto do elemento
            li.textContent = erros[i];
            // mudar estilos pelo javascript - não recomendado
            ulErros.appendChild(li);
        }
        var tituloErro = document.querySelector("#titulo-erro");
        tituloErro.textContent = "Não foi possível atualizar o contato devido aos seguintes erros:";
    }else{
        console.log(contato.nome);
        console.log(contato.email);
        console.log(contato.telefone);
    }    
});

const obterUsuario = (form) => {
    var contato = {
        nome: form.querySelector("#txt-nome").value,
        email: form.querySelector("#txt-email").value,
        telefone: form.querySelector("#txt-telefone").value,
    };
    return contato;
}

const getErros = (contato) =>{
    var erros = [];
    if(contato.nome.length < 4){
        erros.push("Escreva umnome válido");
    }
    if(contato.email.length == 0){
        erros.push("O e-mail é obrigatório!");
    }
    if(contato.telefone.length < 8){
        erros.push("Numero de Telefone Inválido");
    }
    return erros;
}