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

void Encolar(int );
void InicializaCola();
void Imprmir();
int DesEncola();
void ValorF();
int Esvacia();
void* consumidor();
void* productor();

sem_t lugar; //semaforo para indicarle al consumidor que hay lugar 
sem_t vacias; //semaforo para que el productor incerte algun insumo 
sem_t turno; //semaforo para sincronizar el acceso del consumidor o productor


//                                      Fin del header


int main(int argc, char const *argv[])
{ 
 	InicializaCola();
 	
 	
 	
 	pthread_t HilosConsumidor[21];
 	pthread_t HilosProductor;

 	sem_init(&vacias, 0, col.tam);
	sem_init(&lugar, 0, 0);
	sem_init(&turno, 0, 1);//es con uno para que no se den el abrazo martal fatality

	Id **ObjId=(Id**)malloc(col.tam*sizeof(Id*));

 	//   CREACION DE LOS HILOS
 	pthread_create(&HilosProductor,NULL,productor,NULL);
 	for ( int i = 0; i < col.tam; ++i){
 		ObjId[i]=(Id*)malloc(sizeof(Id));
 		ObjId[i]->ID=(i+1);
 		pthread_create(&HilosConsumidor[i],NULL,consumidor,(void*)ObjId[i]);
 				
 	} 	
 	

 	// A QUI ESTAN LOS JOIN
 	for (int j = 0; j < col.tam; ++j){
 	 pthread_join(HilosConsumidor[j],NULL); 		
 	} 	 
 	pthread_join(HilosProductor,NULL);	





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
	
	col.tam=20;
	col.colacircular = (int *)malloc(col.tam*sizeof(int));
	col.fr=0;
	col.pos=0;
	col.n=0;

} 


void Imprmir(){
	for (int i = 0; i < col.tam; ++i)
 	{
 		printf("%d\n",col.colacircular[i] );
 	}

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


void*  consumidor(void * args){
	int prod=col.tam;
	Id* id=(Id*)args;
	sleep(rand()%5);
			
			sem_wait(&lugar);
			//printf("bloqueo lugar\n");
			sem_wait(&turno);
			//printf("bloqueo turno\n");
			int num= DesEncola();
			printf("soy el consumidor %d y consumi a %d\n",id->ID,num );
			
			sem_post(&turno);
			//printf("desbloqueo turno\n");
			sem_post(&vacias);
			//printf("desbloqueo vacias\n");
			prod--;

		
		

	
	
 	pthread_exit(NULL);
	
	
}


void* productor(void* args){
	int prod =1;
	

	while(prod<=col.tam){
		sem_wait(&vacias);
		sem_wait(&turno);
		
		Encolar(prod);
		
		sem_post(&turno);
		sem_post(&lugar);
		
		prod ++;
	
	}

	pthread_exit(NULL);
	
	
}
