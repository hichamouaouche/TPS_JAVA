# TP1 Java — Documentation détaillée

## Présentation
Ce projet contient 4 exercices Java pédagogiques (dossiers `ex1`..`ex4`). Chaque exercice se concentre sur la manipulation des entrées utilisateur, tableaux, chaînes et structures de contrôle.

---

## Exercice 1 — Gestion des notes des étudiants
**Problème :**
Écrire un programme Java qui :
- lit au clavier le nombre d'étudiants,
- lit les notes (double) de chaque étudiant et les stocke dans un tableau `grades`,
- offre les opérations suivantes :
  1. Trier et afficher les notes (utiliser `Arrays.sort()`),
  2. Calculer et afficher la moyenne,
  3. Afficher la note maximale et minimale,
  4. Compter le nombre d'étudiants ayant une note donnée.

**Fichier :** `ex1/Ex1.java`

**Comment ça marche :**
- Lecture via `Scanner` : l'utilisateur indique `n`, puis saisit `n` notes.
- Une fois toutes les notes lues, `Arrays.sort(grades)` trie le tableau.
- La moyenne est calculée par la somme des éléments divisée par `n`.
- Le min est `grades[0]`, le max `grades[n-1]` une fois trié.
- Pour compter les occurrences, on compare chaque note avec la valeur recherchée.

**Exemple :**
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

**Points d'amélioration :**
- Vérifier `n > 0` et gérer les entrées invalides (`InputMismatchException`).
- Pour la comparaison de réels, utiliser une tolérance `epsilon` si nécessaire.

---

## Exercice 2 — Conjugaison d’un verbe du premier groupe
**Problème :**
Écrire un programme Java qui :
- lit un verbe (doit se terminer par `er`),
- vérifie la terminaison `er`,
- affiche la conjugaison au présent pour `je, tu, il/elle, nous, vous, ils/elles`.

**Fichier :** `ex2/Ex2.java` (classe `Exercice2`)

**Comment :**
- On teste la terminaison avec `verbe.endsWith("er")`.
- Le radical est `verbe.substring(0, verbe.length() - 2)`.
- On concatène le radical avec les terminaisons `e, es, e, ons, ez, ent`.

**Exemple :**
```
Entrez un verbe du premier groupe : parler
je parle
tu parles
il/elle parle
nous parlons
vous parlez
ils/elles parlent
```

**Points d'amélioration :**
- Vérifier la longueur minimale du verbe (>=3 caractères).
- Gérer les exceptions ou proposer une boucle de saisie jusqu'à obtenir un verbe valide.

---

## Exercice 3 — Manipulation d’une chaîne de caractères
**Problème :**
Implémenter un menu permettant :
1. Saisir une chaîne,
2. L'afficher,
3. L'inverser,
4. Compter le nombre de mots (mots séparés par un ou plusieurs espaces).

**Fichier :** `ex3/Ex3.java`

**Comment :**
- Menu en boucle (do/while) jusqu'à `0` pour quitter.
- Le comptage des mots utilise `ch.trim().split("\\s+")` pour ignorer espaces multiples.
- L'inversion s'obtient via `new StringBuilder(ch).reverse().toString()`.

**Exemple d'utilisation :**
```
Votre choix : 1
Entrez une chaine : Bonjour   le   monde
Votre choix : 3
Chaine inversee : ednom   el   ruojnoB
Votre choix : 4
Nombre de mots : 3
```

**Points d'amélioration :**
- Gérer la chaîne vide et afficher des messages clairs.
- Séparer la logique menu et la logique traitement dans des méthodes pour faciliter les tests.

---

## Exercice 4 — Comptage des occurrences des lettres
**Problème :**
Écrire un programme qui :
- lit une ligne de texte,
- compte les occurrences des lettres A..Z sans tenir compte de la casse,
- stocke les comptes dans un tableau `int[26]`,
- n'affiche que les lettres présentes au moins une fois.

**Fichier :** `ex4/Ex4.java`

**Comment :**
- Convertir la chaîne en majuscules (`toUpperCase()`), puis pour chaque caractère `c` vérifier `if (c >= 'A' && c <= 'Z')` et incrémenter `counts[c - 'A']`.

**Exemple :**
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

**Points d'amélioration :**
- Gérer les caractères accentués si nécessaire (normalisation Unicode).
- Afficher un tableau complet A..Z si souhaité, même pour les zéros.

---

## Comment compiler et exécuter
Depuis la racine du projet `TP1_java` :

```bash
# Compiler les 4 exercices
javac ex1/Ex1.java ex2/Ex2.java ex3/Ex3.java ex4/Ex4.java

# Exécuter
java -cp ex1 Ex1
java -cp ex2 Exercice2
java -cp ex3 Ex3
java -cp ex4 Ex4
```

---

## Tests et améliorations recommandées
- Ajouter validation et gestion d'erreurs (`try/catch` pour `InputMismatchException`).
- Extraire la logique métier dans des méthodes pour pouvoir écrire des tests unitaires (JUnit).
- Ajouter un script `run_examples.ps1` (Windows) pour automatiser les démonstrations.

---

## Conclusion
Ce TP couvre des concepts essentiels de Java : saisie utilisateur (`Scanner`), tableaux et tri (`Arrays.sort()`), manipulation de chaînes (`String`, `StringBuilder`), et structures de contrôle (boucles et switch). Les exercices sont conçus pour renforcer la lecture/écriture d'entrées, la transformation de données et la gestion de cas simples. Pour aller plus loin, je recommande d'ajouter des validations, des tests unitaires et une meilleure séparation des responsabilités (méthodes/classes), ce qui facilitera l'évolution du code et la maintenance.

---

Si vous le souhaitez, je peux aussi :
- ajouter des tests JUnit, ✅
- créer un script d'exécution automatisé (PowerShell), ✅
- committer et pousser les modifications dans votre dépôt Git. ✅