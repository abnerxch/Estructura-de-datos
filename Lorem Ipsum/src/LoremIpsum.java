public class LoremIpsum {
    public int primero = 0, segundo = 0, tercero = 0, cuarto = 0, quinto = 0, sexto = 0, septimo = 0,
    octavo = 0, noveno = 0, decimo = 0;
    public int uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez;

    int [] abecedario = new int[27];
    int [] top10 = new int[10];
    String [] caracteres = new String[27];

    public void texto(String texto)
    {
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0, eCount = 0, fCount = 0, gCount = 0, hCount = 0,
                iCount = 0, jCount = 0, kCount = 0, lCount = 0, mCount = 0, nCount = 0, oCount = 0, pCount = 0,
                qCount = 0, rCount = 0, sCount = 0, tCount = 0, uCount = 0, vCount = 0, wCount = 0,
                xCount = 0, yCount = 0, zCount = 0, espCount = 0;

        //String texto = "unA cadenA de caracteres";

        char [] arraychar = texto.toCharArray();


        for (int i = 0; i < arraychar.length; i++)
        {

            switch (arraychar[i])
            {
                case 'a': case  'A':
                aCount++;
                abecedario[0] = aCount;
                caracteres[0] = "A";
                //top(abecedario[0]);
                //System.out.println("Hay " + abecedario[0] + " A's");
                break;

                case 'b': case  'B':
                bCount++;
                abecedario[1] = bCount;
                caracteres[1] = "B";
                break;

                case 'c': case  'C':
                cCount++;
                abecedario[2] = cCount;
                caracteres[2] = "C";
                break;

                case 'd': case  'D':
                dCount++;
                abecedario[3] = dCount;
                caracteres[3] = "D";
                break;

                case 'e': case  'E':
                eCount++;
                abecedario[4] = eCount;
                caracteres[4] = "E";
                break;

                case 'f': case  'F':
                fCount++;
                abecedario[5] = fCount;
                caracteres[5] = "F";
                break;

                case 'g': case  'G':
                gCount++;
                abecedario[6] = gCount;
                caracteres[6] = "G";
                break;

                case 'h': case  'H':
                hCount++;
                abecedario[7] = hCount;
                caracteres[7] = "H";
                break;

                case 'i': case  'I':
                iCount++;
                abecedario[8] = iCount;
                caracteres[8] = "I";
                break;

                case 'j': case  'J':
                jCount++;
                abecedario[9] = jCount;
                caracteres[9] = "J";
                break;

                case 'k': case  'K':
                kCount++;
                abecedario[10] = kCount;
                caracteres[10] = "K";
                break;

                case 'l': case  'L':
                lCount++;
                abecedario[11] = lCount;
                caracteres[11] = "L";
                break;

                case 'm': case  'M':
                mCount++;
                abecedario[12] = mCount;
                caracteres[12] = "M";
                break;

                case 'n': case  'N':
                nCount++;
                abecedario[13] = nCount;
                caracteres[13] = "N";
                break;

                case 'o': case  'O':
                oCount++;
                abecedario[14] = oCount;
                caracteres[14] = "O";
                break;

                case 'p': case  'P':
                pCount++;
                abecedario[15] = pCount;
                caracteres[15] = "P";
                break;

                case 'q': case  'Q':
                qCount++;
                abecedario[16] = qCount;
                caracteres[16] = "Q";
                break;

                case 'r': case  'R':
                rCount++;
                abecedario[17] = rCount;
                caracteres[17] = "R";
                break;

                case 's': case  'S':
                sCount++;
                abecedario[18] = sCount;
                caracteres[18] = "S";
                break;

                case 't': case  'T':
                tCount++;
                abecedario[19] = tCount;
                caracteres[19] = "T";
                break;

                case 'u': case  'U':
                uCount++;
                abecedario[20] = uCount;
                caracteres[20] = "U";
                break;

                case 'v': case  'V':
                vCount++;
                abecedario[21] = vCount;
                caracteres[21] = "V";
                break;

                case 'w': case  'W':
                wCount++;
                abecedario[22] = wCount;
                caracteres[22] = "W";
                break;

                case 'x': case  'X':
                xCount++;
                abecedario[23] = xCount;
                caracteres[23] = "X";
                break;

                case 'y': case  'Y':
                yCount++;
                abecedario[24] = yCount;
                caracteres[24] = "Y";
                break;

                case 'z': case  'Z':
                zCount++;
                abecedario[25] = zCount;
                caracteres[25] = "Z";
                break;

                case ' ' :
                espCount++;
                abecedario[26] = espCount;
                caracteres[26] = "Espacio";
                break;

                //default: System.out.println(arraychar[i] + " No es a");
            }

        }

        top();
    }

    public void top()
    {

        for (int i=0; i < abecedario.length; i++){
            if(primero < abecedario[i]){
                primero = abecedario[i];
                uno = i;
            }
        }

        for (int j = 0; j < abecedario.length; j++)
        {
            if(abecedario[j] < primero && abecedario[j] > segundo)
            {
                segundo = abecedario[j];
                dos = j;
            }
        }

        for (int k = 0; k < abecedario.length; k++)
        {
            if(abecedario[k] < segundo && abecedario[k] > tercero)
            {
                tercero = abecedario[k];
                tres = k;
            }
        }

        for (int l = 0; l < abecedario.length; l++)
        {
            if(abecedario[l] < tercero && abecedario[l] > cuarto)
            {
                cuarto = abecedario[l];
                cuatro = l;
            }
        }

        for (int m = 0; m < abecedario.length; m++)
        {
            if(abecedario[m] < cuarto && abecedario[m] > quinto)
            {
                quinto = abecedario[m];
                cinco = m;
            }
        }

        for (int n = 0; n < abecedario.length; n++)
        {
            if(abecedario[n] < quinto && abecedario[n] > sexto)
            {
                sexto = abecedario[n];
                seis = n;
            }
        }

        for (int o = 0; o < abecedario.length; o++)
        {
            if(abecedario[o] < sexto && abecedario[o] > septimo)
            {
                septimo = abecedario[o];
                siete = o;
            }
        }

        for (int p = 0; p < abecedario.length; p++)
        {
            if(abecedario[p] < septimo && abecedario[p] > octavo)
            {
                octavo = abecedario[p];
                ocho = p;
            }
        }

        for (int q = 0; q < abecedario.length; q++)
        {
            if(abecedario[q] < octavo && abecedario[q] > noveno)
            {
                noveno = abecedario[q];
                nueve = q;
            }
        }

        for (int r = 0; r < abecedario.length; r++)
        {
            if(abecedario[r] < noveno && abecedario[r] > decimo)
            {
                decimo = abecedario[r];
                diez = r;
            }
        }


        //top10[0] = primero;

    imprimir();

    }

    public void imprimir ()
    {
        System.out.print("\n" + caracteres[uno] + " " + abecedario[uno] + " " );
        for(int i = 0; i < abecedario[uno]; i++) System.out.print("*");

        System.out.print("\n" + caracteres[dos] + " " + abecedario[dos] + " " );
        for(int j = 0; j < abecedario[dos]; j++) System.out.print("*");

        System.out.print("\n" + caracteres[tres] + " " + abecedario[tres] + " " );
        for(int k = 0; k < abecedario[tres]; k++) System.out.print("*");

        System.out.print("\n" + caracteres[cuatro] + " " + abecedario[cuatro] + " " );
        for(int l = 0; l < abecedario[cuatro]; l++) System.out.print("*");

        System.out.print("\n" + caracteres[cinco] + " " + abecedario[cinco] + " " );
        for(int m = 0; m < abecedario[cinco]; m++) System.out.print("*");

        System.out.print("\n" + caracteres[seis] + " " + abecedario[seis] + " " );
        for(int n = 0; n < abecedario[seis]; n++) System.out.print("*");

        System.out.print("\n" + caracteres[siete] + " " + abecedario[siete] + " " );
        for(int o = 0; o < abecedario[siete]; o++) System.out.print("*");

        System.out.print("\n" + caracteres[ocho] + " " + abecedario[ocho] + " " );
        for(int p = 0; p < abecedario[ocho]; p++) System.out.print("*");

        System.out.print("\n" + caracteres[nueve] + " " + abecedario[nueve] + " " );
        for(int q = 0; q < abecedario[nueve]; q++) System.out.print("*");

        System.out.print("\n" + caracteres[diez] + " " + abecedario[diez] + " " );
        for(int r = 0; r < abecedario[diez]; r++) System.out.print("*");

    }

}
