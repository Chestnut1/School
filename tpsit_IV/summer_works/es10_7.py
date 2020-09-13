"""
Author: Bruno Luca
Date: 11-09-2020
Title: duplicati
"""

def has_duplicates(t):
    copied_t = t[:]
    for element in copied_t:
        copied_t.remove(element)
        if element in copied_t:
            return True
    return False


def main():
    t = [1]
    print(has_duplicates(t))

if __name__ == "__main__":
    main()