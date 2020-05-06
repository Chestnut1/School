"""
Author: Bruno Luca
Date: 06-05-2020
This program sort people for tournaments
"""

import random

def createTournament(d):

    numbers = [i for i in range(1,22)]
    print(numbers)
    while(len(numbers) > 0):
        selected = numbers.pop(random.randint(0,len(numbers)-1))
        print(d[selected])


def main():
    classe = {
        1:"Acchiardi Paolo",
        2:"Agbonson Fabrizio",
        3:"Armando Luca",
        4:"Armando Yuri",
        5:"Badoino Matteo",
        6:"Bagnis Gabriele",
        7:"Bassignana Francesco",
        8:"Bernardi Gianluca",
        9:"Bruno Francesco",
        10:"Bruno Luca",
        11:"Cuniberti Andrea",
        12:"Degiovannini Alessia",
        13:"Gabutti Irene",
        14:"Genovese Tommaso",
        15:"Giavelli Luca",
        16:"Giusti Matteo",
        17:"Jomini Pietro",
        18:"Lovera Asia",
        19:"Nardi Simone",
        20:"Shekhawat Karni",
        21:"Van Cleeff",
    }

    createTournament(classe)

if __name__ == "__main__":
    main()