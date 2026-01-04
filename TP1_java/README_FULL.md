README_FULL — TP1 Java (Documentation complète)

1) Objectif

Fournir une documentation complète des 4 exercices Java présents dans le dépôt, incluant :
- description fonctionnelle,
- détails d'implémentation,
- exemples d'exécution (entrées/sorties),
- cas limites et suggestions de tests.

---

Exercice 1 — Gestion des notes des étudiants

Problème & exigences
- Lire un entier n (nombre d'étudiants).
- Lire n notes (double) et stocker dans un tableau `grades`.
- Opérations à implémenter :
  - trier et afficher (utiliser `Arrays.sort()`),
  - calculer la moyenne,
  - afficher la note minimale et maximale,
  - compter le nombre d'étudiants ayant une note donnée.

Implémentation (points clés)
- Lecture avec `Scanner` : attention aux types (int puis double).
- Tri : `Arrays.sort(grades)` modifie le tableau en place.
- Moyenne : somme / n (vérifier division par zéro si n==0).
- Comparaison des doubles pour compter une note donnée : utiliser `==` est acceptable ici mais pour tolérance il est possible d'utiliser `Math.abs(a - b) < epsilon`.

Exemples de tests
- Entrée normale : n=3, notes 12,16,14 → moyenne 14.0, min 12, max 16.
- Cas limites : n=0 (définir comportement), notes négatives (autoriser ou invalider).

---

Exercice 2 — Conjugaison (verbe en -er)

Problème & exigences
- Lire un verbe.
- Vérifier qu'il se termine par `er`.
- Si oui, afficher les formes : je/tu/il/nous/vous/ils.

Implémentation (points clés)
- Test `if (!verbe.endsWith("er"))` et message d'erreur.
- Radical = `verbe.substring(0, verbe.length() - 2)`.
- Concaténer les terminaisons simples (`e`, `es`, `e`, `ons`, `ez`, `ent`).

Cas limites et extensions possibles
- Gestion des verbes irréguliers (non demandée),
- Vérifier que la chaîne a au moins 3 caractères pour être un verbe valide.

---

Exercice 3 — Manipulation de chaîne

Fonctionnalités
- Menu en boucle (1..4 et 0 pour quitter).
- Saisie, affichage, inversion et comptage des mots (délimiteurs : espace(s)).

Implémentation
- Utiliser `ch.trim().split("\\s+")` pour compter les mots en traitant plusieurs espaces.
- Inversion : `new StringBuilder(ch).reverse().toString()`.

Tests manuels
- Chaîne vide: (afficher vide, inverse vide, mots 0),
- Chaîne avec multiples espaces: " a  b   c " → mots 3.

---

Exercice 4 — Comptage lettres A-Z

Fonctionnalités
- Lire une ligne, convertir en majuscules, compter occurrences A..Z.
- Afficher seulement lettres présentes.

Implémentation
- Tableau `int[26]`.
- Boucler sur chaque char, si 'A' <= c <= 'Z' alors incrementer `count[c - 'A']`.

Exemples
- "Hello World" → L:3, H:1, E:1, O:2, W:1, R:1, D:1 (ordre arbitraire ou A..Z).

---

Scripts et automatisation
- Pour compiler tous : `javac ex1/Ex1.java ex2/Ex2.java ex3/Ex3.java ex4/Ex4.java`.
- Exemple de script PowerShell :
```powershell
javac ex1/Ex1.java ex2/Ex2.java ex3/Ex3.java ex4/Ex4.java
java -cp ex1 Ex1
```

---

Conseils de tests unitaires
- Ecrire des tests pour :
  - tri et moyenne (ex1),
  - validation d'entrée (ex2),
  - comportement menu (ex3),
  - comptage correct même avec caractères non alphabétiques (ex4).

---

Suivi
- Souhaitez-vous que j'ajoute un script `run_examples.sh` / `run_examples.ps1` ou que je crée des tests JUnit et un pipeline CI simple ?
