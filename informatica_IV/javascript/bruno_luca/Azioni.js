function Azioni(azienda, borsa, vals){

    this.nome_azienda = azienda
    this.nome_borsa = borsa

    this.giorni = ["lunedi","martedi","mercoledi","giovedi","venerdi","sabato","domenica"]

    this.valori = { //non so usare i file JSON quindi li carico manualmente con un vettore di 7 numeri
        "lunedi" : vals[0],
        "martedi" : vals[1],
        "mercoledi" : vals[2],
        "giovedi" : vals[3],
        "venerdi" : vals[4],
        "sabato" : vals[5],
        "domenica" : vals[6],
    }

    this.getMax = function(){
        let max = this.valori.lunedi
        let giorno = 0
        for(day in this.valori){
            //alert(this.valori[day])
            if(this.valori[day] > max) max = this.valori[day]; giorno = day; 
        }
        return giorno + " --> " + max
    }

    this.get
}
