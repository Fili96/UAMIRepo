require "Fraccion"

class FraccionEgipcia < Fraccion
  ##
  # Constructor
  ##
  def initialize(num,den)
    super(num,den)
  end

  ##
  # Genera nueva Fraccion usando formula del divisor
  ##
  def self.generaNuevaFraccion(f)
    return Fraccion.new(1,(f.den/f.num)+1)
  end

  ##
  # Resta las fracciones para encontrar fraccion egipcia
  ##
  def self.restaEgipcia(f)
    nf = generaNuevaFraccion(f)
    return Fraccion.restaFraccion(f,nf)
  end

  ##
  # regresa una lista con las fracciones egipcias
  ##
  def self.getFraccionesEgipcias(f,lista)
    if f.num == 1
      return lista.push(f)
    else
      nf = generaNuevaFraccion(f)
      lista.push(nf)
      fraccionEgipcia = restaEgipcia(f)
      return getFraccionesEgipcias(fraccionEgipcia,lista)
    end
  end

  ##
  # Realiza el metodo completo de fracciones egipcias
  ##
  def self.egipcia(fraccion)
    lista = []
    for f in getFraccionesEgipcias(fraccion,[])
      lista.push(" #{f.num}/#{f.den} ")
    end
    return lista
  end
  
  ##
  # Imprime en consola las fracciones egipcias
  ##
  def self.printFracciones(fracciones)
    print "Fracciones Egipcias: ["
    for f in fracciones
      print f
    end
    print "]\n"
  end
  
  ##
  # Regresa la fraccion original dada una lista de fracciones egipcias
  ##
  def self.getFraccion(fracciones)
    aux = Fraccion.new(0,0)
    for f in fracciones
      fraccion = f.split(/\//)
      num, den = fraccion[0].to_i(), fraccion[1].to_i()
      aux = Fraccion.sumaFraccion(aux,Fraccion.new(num,den))
    end
    return aux
  end

end