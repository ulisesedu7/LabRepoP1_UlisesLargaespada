/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labrepop1_uliseslargaespada;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ularg
 */
public class LabRepoP1_UlisesLargaespada {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Llamar al menu principal
    mainMenu();
  }

  public static void mainMenu() {
    System.out.println("-- Bienvenido al programa para resolver la repo del laboratorio 8 --");

    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    // Ask for the name
    System.out.println("Como te llamas?");
    System.out.print("Ingresa tu nombre: ");

    String nombre = entry.nextLine();

    System.out.println("Bienvenido " + nombre + ", espero disfrutes los ejercicios!");
    System.out.println();

    // Iniciar menu repetitivo
    do {
      System.out.println("Elija que ejercicio desea resolver: ");
      System.out.println("1 - Ajedrez Nordico");
      System.out.println("2 - Sistema de Venta de Carros");
      System.out.println("3 - Salir");

      System.out.print("Ingrese la opcion: ");
      int option = entry.nextInt();

      switch (option) {
        case 1 ->
          ajedrezNordico(nombre);

        case 2 ->
          ventaDeCarros(nombre);

        case 3 ->
          System.out.println("Gracias por usar el este programa " + nombre + ", feliz dia!");

        default ->
          System.out.println("Elija una opcion de las anteriores");
      }

      // Salir del programa 
      if (option == 3) {
        break;
      }
    } while (true);
  }

  /*
    Abajo de aqui estan todas las funciones para la funcionalidad
    del juego de ajedrez nordico
   */
  public static void ajedrezNordico(String nombre) {
    System.out.println();

    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    System.out.println("Bienvenido " + nombre + ", al juego del ajedrez nordico");
    System.out.println("En este juego podran competir dos personas, una sera los suecos y otra los nordicos");

    do {
      System.out.println("Elija que opcion deseas: ");
      System.out.println("1 - Comenzar Juego!");
      System.out.println("2 - Instrucciones");
      System.out.println("3 - Mostrar tablero del juego! (m -> moscovitas, s -> suecos)");
      System.out.println("4 - Salir");

      System.out.print("Ingrese la opcion: ");
      int option = entry.nextInt();

      // Iniciar un tablero
      String[][] tableroInicial = nuevoTablero();

      switch (option) {
        case 1 ->
          iniciarJuego(tableroInicial);

        case 2 ->
          instruccionesAjedrez();

        case 3 ->
          mostrarTablero(tableroInicial);

        default ->
          System.out.println("Elija una opcion de las anteriores");
      }

      // Salir del programa 
      if (option == 4) {
        break;
      }
    } while (true);

    System.out.println();
  }

  // Funcion para crear el tablero con las posicioens respectivas
  public static String[][] nuevoTablero() {
    // Declaro tablero
    String[][] tablero = new String[9][9];

    // Variables
    String moscovitas = "m";
    String suecos = "s";
    String rey = "R";

    // Rellenar de espacios del tablero con espacios
    for (int row = 0; row < tablero.length; row += 1) {
      for (int col = 0; col < tablero[row].length; col += 1) {
        tablero[row][col] = " ";
      }
    }

    // ---Rellenar espacios espeficicos de la tabla---
    // 1. Espacios suecos
    // Rey
    tablero[4][4] = rey;
    // soldados suecos
    tablero[2][4] = suecos;
    tablero[3][4] = suecos;
    tablero[5][4] = suecos;
    tablero[6][4] = suecos;

    tablero[4][2] = suecos;
    tablero[4][3] = suecos;
    tablero[4][5] = suecos;
    tablero[4][6] = suecos;

    // 2. Espacios moscovitas
    tablero[0][3] = moscovitas;
    tablero[0][4] = moscovitas;
    tablero[0][5] = moscovitas;

    tablero[8][3] = moscovitas;
    tablero[8][4] = moscovitas;
    tablero[8][5] = moscovitas;

    tablero[3][0] = moscovitas;
    tablero[4][0] = moscovitas;
    tablero[5][0] = moscovitas;

    tablero[3][8] = moscovitas;
    tablero[4][8] = moscovitas;
    tablero[5][8] = moscovitas;

    tablero[1][4] = moscovitas;
    tablero[4][1] = moscovitas;
    tablero[4][7] = moscovitas;
    tablero[7][4] = moscovitas;

    return tablero;
  }

  // Funcion para imprimir los tableros
  public static void mostrarTablero(String[][] tablero) {
    System.out.println();
    // For para msotrar tablero
    for (int row = 0; row < tablero.length; row += 1) {
      System.out.println();
      for (int col = 0; col < tablero[row].length; col += 1) {
        System.out.print("[" + tablero[row][col] + "]");
        System.out.print(" ");

      }
    }

    System.out.println();
    System.out.println();
  }

  // Funcion para mostrar las instrucciones del juego
  public static void instruccionesAjedrez() {
    System.out.println();

    // Explicaciones Principales
    System.out.println("---------------------------");
    System.out.println("DESCRIPCION");
    System.out.println("Un jugador controlara los movimientos de los suecos mientras que el otro controlara a los moscovitas");
    System.out.println("- El objetivo de los suecos es mover a su rey hasta un borde de la partida");
    System.out.println("- El objetivo de los moscovitas es capturar al rey sueco");
    System.out.println("---------------------------");

    // Reglas del juego
    System.out.println("REGLAS GENERALES");
    System.out.println("Cada jugador puede mover unicamente una pieza por movimiento");
    System.out.println("En su turno, el jugador debera indicar la coordenada del tablero a la que mover su pieza");
    System.out.println("Todas las piezas se mueven igual, cualquier cantidad de casillas horizontal o verticalmente");
    System.out.println("Si una pieza pasa por sobre otra pieza, se la restara al contrario");
    System.out.println("---------------------------");

    // Restricciones
    System.out.println("RESTRICCIONES");
    System.out.println("No pueden haber mas de una pieza en la misma casilla");
    System.out.println("Despues de que el rey abandone su trono, ninguna pieza puede colocarse en el trono, nisiquiera el mismo rey");
    System.out.println("---------------------------");

    // Declarar ganadores
    System.out.println("GANADOR");
    System.out.println("Si el rey se mueve a una de las esquinas ganan los suecos!");
    System.out.println("Si los moscovitas capturan al rey, rodeandolo, ganan los moscovitas!");
    System.out.println("---------------------------");

    System.out.println();
  }

  // Funcion para iniciar el juego 
  public static void iniciarJuego(String[][] tablero) {
    System.out.println();
    // Numero random para determinar quien inicia
    int randomInicio = new Random().nextInt(10);
    int jugadorInicial = 0;

    System.out.println("A continuacion veremos quien jugara primero, moscovitas o suecos!");

    if (randomInicio % 2 == 0) {
      System.out.println("El jugador 1 que controla a los moscovitas jugara primero!");
      jugadorInicial = 1;
    } else {
      System.out.println("El jugador 2 que controla a los suecos jugara primero!");
      jugadorInicial = 2;
    }

    jugarImprimirTablero(jugadorInicial, tablero);
  }

  // Funcion para correr los juegos e ir imprimiendo los valores
  public static void jugarImprimirTablero(int jugadorInicial, String[][] tablero) {
    // Coordenadas solicitadas a los jugadores
    int[] coordenadaJugador1;
    int[] coordenadaJugador2;

    // Variables    
    String player1;
    String player2;
    boolean check = true;
    boolean checkPieza = true;

    // Mostrar tablero para empezar
    System.out.println("Este es el tablero inicialmente!");
    mostrarTablero(tablero);

    System.out.println("Jugador, indique la coordenada de la pieza que desea mover");
    do {
      coordenadaJugador1 = solicitarValidar(tablero);

      checkPieza = checkForPieza(coordenadaJugador1, tablero, jugadorInicial);

    } while (checkPieza);

    System.out.println("Ahora indique la coordenada a la que movera su pieza: ");

    System.out.println();
  }

  // Funcion para validar que las coordenadas esten dentro de los numeros validos del tablero
  public static int[] solicitarValidar(String[][] tablero) {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    int[] coordenadaFinal = new int[2];
    int rowMove, colMove;

    do {
      System.out.println("Por favor, ingrese la fila de su pieza: ");
      rowMove = entry.nextInt();

      System.out.println("Por favor, ingrese la columna de su pieza: ");
      colMove = entry.nextInt();
      if (rowMove <= 8 && colMove <= 8) {
        break;
      } else {
        System.out.println("Coordenada incorrecta");
        System.out.println("Ingrese coordenadas entre 0 y 8");
      }
    } while (true);

    coordenadaFinal[0] = rowMove;
    coordenadaFinal[1] = colMove;

    System.out.println();

    return coordenadaFinal;
  }

  // Validar si existe una pieza en esa posicion
  public static boolean checkForPieza(int[] coordenada, String[][] tablero, int jugadorInicial) {
    int rowMove = coordenada[0];
    int colMove = coordenada[1];

    boolean check = true;

    if (tablero[rowMove][colMove].equals(" ")) {
      System.out.println("En este lugar no se encuentra una pieza, por favor ingrese las coordenadas de nuevo");
    } else if (jugadorInicial == 1 && tablero[rowMove][colMove].equals("m")) {
      System.out.println("--Pieza Seleccionada--");
      check = false;
    } else if (jugadorInicial == 2 && tablero[rowMove][colMove].equals("s")) {
      System.out.println("--Pieza Seleccionada--");
      check = false;
    } else {
      System.out.println("En este lugar no se encuentra tu pieza, sino la del otro jugador, ingrese de nuevo las coordenadas.");
    }

  return check ;
}

