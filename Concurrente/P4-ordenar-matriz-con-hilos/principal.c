#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>

int ** matriz;
int filas, columnas;
int cont;

void matrizAleat(int **);
void imprMatriz(int **);
void imprArreglo(int , int *);
void copren(int ,int , int** , int *);
void burbujaMatriz();
void copcol(int ,int , int** , int *);
void concambios_f(int*, int );
void concambios_c(int*, int );
void intercambia(int , int , int ,int*);
void metMerge(int ,int ,int* );
void* rutFilas(void*);
void* rutColumnas(void*);


typedef struct{
		int tid;//Identifiacdor del hilo
		int *A_O;//Arreglo de enteros para almacenar los datos a ser ordenados.
	}Info;


int main(int argc, char const *argv[]){
	int i,j;

/******INICIALIZAR MATRIZ*******************************/
	printf("Dame las filas\n");
	scanf("%d",&filas);

	printf("Dame las columnas\n");
	scanf("%d",&columnas);

	matriz=(int**) malloc(filas*sizeof(int*));
	for (i = 0; i < filas; i++){
		matriz[i]=(int*) malloc(columnas*sizeof(int));
	}

	matrizAleat(matriz);
	int des;
	printf("Quieres imprimir la matriz?\nSi->1\nNo->0\n");
	scanf("%d",&des);
	switch(des){
		case 0:
		printf("No se imprimio la Matriz\n");
		break;

		case 1:
		imprMatriz(matriz);
		printf("\n");
		break;

		default:
		printf("Valor invalido\n");
		break;
	}
	printf("\n");
/******************************************************/

/*******INICIALIZACION DE ESTRUCTURA FILA Y COLUMNA******/
	Info ** obj_FILAS;
	pthread_t hilos_f[columnas];
	Info ** obj_COLUMNAS;
	pthread_t hilos_c[filas];
	void * obj_info;
	
	obj_FILAS= (Info**)malloc(filas*sizeof(Info*));

	for (i = 0; i < filas; i++)
	{
		obj_FILAS[i]=(Info*) malloc(sizeof(Info));
	}

	obj_COLUMNAS=(Info**)malloc(columnas*sizeof(Info*));

	for (i = 0; i < columnas; i++)
	{
		obj_COLUMNAS[i]=(Info*) malloc(sizeof(Info));
	}
/************************************************************/
/************CREACION DE HILOS EN FILAS****************************/
	do{

		cont=0;
		
		for ( i = 0; i < filas; i++)
		{	
			obj_FILAS[i]->tid=i;
			obj_FILAS[i]->A_O= (int*)malloc(columnas*sizeof(int));
			pthread_create(&hilos_f[i],NULL,rutFilas,(void*)obj_FILAS[i]);
		}

		for ( j = 0; j < filas; ++j)
		{
			pthread_join(hilos_f[j],&obj_info);
			obj_FILAS[j]=(Info*)obj_info;
			copren(columnas,obj_FILAS[j]->tid,matriz,obj_FILAS[j]->A_O);
		}
	/************************************************************/
		printf("\n");
		printf("Aplicando Merge en filas\n");
		imprMatriz(matriz);

		/************CREACION DE HILOS EN COLUMNAS****************************/
		
		for ( i = 0; i < columnas; i++)
		{	
			obj_COLUMNAS[i]->tid=i;
			obj_COLUMNAS[i]->A_O= (int*)malloc(filas*sizeof(int));
			pthread_create(&hilos_c[i],NULL,rutColumnas,(void*)obj_COLUMNAS[i]);
		}

		for ( j = 0; j < columnas; ++j)
		{
			pthread_join(hilos_c[j],&obj_info);
			obj_COLUMNAS[j]=(Info*)obj_info;
			copcol(filas,obj_COLUMNAS[j]->tid,matriz,obj_COLUMNAS[j]->A_O);
		}
	/************************************************************/
		printf("\n");
		printf("Aplicando Merge en columnas\n");
		imprMatriz(matriz);
		printf("Contador= %d\n",cont );

	}while(cont!=0);

	printf("\nMetodo Burbuja\n");
		burbujaMatriz();
		imprMatriz(matriz);
	
	return 0;
}




