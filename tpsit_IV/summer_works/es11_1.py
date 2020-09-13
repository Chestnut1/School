"""
Author: Bruno Luca
Date: 11-09-2020
Title: dictionary
"""

def load_dictionary(file_name):
    d = dict()
    fin = open(file_name)
    for i,line in enumerate(fin):
        d[line.strip()] = i

    fin.close()

    return d

def main():
    words = load_dictionary("words.txt")

    if "dog" in words:
        print(f"[dog]\t->\t{words['dog']}")

if __name__ == "__main__":
    main()