#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <time.h>
#include <unistd.h>


typedef struct Id {
	int ID;
}Id;
typedef struct Cola {
  int fr; /* el frente de la cola */
  int n; /* número de elementos de la cola */
  int pos; /* número máximo de elementos de la cola */
  int *colacircular;
  int tam;
}Cola;

struct Cola col; // variable global para que los hilos lo pudedan ver
int total=25;
int cupo=20;//cuantos pueden entrar al banco
int lugares=10;//cuantos lugares hay
void Encolar(int );
void InicializaCola();
void Imprimir();
int DesEncola();
void ValorF();
int Esvacia();
pthread_mutex_t lock;
void* entrarbanco();

int busca(int id);
int numclientes=25;
sem_t lugar; //semaforo para controlar cuantos se sientan
sem_t vacias; //semaforo para controlar cuantos entran al banco
sem_t turno;//semaforo para controlar cuando pueden irse

//                                      Fin del header


int main(int argc, char const *argv[])
{
	int i,j;
 	InicializaCola();



 	pthread_t cliente[total];
	

 	sem_init(&vacias, 0, col.tam);
	sem_init(&lugar, 0, cupo);
	sem_init(&turno, 0, 1);


	Id **ObjId=(Id**)malloc(col.tam*sizeof(Id*));

 	//   CREACION DE LOS HILOS
	Imprimir();
	printf("primera impresion\n");
 	for (i = 0; i < total; i++){
 		ObjId[i]=(Id*)malloc(sizeof(Id));
 		ObjId[i]->ID=(i+1);
 		printf("%d\t",ObjId[i]->ID);


 	}
 	printf("\n");
	for (i = 0; i < total; i++){

 		pthread_create(&cliente[i],NULL,entrarbanco,(void*)ObjId[i]);

 	}

	printf("\n");
 	// A QUI ESTAN LOS JOIN
 	for (j = 0; j < col.tam; j++){
 	 pthread_join(cliente[j],NULL);
 	}






	return 0;
}














//                                                   METODOS

void Encolar(int dato){

	if(col.n<col.tam){
    col.pos =(col.fr+col.n)%col.tam;
    col.colacircular[col.pos]=dato;
    ++(col.n);
	}
	else{
		printf("La cola esta llena\n");
	}


}


int DesEncola(){
	int aux;
	if(col.n==0){
		printf("La cola esta vacia\n");
	}
	else{
		col.pos=(col.fr)%col.tam;
	    aux = col.colacircular[col.pos];
	    ++(col.fr);
	    --(col.n);
	    }

	return aux;

}



int Esvacia(){

	if(col.n==0){
		return 1;
	}else{
		return 0;
	}
}


void InicializaCola(){

	col.tam=lugares;
	col.colacircular = (int *)malloc(col.tam*sizeof(int));
	col.fr=0;
	col.pos=0;
	col.n=0;

}


void Imprimir(){
int i;
	for (i = 0; i < col.tam; i++)
 	{
 		printf("%d\t",col.colacircular[i] );
 	}
 	printf("\n");

}



void ValorF(){

	if (col.n==0)
	{
		printf("La cola esta vacia\n");
	}
	else{
      printf("%d",col.colacircular[col.fr]);

	}

}


void*  entrarbanco(void * args){
	int prod=col.tam,asiento,bandera=0,t;
	Id* id=(Id*)args;
	sleep(rand()%10);
           
			sem_wait(&lugar);
			
            		pthread_mutex_lock(&lock);
            		
            		
            		lugares--;
            		while(bandera==0){
            		if(lugares>=0){
			Encolar(id->ID);
			bandera=1;
			asiento=busca(id->ID);
			numclientes--;
			printf("soy el cliente %d  y me sente en la silla.  %d lugares quedan:%d  faltan: %d clientes\n",id->ID,asiento+1,lugares,numclientes );
            		
            		Imprimir();
            		}
            		else{
            		
            		}
            		}
            		pthread_mutex_unlock(&lock);
            		t=rand()%10;
            		sleep(t);
            		
            		sem_wait(&turno);
            		DesEncola();
            		printf("soy: %d me tarde: %d min\n",id->ID,t+1);
            		sem_post(&turno);
            		lugares++;
            		pthread_mutex_unlock(&lock);
			
			

			
			sem_post(&lugar);
			







 	pthread_exit(NULL);


}





int busca(int id){
    int i=0;
    while(id!=col.colacircular[i]){
        i++;
    }
    return i;
}
