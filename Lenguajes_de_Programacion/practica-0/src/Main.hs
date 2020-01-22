-- Lenguajes de Programacion
-- Angel Rebollo López <arl96uam@gmail.com>
-- 2143009467

-- funcion para el factorial de un numero
factorial :: Integral numero => numero -> numero
factorial(0) = 1
factorial(n) = n * factorial(n-1)
                    
-- funcion para calcular los valores de a, b, c en una ecuacion cuadrada
raices (a, b, c) = if( a /= 0 ) 
                    then
                        ( ( -b + sqrt(b**2 - 4 * a * c) ) * 0.5, ( -b - sqrt(b**2 - 4 * a * c) ) * 0.5 )
                    else
                         error "NO SE PUEDE DIVIDIR POR CERO"
