"""
Author: Bruno Luca
Date: 11-09-2020
Title: Birthday Paradox
"""

import random

def generate_dates(n):
    t = []
    for _ in range(n):
        t.append(random.randint(1,32))
    return t

def main():
    number_of_students = 23
    students = generate_dates(number_of_students)

    max = 0
    count = 0

    for date in students:
        while date in students:
            count += 1
            students.remove(date)
        if count > max:
            max = count
    
    print(f"% is {(max*100)/number_of_students}")




if __name__ == "__main__":
    main()