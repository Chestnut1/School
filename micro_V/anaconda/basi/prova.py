import numpy as np
from numpy import random

ERRORI = 20

dati = np.random.normal(19, 5, 100)
indici = random.randint(100, size = ERRORI)
dati[indici] = 999.9

print(dati)