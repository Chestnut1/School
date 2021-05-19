import cv2 as cv
import numpy as np


def main():
    cap = cv.VideoCapture(0)

    if not cap.isOpened():
        raise IOError("Cannot open webcam")

    while True:
        ret, frame = cap.read()

        cv.imshow("Webcam", frame)

        c = cv.waitKey(1)
        if c == 27:
            break
    
    cap.release()
    cap.destryAllWindows()

if __name__ == "__main__":
    main()


