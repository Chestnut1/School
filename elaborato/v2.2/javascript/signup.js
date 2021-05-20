const form = document.querySelector(".signup form"),
chatBtn = form.querySelector(".button input");

form.onsubmit = (e) => {
    e.preventDefault(); //preventing form from submitting
}

chatBtn.onclick = () => {
    //AJAX
    let xhr = new XMLHttpRequest(); //creo un oggetto XML
    xhr.open("POST", "php/signup.php", true);

    xhr.onload = () => {

    }
    xhr.send();
}