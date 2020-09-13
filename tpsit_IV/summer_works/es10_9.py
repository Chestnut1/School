"""
Author: Bruno Luca
Date: 11-09-2020
Title: Algorithm Complexity
"""

import time

def append_list(file):
    t = []
    for line in file:
        t.append(line.strip())
    return t

def cumulating_list(file):      #WAY FASTER
    t = []
    for line in file:
        t = t + [line.strip()]
    return t

def main():
    fin = open("words.txt")

    start_time = time.time()
    _ = append_list(fin)
    appending_time = time.time() - start_time

    start_time = time.time()
    _ = cumulating_list(fin)
    cumulating_time = time.time() - start_time

    print(f"Appending expired in {appending_time} seconds...\n\nCumulating expired in {cumulating_time} seconds...")

    fin.close()



if __name__ == "__main__":
    main()