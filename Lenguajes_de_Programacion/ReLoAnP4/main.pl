
:-consult('movies.txt').

menu:-
	write('1.- Informacion de pelicula'),nl,
	%Agregar
	write('2.- Agregar Pelicula'),nl,
	write('3.- Agregar Director'),nl,
	write('4.- Agregar Actor'),nl,
	write('5.- Agregar Actriz'),nl,
	%Modificar
	write('6.- Modificar Pelicula'),nl,
	write('7.- Modificar Actor'),nl,
	write('8.- Modificar Actriz'),nl,
	write('9.- Modificar Director'),nl,
	%Eliminar
	write('10.- Eliminar Pelicula'),nl,
	write('11.- Eliminar Actor'),nl,
	write('12.- Eliminar Actriz'),nl,
	write('13.- Eliminar Director'),nl,
	%Escribir Meta
	write('14.- Escribir Meta'),nl,
	write('15.- Guardar Cambios'),nl,
	write('16.- Salir'),nl,
	
	write('Dame una opcion'),nl,
	read(Opcion),
	hazOpcion(Opcion).
	
/**********************************/
/*********** CONSULAR *************/
/**********************************/

%Info de Pelicula	
hazOpcion(1):-
	write('Haz elegido Informacion de Pelicula'),nl,
	write('Dame el nombre de la pelicula'),nl,
	read(M),
	movie(M,Y),
	director(M,D),
	findall((A1,R1),actor(M,A1,R1),Actores),
	findall((A2,R2),actress(M,A2,R2),Actrices),
	nl,
	write('Pelicula: '),
	write(M),nl,
	write('Anio: '),
	write(Y),nl,
	write('Director: '),
	write(D),nl,
	write('Actores: '),
	write(Actores),nl,
	write('Actrices: '),
	write(Actrices),nl,nl,
	menu.

	
/*********************************/
/*********** AGREGAR *************/
/*********************************/
		
%Agregar Pelicula
hazOpcion(2):-
	write('Haz elegido Agregar Pelicula'),nl,
	write('Dame el nombre de la pelicula'),nl,
	read(P),
	write('Dame el anio de la pelicula'),nl,
	read(Y),
	assert(movie(P,Y)),
	write('Pelicula Agregada'),nl,nl,
	menu.
	
%Agregar Director
hazOpcion(3):-
	write('Haz elegido Agregar Director'),nl,
	write('Dame el nombre de la Pelicula'),nl,
	read(M),
	write('Dame el nombre del Director'),nl,
	read(D),
	assert(director(M,D)),
	write('Director Agregado'),nl,nl,
	menu.
	
%Agregar Actor
hazOpcion(4):-
	write('Haz elegido Agregar Actor'),nl,
	write('Dame el nombre de la Pelicula'),nl,
	read(M),
	write('Dame el nombre de la Actor'),nl,
	read(A),
	write('Dame el papel de la Actor'),nl,
	read(P),
	assert(actor(M,A,P)),
	write('Actor Agregado'),nl,nl,
	menu.
	
%Agregar Actriz
hazOpcion(5):-
	write('Haz elegido Agregar Actriz'),nl,
	write('Dame el nombre de la Pelicula'),nl,
	read(M),
	write('Dame el nombre de la Actriz'),nl,
	read(A),
	write('Dame el papel de la Actriz'),nl,
	read(P),
	assert(actress(M,A,P)),
	write('Actriz Agregada'),nl,nl,
	menu.
	
/***********************************/
/*********** MODIFICAR *************/
/***********************************/

%Modificar Pelicula
hazOpcion(6):-
	write('Haz elegido Modificar Pelicula'),nl,nl,
	write('Dame el nombre de la Pelicula'),nl,
	read(M),
	write('Dame el nuevo nombre de la Pelicula'),nl,
	read(N),
	
	movie(M,Y),
	findall(D,director(M,D),Directores),
	findall((A1,P1),actor(M,A1,P1),Actores),
	findall((A2,P2),actress(M,A2,P2),Actrices),
	
	retract(movie(M,_)),
	retractall(director(M,_)),
	retractall(actor(M,_,_)),
	retractall(actress(M,_,_)),

	assert(movie(N,Y)),
	(member(X,Directores),assert(director(N,X)),fail;true),
	(member((A,R),Actores),assert(actor(N,A,R)),fail;true),
	(member((A,R),Actrices),assert(actress(N,A,R)),fail;true),
	write('Pelicula Modificada'),nl,nl,
	menu.


