from sys import exit

def gold_room():
    print("This room is full of gold, how much do you take?", end = ' ')

    choice = -1
    while choice < 0:
        choice = int(input(">>")
        if choice < 0:
            print("Man, lear to type a number...")
    
    if choice < 50:
        print("Nice, you are not greedy, you WIN!")
        exit(0)
    else:
        dead("You greedy bastard")


def bear_room():
    print("""
    There is a bear here.
    He has a buch of honey...
    The fat bear is in front of an other door.
    How are you going to move the bear?
    """)
    bear_moved = False

    while True:
        choice = input(">>")
        if choice == "take honey":
            dead("The bear looks at you then slap your face off.")
        elif choice == "taunt bear" and not bear_moved:
            print("The bear has moved from the door. You can go trought it now.")
            bear_moved = True
        elif choice == "taunt bear" and bear_moved:
            dead("The bear gets pissed of and chew your face off.")
        elif choice == "open door" and bear_moved:
            gold_room()
        else:
            print("I'm almost sure you can't do this...")

def cthulhu_room():
    print("""
    Here you see the great evil Cthulhu!
    He, it, what ever stares at you and you go insane.
    Do you flee for your life or aet your head?
    """)

    choice = input(">>")
    if "flee" in choice:
        start()
    elif "head" in choice:
        dead("Well, that was tasty!")
    else:
        cthulhu_room()

def dead(why):
    print(why, "Good job!")
    exit(0)

def start():
    print("""
    You are in a dark room, and all you can see is a door on your right and another one on your left.
    Which one you opne?
    """)

    choice = input(">>")

    if choice == "left":
        bear_room()
    elif choice == "right":
        cthulhu_room()
    else:
        dead("You stumble around the room until you starve.")



start()



