"""


"""

import cv2 as cv

def main():
    img = cv.imread("teste001.png",0)

    for contour in contours:
        x, y, _, _ = cv.boundingRect(contour)
        
        print(x, " ", y)

if __name__ == "__main__":
    main()