%Modificar Actor
hazOpcion(7):-
	write('Haz elegido Modificar Actor'),nl,nl,
	write('Dame el nombre del Actor'),nl,
	read(A),
	write('Dame el nuevo nombre del Actor'),nl,
	read(N),
	
	findall((M,R),actor(M,A,R),Movies),
	retractall(actor(_,A,_)),
	(member((Pelicula,Papel),Movies),assert(actor(Pelicula,N,Papel)),fail;true),
	write('Actor Modificado'),nl,nl,
	menu.
	
%Modificar Actriz
hazOpcion(8):-
	write('Haz elegido Modificar Actriz'),nl,nl,
	write('Dame el nombre de la Actriz'),nl,
	read(A),
	write('Dame el nuevo nombre de la Actriz'),nl,
	read(N),
	
	findall((M,R),actress(M,A,R),Movies),
	retractall(actress(_,A,_)),
	(member((Pelicula,Papel),Movies),assert(actress(Pelicula,N,Papel)),fail;true),
	write('Actriz Modificado'),nl,nl,
	menu.
	
%Modificar Director
hazOpcion(9):-
	write('Haz elegido Modificar Director'),nl,nl,
	write('Dame el nombre del director'),nl,
	read(D),
	write('Dame el nuevo nombre del director'),nl,
	read(N),
	
	findall(M,director(M,D),Directores),
	retractall(director(_,D)),
	(member(X,Directores),assert(director(X,N)),fail;true),
	write('Director Modificado'),nl,nl,
	menu.
	

/**********************************/
/*********** ELIMINAR *************/
/**********************************/

%Eliminar Pelicula
hazOpcion(10):-
	write('Haz elegido Eliminar Pelicula'),nl,nl,
	write('Dame el nombre de la Pelicula'),nl,
	read(M),
	
	retract(movie(M,_)),
	retractall(director(M,_)),
	retractall(actor(M,_,_)),
	retractall(actress(M,_,_)),
	
	write('Pelicula Eliminada'),nl,nl,
	menu.
	
%Eliminar Actor
hazOpcion(11):-
	write('Haz elegido Eliminar Actor'),nl,nl,
	write('Dame el nombre del Actor'),nl,
	read(A),
	
	retractall(actor(_,A,_)),
	
	write('Actor Eliminado'),nl,nl,
	menu.
	
%Eliminar Actriz
hazOpcion(12):-
	write('Haz elegido Eliminar Actriz'),nl,nl,
	write('Dame el nombre de la Actriz'),nl,
	read(A),
	
	retractall(actress(_,A,_)),
	
	write('Actriz Eliminada'),nl,nl,
	menu.
	
%Eliminar Director
hazOpcion(13):-
	write('Haz elegido Eliminar Director'),nl,nl,
	write('Dame el nombre del Director'),nl,
	read(D),
	
	retractall(director(_,D)),
	
	write('Director Eliminado'),nl,nl,
	menu.

/***************/
/**** OTROS ****/
/***************/
	
%Escribir Meta
hazOpcion(14):-
	write('Escribe una consulta'),nl,
	read(P),
	call(P),
	write(P),nl,
	fail;true,
	nl,nl,
	menu.
	
%Guardar Estado	
hazOpcion(15):-
	open('movies.txt',write,S),
	set_output(S),
	listing(movie/2),
	listing(director/2),
	listing(actor/3),
	listing(actress/3),
	nl(S),
	close(S),
	write('Cambios Guardados'),
	nl,nl,
	menu.
	
%Salir
hazOpcion(16):-
	write('adios').
		
%Default		
hazOpcion(X):-
	write('Opcion Invalida, Intenta de nuevo'),
	nl,nl,
	menu.