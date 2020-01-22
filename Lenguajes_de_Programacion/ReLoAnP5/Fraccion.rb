class Fraccion
  def initialize(num, den)
    @num = num
    @den = den
  end

  def to_s()
    puts "#{@num}/#{@den}"
  end

  def num()
    return @num
  end

  def den()
    return @den
  end

  ##
  # Suma de Fracciones
  ##
  def self.sumaFraccion(f1, f2)
    a,b = f1.num, f1.den
    c,d = f2.num, f2.den

    # si f1 es cero
    if (a==0)&&(b==0)
      return f2
    end

    # si f2 es cero
    if (c==0)&&(d==0)
      return f1
    end

    num, den = ( (mcm(b,d)/b)*a ) + ( (mcm(b,d)/d)*c), mcm(b,d)

    return Fraccion.new(num/mcd(num,den),den/mcd(num,den))
  end

  ##
  # Resta de Fracciones
  ##
  def self.restaFraccion(f1, f2)
    a,b = f1.num, f1.den
    c,d = f2.num, f2.den

    # si f1 es cero
    if (a==0)&&(b==0)
      return Fraccion.new(-1*num,den)
    end

    # si f2 es cero
    if (c==0)&&(d==0)
      return f1
    end

    num, den= ( (mcm(b,d)/b)*a ) - ( (mcm(b,d)/d)*c), mcm(b,d)

    return Fraccion.new(num/mcd(num,den),den/mcd(num,den))
  end

  ##
  # Multiplicacion de Fracciones
  ##
  def self.multFraccion(f1,f2)
    a,b = f1.num, f1.den
    c,d = f2.num, f2.den
    multiplo = mcd(a*c,b*d)

    num, den = (a*c)/multiplo, (b*d)/multiplo

    return Fraccion.new(num,den)

  end

  ##
  # Division de Fracciones
  ##
  def self.divFraccion(f1,f2)
    a,b = f1.num, f1.den
    c,d = f2.num, f2.den
    multiplo = mcd(a*d,b*c)

    num, den = (a*d)/multiplo, (b*c)/multiplo

    return Fraccion.new(num,den)

  end

end
