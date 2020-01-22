module Main where
main::IO()

-------------------
-- Tipo Fraccion --
-------------------

data Fraccion  =  Fraccion Int Char Int deriving (Show)

numerador :: Fraccion -> Int
numerador ( Fraccion n _ _ ) = n

denominador :: Fraccion -> Int
denominador ( Fraccion _ _ d ) = d

divisor :: Fraccion -> [Char]
divisor (Fraccion _ '/' _) = ['/']


--------------------------------
-- Metodos toFrac y toCadFrac --
--------------------------------

toCadFrac :: Fraccion -> [Char]
toCadFrac ( Fraccion n '/' d) = (show n) ++ ['/'] ++ (show d)

toFrac :: [Char] -> Fraccion 
toFrac cadFrac = 
    Fraccion (read (head listaNumeros)) '/' (read (last listaNumeros))
    where listaNumeros = splitFrac cadFrac
        

splitFrac :: [Char] -> [[Char]]
splitFrac [] = []
splitFrac cadFrac =  
    numero:( splitFrac (drop 1 restoCadFrac) )
    where
    (numero, restoCadFrac) = span (/= '/') cadFrac

---------------------
-- Minimos Comunes --
---------------------

-- Minimo Comun Divisor
mcd :: Int -> Int -> Int
mcd a 0 = a
mcd a b = mcd b (mod a b)

-- Minimo Comun Multiplo
mcm :: Int -> Int -> Int
mcm a b = div (a*b) (mcd a b)

-------------------------------
-- Operaciones de Fracciones --
-------------------------------

-- Resta de Fracciones                                 
restaFraccion :: Fraccion -> Fraccion -> Fraccion
restaFraccion fraccion1 fraccion2 = 
    Fraccion (( (div minimoComunMultiplo b) * a ) - ( (div minimoComunMultiplo d) * c ) ) '/' (minimoComunMultiplo)
    where 
    a = numerador fraccion1
    b = denominador fraccion1
    c = numerador fraccion2
    d = denominador fraccion2
    minimoComunMultiplo = mcm b d


-- Suma de Fracciones                                 
sumaFraccion :: Fraccion -> Fraccion -> Fraccion
sumaFraccion f (Fraccion 0 '/' 1) = f
sumaFraccion fraccion1 fraccion2 = 
    Fraccion ( ( (div minimoComunMultiplo b) * a ) + ( (div minimoComunMultiplo d) * c ) ) '/' (minimoComunMultiplo)
    where 
    a = numerador fraccion1
    b = denominador fraccion1
    c = numerador fraccion2
    d = denominador fraccion2
    minimoComunMultiplo = mcm b d
   


-- sumaListaFracciones :: [Fraccion] -> Fraccion
-- sumaListaFracciones [] = (Fraccion 0 '/' 1)
-- sumaListaFracciones (x:xs) = reducirFraccion (sumaFraccion x (sumaListaFracciones xs))


sumaListaFracciones :: [[Char]] -> [Char]
sumaListaFracciones [] = "0/1"
sumaListaFracciones (x:xs) = toCadFrac (reducirFraccion (sumaFraccion (toFrac x) (toFrac (sumaListaFracciones xs))))


-- reducirFraccion
reducirFraccion fraccion =
    Fraccion (div n minComDiv) '/' (div d minComDiv)
    where
        n = numerador fraccion
        d = denominador fraccion
        minComDiv = mcd n d

    
------------------------------
-- Metodos Fraccion Egipcia --
------------------------------

                    
-- Genera nueva lista usando formula del divisor
generaNuevaFraccion :: Fraccion -> Fraccion
generaNuevaFraccion fraccion = 
    Fraccion 1 '/' ((div d n) + 1)
    where
    n = numerador fraccion
    d = denominador fraccion
                                                 
                                                 
-- Resta las fracciones para encontrar fraccion egipcia
restaEgipcia :: Fraccion -> Fraccion
restaEgipcia fraccion =  
    restaFraccion fraccion nuevaFraccion
    where 
    nuevaFraccion = generaNuevaFraccion fraccion
    
-- Realiza el metodo completo de fracciones egipcias
egipcia :: Fraccion -> [[Char]]                               
egipcia (Fraccion 1 '/' d) = [ ( toCadFrac (Fraccion 1 '/' d) )]
egipcia fraccion = 
    [ (toCadFrac nuevaFraccion)] ++ egipcia fraccionEgipcia 
    where
        nuevaFraccion = generaNuevaFraccion fraccion
        fraccionEgipcia = restaEgipcia fraccion
 


-----------------
-- Metodo Main --
-----------------

main = 
   do
      putStrLn "1.- Escribir Archivo con Fracciones egipcias dada una Fraccion:"
      putStrLn "2.- Leer un Archivo con Fracciones egipcias a su Fraccion:"
      putStrLn "3.- Leer contenido de Archivo con Fracciones egipcias:"
      putStrLn "4.- Salir:"
      putStr "Dame una opcion: "
      
      opt <- getLine

      if (opt == "1")
            then do
                
                putStr "Dame una Fraccion Normal: "
                cadFrac <- getLine
                
                putStr "Nombre de Archivo de Salida: "
                ofile <- getLine
                
                writeFile ofile (foldr (++) [] (map (++" ") (egipcia (toFrac cadFrac))))
                print ("El Archivo " ++ ofile ++ " se ha escrito con las fracciones egipcias de " ++ cadFrac)
                
                main
                
      else if (opt == "2")
            then do
                putStr "Archivo Entrada: "
                ifile <- getLine
                
                s <- readFile ifile
                print ("La fraccion obtenida dadas las fracciones egipcias del archivo es: " ++ sumaListaFracciones (words s))
                
                main
                
      else if (opt == "3")
            then do
            putStr "Archivo Entrada: "
            ifile <- getLine
          
            s <- readFile ifile
            print (s)
            
            main
                               
      else if (opt == "4")
            then return ()
      
      else
           main
         