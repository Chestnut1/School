"""
Author: Bruno Luca
Date 11-09-2020
Title: Bifront Words
"""

def append_list(file):
    t = []
    for line in file:
        t.append(line)
    return t

def check_word(word,t):


    for item in t:
        if item.strip() != word and item.strip() == word[::-1]:
            print(f"\n{word.upper()}\n")
            print(f">\t{item}")


def main():
    fin = open("words.txt")
    list_of_words = append_list(fin)
    fin.close()

    fin = open("words.txt")

    for line in fin:
        check_word(line.strip(),list_of_words)

    fin.close()

if __name__ == "__main__":
    main()