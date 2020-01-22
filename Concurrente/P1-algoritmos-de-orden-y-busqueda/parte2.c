#include <stdio.h>
#include <stdlib.h>
#include <time.h>





typedef struct Nodo{
	struct Nodo* siguiente;
	struct Nodo* atras;
	int dato;
}Nodo;

Nodo* primero=NULL;
Nodo* ultimo= NULL;



void inserOrdenado(Nodo* nodo){
	nodo -> siguiente= NULL;
	nodo -> atras= NULL;

	if(primero==NULL){
		primero =nodo;
		ultimo = nodo;
	} else if ((primero->dato > nodo->dato)&&(primero->atras==NULL)){//dato es menor y se va primer posicion
				nodo-> siguiente = primero;
				nodo-> atras = NULL;
				primero->atras=nodo;
				primero=nodo;

				
				
			} 
			else if((ultimo->dato < nodo->dato)&&(ultimo->siguiente==NULL)){//dato es mayor se va a ultima posicion
				ultimo->siguiente=nodo;
				nodo->atras=ultimo;
				nodo->siguiente=NULL;
				ultimo=nodo;
				} 
		  		else{
			  		Nodo* i=malloc(sizeof(Nodo));
			  		Nodo* j=malloc(sizeof(Nodo));
			  		Nodo* aux=malloc(sizeof(Nodo));
			  		i=primero;
			  		while(i->dato < nodo->dato){
			  			i=i->siguiente;
			  			printf("avanza\n");
			  		}
				  
				  aux->dato=i->dato;
				  i->dato=nodo->dato;

				  aux->siguiente=i->siguiente;
				  i->siguiente=aux;

				  j=primero;
				  while(j->siguiente!=NULL){
			  			j=j->siguiente;
			  			ultimo=j;
			  		}

				}
}

void eliminaNodo(int dato){
	
	if((primero->dato==dato)&&(primero->siguiente!=NULL)){//dato a borrar es el primero
				primero=primero->siguiente;
				primero->atras=NULL;
			} else if(primero->siguiente==NULL){//es unico elemento
					primero=NULL;
					}else if(ultimo->dato==dato){//dato a borrar es el ultimo
							ultimo=ultimo->atras;
							ultimo->siguiente=NULL;
							} else {
									Nodo* i=malloc(sizeof(Nodo));
									Nodo* j=malloc(sizeof(Nodo));
									Nodo* aux=malloc(sizeof(Nodo));
									i=primero;
									int cont=0;

									while((i!=NULL)&&(i->dato!=dato)){
										i=i->siguiente;
										cont++;
									}

									if(i==NULL){
										printf("el elemento no se encuentra\n");
									}else if(i->dato==dato){
											j=primero;
									  		while(i->dato != dato){
									  			j=j->siguiente;
									  			printf("avanza\n");
			  								}
			  								aux=j->atras;
			  								aux->siguiente=j->siguiente;
			  								j->siguiente=NULL;

											
									}
				  
									
			  					
							}
		  		
}


void impList(Nodo* nodo){
	if(nodo==NULL){
		printf("La lista esta vacia\n");
	}else{
		printf("Los elementos son:\n");
		while(nodo!=NULL){
			printf("[%d] ",nodo->dato );
		nodo= nodo->siguiente;
		}
		printf("\n");
	}
}

void Consulta(int x){
	Nodo* i=malloc(sizeof(Nodo));
	Nodo* k=malloc(sizeof(Nodo));
	i=primero;
	k=primero;
	int cont=0;

	while(i!=NULL){
		i=i->siguiente;
		cont++;
	}

	if (cont<x)
	{
		printf("Indice Incorrecto\n");
	}else{
			for (int j = 0; j < x-1; j++){
				k=k->siguiente;
			}
			printf("el numero en la posicion %d es: %d\n",x,k->dato );
			impList(primero);
	}
}

void Busca(int x){
	Nodo* i=malloc(sizeof(Nodo));
	i=primero;
	int cont=0;

	while((i!=NULL)&&(i->dato!=x)){
		i=i->siguiente;
		cont++;
	}

	if(i==NULL){
		printf("el elemento no se encuentra\n");
	}else if(i->dato==x){
			printf("el elemento esta en la posicion %d\n",cont+1);
			impList(primero);
	}
}

void HazNula(){
	free(primero);
	free(ultimo);
	primero=malloc(sizeof(Nodo));
	ultimo=malloc(sizeof(Nodo));
	primero=NULL;
	ultimo=NULL;
	printf("Lista vacia\n");;
}


	


int main(int args, char  *argv[])
{
	int opt;
do{
	printf("\nMenu\n");
	printf("1- Inserta Ordenado\n");
	printf("2- Despliega\n");
	printf("3- Consulta\n");
	printf("4- Elimina\n");
	printf("5- Busca\n");
	printf("6- Busca recursiva\n");
	printf("7- Haz nula\n");
	printf("8- Haz nula recursiva\n");
	printf("9- Salir\n");

	printf("Elige una opcion\n");
	scanf("%d",&opt);
	system("clear");
	switch(opt){

		case 1:
		
		printf("dame el numero a ingresar, lueego presiona enter\n");
		int num;
		scanf("%d",&num);
		Nodo* obj1=malloc(sizeof(Nodo));
		obj1-> dato=num;
		inserOrdenado(obj1);
		char enter=getchar();
		
		if (enter=='\n')
		{	
			system("clear");
		}
		
		
		break;

		case 2:
		impList(primero);
		//printf("\nsoy primero: %d",primero->dato );
		//printf("\nsoy ultimo: %d\n",ultimo->dato );
		break;

		case 3:
		printf("Dame el indice del numero a consultar\n");
		int num2;
		scanf("%d",&num2);
		Consulta(num2);
		break;

		case 4:
		printf("Dame el numero a Eliminar\n");
		int num3;
		scanf("%d",&num3);
		eliminaNodo(num3);
		impList(primero);
		break;

		case 5:
		printf("Dame el numero a Buscar\n");
		int num4;
		scanf("%d",&num4);
		Busca(num4);
		break;

		case 6:
		break;

		case 7:
		printf("Quieres borrar la lista??\n");
		printf("si-->1\nNo-->0\n");
		int num6;
		scanf("%d",&num6);
		if (num6=1)
		{
			HazNula();
		}
		break;

		case 8:
		break;

		default:
		break;
	}
 }while(opt!=9);
return 0;
}


	
