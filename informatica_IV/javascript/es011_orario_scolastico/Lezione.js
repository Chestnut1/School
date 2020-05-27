"use strict"

//creating table
var table = document.getElementById("table")
for(let riga = 0; riga < 6; riga++){

    var r = document.createElement("tr")    //creo la riga e ci aggiungo le celle
    
    for(let giorno = 0; giorno < 7; giorno++){
        var cella = document.createElement("td")
        cella.style.border = "2px solid #32a852"
        cella.style.fontSize = "30px"
        cella.style.width = "150px"
        if(giorno == 0){
            switch(riga){
                case 0:
                    cella.innerHTML = "8:10-9:10"
                    break
                case 1:
                    cella.innerHTML = "9:10-10:10"
                    break
                case 2:
                    cella.innerHTML = "10:10-11:10"
                    break
                case 3:
                    cella.innerHTML = "11:10-12:10"
                    break
                case 4:
                    cella.innerHTML = "12.10-13.10"
                    break
                case 5:
                    cella.innerHTML = "13.10-14.10"
                    break
                case 6:
                    cella.innerHTML = "14.10-15.10"
                    break
            }
        }
        cella.addEventListener("mouseover", showDetails)
        r.appendChild(cella)
    }

    table.appendChild(r)
}

function showDetails(){
    
}