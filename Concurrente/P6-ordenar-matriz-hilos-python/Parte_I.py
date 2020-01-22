import random
import time

def aleatMatriz(M,n,m):
	for i in range(n):
		for j in range(m):
			M[i][j]= random.randint(0, 100)
			

def impMatriz(M,n,m):
	for i in range(n):
		for j in range(m):
			print " "+ str(M[i][j])+ "\t",
		print "\n"

def TDaplicar(M, n, m):
	a=[]
	for i in range(0, n):
		r=[]
		for j in range(0, m):
			r.append(g(M[i][j]))
		a.append(r)
	return a

def TDaplicar2(M,n,m):
	matriz=[ [ g(M[i][j]) for j in range(m) ] for i in range(n) ]
	return matriz

def g(x):
	return x**2

def approachA():
	l=[]
	for x in range(10000):
		#print l
		l.extend(tomaSiguienteLista())

def approachB():
	l=[]
	for x in range(10000):
		#print l
		l=l+tomaSiguienteLista()

def tomaSiguienteLista():
	return [1,2,3,4]

def main():
	#######     SLICE     ##############################################
	print "Hola Mundo"
	Lista1 = [1,2,3,4,5,6,7,8,9]
	print Lista1
	print "(a) El tercero hasta sexto, incluyendo los extremos de la lista"
	print Lista1[3:6]
	print "(b) Todos menos el ultimo elemento"
	print Lista1[:8]
	print "(c) Toda la lista"
	print Lista1[:]

	###########     INICIALIZAR MATRIZ     ################################
	n= int(raw_input("dame las filas\n"))
	m= int(raw_input("dame las columnas\n"))
	M = [range(m) for i in range(n)]
	aleatMatriz(M,n,m)

	##########     Primer matriz    #########################

	print "\nPrimer Matriz\n"
	impMatriz(M,n,m)
	
	##########     Segunda matriz    #########################

	print "utilizando TDaplicar()"
	print "Segunda Matriz\n"
	M2=TDaplicar(M,n,m)
	impMatriz(M2,n,m)

	##########     Tercer matriz    #########################

	print "utilizando TDaplicar2()"
	print "Tercera Matriz\n"
	M3=TDaplicar2(M,n,m)
	impMatriz(M3,n,m)
	
	##########     Funciones approach    #########################
	tiempo1= time.time()
	approachA()
	tiempo2= time.time()
	print "-----", tiempo2-tiempo1,"segundos----- "

	tiempo3= time.time()
	approachB()
	tiempo4= time.time()
	print "-----", tiempo4-tiempo3,"segundos----- "

if __name__ == '__main__':
	main()