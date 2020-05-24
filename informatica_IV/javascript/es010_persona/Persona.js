function Persona(){
    this.nome = ""
    this.cognome = ""
}

var p = new Persona()

function setValues(){
    p.nome = (document.getElementById("nome").value || "")
    p.cognome = (document.getElementById("cognome").value || "")
}