"""
Author: Bruno Luca
Date 12-09-2020
Title: has duplicates using dictionaries
"""

def invert_dictionary_mapping(d):
    invert = {}

    for key,value in d.items():
        invert.setdefault(value,[]).append(key)
    return invert

def has_duplicates(d):
    invert_d = invert_dictionary_mapping(d)
    print(invert_d)
    return len(invert_d)-1

def main():
    d = {"0":1,"1":2,"2":1}

    print(has_duplicates(d))

if __name__ == "__main__":
    main()