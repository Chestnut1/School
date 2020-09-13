"""
Author: Bruno Luca
Date 11-09-2020
Title: anagrammi
"""

def anagrammi(w1,w2):
    w1 = list(w1)
    w2 = list(w2)

    for letter in w1:
        if letter in w2:
            w2.remove(letter)
        else:
            return False

    return not len(w2)


def main():
    a = "banana"
    b = "nabanaa"

    print(anagrammi(a,b))

if __name__ == "__main__":
    main()