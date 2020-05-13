function showName(){
    switch(event.target.id){
        case "cpu":
            document.getElementById("cpuEN").style.color = "#C6DABF"
            break
        case "mobo":
            document.getElementById("moboEN").style.color = "#C6DABF"
            break
        case "socket":
            document.getElementById("socketEN").style.color = "#C6DABF"
            break
        case "ram":
            document.getElementById("ramEN").style.color = "#C6DABF"
            break
        case "aio":
            document.getElementById("aioEN").style.color = "#C6DABF"
            break
        case "gpu":
            document.getElementById("gpuEN").style.color = "#C6DABF"
            break
    }
    
}
function hideName(){
    switch(event.target.id){
        case "cpu":
            document.getElementById("cpuEN").style.color("#114B5F")
            break
        case "mobo":
            document.getElementById("moboEN").style.color("#114B5F")
            break
        case "socket":
            document.getElementById("socketEN").style.color("#114B5F")
            break
        case "ram":
            document.getElementById("ramEN").style.color("#114B5F")
            break
        case "aio":
            document.getElementById("aioEN").style.color("#114B5F")
            break
        case "gpu":
            document.getElementById("gpuEN").style.color("#114B5F")
            break
    }
    
}