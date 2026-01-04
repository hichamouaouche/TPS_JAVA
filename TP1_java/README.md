# TP1 Java — Exercices

## 📚 Présentation
Ce dépôt contient 4 petits programmes Java (ex1..ex4) implémentant chacun un exercice pédagogique. Chaque sous-dossier (`ex1`, `ex2`, `ex3`, `ex4`) contient le code source Java compilable et exécutable depuis la racine du projet.

---

## 🔧 Exercice 1 : Gestion des notes des étudiants
**Problème :**
On veut créer un programme Java qui :
- lit des notes saisies au clavier,
- les stocke dans un tableau `grades`,
- permet d’effectuer les opérations suivantes :
  1. Trier et afficher les notes (utiliser `Arrays.sort()`),
  2. Calculer et afficher la moyenne,
  3. Afficher la note maximale et minimale,
  4. Compter le nombre d’étudiants ayant une note donnée.

**Fichier :** `ex1/Ex1.java`

**Compilation & exécution :**
```bash
javac ex1/Ex1.java
java -cp ex1 Ex1
```

**Exemple d'exécution :**
```
Entrez le nombre d'etudiants : 3
Note de l'etudiant 1 : 12
Note de l'etudiant 2 : 16
Note de l'etudiant 3 : 14
Notes triees : [12.0, 14.0, 16.0]
Moyenne : 14.0
Note minimale : 12.0
Note maximale : 16.0
Entrez une note a rechercher : 14
Nombre d'etudiants ayant la note 14.0 : 1
```

**Remarques :**
- Le tri est réalisé avec `Arrays.sort(grades)` (complexité O(n log n)).
- Le programme suppose des entrées numériques valides (entiers ou décimales) et un nombre d'étudiants > 0.

---

## 🔤 Exercice 2 : Conjugaison d’un verbe du premier groupe
**Problème :**
On veut créer un programme Java qui :
- lit un verbe du premier groupe (se terminant par `er`),
- vérifie qu’il se termine bien par `er`,
- affiche sa conjugaison au présent pour `je/tu/il/elle/nous/vous/ils/elles`.

**Fichier :** `ex2/Ex2.java` (classe `Exercice2`)

**Compilation & exécution :**
```bash
javac ex2/Ex2.java
java -cp ex2 Exercice2
```

**Exemple d'exécution :**
```
Entrez un verbe du premier groupe : parler
je parle
tu parles
il/elle parle
nous parlons
vous parlez
ils/elles parlent
```

**Remarques :**
- Si l'entrée ne se termine pas par `er`, le programme affiche un message d'erreur et termine.
- Le radical est obtenu par `verbe.substring(0, verbe.length() - 2)`.

---

## 🔁 Exercice 3 : Manipulation d’une chaîne de caractères
**Problème :**
Créer un programme avec un menu qui permet :
1. Saisir une chaîne
2. L’afficher
3. L’inverser
4. Compter le nombre de mots (séparés par un ou plusieurs espaces)

Après chaque opération, le programme revient au menu jusqu'à ce que l'utilisateur choisisse `0` pour quitter.

**Fichier :** `ex3/Ex3.java`

**Compilation & exécution :**
```bash
javac ex3/Ex3.java
java -cp ex3 Ex3
```

**Exemple d'utilisation :**
```
--- MENU ---
1. Saisir une chaine
2. Afficher la chaine
3. Inverser la chaine
4. Nombre de mots
0. Quitter
Votre choix : 1
Entrez une chaine : Bonjour   le   monde
(Retour au menu)
Votre choix : 2
Chaine : Bonjour   le   monde
Votre choix : 3
Chaine inversee : ednom   el   ruojnoB
Votre choix : 4
Nombre de mots : 3
Votre choix : 0
(Programme termine)
```

**Remarques :**
- Le comptage des mots utilise `ch.trim().split("\\s+")` pour gérer plusieurs espaces.
- L'inversion utilise `new StringBuilder(ch).reverse().toString()`.

---

## 🔎 Exercice 4 : Comptage des occurrences des lettres
**Problème :**
Écrire un programme qui :
- lit une chaîne,
- compte les occurrences des lettres A à Z sans distinction majuscule/minuscule,
- stocke les résultats dans un tableau de taille 26,
- affiche seulement les lettres présentes au moins une fois.

**Fichier :** `ex4/Ex4.java`

**Compilation & exécution :**
```bash
javac ex4/Ex4.java
java -cp ex4 Ex4
```

**Exemple d'exécution :**
```
Entrez une ligne de texte : Hello World
Occurrences des lettres :
3 occurrence(s) de la lettre 'L'
1 occurrence(s) de la lettre 'H'
1 occurrence(s) de la lettre 'E'
1 occurrence(s) de la lettre 'O'
1 occurrence(s) de la lettre 'W'
1 occurrence(s) de la lettre 'R'
1 occurrence(s) de la lettre 'D'
```

**Remarques :**
- La chaîne est convertie en majuscules (`toUpperCase()`), puis seules les lettres 'A'..'Z' sont comptées via `nb_occurrences[c - 'A']++`.

---

## ✅ Commandes utiles (depuis la racine du projet `TP1_java`)
- Compiler tous les fichiers :
```bash
javac ex1/Ex1.java ex2/Ex2.java ex3/Ex3.java ex4/Ex4.java
```
- Exécuter un exercice (exemple) :
```bash
java -cp ex1 Ex1
java -cp ex2 Exercice2
java -cp ex3 Ex3
java -cp ex4 Ex4
```

---

## 💡 Suggestions & amélioration
- Ajouter des vérifications d'entrée (gestion des exceptions `InputMismatchException`).
- Ajouter des tests unitaires (JUnit) et des jeux de tests pour valider les comportements.
- Documenter les cas limites (notes négatives, verbe vide, chaine vide, caractères non alphabétiques).

---

Si vous souhaitez, je peux :
- ajouter des tests et un script de test, ✅
- formater le README en anglais en plus du français, ✅
- committer et pousser ces fichiers dans Git pour vous. ✅

Souhaitez-vous que je fasse le commit maintenant ?

