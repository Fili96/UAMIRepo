-- Practica 1
-- Angel Rebollo Lopez
-- 2143009467


-- <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- <<<<<<<< Primera Parte >>>>>>>>>>>>
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<

-- 1a) Newton Rapson

f x = x^2 - x - 6
f' x = 2*x - 1

newtonRapson n = if ( f n < 0.00001 && f n > 0 )
                    then
                        n
                    else
                        newtonRapson ( n - f n / f' n ) 

-- 1b) funcion para formar palabras                    

formaPalabra :: Eq a => a -> [a] -> [ [a] ]
formaPalabra espacio [] = []
formaPalabra espacio texto =  palabra : formaPalabra espacio (drop 1 restoTexto)
                                 where (palabra, restoTexto) = span (/= espacio) texto

-- PD: no use words porque me dio error ya que es una palabra reservada     

formaPalabra2 palabra = words palabra           

                       
                                 
-- <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- <<<<<<<< Segunda Parte >>>>>>>>>>>>
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<

-- 2a) funcion que guarda una fraccion

data Racional  =  Fraccion Int Int deriving (Show)


guardaFraccion :: Racional -> [Char]
guardaFraccion ( Fraccion numerador denominador ) = if( denominador == 0)
                                                      then error "No es un numero"
                                                    else if ( numerador == 0 )
                                                     then "0"
                                                    else ("Fraccion = " ++ show numerador ++ "/" ++ show denominador)

-- 2b) Operaciones para las fracciones

-- Suma y Resta                                   
srFraccion :: Racional -> Racional -> [Char]
srFraccion ( Fraccion a b ) ( Fraccion c d ) = if( b == 0 || d == 0 )
                                                 then error "No es un numero"
                                               else if ( ( a*d + b*c ) == 0 )
                                                 then "0"
                                               else
                                                 ("Res = " ++ show (a*d + b*c) ++ "/" ++ show (b*d) )
                            

-- Multiplicacion
multFraccion :: Racional -> Racional -> [Char]
multFraccion ( Fraccion a b ) ( Fraccion c d ) = if( b == 0 || d == 0 )
                                                    then error "No es un numero"
                                                 else if ( a == 0 || c == 0)
                                                    then "0"
                                                 else
                                                    ("Res = " ++ show (a*c) ++ "/" ++ show (b*d) )

-- Division
divFraccion :: Racional -> Racional -> [Char]
divFraccion ( Fraccion a b ) ( Fraccion c d ) = if( b == 0 || d == 0 )
                                                   then error "No es un numero"
                                                else if ( a == 0 || c == 0)
                                                   then "0"
                                                else
                                                   ("Res = " ++ show (a*d) ++ "/" ++ show (b*c) )

-- <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- <<<<<<<< Tercera Parte >>>>>>>>>>>>
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<       


mergeSort :: (Ord a) => [a] -> [a]
mergeSort [] = []
mergeSort [elemento] = [elemento]
mergeSort lista = merge (mergeSort listaIzq) (mergeSort listaDer)
                    where listaIzq = take ((length lista) `div` 2) lista
                          listaDer = drop ((length lista) `div` 2) lista
          
-- mezcla las listas
merge :: (Ord a) => [a] -> [a] -> [a]
merge listaIzq [] = listaIzq
merge [] listaDer = listaDer
merge (x:xs) (y:ys)
  | x < y     = x:(merge xs (y:ys))
  | otherwise = y:(merge (x:xs) ys)         