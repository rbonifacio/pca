import matplotlib.pylab as plt
import numpy as np
from random import uniform


# sampling rate
sr = 500.0
# sampling interval
ts = 1.0/sr
t = np.arange(0,1,ts)


def randomSine():
    # frequency of the signal
    freq = uniform(1, 10)  
    return np.sin(2*np.pi*freq*t)
   


N = 4
input = [randomSine() for i in range(N)]

for i in range(N):
    sine = input[i]
    plt.plot(t, sine, label = f'sin {i}')
plt.xlabel('Angle [rad]')
plt.ylabel('sin(x)')
plt.axis('tight')
plt.legend()
plt.show()
