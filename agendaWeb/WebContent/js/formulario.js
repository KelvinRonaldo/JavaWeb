var botao = document.querySelector("#btn-cadastrar");

botao.addEventListener('click', () => {
    // O elemento que chama essa função perde suas ações padrões
    var form = document.querySelector("#form-usuario");
    var usuario = obterUsuario(form);
    var erros = getErros(usuario);
    if(erros.length > 0){ 
        event.preventDefault();
        var painelDeErros = document.querySelector("#painelDeErros");
        painelDeErros.className = "list-group list-group-item list-group-item-warning pl-4";
        
        var ulErros = document.querySelector("#mensagem-erros");
        ulErros.textContent = "";
        
        for(let i = 0; i < erros.length; i++){
            var li = document.createElement("li");
            // inserir no texto do elemento
            li.textContent = erros[i];
            // mudar estilos pelo javascript - não recomendado
            ulErros.appendChild(li);
        }
        var tituloErro = document.querySelector("#tituloErro");
        tituloErro.textContent = "Não foi possível cadastrar usuário devido aos seguintes erros:";
    }else{
        console.log(usuario.nome);
        console.log(usuario.nascimento);
        console.log(usuario.sexo);
        console.log(usuario.email);
        console.log(usuario.senha1);
        console.log(usuario.senha2);
    }
    
    
});

const obterUsuario = (form) => {
    var usuario = {
        nome: form.querySelector("#txt-nome").value,
        nascimento: form.querySelector("#txt-nascimento").value,
        sexo: form.querySelector("#cb-sexo").value,
        email: form.querySelector("#txt-email").value,
        senha1: form.querySelector("#txt-senha1").value,
        senha2: form.querySelector("#txt-senha2").value,
    };
    return usuario;
}

const getErros = (usuario) =>{
    var erros = [];
    if(usuario.nome.length < 5){
        erros.push("O Nome deve conter pelo menos 5 caracteres!");
    }
    if(usuario.nascimento.length == 0){
        erros.push("A data de nascimento é obrigatória!");
    }
    if(usuario.sexo == "Selecione:"){
        erros.push("O sexo não foi selecionado!");
    }
    if(usuario.email.length == 0){
        erros.push("O e-mail é obrigatório!");
    }
    if(usuario.senha1.length < 4){
        erros.push("A senha deve ter mais de 4 caracteres!")
    }
    if(usuario.senha2.length < 4){
        erros.push("A confirmação da senha deve ter mais de 4 caracteres!")
    }
    if(usuario.senha2 != usuario.senha1){
        erros.push("As senhas não correspondem!");
    }
    return erros;
}