void* rutFilas(void* param){
	Info* obj=(Info*) param;
	for (int i = 0; i < columnas; i++)
	{
		obj->A_O[i]=matriz[obj->tid][i];
		//printf("%d ",obj->A_O[i]);
	}
	//printf("\n");
	
	metMerge(0,columnas-1,obj->A_O);
	concambios_f(obj->A_O,obj->tid);
	pthread_exit(obj);
	
}

void* rutColumnas(void* param){
	Info* obj=(Info*) param;
	for (int i = 0; i < filas; i++)
	{
		obj->A_O[i]=matriz[i][obj->tid];
		//printf("%d ",obj->A_O[i]);
	}
	//printf("\n");
	
	metMerge(0,filas-1,obj->A_O);
	concambios_c(obj->A_O,obj->tid);
	pthread_exit(obj);
	
}

void matrizAleat(int **matriz){

	srand(time(NULL));
	for (int i = 0; i < filas;i++){
		for (int j = 0; j < columnas; j++)
			matriz[i][j]=rand()%2001;
	}	
}

void imprMatriz(int** matriz){

	for (int i = 0; i < filas;i++){
		for (int j = 0; j < columnas; j++)
			printf("%d\t",matriz[i][j] );
		printf("\n");
	}
}

void imprArreglo(int numElem, int *arreglo){
	printf("[");
	for (int i = 0; i < numElem; i++)
		printf(" %d ",arreglo[i] );
	printf("]\n");
}

void copren(int numElem,int sig, int** matriz, int *arreglo){
	
	for (int i = 0; i < numElem; i++){
		matriz[sig][i]= arreglo[i];
	}
		
	
}

void copcol(int numElem,int sig, int** matriz, int *arreglo){
	
	for (int i = 0; i < numElem; i++){
		matriz[i][sig]= arreglo[i];
	}
		
	
}


void intercambia(int inicio, int final, int mitad,int*arreglo){

   int parteizq=inicio;
   int parteder=mitad+1;   
   int* aux= calloc(final-inicio+1,sizeof(int));
   int k=0;
  
   while ((parteizq<=mitad) &&(parteder<=final))
   {
       
       if(arreglo[parteizq]<arreglo[parteder])
       {
           aux[k]=arreglo[parteizq];
           parteizq++;
       }
       else
       {
           aux[k]=arreglo[parteder];
           parteder++;
       }
       k++;
   }
  
   while (parteizq<=mitad)
   {
     
       aux[k]=arreglo[parteizq];
       parteizq++;       
       k++;
   }

   while (parteder<=final)
   {
       
       aux[k]=arreglo[parteder];
       parteder++;       
       k++;
   }

   for(parteizq=0;parteizq<k;parteizq++)
   {
      
       arreglo[parteizq+inicio]=aux[parteizq];
   }

}

void metMerge(int inicio,int final,int* arreglo){
	
	if (inicio<final)
	{
		int mitad= (inicio+final)/2;
		metMerge(inicio,mitad,arreglo);
		metMerge(mitad+1,final,arreglo);
		intercambia(inicio,final,mitad,arreglo);
		
	}

}

void concambios_f(int* arreglo, int tid){

	for (int i = 0; i < columnas; ++i)
	{
		if(arreglo[i]!=matriz[tid][i]){
			cont++;
		}
	}

}

void concambios_c(int* arreglo, int tid){

	for (int i = 0; i < filas; ++i)
	{
		if(arreglo[i]!=matriz[i][tid]){
			cont++;
		}
	}

}

void burbujaMatriz(){

	int t=0;

	for( int i=0; i < filas; i++){

		for( int j=0;j< columnas; j++){

			for(int x=0; x < filas; x++){

				for(int y=0; y <columnas; y++){

					if(matriz[i][j] < matriz[x][y]){

						t = matriz[i][j];

						matriz[i][j] = matriz[x][y];

						matriz[x][y] = t;

					}

				}

			}

		}

   }

}


