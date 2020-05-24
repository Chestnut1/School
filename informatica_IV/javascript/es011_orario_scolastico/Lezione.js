"use strict"

//creating table
var table = document.getElementById("table")
for(let riga = 0; riga < 6; riga++){

    var r = document.createElement("tr")    //creo la riga e ci aggiungo le celle
    
    for(let ora = 0; ora < 7; ora++){
        var cella = document.createElement("td")
        cella.style.border = "2px solid #32a852"
        cella.style.width = "30px"
        cella.style.height = "30px"
        cella.addEventListener("mouseover", showDetails)
        r.appendChild(cella)
    }

    table.appendChild(r)
}

var showDetails = function() {
    
}