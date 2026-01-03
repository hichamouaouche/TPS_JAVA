TP1 Java — Exercices

Description
- Ce dépôt contient 4 petits exercices Java (ex1..ex4). Chaque dossier contient un seul fichier source compilable en Java.

Contenu des exercices

1) ex1/Ex1.java
- Description: Lecture du nombre d'étudiants et de leurs notes, tri des notes, calcul de la moyenne, affichage du min/max et comptage d'une note donnée.
- Compilation & exécution:
```bash
javac ex1/Ex1.java
java -cp ex1 Ex1
```
- Exemple d'exécution (utilisateur -> entrée):
  - Entrez le nombre d'etudiants : 3
  - Note de l'etudiant 1 : 12
  - Note de l'etudiant 2 : 16
  - Note de l'etudiant 3 : 14
  - Entrez une note a rechercher : 14
  - Résultat: notes triées, moyenne, min/max, nombre d'occurrences de 14

2) ex2/Ex2.java
- Description: Conjugue un verbe du premier groupe au présent (forme basique) en affichant les terminaisons pour je/tu/il/nous/vous/ils.
- Compilation & exécution:
```bash
javac ex2/Ex2.java
java -cp ex2 Exercice2
```
- Exemple d'exécution:
  - Entrez un verbe du premier groupe : parler
  - Sortie:
    je parle
    tu parles
    il/elle parle
    nous parlons
    vous parlez
    ils/elles parlent

3) ex3/Ex3.java
- Description: Menu interactif pour manipuler une chaîne (saisir, afficher, inverser, compter les mots). Boucle jusqu'à choix 0.
- Compilation & exécution:
```bash
javac ex3/Ex3.java
java -cp ex3 Ex3
```
- Exemple d'exécution (résumé):
  - Choisir 1 puis saisir "Bonjour le monde"
  - Choisir 3 -> affiche "ednom el ruojnoB"
  - Choisir 4 -> affiche "Nombre de mots : 3"

4) ex4/Ex4.java
- Description: Compte les occurrences de chaque lettre A-Z (insensible à la casse) dans une ligne de texte saisie.
- Compilation & exécution:
```bash
javac ex4/Ex4.java
java -cp ex4 Ex4
```
- Exemple d'exécution:
  - Entrez une ligne de texte : Hello World
  - Sortie (exemple): 3 occurrence(s) de la lettre 'L', 1 occurrence(s) de la lettre 'H', etc.

Notes générales
- Commandes ci-dessus à lancer depuis la racine du workspace (`TP1_java`).
- Sur Windows PowerShell, utilisez les mêmes commandes (slashes `/` fonctionnent dans `javac` et `java`), ou adaptez en `ex1\Ex1.java` si vous préférez.
- Si une classe a un nom différent du fichier (ex: `Exercice2` dans `Ex2.java`), exécutez avec le nom de la classe (`java -cp ex2 Exercice2`).

Souhaitez-vous que je commit et pousse ce `README.md`, ou que je l'adapte (français/anglais, formatage supplémentaire, exemples plus détaillés)?
