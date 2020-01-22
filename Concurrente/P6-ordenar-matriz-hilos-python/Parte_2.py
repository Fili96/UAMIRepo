import random
import threading
from time import time

def aleatMatriz(M,n,m):
	for i in range(n):
		for j in range(m):
			M[i][j]= random.randint(0, 100)
			

def impMatriz(M,n,m):
	for i in range(n):
		for j in range(m):
			print " "+ str(M[i][j])+ "\t",
		print "\n"

def copfila(m,tid,M,Arreglo):
	for i in range(0,m):
		M[tid][i]=Arreglo[i]

def copcol(n,tid,M,Arreglo):
	for i in range(0,n):
		M[i][tid]=Arreglo[i]

def intercambia(a,b):
  
    c = []
    while len(a) != 0 and len(b) != 0:
        if a[0] < b[0]:
            c.append(a[0])
            a.remove(a[0])
        else:
            c.append(b[0])
            b.remove(b[0])

    if len(a) == 0:
        c.extend(b)

    else:
        c.extend(a)

    return c


def mergesort(x):
   
    if len(x) == 0 or len(x) == 1:
        return x
    else:
        medio = len(x)/2
        a = mergesort(x[:medio])
        b = mergesort(x[medio:])
	return intercambia(a,b)

def burbuja(M,n,m):
	for i in range(0,n):
		for j in range(0,m):
			for k in range(0,n):
				for l in range(0,m):
					if M[i][j]<M[k][l]:
						aux=M[i][j]
						M[i][j]=M[k][l]
						M[k][l]=aux

def main():
	global n
	global m
	global M
	n= int(raw_input("dame las filas\n"))
	m= int(raw_input("dame las columnas\n"))
	print
	M = [range(m) for i in range(n)]
	aleatMatriz(M,n,m)

	desicion= str(raw_input("quieres desplegar la matriz?--> (si, no)\n"));

	if desicion=='si':
		
		print "\nMatriz Aleatoria"
		impMatriz(M,n,m,)

		##################   Hilos filas   #######################################
		Hilos_filas= list ()

		for i in range(0,n):
			tf=threading.Thread(target=rut_filas(i))
			Hilos_filas.append(tf)
			tf.start()

		for x in range(len(Hilos_filas)):
				Hilos_filas[x].join()

		print "Matriz ordenando filas"
		impMatriz(M,n,m)

		##################   Hilos columnas  #######################################

		Hilos_col= list ()

		for j in range(0,m):
			tc=threading.Thread(target=rut_columnas(j))
			Hilos_col.append(tc)
			tc.start()

		for y in range(len(Hilos_col)):
			Hilos_col[y].join()

		print "Matriz ordenando columnas"
		impMatriz(M,n,m)

		##################   BURBUJA   #######################################
		burbuja(M,n,m)
		print "Matriz ordenana con Metodo Burbuja"
		impMatriz(M,n,m)
		
	else:
		if desicion=='no':
			print "No se ha imprimido"

			##################   Hilos filas   #######################################
			Hilos_filas= list ()

			for i in range(0,n):
				tf=threading.Thread(target=rut_filas(i))
				Hilos_filas.append(tf)
				tf.start()

			for x in range(len(Hilos_filas)):
				Hilos_filas[x].join()

			##################   Hilos columnas  #######################################
			Hilos_col= list ()

			for j in range(0,m):
				tc=threading.Thread(target=rut_columnas(j))
				Hilos_col.append(tc)
				tc.start()

			for y in range(len(Hilos_col)):
				Hilos_col[y].join()

			##################   BURBUJA   #######################################
			burbuja(M,n,m)

		else:
			print "Desicion invalida"
			return

def rut_filas(tid):
	global M
	Arreglo=[]

	for i in range(0,m):
		Arreglo.append(M[tid][i])

	Arreglo=mergesort(Arreglo)
	copfila(m,tid,M,Arreglo)
	return

def rut_columnas(tid):
	global M
	Arreglo=[]
	for i in range(0,n):
		Arreglo.append(M[i][tid])
	Arreglo=mergesort(Arreglo)
	copcol(n,tid,M,Arreglo)
	return

if __name__ == '__main__':
	tiempo1= time()
	main()
	tiempo2= time()
	tiempo_ejecucion = (tiempo2 - tiempo1)
	print '-----',tiempo_ejecucion,'segundos -----'
