"""

Author: Bruno Luca
Date: 20-04-2021

Il programma richiede inizialmente all'utente nome di grandezza da inserire e nome 
della stazione che ha effettuato la misurazione, stampa a schermo i corrispettivi id,
richiede il valore misurato e poi invia al server una nuova misurazione da aggiungere 
al database.

Dopodichè si richiede all'utente l'inserimento del nome di una stazione, del nome 
di una misurazione e si stampano le statistice delle misurazioni corrispettive

"""


from flask import json
import requests
import datetime

def main():
    while True:

    #RICHIESTA ID GRANDEZZA
        nome = input("NOME GRANDEZZA>> ") #chiedo il nome della grandezza all'utente
        url_get = f"http://127.0.0.1:5000/get_idgrandezza?nome={nome}"
        
        r = requests.get(url_get)   #invio la GET

        if r.status_code == 200:    #controllo se l'invio è andato a buon fine
            print(f"\nNOME INVIATO CORRETAMENTE\n\n{r.text}\n")

        #prendo l'id dalla risposta
        id_grandezza = json.loads(r.text)['id']    #da stringa simil dizionario a dizionario
        
        print(f"ID GRANDEZZA = {id_grandezza}\n")

        if id_grandezza == "-1":    #se ho inviato un nome inesistente chiudo il client
            break

    #ID STAZIONE
        nome = input("NOME STAZIONE>> ")    #chiedo il nome della stazione all'utente
        url_get = f"http://127.0.0.1:5000/get_idstazione?nome={nome}"
        

        r = requests.get(url_get)   #invio la GET

        if r.status_code == 200:    #controllo se l'invio è andato a buon fine
            print(f"\nNOME INVIATO CORRETAMENTE\n\n{r.text}")

        #prendo l'id dalla risposta
        id_stazione = json.loads(r.text)['id']    #da stringa simil dizionario a dizionario
        
        print(f"ID STAZIONE = {id_stazione}\n")

        if id_stazione == "-1":     #se ho inviato un nome inesistente chiudo il client
            break

    #INSERIMENTO MISURAZIONE
        valore_misurazione = input("VALORE MISURAZIONE>> ")
        url_set = f"http://127.0.0.1:5000/set_misurazione?valore={valore_misurazione}&id_grandezza={id_grandezza}&id_stazione={id_stazione}&data={datetime.datetime.now()}"
        

        r = requests.get(url_set)   #invio la GET

        if r.status_code == 200:
            print(f"\nMISURAZIONE INVIATA CORRETAMENTE\n\n{r.text}")

    #RICHIESTA STATISTICHE
        print("RICHIESTA STATISTIHCE:\n")
        
        nome = input("NOME GRANDEZZA>> ") 
        url_get = f"http://127.0.0.1:5000/get_idgrandezza?nome={nome}"
        
        r = requests.get(url_get)   

        if r.status_code == 200:    
            print(f"\nNOME INVIATO CORRETAMENTE\n\n")

        id_grandezza = json.loads(r.text)['id']




        nome = input("NOME STAZIONE>> ")    
        url_get = f"http://127.0.0.1:5000/get_idstazione?nome={nome}"
        

        r = requests.get(url_get)   

        if r.status_code == 200:    
            print(f"\nNOME INVIATO CORRETAMENTE\n\n")

        #prendo l'id dalla risposta
        id_stazione = json.loads(r.text)['id']    
        
        print(f"ID STAZIONE = {id_stazione}\n")

        if id_stazione == "-1":     
            break

        url_get = f"http://127.0.0.1:5000/get_stats?id_grandezza={id_grandezza}&id_stazione={id_stazione}"
        

        r = requests.get(url_get)   #invio la GET

        if r.status_code == 200:    #controllo se l'invio è andato a buon fine
            print(f"\nSTATISTICHE RICHIESTE CORRETAMENTE\n\n")

        #prendo le statistiche dalla risposta
        minimo = json.loads(r.text)['min']
        massimo = json.loads(r.text)['max']
        avg = json.loads(r.text)['avg']
        
        print(f"""
        
        STATS: 

        min:    {minimo}
        max:    {massimo}
        avg:    {avg}
        
        """)

        input("\nPress any key to kill the program...")
        break


if __name__ == "__main__":
    main()































































