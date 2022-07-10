# Repte 2 - Welcome to Lambdas

El repositori conté la classe MyLambda, que conté tot el necessari per implementar els objectius llistats a [la web de Nuwe](https://nuwe.io/challenge/repte-2-welcome-to-lambdas).

## Ús

```Java

//Instanciem un objecte de la classe MyLambda
MyLambda myLambda = new MyLambda();

//Creem un array de nombres enters
int[] nums = {4, 5, 898, 34};

//Mostrem el resultat
System.out.println(myLambda.checker(nums));

```

## Solució

Per implementar els mètodes isPrime i isPalindrome es fa ús de la API Steam de Java. S'ha creat un Java Record anomenat `Numero` per desar els retorns dels diferents mètodes i poder mostrar-los tots junts. Al mètode principal `checker` retornem una llista d'objectes `Numero`. S'ha decidit comprovar per cada enter de l'input si el seu valor és 0, i en aquest cas, mostrar per pantalla el missatge `"NOT A POSSIBLE OPTION"` i excluir-lo dels càlculs posteriors, ja que es tracta d'un input no vàlid.
