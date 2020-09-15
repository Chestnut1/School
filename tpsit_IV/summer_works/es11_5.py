"""
Author: Bruno Luca
Date: 14-09-2020
Title: rotate word
"""

def load_dictionary(file_name):
    d = dict()
    fin = open(file_name)
    for i,line in enumerate(fin):
        d[line.strip()] = i

    fin.close()

    return d

def are_rotable(w1,w2):
    pass

def main():
    pass

if __name__ == "__main__":
    main()