/*
    Abajo de aqui estan todas las funciones para la funcionalidad
    del sistema de ventas de carros
 */
public static void ventaDeCarros(String nombre) {
    System.out.println();

    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    // Crear arrayList para guardar los carros
    ArrayList<Carro> arrayDeCarros = new ArrayList();

    System.out.println("Bienvenido al sistema de venta de carros!");

    // Iniciar menu repetitivo
    do {
      System.out.println();
      System.out.println("----Menu Hermanos Rodriguez----");
      System.out.println("Elija la opcion que desea realizar: ");
      System.out.println("1 - Ingresar un carro");
      System.out.println("2 - Modificar un carro");
      System.out.println("3 - Leer la lista de carros");
      System.out.println("4 - Eliminar un carro");
      System.out.println("5 - Salir");

      System.out.print("Ingrese la opcion: ");
      int option = entry.nextInt();

      // Bolean para preguntar si qiere agregar otra opcion
      boolean check = true;

      switch (option) {
        case 1 -> {
          System.out.println("Ingrese los elementos del carro");
          Carro carro = ingresarCarro();

          // Agregar carro al array
          arrayDeCarros.add(carro);

          // Call boolan method
          check = deseaContinuar();
        }

        case 2 -> {
          arrayDeCarros = modificarCarro(arrayDeCarros);

          // Call boolan method
          check = deseaContinuar();
        }

        case 3 -> {
          leerListaCarros(arrayDeCarros);

          // Call boolan method
          check = deseaContinuar();
        }

        case 4 -> {
          arrayDeCarros = eliminarCarro(arrayDeCarros);

          // Call boolan method
          check = deseaContinuar();
        }

        default ->
          System.out.println("Elija una opcion de las anteriores");
      }

      // Salir del programa 
      if (option == 5 || !check) {
        System.out.println("Gracias por usar el este sistema de ventas de carros " + nombre);
        break;
      }
    } while (true);

    System.out.println();
  }

  // Funcion para ingresar un carro
  public static Carro ingresarCarro() {
    System.out.println();

    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    // Guardar entradas
    System.out.print("Ingrese el VIN: ");
    String numeroVIN = entry.nextLine();

    System.out.print("Ingrese la marca: ");
    String marca = entry.nextLine();

    System.out.print("Ingrese el modelo: ");
    String model = entry.nextLine();

    System.out.print("Ingrese el color: ");
    String color = entry.nextLine();

    System.out.print("Ingrese el año: ");
    int year = entry.nextInt();

    // Crear clase de carro
    Carro carro = new Carro(numeroVIN, marca, model, color, year);

    System.out.println("---Se ha ingresado un carro exitosamente---");

    return carro;
  }

  // Funcion para modificar un carro
  public static ArrayList modificarCarro(ArrayList arrayCarros) {
    int carNumberSel = 0;
    Carro carroSeleccionado;
    Carro carroModificado = null;

    // Check si hay carros o no 
    if (arrayCarros.isEmpty()) {
      System.out.println("No hay carros para modificar");
    } else {
      System.out.println("Seleccione el numero del carro que desea modificar");
      leerListaCarros(arrayCarros);

      carNumberSel = validarCarroSeleccionado(arrayCarros);

      carroSeleccionado = (Carro) arrayCarros.get(carNumberSel);

      carroModificado = modificarCarroSelec(carroSeleccionado);
    }
    // Eliminar carro viejo
    arrayCarros.remove(carNumberSel);

    // Actualizar lista con el carro modificado
    arrayCarros.add(carroModificado);

    System.out.println();
    return arrayCarros;
  }

  // Funcion para validar el carro ingresado
  public static int validarCarroSeleccionado(ArrayList arrayCarros) {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    int carroNumber;
    boolean checkNumber = true;

    do {
      System.out.print("Ingrese el numero: ");
      carroNumber = entry.nextInt();

      if (carroNumber < arrayCarros.size() || carroNumber > arrayCarros.size()) {
        System.out.println("Ingrese un numero correcto de carros que esten en la lista");
      } else {
        checkNumber = false;
      }

    } while (checkNumber);

    carroNumber -= 1;

    return carroNumber;
  }

  // Funcion para modificar el carro seleccionado
  public static Carro modificarCarroSelec(Carro carro) {
    System.out.println();

    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    System.out.print("Ingrese la marca: ");
    String marca = entry.nextLine();

    System.out.print("Ingrese el modelo: ");
    String model = entry.nextLine();

    System.out.print("Ingrese el color: ");
    String color = entry.nextLine();

    System.out.print("Ingrese el año: ");
    int year = entry.nextInt();

    // Modificar carro con nuevos valores
    carro.setMarca(marca);
    carro.setModel(model);
    carro.setColor(color);
    carro.setYear(year);

    System.out.println("---Se ha modificado el carro exitosamente---");

    return carro;
  }

  // Funcion para leer la lista de carros
  public static void leerListaCarros(ArrayList arrayCarros) {
    System.out.println();

    if (arrayCarros.isEmpty()) {
      System.out.println("--La lista de carros esta vacia--");
    } else {
      System.out.println("--Estss son los carros que usted ingreso con su informacion--");
      System.out.println();

      for (int i = 0; i < arrayCarros.size(); i += 1) {
        Carro carro = (Carro) arrayCarros.get(i);
        int numero = i + 1;
        System.out.println(numero + ". Vin: " + carro.getNumeroVIN() + ", marca: " + carro.getMarca() + ", modelo: " + carro.getModel() + ", color: " + carro.getColor() + ", año: " + carro.getYear());

      }
    }

    System.out.println();
  }

  // Funcion para eliminar un carro
  public static ArrayList eliminarCarro(ArrayList arrayCarros) {
    int carroSelecNum;

    // Check si hay carros o no 
    if (arrayCarros.isEmpty()) {
      System.out.println("No hay carros para modificar");
    } else {
      System.out.println("Seleccione el numero del carro que desea eliminar");
      leerListaCarros(arrayCarros);

      carroSelecNum = validarCarroSeleccionado(arrayCarros);

      arrayCarros.remove(carroSelecNum);

      System.out.println("---Se ha eliminado el carro exitosamente---");
    }
    return arrayCarros;
  }

  // Funcion para confirmar si quiere agregar mas opciones de carro
  public static boolean deseaContinuar() {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    boolean check = true;

    System.out.print("Desea ingresar otra opcion [S/N]: ");
    String letra = entry.nextLine();

    if (letra.contains("n") || letra.contains("N")) {
      check = false;
    }

    return check;
  }
}
