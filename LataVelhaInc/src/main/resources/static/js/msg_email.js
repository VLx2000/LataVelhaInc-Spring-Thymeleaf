function msg_email() {
    
    var msg = document.getElementById('mensagem')
    
    document.getElementById('aceitar').href += encodeURI(msg.value)
    document.getElementById('negar').href += encodeURI(msg.value)
    document.getElementById('salvar_mensagem').disabled = true;
}