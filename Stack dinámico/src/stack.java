import java.util.Arrays;

public class stack {
    private static int tamaño = 10;
    public int array[] = new int[tamaño];
    int top = -1;


    public int push(int elemento)
    {
        if (top < tamaño - 1) {
            top++;
            array[top] = elemento;
            System.out.println("Elemento " + elemento + " añadido a Stack\n");
            mostrar();
        } else {

            array = Arrays.copyOf(array, array.length+10);
            top++;
            array[top] = elemento;
            System.out.println("Elemento " + elemento + " añadido a Stack\n");
            mostrar();

        }
        return array[top];
    }


    public void pop()
    {
        if (top >= 0) {
            top--;
            System.out.println("Pop realizado\n");
            mostrar();
        } else {
            System.out.println("=Stack Underflow=\n");
        }
    }

    public void clear()
    {
        for(int i = 0; i <= array.length; i++)
            pop();
        System.out.println("Array vacío");

    }

    public void mostrar()
    {
        if (top >= 0) {
            System.out.println("Elements in stack :");
            for (int i = 0; i <= top; i++) {
                System.out.println(array[i]);
            }
            System.out.println("\n");
        }
    }

}
