function showName(id){
    switch(id){
        case "cpu":
            document.getElementById("cpu").innerHTML = "Central Process Unit"
            break
        case "mobo":
            document.getElementById("mobo").innerHTML = "Motherboard"
            break
        case "socket":
            document.getElementById("socket").innerHTML = "Socket"
            break
        case "ram":
            document.getElementById("ram").innerHTML = "RAM"
            break
        case "aio":
            document.getElementById("aio").innerHTML = "Liquid Cooler"
            break
        case "gpu":
            document.getElementById("gpu").innerHTML = "Graphic Card"
            break
    }
}

function hideName(id){
    document.getElementById(id).innerHTML = "?"
}