# TP_2 - README détaillé ✅

> Ce README décrit chaque script Java du projet, explique comment compiler/exécuter, précise les entrées attendues et fournit des emplacements pour les captures d'écran d'exécution ajoutées dans chaque dossier.

---

## Structure du projet 🔧
- **Generic/**
  - **partie_1/**
    - `GenericStorage.java` — Classe générique de stockage (List)
    - `Application.java` — Démo d'utilisation de `GenericStorage` (Integer, String)
    - `1.png` — Capture d'écran d'exécution (chemin : `./Generic/partie_1/1.png`)
  - **partie_2/**
    - `IMetier.java` — Interface générique (add, getAll, findById, delete)
    - `Product.java` — POJO produit (id, name, brand, price, ...)
    - `MetierProduitImpl.java` — Implémentation de `IMetier` pour `Product`
    - `ApplicationProduit.java` — Application interactive de gestion de produits
    - `2.png` — Capture d'écran d'exécution (chemin : `./Generic/partie_2/2.png`)

- **Liste/**
  - `Product.java` — POJO simple (id, name, price)
  - `ProductManagementApp.java` — Exemple d'utilisation d'`ArrayList` (add, remove, modify, search)
  - `liste_sc.png` — Capture d'écran d'exécution (chemin : `./Liste/liste_sc.png`) 

- **Mps/**
  - `GestionNotes.java` — Utilisation de `Map` pour gérer des notes (insert, update, delete, stats)
  - `mps-sc.png` — Capture d'écran d'exécution (chemin : `./Mps/mps-sc.png`) 

- **Set/**
  - `StudentGroups.java` — Démonstration de `Set` (union, intersection)
  - `set_sc.png` — Capture d'écran d'exécution (chemin : `./Set/set_sc.png`) 

---

## Instructions générales de compilation et d'exécution 💡
> Astuce : chaque dossier utilise le package par défaut (pas de déclaration `package`), donc il est plus sûr de compiler et d'exécuter depuis **le répertoire contenant** les fichiers afin d'éviter des conflits de classes (notamment `Product` défini deux fois).

Exemples de commandes (PowerShell / Terminal) :

- Pour compiler et exécuter un dossier :
  - cd dans le dossier contenant les fichiers
  - javac *.java
  - java NomDeLaClasseAvecMain

Exemple :

```
cd Generic/partie_1
javac *.java
java Application
```

---

## Détails par script (description, usage, sortie attendue, capture d'écran) 📋

### 1) Generic/partie_1 — GenericStorage & Application 🔁
- **Fichiers**: `GenericStorage.java`, `Application.java`
- **But**: Montrer une implémentation générique de stockage (`GenericStorage<T>`) et tests avec `Integer` et `String`.
- **Utilisation**:
  - Compilation : `javac *.java`
  - Exécution : `java Application`
- **Entrées**: Aucune (exécution non-interactive)
- **Sortie attendue (extrait)**:
  - "--- Test Integer ---"
  - "Taille: 3"
  - "Element index 1: 20"
  - "--- Test String ---"
  - "Element index 2: Python"

- **Capture d'écran** :

![Résultat Generic/partie_1](./Generic/partie_1/1.png)

> 💡 Remarque: `GenericStorage` inclut des méthodes: addElement, removeElement, getElement, getSize.

---

### 2) Generic/partie_2 — Gestion de produits interactive 🛒
- **Fichiers**: `IMetier.java`, `Product.java`, `MetierProduitImpl.java`, `ApplicationProduit.java`
- **But**: Implémenter un mini CRUD en mémoire pour des produits, démontrer ajout, recherche, suppression, affichage formaté.
- **Utilisation**:
  - cd `Generic/partie_2`
  - `javac *.java`
  - `java ApplicationProduit`
- **Entrées**: Application interactive (menu) — choix numérique puis saisies (IDs, nom, marque, prix, description, stock)
- **Actions de démonstration**:
  - Choix 1 — afficher la liste des produits (pré-chargés: 30 produits)
  - Choix 2 — rechercher un produit par ID (ex: entrer `1` doit retourner MacBook Pro M2)
  - Choix 3 — ajouter un produit (saisir ID, nom, marque, prix, description, stock)
  - Choix 4 — supprimer par ID
- **Sortie attendue (extrait)**:
  - "Chargement des données de test..."
  - "30 produits ajoutés avec succès !"
  - Menu interactif et affichage tabulaire (ID, NOM, MARQUE, PRIX, STOCK)

- **Capture d'écran** :

![Résultat Generic/partie_2](./Generic/partie_2/2.png)

> ⚠️ Note : Pour des tests automatisés, lancer l'app et choisir "1" pour afficher la table, ou "2" puis un ID existant (1..30) pour vérifier la recherche.

> ⚠️ Note : Pour des tests automatisés, lancer l'app et choisir "1" pour afficher la table, ou "2" puis un ID existant (1..30) pour vérifier la recherche.

---

### 3) Liste — ProductManagementApp (ArrayList) 🗂️
- **Fichiers**: `Product.java`, `ProductManagementApp.java`
- **But**: Expliquer les opérations basiques sur `ArrayList`: insertion, suppression par index, modification par index et recherche par nom (saisie utilisateur).
- **Utilisation**:
  - cd `Liste`
  - `javac *.java`
  - `java ProductManagementApp`
- **Entrées**: L'utilisateur doit saisir le nom à rechercher (ex: `Laptop Dell`)
- **Sortie attendue (extrait)**:
  - Affichage de la liste initiale
  - Après suppression d'un élément, nouvelle liste
  - Après modification du prix, nouvelle liste
  - Résultat de la recherche ("Produit trouvé : ..." ou "Aucun produit trouvé ...")

- **Capture d'écran** :

![Résultat Liste](./Liste/liste_sc.png)

---

### 4) Mps — GestionNotes (Map et statistiques) 📊
- **Fichier**: `GestionNotes.java`
- **But**: Montrer manipulation d'une `HashMap<String, Double>` pour stocker des notes d'étudiants puis calculer moyenne/min/max.
- **Utilisation**:
  - cd `Mps`
  - `javac GestionNotes.java`
  - `java GestionNotes`
- **Entrées**: Aucune (opérations pré-codées)
- **Sortie attendue (extrait)**:
  - Insertion des notes, mises à jour (Ahmed, Karim), suppression (Sarah), affichage de la moyenne, max, min

- **Capture d'écran** :

![Résultat Mps](./Mps/mps-sc.png) 

---

### 5) Set — StudentGroups (HashSet) 🔗
- **Fichier**: `StudentGroups.java`
- **But**: Démontrer l'utilisation d'un `HashSet` pour union/intersection entre 2 groupes.
- **Utilisation**:
  - cd `Set`
  - `javac StudentGroups.java`
  - `java StudentGroups`
- **Entrées**: Aucune (données codées en dur)
- **Sortie attendue (extrait)**:
  - Affichage des deux groupes
  - Intersection (étudiants présents dans les deux groupes)
  - Union (tous les étudiants sans doublons)

- **Capture d'écran** :

![Résultat Set](./Set/set_sc.png)

---

## Remarques générales et suggestions d'amélioration 🛠️
- Il y a deux classes `Product` dans le projet (`Generic/partie_2/Product.java` et `Liste/Product.java`). Si vous compilez tout depuis la racine, il peut y avoir des conflits de noms de classes. Solutions :
  - Compiler/exécuter par dossier (recommandé pour ce TP) ;
  - Ajouter des `package` différents pour chaque module et adapter les imports ;
  - Renommer une des classes si vous souhaitez compiler tout ensemble.

- Pour automatiser les tests de l'app interactive `ApplicationProduit`, vous pouvez rediriger un fichier d'entrée (`java ApplicationProduit < inputs.txt`) contenant les choix séquentiels pour simuler un utilisateur.

- Si vous voulez, je peux :
  1) Générer automatiquement des captures d'écran d'exécution (si vous me fournissez la sortie ou autorisez un runner local),
  2) Ajouter des badges ou une section "Tests" avec exemples d'inputs/outputs,
  3) Réorganiser (ajouter des packages) pour permettre compilation globale sans conflits.

---

Si vous voulez que j'insère directement les images dans le README (avec balises Markdown) à partir des fichiers présents (`./Generic/partie_1/1.png`, etc.), dites-le et je les ajoute. ✅

Bon travail — dites-moi si vous voulez que j'ajoute les images intégrées dans ce README ou que je crée une version en anglais. 🎯
