require "Fraccion"
require "FraccionEgipcia"
require "operaciones"

include OPE

puts "****************************"
puts "*******OPERACIONES**********"
puts "****************************"

print "\nDame el numerado de f1: "
a = gets.to_i

print "Dame el denominador de f1: "
b = gets.to_i

print "Dame el numerado de f2: "
c = gets.to_i

print "Dame el denominador de f2: "
d = gets.to_i

f1 = Fraccion.new(a,b)
f2 = Fraccion.new(c,d)

puts "\nLa suma de #{f1.num()}/#{f1.den()} y #{f2.num()}/#{f2.den()} es:"
suma = Fraccion.sumaFraccion(f1,f2)
suma.to_s()

puts "La resta de #{f1.num()}/#{f1.den()} y #{f2.num()}/#{f2.den()} es:"
resta = Fraccion.restaFraccion(f1,f2)
resta.to_s()

puts "La multiplicacion de #{f1.num()}/#{f1.den()} por #{f2.num()}/#{f2.den()} es:"
multi = Fraccion.multFraccion(f1,f2)
multi.to_s()

puts "La division de #{f1.num()}/#{f1.den()} entre #{f2.num()}/#{f2.den()} es:"
div = Fraccion.divFraccion(f1,f2)
div.to_s()

puts "\n****************************"
puts "****Conversion Egipcia******"
puts "****************************"

print "Dame el numerador: "
num = gets.to_i
print "Dame el denominador: "
den = gets.to_i
print "\n"

f3 = FraccionEgipcia.new(num,den)
fracciones = FraccionEgipcia.egipcia(f3)

puts "Tu fraccion: #{f3.num()}/#{f3.den()}\n"
FraccionEgipcia.printFracciones(fracciones)

fraccion = FraccionEgipcia.getFraccion(["1/2","1/3","1/9","1/180"])
 
print "\n" 
puts "La fraccion resultante de las fracciones egipcias [ \"1/2\", \"1/3\", \"1/9\", \"1/180\" ] es: #{fraccion.num()}/#{fraccion.den()}\n"

