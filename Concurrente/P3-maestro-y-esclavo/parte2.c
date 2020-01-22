#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>


int filas,columnas,tam;
int **matriz;

void Merge(int inicio, int final,int *arreglocompartido){
	int pid1,pid2,status;
	int mitad=(inicio+final)/2;
	int *copy= malloc(final*sizeof(int));

	for (int i = 0; i < final; i++)
	{
		copy[i]=arreglocompartido[i+inicio];
	}
	
	if((final==inicio)&&(inicio==mitad)){
			while(1);
		}else{
			pid1=fork();
			if(pid1){
				pid2=fork();

				if(pid2){
					pid1=wait(&status);
					pid2=wait(&status);
					exit(0);
			
				}else{
					inicio=mitad+1;
					free(copy);
					copy=malloc((final-mitad)*sizeof(int));
					for (int i = inicio; i < final; i++)
					{
						copy[i-inicio]=arreglocompartido[inicio];
					}
					Merge(inicio,final,copy);
					exit(0);
				}

			}else{
				final=mitad;
				free(copy);
				copy=malloc(mitad*sizeof(int));
				for (int i = 0; i < mitad; i++)
				{
					copy[i]=arreglocompartido[i];
				}
				Merge(inicio,final,copy);
				exit(0);
			}
		}
}

void arrcopy(int *copia, int *original,int inicio, int tam){
	
	for (int i = 0; i < tam; i++)
	{
		copia[i]=original[i+inicio];
	}

}

void arregAleat(int *arreglo){

		srand(time(NULL));

		for (int i = 0; i < tam;i++){
					arreglo[i]=rand()%2001;
		}
		
}


void imprimirMatriz(int **matriz){
	for (int i = 0; i < filas; ++i){
		
		for (int j = 0; j < columnas; ++j)
		{
			printf("%d\t", matriz[i][j]);
		}
		printf("\n");
	}
}

void  imprimirArreglo(int * arreglo){
	printf("[ " );
	for (int i = 0; i < tam; ++i)
	{
		printf("%d ",arreglo[i] );
	}
	printf("]\n");
}

void AtoM(int * arreglo, int **matriz){

	int cont=0;

	for (int i = 0; i < filas; ++i){
		for (int j = 0; j < columnas; ++j)
		{
			matriz[i][j]=arreglo[cont];
			cont++;
		}
	}
}

int main(int args, char *argv[]){

	
	int shmID;
	int *arreglocompartido;
	int des;

	
	printf("dame las columnas\n");
	scanf("%d",&columnas);
	printf("dame las filas\n");
	scanf("%d",&filas);

	tam=filas*columnas;


	/***************INICIALIZAR MATRIZ**********************/
	matriz=(int**)malloc(filas*sizeof(int*));

	for (int i = 0; i < filas; ++i)
	{
		matriz[i]=(int*)malloc(columnas*sizeof(int));
	}

	/***************MEMORIA COMPARTIDA**********************/

	shmID= shmget(IPC_PRIVATE,tam*sizeof(int),IPC_CREAT | 0666);

	if (shmID<0)
	{
		printf("ERROR al reservar el espacio de memoria compartida\n");
		exit(1);
	}

	printf("El servidor recibio espacio de memoria para %d enteros\n",tam );

	arreglocompartido=(int *) shmat(shmID,NULL,0);

	if(*arreglocompartido==-1){
		printf("ERROR al adjuntar memoria compartida al seervidor\n");
		exit(1);
	}

	printf("El servidor adjunto memoria compartida\n");

	/******************INICIA PROGRAMA*****************************/

	printf("Escribir numeros-->1\nNumeros aleatorios-->0\n");
	scanf("%d",&des);

	switch(des){
		
		case 1:
			for(int i=0;i<tam;i++){
				printf("Dame el numero %d: \n",i+1);
				scanf("%d",&arreglocompartido[i]);
			}
			imprimirArreglo(arreglocompartido);
			AtoM(arreglocompartido,matriz);
			
			break;

		case 0: 
			arregAleat(arreglocompartido);
			AtoM(arreglocompartido,matriz);
			break;

		default:
			printf("opcion no valida\n");
			exit(1);
	}

	printf("Quieres imprimir la matriz?\nSi->1\nNo->0\n");
	scanf("%d",&des);

	switch(des){
		
		case 1:
			imprimirMatriz(matriz);
			break;

		default:
			printf("No se imprimio nada\n");
			break;
	}


	/*********************INICIA MERGESORT*************************/
	
		Merge(0,tam,arreglocompartido);

	
		




		
			
			
		




	return 0;

	

}

