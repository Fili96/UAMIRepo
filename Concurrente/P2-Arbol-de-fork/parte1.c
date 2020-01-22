#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>



int main(int args, char *argv[]){

	char *tty;
	char *ttyname();
	tty=ttyname(0);

	int Profundidad,hijo1,hijo2;
	printf("Dame la Profundidad\n");
	scanf("%d",&Profundidad);

	printf("UID\tPID\tPPID\tTTY\t\tCOMMAND\t\n%s\t%d\t%d\t%s\t%s\n",getlogin(),getpid(),getppid(),tty,argv[0]);


	for(int i=0;i<Profundidad;i++){

		hijo1=fork();
		if(hijo1){
			hijo2= fork();
			if (hijo2){
				printf("%s\t%d\t%d\t%s\t%s\n",getlogin(),hijo1,getpid(),tty,argv[0]);
				printf("%s\t%d\t%d\t%s\t%s\n",getlogin(),hijo2,getpid(),tty,argv[0]);
			break;
			}
			
		}
		
	}
	while(1);
	return 0;
}