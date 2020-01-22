#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <time.h>


void arregAleat(int numElem, int *arreglo){

	
		srand(time(NULL));

		for (int i = 0; i < numElem;i++){
					arreglo[i]=rand()%2001;
		}

				
}


void imprArreglo(int numElem, int *arreglo){

		printf("[");
		for (int i = 0; i < numElem; i++)
		printf(" %d ",arreglo[i] );
		printf("]\n");	
}

void metBurbuja(int numElem, int *arreglo){
	int bandera=1;
			while(bandera==1){
				bandera=0;
				for (int i = 0; i < numElem-1; i++)
				{
					if (arreglo[i]>arreglo[i+1])
					{
						int aux= arreglo[i];
							arreglo[i]=arreglo[i+1];
							arreglo[i+1]=aux;
							bandera=1;
					}

					
				}

			}

}

void metinsertDir(int numElem, int* arreglo){
	
	for (int i = 1; i < numElem; i++)
	{
		int j=i;
		do{
			if (arreglo[j]<arreglo[j-1])
			{
				int aux= arreglo[j-1];
				arreglo[j-1]=arreglo[j];
				arreglo[j]=aux;
				j--;
			}else{
				j--;
			}
			
		} while(j>=1);
	}
}


int buscamin(int inicio,int fin,int *arreglo){
	
		int min=arreglo[inicio];
		int pos_min=inicio;

		
			for (int j = inicio; j < fin; j++)
			{	
				if (arreglo[j]<min)
					{
						min=arreglo[j];
						pos_min=j;
					}
			}

		return pos_min;
		
	
}

void metSelecDir(int numElem, int *arreglo){
	for (int i = 0; i < numElem-1; i++)
			{
				int pos_min=buscamin(i+1,numElem,arreglo);
				
				if ( (arreglo[i]>arreglo[pos_min]) && (arreglo[pos_min]!=0) )
				{
					int aux=arreglo[i];
					arreglo[i]=arreglo[pos_min];
					arreglo[pos_min]=aux;
				}

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

int main(int args, char *argv[]){

	clock_t time1,time2;
	clock_t ti,tf;
	double tt;
	double *total;
	int pid;
	int tam;
	int res;
	int ID;
	int estatus;
	int *arreglo;

	ID= shmget(IPC_PRIVATE,sizeof(double),IPC_CREAT | 0666);
	total=(double*) shmat(ID,NULL,0);
	total[0]=0;

	printf("Dame el tamaño del arreglo\n");
	scanf("%d", &tam);
	arreglo= malloc(tam*sizeof(int));

	printf("Escribir numeros-->1\nNumeros aleatorios-->0\n");
	scanf("%d",&res);

	switch(res){
		
		case 1:
			for(int i=0;i<tam;i++){
				printf("Dame el numero %d: \n",i+1);
				scanf("%d",&arreglo[i]);
			}
			break;

		case 0: 
			arregAleat(tam,arreglo);
			break;

		default:
			printf("opcion no valida\n");
			exit(1);
	}

	printf("Quieres desplegar los elementos?\nYes->1\nNo->0\n");
	scanf("%d",&res);

	switch(res){
		
		case 1:
			imprArreglo(tam,arreglo);
			printf("\n");
			sleep(2);
			break;

		default:
			printf("No se imprimio nada\n");
			printf("\n");
			sleep(2);
			break;
	}

	
	for (int i = 0; i < 4; i++)
	{
		pid=fork();

		if (pid)
		{	
			printf("Empieza la creacion del hijo %d\n",i+1);
			printf("PADRE EN ESPERA...\n");
			

		}

		else{
			if (pid==0)
			{
				
				if (i==0)
				{	
					time1= clock();
					printf("Inicia Metodo proceso 1: Burbuja (%d)\n",getpid());
					 ti = clock();
					metBurbuja(tam,arreglo);
					/*printf("arreglo Burbuja -->");
					imprArreglo(tam,arreglo);*/
					tf = clock();
					tt=(double) (tf-ti)/CLOCKS_PER_SEC;
					printf("Burbuja(%d) termino en:%.3f\n",getpid(),tt );
					time2= clock();
					total[0]=total[0] + ((double)(time2-time1)/CLOCKS_PER_SEC);
					exit(0);
				}
				
				
				if (i==1)
				{
					time1= clock();
						printf("Inicia Metodo proceso 2: Insercion Directa(%d)\n",getpid());
						 ti = clock();
							metinsertDir(tam,arreglo);
							/*printf("arreglo Insercion Directa -->");
							imprArreglo(tam,arreglo);*/
						 tf = clock();
						 tt=(double) (tf-ti)/CLOCKS_PER_SEC;
						 printf("Insercion (%d) termino en:%.3f\n",getpid(),tt );
					 time2= clock();
					 total[0]=total[0] + ((double)(time2-time1)/CLOCKS_PER_SEC);
					 exit(0);
					 
					

				}

				if (i==2)
				{
					time1= clock();
						printf("Inicia Metodo proceso 3: Seleccion Directa(%d)\n",getpid());
						 ti = clock();
							 metSelecDir(tam,arreglo);
							/*printf("arreglo Seleccion Directa -->");
							imprArreglo(tam,arreglo);*/
						 tf = clock();
						 tt=(double) (tf-ti)/CLOCKS_PER_SEC;
						 printf("Seleccion (%d) termino en:%.3f\n",getpid(),tt );
					time2= clock();
					total[0]=total[0] + ((double)(time2-time1)/CLOCKS_PER_SEC);
					 exit(0);
					
					

				}

				if (i==3)
				{
					time1= clock();
						 printf("Inicia Metodo proceso 4: Mergesort(%d)\n",getpid());
						 ti = clock();
							 metMerge(0,tam-1,arreglo);
							/*printf("arreglo Mergesort -->");
							imprArreglo(tam,arreglo);*/
							 tf = clock();
						 tt=(double) (tf-ti)/CLOCKS_PER_SEC;
						 printf("Mergesort (%d) termino en:%.3f\n",getpid(),tt );
					time2= clock();
					total[0]=total[0] + ((double)(time2-time1)/CLOCKS_PER_SEC);	 
					exit(0);
					
					

				}

			}

			else{
				printf("Error al generar proceso\n");
				exit(1);
			}
		}


	}


pid=wait(&estatus);
pid=wait(&estatus);
pid=wait(&estatus);
pid=wait(&estatus);
printf("ya termine, Tiempo del programa: %.3f ms\n",total[0]);
return 0;

	
}

void copmuerte(int tt, int tm){
	tm=tt;
}