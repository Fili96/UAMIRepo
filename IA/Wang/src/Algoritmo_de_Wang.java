public class Algoritmo_de_Wang {

    String izquierda = "";
    String derecha = "";

    public void CadEnLados(String teorema) {
        int indice = teorema.indexOf("=");
        izquierda = teorema.substring(0, indice);
        derecha = teorema.substring(indice + 1);
    }

    public boolean ComprobarTeorema(String teorema) {

        CadEnLados(teorema);
        System.out.println("Teorema: " + teorema);
        System.out.println("Lado izquierdo: " + izquierda);
        System.out.println("Lado derecho: " + derecha);
        try {
            negacion();
        }

        catch(Exception e){
             AndyOr();
        }
        implicacion();

        if (!izquierda.contains("not") && !derecha.contains("not")
                && !izquierda.contains("or") && !derecha.contains("or")
                && !izquierda.contains("and") && !derecha.contains("and")
                && !izquierda.contains("->") && !derecha.contains("->")
                && !izquierda.equals(derecha)) {
            System.out.println("Teorema: " + teorema + " no somos iguales");

            return false;
        }

        if (izquierda.equals(derecha)) {
            System.out.println("Teorema: " + teorema + " somos iguales");
            return true;
        }

        return AndyOr();

    }

    public void negacion() {
        //lado izquierdo

        if (izquierda.contains("not")) {

            String cad_restante = izquierda.substring(izquierda.indexOf("not") + 3);

            if (cad_restante.contains(")")) {

                cad_restante = cad_restante.replace("(", "/");
            }
            //System.out.println("cadena restante de izquierda: " + cad_restante);

            if (cad_restante.contains("/") && cad_restante.contains(")")) {
                cad_restante = cad_restante.replace("/", "(");
                cad_restante = cad_restante.replace(")", "/");
            }

            if (cad_restante.contains(")")) {

                String cadantes_not = izquierda.substring(0, izquierda.indexOf("("));
                cad_restante = izquierda.substring(izquierda.indexOf("not") - 1);//regresar prentesis

                String cad_parentesis = cad_restante.substring(cad_restante.indexOf("("), cad_restante.indexOf(")") + 1);

                cad_parentesis = cad_parentesis.replace("n", "m");//camion la n por m

                cad_restante = cad_parentesis + cad_restante.substring(cad_restante.indexOf(","));
                //System.out.println("cadena con parentesis restante de izquierda: " + cad_restante);
                izquierda = cadantes_not + cad_restante;
                cad_restante = izquierda.substring(izquierda.indexOf("not") + 3);
            }

            if (izquierda.contains("not")) {

                if (cad_restante.contains(",")) {
                    cad_restante = cad_restante.substring(0, cad_restante.indexOf(","));
                    // System.out.println("cadena restante dentro del if: " + cad_restante);
                    izquierda = izquierda.replace("not" + cad_restante + ",", "") + ",";
                }

                izquierda = izquierda.replace("not" + cad_restante, "");
                derecha = derecha + "," + cad_restante + ",";

                if (izquierda.contains(")")) {
                    izquierda = izquierda.replace("m", "n");
                }
                izquierda = izquierda.replace(",,", ",");
                derecha = derecha.replace(",,", ",");

                //   System.out.println("nueva izq: " + izquierda);
                //   System.out.println("nueva der: " + derecha);
            }
        }
        //lado derecho

        if (derecha.contains("not")) {

            String cad_restante = derecha.substring(derecha.indexOf("not") + 3);

            if (cad_restante.contains(")")) {

                cad_restante = cad_restante.replace("(", "/");
            }
            //System.out.println("cadena restante de izquierda: " + cad_restante);

            if (cad_restante.contains("/") && cad_restante.contains(")")) {
                cad_restante = cad_restante.replace("/", "(");
                cad_restante = cad_restante.replace(")", "/");
            }

            if (cad_restante.contains(")")) {

                String cadantes_not = derecha.substring(0, derecha.indexOf("("));
                cad_restante = derecha.substring(derecha.indexOf("not") - 1);//regresar prentesis

                String cad_parentesis = cad_restante.substring(cad_restante.indexOf("("), cad_restante.indexOf(")") + 1);

                cad_parentesis = cad_parentesis.replace("n", "m");//camion la n por m

                cad_restante = cad_parentesis + cad_restante.substring(cad_restante.indexOf(","));
                //System.out.println("cadena con parentesis restante de izquierda: " + cad_restante);
                derecha = cadantes_not + cad_restante;
                cad_restante = derecha.substring(derecha.indexOf("not") + 3);
            }

            if (derecha.contains("not")) {
                cad_restante = derecha.substring(derecha.indexOf("not") + 3);
                //  System.out.println("cadena restante de derecha: " + cad_restante);

                if (cad_restante.contains(",")) {
                    cad_restante = cad_restante.substring(0, cad_restante.indexOf(","));
                    //      System.out.println("cadena restante dentro del if: " + cad_restante);
                    derecha = derecha.replace("not" + cad_restante + ",", "") + ",";
                }

                derecha = derecha.replace("not" + cad_restante, "");
                izquierda = izquierda + "," + cad_restante + ",";

                izquierda = izquierda.replace(",,", ",");
                derecha = derecha.replace(",,", ",");

                //   System.out.println("nueva izq: " + izquierda);
                //   System.out.println("nueva der: " + derecha);
            }
        }
    }

    private void implicacion() {
        //lado izquierdo
        if (izquierda.contains("->")) {
            int indicenot = izquierda.indexOf("->");
            String letra1 = izquierda.substring(indicenot - 1, indicenot);
            //System.out.println("P " + letra1);
            String letra2 = izquierda.substring(indicenot + 2, indicenot + 3);
            //System.out.println("Q " + letra2);
            String cad2_der = izquierda.substring(indicenot + 3);//toda la cadena izq despues de ->
            String cad1_der = izquierda.substring(0, indicenot - 1);//toda la cadena izq antes de ->
            izquierda = cad1_der + "(not" + letra1 + "or" + letra2 + ")" + cad2_der;
            // System.out.println("Izquierda implicacion " + izquierda);

        }

        //lado derecho
        if (derecha.contains("->")) {
            int indicenot = derecha.indexOf("->");
            String letra1 = derecha.substring(indicenot - 1, indicenot);
            //System.out.println("P " + letra1);
            String letra2 = derecha.substring(indicenot + 2, indicenot + 3);
            //System.out.println("Q " + letra2);
            String cad2_der = derecha.substring(indicenot + 3);//toda la cadena izq despues de ->
            String cad1_der = derecha.substring(0, indicenot - 1);//toda la cadena izq antes de ->
            derecha = cad1_der + "(not" + letra1 + "or" + letra2 + ")" + cad2_der;
            // System.out.println("Derecha implicacion " + derecha);
        }

    }

    private boolean AndyOr() {

        if ((izquierda.contains("(") && izquierda.contains(")"))
                || (derecha.contains("(") && derecha.contains(")"))) {//si hay parentesis en la izq o der

            if (izquierda.contains("(") && izquierda.contains(")")) {//el parentesis esta en la izq

                String aux = izquierda.substring(izquierda.indexOf("("), izquierda.indexOf(")") + 1);
                String cadizq_parentesis = izquierda.substring(izquierda.indexOf("(") + 1, izquierda.indexOf(")"));

                if (cadizq_parentesis.contains("and")) {//hay un and
                    cadizq_parentesis = cadizq_parentesis.replace("and", ",");
                    izquierda = izquierda.replace(aux, cadizq_parentesis);
                    System.out.println(izquierda + "=" + derecha);
                } else if (cadizq_parentesis.contains("or")) {//hay un or

                    String elemento1 = cadizq_parentesis.substring(0, cadizq_parentesis.indexOf("or"));
                    String elemento2 = cadizq_parentesis.substring(cadizq_parentesis.indexOf("or") + 2);
                    //  System.out.println("Elemento 1: " + elemento1 + " y Elemento 2: " + elemento2);

                    String nuevo_teorema1 = izquierda.replace(aux, elemento1) + "=" + derecha;
                    String nuevo_teorema2 = izquierda.replace(aux, elemento2) + "=" + derecha;
                    System.out.println("nuevo teorema 1: " + nuevo_teorema1 + "\nnuevo teorema 2: " + nuevo_teorema2);
                    return (ComprobarTeorema(nuevo_teorema1) || ComprobarTeorema(nuevo_teorema2));

                }
            }

            if (derecha.contains("(") && derecha.contains(")")) {//el parentesis esta en la der

                String aux = derecha.substring(derecha.indexOf("("), derecha.indexOf(")") + 1);
                String cadder_parentesis = derecha.substring(derecha.indexOf("(") + 1, derecha.indexOf(")"));

                if (cadder_parentesis.contains("or")) {//hay un or
                    cadder_parentesis = cadder_parentesis.replace("or", ",");
                    derecha = derecha.replace(aux, cadder_parentesis);
                    System.out.println(izquierda + "=" + derecha);
                } else if (cadder_parentesis.contains("and")) {//hay un and

                    String elemento1 = cadder_parentesis.substring(0, cadder_parentesis.indexOf("and"));
                    String elemento2 = cadder_parentesis.substring(cadder_parentesis.indexOf("and") + 2);
                    //  System.out.println("Elemento 1: " + elemento1 + " y Elemento 2: " + elemento2);

                    String nuevo_teorema1 = derecha.replace(aux, elemento1) + "=" + izquierda;
                    String nuevo_teorema2 = derecha.replace(aux, elemento2) + "=" + izquierda;
                    System.out.println("nuevo teorema 1: " + nuevo_teorema1 + "\nnuevo teorema 2: " + nuevo_teorema2);
                    return (ComprobarTeorema(nuevo_teorema1) || ComprobarTeorema(nuevo_teorema2));
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Algoritmo_de_Wang obj = new Algoritmo_de_Wang();
        System.out.println(obj.ComprobarTeorema("P,(notQandR)=(PandnotQ)"));
        /*String s = "xxxxx xxx xxxx  fdsfds xzsdsd xxxxx xxx xxxx frgtrvrfvvhythytuy";
String s2 = "yyymmdd";
s = s.replace("xxxxx xxx xxxx ",s2);
        System.out.println(s);*/
    }
}
//(PorQ),R,S=(QorP)    Q->R,(notBorS),notR=notP,B->S  "P->Q,Q->R,notR=notP"
//P,(notQandR)=(PandnotQ)