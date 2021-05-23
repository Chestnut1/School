const form = document.querySelector(".signup form"),
    chatBtn = form.querySelector(".button input"),
    msgError = form.querySelector(".error-txt");

form.onsubmit = (e) => {
    e.preventDefault(); //preventing form from submitting
}

chatBtn.onclick = () => {
    //AJAX
    let xhr = new XMLHttpRequest(); //creo un oggetto XML
    xhr.open("POST", "php/signup.php", true);

    xhr.onload = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                let data = xhr.response;
                if (data === "success") {
                    location.href = "users.php";
                } else {
                    msgError.style.display = "block";
                    msgError.textContent = data;
                }
            }
        }
    }

    //invio trmite ajax a php
    let formData = new FormData(form);  //creo un oggetto per i dati del form
    xhr.send(formData);     //invio
}
