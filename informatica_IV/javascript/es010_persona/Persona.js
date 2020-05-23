

function Persona(){
    nome = ""
    cognome = ""

    setNome = function(n){
        if(n != undefined && n != ""){
            this.nome = n
        }
    }
    function setCognome(c){
        if(c != undefined && c != ""){
            this.cognome = c
        }
    }
}  

var p = new Persona()

function nome(){
    p.setNome(document.getElementById("nome").innerHTML)
}

function cognome(){
    p.setCognome(document.getElementById("cognome").innerHTML)
}