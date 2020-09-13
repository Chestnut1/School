"""
Author: Bruno Luca
Date: 12-09-2020
Title: invert dictionary
"""

def invert_dictionary_mapping(d):
    invert = {}

    for key,value in d.items():
        invert.setdefault(value,[]).append(key)
    return invert


def main():
    initial_mapping = dict(a = 1, b = 2, c = 3, z = 1)

    print(f"Before map inverting:\n\t{initial_mapping}")
    print(f"\n\nAfter map inverting:\n\t{invert_dictionary_mapping(initial_mapping)}")

if __name__ == "__main__":
    main()