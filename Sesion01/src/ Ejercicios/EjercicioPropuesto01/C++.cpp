#include <iostream>

using namespace std;

int sumarElementos(int arr[], int tamanio) {
    int suma = 0;
    for (int i = 0; i < tamanio; i++) {
        suma += arr[i];
    }
    return suma;
}

int main() {
    int miArreglo[] = {1, 2, 3, 4, 5};

    int tamanio = 5;

    int resultado = sumarElementos(miArreglo, tamanio);

    cout << "La suma de los elementos es: " << resultado << endl;

    return 0;
}
