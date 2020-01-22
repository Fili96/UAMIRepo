#include <stdio.h>
#include <stdlib.h>
#include<time.h>



void imprArreglo(int numElem, int *arreglo){
	printf("[");
	for (int i = 0; i < numElem; i++)
		printf(" %d ",arreglo[i] );
	printf("]\n");
}

void arregAleat(int numElem, int *arreglo){

	printf("Quieres desplegar los elementos del arreglo???\n");
	printf("si-->1\nNo-->0\n");
	cfree(arreglo);
	arreglo=calloc(numElem,sizeof(int));
	int desplegar;
	scanf("%d",&desplegar);

	if (desplegar==1){
		srand(time(NULL));
		printf("---Los elementos son---\n");

		for (int i = 0; i < numElem;i++){
					arreglo[i]=rand()%2001;
		}

		imprArreglo(numElem, arreglo);
		printf("\n");

	}else {
		srand(time(NULL));
		printf("---No se desplegaron los elementos---\n");
		for (int i = 0; i < numElem;i++)
				arreglo[i]=rand()%2001;
		}
		printf("\n");		
}

void copiarArrelgo(int* arreglo, int* copia, int numElem){

	for (int i = 0; i < numElem; i++)
	{
		copia[i]=arreglo[i];
	}

	
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

	int opt,numElem;
	int *arreglo;

	printf("1- Ordenar el arreglo por el metodo Burbuja\n");
	printf("2- Ordenar el arreglo por el metodo Insercion Directa\n");
	printf("3- Ordenar el arreglo por el metodo Seleccion Directa\n");
	printf("4- Ordenar el arreglo por el metodo MergeSort Recursivo\n");
	printf("5- Comprobar los tiempos de todos los metodos de ordenamiento\n");
	printf("6- Salir\n");

	printf("Elige una opcion\n");
	scanf("%d",&opt);
	system("clear");
	switch(opt){

		case 1: 
			printf("--------METODO BURBUJA--------\n");//listo

			printf("Dame el numero de elementos\n");
			scanf("%d",&numElem);
			arreglo=calloc(numElem,sizeof(int));
			arregAleat(numElem, arreglo);
			printf("---El orden es el siguiente---\n");
			metBurbuja(numElem,arreglo);
			imprArreglo(numElem,arreglo);

		break;

		case 2:
			printf("--------METODO INSERCION DIRECTA--------\n");

			printf("Dame el numero de elementos\n");
			scanf("%d",&numElem);
			arreglo=calloc(numElem,sizeof(int));
			arregAleat(numElem, arreglo);
			printf("---El orden es el siguiente---\n");
			metinsertDir(numElem,arreglo);
			imprArreglo(numElem,arreglo);
		break;

		case 3:
			printf("--------METODO SELECCION DIRECTA--------\n");//listo

		printf("Dame el numero de elementos\n");
			scanf("%d",&numElem);
			arreglo=calloc(numElem,sizeof(int));
			arregAleat(numElem, arreglo);
			printf("---El orden es el siguiente---\n");
			metSelecDir(numElem,arreglo);
			imprArreglo(numElem,arreglo);

		break;

		case 4:
			printf("--------METODO MERGESORT--------\n");//listo

			printf("Dame el numero de elementos\n");
			scanf("%d",&numElem);
			arreglo=calloc(numElem,sizeof(int));
			arregAleat(numElem, arreglo);
			printf("---El orden es el siguiente---\n");
			metMerge(0,numElem-1,arreglo);
			imprArreglo(numElem,arreglo);
			
		break;

		case 5:
			printf("--------COMPARACION DE METODOS--------\n");
			int* copia1;
			int* copia2;
			int* copia3;
			int* copia4;

			printf("Dame el numero de elementos\n");
			scanf("%d",&numElem);

			arreglo=calloc(numElem,sizeof(int));
			arregAleat(numElem, arreglo);

			copia1=calloc(numElem,sizeof(int));
			copiarArrelgo(arreglo,copia1,numElem);

			copia2=calloc(numElem,sizeof(int));
			copiarArrelgo(arreglo,copia2,numElem);

			copia3=calloc(numElem,sizeof(int));
			copiarArrelgo(arreglo,copia3,numElem);

			copia4=calloc(numElem,sizeof(int));
			copiarArrelgo(arreglo,copia4,numElem);

			printf("---BURBUJA---\n");
			clock_t ti = clock();
			metBurbuja(numElem,copia1);
			clock_t tf = clock();

			printf("Tiempo de Burbuja: %.3f ms\n",(double) (tf-ti)*1000/CLOCKS_PER_SEC);
			printf("Orden de Burbuja:\n");
			imprArreglo(numElem, copia1);

			printf("\n");

			printf("---INSERCION DIRECTA---\n");
			ti = clock();
			metinsertDir(numElem,copia2);
			tf = clock();
			printf("Tiempo de Insercion Directa: %.3f ms\n",(double) (tf-ti)*1000/CLOCKS_PER_SEC);
			printf("Orden de Insercion Directa\n");
			imprArreglo(numElem, copia2);

			printf("\n");

			printf("---SELECCION DIRECTA---\n");
			ti = clock();
			metSelecDir(numElem,copia3);
			tf = clock();
			printf("Tiempo de Seleccion Directa: %.3f ms\n",(double) (tf-ti)*1000/CLOCKS_PER_SEC);
			printf("Orden de Seleccion Directa\n");
			imprArreglo(numElem, copia3);

			printf("\n");

			printf("---MERGESORT---\n");
			ti = clock();
			metMerge(0,numElem-1,copia4);
			tf = clock();
			printf("Tiempo de MergeSort: %.3f ms\n",(double) (tf-ti)*1000/CLOCKS_PER_SEC);
			printf("Orden de MergeSort:\n");
			imprArreglo(numElem, copia4);

			printf("\n");


		break;

		default:
		return 0;
		break;
	}
	return 0;
}

