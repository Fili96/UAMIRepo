module OPE
  ##
  # Minimo Comun Divisor
  ##
  def mcd(a,b)
    if(b == 0)
      return a
    else
      return mcd(b,a%b)
    end
  end

  ##
  # Minimo Comun Multiplo
  ##
  def mcm(a,b)
    return (a*b)/mcd(a,b)
  end
  
end