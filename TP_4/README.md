# TP_4: Java Multithreading & Network Programming

Ce document contient une description détaillée de tous les exercices du TP_4, couvrant les concepts de multithreading, synchronisation des threads, programmation réseau (TCP/IP et UDP).

---

## Table des Matières
1. [Sc_1: Bank Simulation (Race Condition & Synchronization)](#sc_1-bank-simulation)
2. [Sc_2: Unsafe Bus Reservation (Race Condition)](#sc_2-unsafe-bus-reservation)
3. [Sc_3: Game Server & Client (TCP/IP)](#sc_3-game-server--client)
4. [Sc_4: UDP Communication](#sc_4-udp-communication)

---

## Sc_1: Bank Simulation

### 📋 Description Générale
Cet exercice démontre le problème de **race condition** dans un environnement multithreading et comment le résoudre avec la synchronisation.

### 🎯 Objectifs
- Comprendre les **race conditions** en Java
- Apprendre à utiliser `synchronized` pour protéger les sections critiques
- Voir comment la synchronisation empêche les incohérences de données

### 📂 Fichiers
- `Sc_1/BankSimulation.java`

### 📝 Code Détaillé

#### Classe `BankAccount`
```java
private int balance;  // Solde du compte - ressource partagée

// Méthode SYNCHRONISÉE pour protéger l'accès concurrent
public synchronized void withdraw(int amount, String clientName)
```
- **Problème sans `synchronized`**: Deux clients peuvent vérifier le solde simultanément, voir qu'il suffit, puis les deux retirer sans être conscients l'un de l'autre
- **Solution avec `synchronized`**: Seul un thread à la fois peut exécuter cette méthode

#### Classe `Client` (extends `Thread`)
- Chaque client est un thread indépendant
- Appelle `withdraw()` sur le compte partagé

#### Méthode `main()`
```
BankAccount initiale = 500
Client 1: retire 450
Client 2: retire 100
```

### 🔴 Scenario sans Synchronization (Race Condition)
```
TEMPS    CLIENT 1                          CLIENT 2
T0       Vérifier solde = 500 ✓            -
T1       -                                  Vérifier solde = 500 ✓
T2       Retirer 450, balance = 50         -
T3       -                                  Retirer 100, balance = 400 ❌ INCORRECT!
```
**Résultat attendu**: 500 - 450 - 100 = -50 (impossible) ou solde invalide
**Résultat obtenu**: Incohérence

### 🟢 Scenario avec Synchronization
```
TEMPS    CLIENT 1                          CLIENT 2
T0       [LOCK]                            -
T1       Vérifier solde = 500 ✓            [ATTENTE]
T2       Retirer 450, balance = 50         [ATTENTE]
T3       [UNLOCK]                          [LOCK]
T4       -                                  Vérifier solde = 50 ✗
T5       -                                  Rejet (pas assez de fonds)
T6       -                                  [UNLOCK]
```
**Résultat**: Solde cohérent = 50

### 🚀 Comment Exécuter

#### Compilation
```bash
cd Sc_1
javac BankSimulation.java
```

#### Exécution
```bash
java BankSimulation
```

### 📊 Sortie Attendue
```
Client 1 is attempting to withdraw 450
Client 1 sees sufficient funds. Proceeding...
Client 1 completed withdrawal. Remaining Balance: 50
Client 2 is attempting to withdraw 100
Client 2 denied. Insufficient funds. Balance: 50
```

### 🎓 Concepts Clés Appris
- **Race Condition**: Quand plusieurs threads accèdent à une ressource partagée sans synchronisation
- **Critical Section**: Code qui accède à des données partagées
- **Lock/Mutex**: Mécanisme pour assurer l'accès exclusif
- **`synchronized` Keyword**: Protège une méthode ou bloc de code

---

## Sc_2: Unsafe Bus Reservation

### 📋 Description Générale
Cet exercice montre comment une **race condition** peut causer une surréservation de places dans un système de réservation de bus.

### 🎯 Objectifs
- Identifier les problèmes de concurrence dans les systèmes critiques
- Comprendre l'importance de la synchronisation pour les opérations commerciales
- Voir les conséquences réelles d'une mauvaise synchronisation

### 📂 Fichiers
- `Sc_2/UnsafeBusReservation.java`

### 📝 Code Détaillé

#### Classe `Bus`
```java
private int availableSeats;  // Nombre de places disponibles

// SANS synchronization - cause la race condition
public void bookSeats(int seatsRequested, String passengerName)
```
- **Problème**: La méthode n'est pas `synchronized`
- **Thread.sleep(100)**: Simule un délai de traitement pour forcer la race condition

#### Classe `Passenger` (extends `Thread`)
- Représente un passager qui réserve des places
- Chaque passager est un thread

#### Scenario dans `main()`
```
Bus total = 3 places
Passager 1: veut 2 places
Passager 2: veut 2 places
Total demandé: 4 places (> capacité!)
```

### 🔴 Scenario du Bug (Race Condition)

```
TEMPS    PASSAGER 1                        PASSAGER 2
T0       Vérifier: 3 places >= 2 ✓        -
T1       (Thread.sleep)                    Vérifier: 3 places >= 2 ✓
T2       -                                  (Thread.sleep)
T3       Réserver 2, places = 1            -
T4       -                                  Réserver 2, places = -1 ❌ BUG!
```

### 📊 Sortie Attendue (Avec le Bug)
```
Passager 1 entered.
Available seats: 3
Passager 2 entered.
Available seats: 3
Passager 1 booked 2 seats.
Seats left after Passager 1: 1
Passager 2 booked 2 seats.
Seats left after Passager 2: -1
```

**Problème**: Le bus a maintenant **-1 places** - situation impossible!

### 🔧 Comment Corriger
Ajouter `synchronized` à la méthode:
```java
public synchronized void bookSeats(int seatsRequested, String passengerName) {
    // ... code ...
}
```

### 🚀 Comment Exécuter

#### Compilation
```bash
cd Sc_2
javac UnsafeBusReservation.java
```

#### Exécution
```bash
java UnsafeBusReservation
```

### 🎓 Concepts Clés Appris
- **Data Race**: Accès non-synchronisé à des données partagées
- **Overselling**: Vendre plus que la capacité disponible
- **Atomicity**: Importance que les opérations complètes ne soient pas interrompues
- **Critical Section Protection**: Nécessité de protéger les opérations atomiques

---

## Sc_3: Game Server & Client

### 📋 Description Générale
Cet exercice implémente un jeu du **nombre magique** avec architecture **client-serveur** utilisant TCP/IP (sockets).

### 🎯 Objectifs
- Apprendre la communication réseau TCP/IP en Java
- Implémenter un serveur qui accepte une seule connexion
- Implémenter un serveur multithreading pour plusieurs clients simultanés
- Créer un système de leaderboard thread-safe
- Comprendre la programmation client-serveur

### 📂 Fichiers
- `Sc_3/SimpleServer.java` - Serveur simple (un seul client)
- `Sc_3/MultiThreadedServer.java` - Serveur pour plusieurs clients + leaderboard
- `Sc_3/GameClient.java` - Client pour jouer au jeu

---

### 📝 SimpleServer - Serveur Simple

#### Description
Serveur TCP qui accepte **un seul client** et joue au jeu du nombre magique.

#### Fonctionnement
1. Génère un nombre aléatoire entre 0 et 100
2. Écoute sur le port **1234**
3. Accepte une connexion client
4. Boucle: reçoit les estimations et envoie des indices
5. Termine quand le client trouve le nombre

#### Code Clés
```java
ServerSocket serverSocket = new ServerSocket(port);
Socket socket = serverSocket.accept();  // Bloque jusqu'à une connexion
BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
```

#### Indices Envoyés
- `"TOO_LOW"` - Le nombre est plus grand
- `"TOO_HIGH"` - Le nombre est plus petit
- `"CORRECT"` - Le nombre est trouvé
- `"INVALID_INPUT"` - Entrée invalide

#### Limitation
❌ Peut servir qu'**un seul client à la fois**

---

### 📝 MultiThreadedServer - Serveur Multi-Clients

#### Description
Serveur TCP avancé qui accepte **plusieurs clients simultanément** et gère un **leaderboard**.

#### Améliorations
1. **Accepte les connexions en boucle infinie**
   ```java
   while (true) {
       Socket socket = serverSocket.accept();
       new PlayerHandler(socket).start();  // Crée un thread pour chaque client
   }
   ```

2. **Thread-Safe Leaderboard**
   ```java
   private static final List<String> leaderboard = new CopyOnWriteArrayList<>();
   ```
   - `CopyOnWriteArrayList`: Collection thread-safe pour éviter les race conditions

3. **Classe Interne `PlayerHandler`** (extends `Thread`)
   - Chaque instance gère un joueur
   - Communique avec son client via les I/O streams
   - Enregistre les scores dans le leaderboard

#### Fonctionnalités
- Demande le **nom du joueur**
- Compte les **tentatives**
- Trie le leaderboard par **tentatives croissantes** (meilleur score = moins de tentatives)
- Affiche les **Top 5** du leaderboard au joueur

#### Code Clés - Tri du Leaderboard
```java
leaderboard.sort((a, b) -> {
    int scoreA = Integer.parseInt(a.split(" ")[0]);
    int scoreB = Integer.parseInt(b.split(" ")[0]);
    return scoreA - scoreB;  // Croissant
});
```

#### ✅ Avantage
✅ Accepte **plusieurs clients simultanément**
✅ Chaque client a son propre **nombre magique**
✅ Leaderboard **partagé** et **thread-safe**

---

### 📝 GameClient - Client Joueur

#### Description
Client TCP qui se connecte au serveur et joue au jeu du nombre magique.

#### Fonctionnement
1. Se connecte au serveur sur `localhost:1234`
2. Envoie les estimations au serveur
3. Reçoit les indices du serveur
4. Boucle jusqu'à trouver le nombre (réponse = `"CORRECT"`)
5. Affiche le nombre de tentatives

#### Code Clés
```java
Socket socket = new Socket(hostname, port);
PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
Scanner console = new Scanner(System.in);

do {
    String guess = console.nextLine();
    output.println(guess);  // Envoyer
    String response = input.readLine();  // Recevoir
    System.out.println("Server says: " + response);
} while (!response.equals("CORRECT"));
```

#### Flux d'Entrée/Sortie
```
CLIENT                                SERVER
                 ← Connection Établie ←
Envoyer "50"     → Recevoir "50"
                 Vérifier 50 vs nombre
Recevoir "TOO_LOW" ← Envoyer "TOO_LOW"
```

---

### 🚀 Comment Exécuter Sc_3

#### Étape 1: Compiler tous les fichiers
```bash
cd Sc_3
javac *.java
```

#### Étape 2 (Option A): Utiliser SimpleServer
```
Terminal 1:
java SimpleServer

Terminal 2:
java GameClient
```

#### Étape 2 (Option B): Utiliser MultiThreadedServer
```
Terminal 1:
java MultiThreadedServer

Terminal 2:
java GameClient

Terminal 3:
java GameClient  # Deuxième joueur simultané
```

### 📊 Exemple de Session SimpleServer
```
[SERVER]
Server is listening on port 1234
Client connected!
Client won in 7 attempts.

[CLIENT]
Connected to the Magic Number Server!
Enter your guess (0-100): 50
Server says: TOO_LOW
Enter your guess (0-100): 75
Server says: TOO_HIGH
Enter your guess (0-100): 62
Server says: TOO_LOW
...
Enter your guess (0-100): 67
Server says: CORRECT
Congratulations! You found the number in 7 attempts.
```

### 📊 Exemple de Session MultiThreadedServer
```
[SERVER]
Multi-threaded Server Started...
New player connected: 127.0.0.1
New player connected: 127.0.0.1

[CLIENT 1]
Connected to the Magic Number Server!
WELCOME! Enter your name:
Alice
Enter your guess (0-100): 50
Server says: TOO_HIGH
...
Server says: CORRECT
--- LEADERBOARD ---
1. 5 attempts - Alice
2. 8 attempts - Bob
END_LB
Congratulations! You found the number in 5 attempts.

[CLIENT 2]
WELCOME! Enter your name:
Bob
Enter your guess (0-100): 45
...
```

### 🎓 Concepts Clés Appris
- **ServerSocket & Socket**: Communication TCP/IP
- **Stream I/O**: `BufferedReader` et `PrintWriter`
- **Threading**: Gestion de clients multiples
- **Thread-Safe Collections**: `CopyOnWriteArrayList`
- **Client-Server Architecture**: Séparation des responsabilités
- **Protocol Design**: Messages standardisés (TOO_LOW, TOO_HIGH, CORRECT)

---

## Sc_4: UDP Communication

### 📋 Description Générale
Cet exercice montre la communication **UDP (User Datagram Protocol)** en Java - un protocole sans connexion et non fiable, contrairement à TCP.

### 🎯 Objectifs
- Comprendre la différence entre UDP et TCP
- Implémenter un **récepteur UDP** (serveur)
- Implémenter un **émetteur UDP** (client)
- Apprendre à utiliser `DatagramSocket` et `DatagramPacket`
- Voir les avantages et inconvénients du UDP

### 📂 Fichiers
- `Sc_4/UDPReceiver.java` - Récepteur UDP (serveur)
- `Sc_4/UDPSender.java` - Émetteur UDP (client)

---

### 📝 UDPReceiver - Récepteur Serveur

#### Description
Programme qui **écoute** sur un port UDP et affiche tous les messages reçus.

#### Fonctionnement
```
1. Crée un DatagramSocket sur le port 1234
2. Boucle infinie: écoute les paquets UDP entrants
3. Affiche l'adresse IP et port de l'émetteur
4. Affiche le message reçu
5. Peut s'arrêter avec Ctrl+C ou message "exit"
```

#### Code Détaillé
```java
DatagramSocket socket = new DatagramSocket(1234);  // Port d'écoute
byte[] buffer = new byte[1024];  // Buffer pour recevoir les données
DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

socket.receive(packet);  // Bloque jusqu'à réception
String message = new String(packet.getData(), 0, packet.getLength());
String sender = packet.getAddress().getHostAddress();
int senderPort = packet.getPort();
```

#### Avantages UDP
- **Vitesse**: Pas de handshake (TCP en demande 3)
- **Léger**: Moins d'overhead réseau
- **Idéal pour**: Streaming audio/vidéo, jeux en temps réel

#### Inconvénients UDP
- **Non fiable**: Les paquets peuvent être perdus
- **Non ordonné**: Les paquets peuvent arriver dans le désordre
- **Pas de connexion**: Pas de garantie que le récepteur existe

### 🚀 Exécuter UDPReceiver
```bash
cd Sc_4
javac UDPReceiver.java
java UDPReceiver
```

### 📊 Sortie
```
Receiver is listening on port 1234...
Press Ctrl+C to stop the receiver manually.
Received from [127.0.0.1:52345]: Hello World
Received from [127.0.0.1:52346]: Test message
Received from [192.168.1.100:52347]: Message from another computer
```

---

### 📝 UDPSender - Émetteur Client

#### Description
Programme qui envoie des messages UDP à un récepteur spécifié.

#### Fonctionnement
```
1. Demande à l'utilisateur l'adresse IP cible
2. Crée un DatagramSocket (pas besoin d'accepter de connexions)
3. Boucle: Lit les messages de l'utilisateur et envoie via UDP
4. S'arrête si l'utilisateur tape "bye"
```

#### Code Détaillé
```java
DatagramSocket socket = new DatagramSocket();  // Port source aléatoire

System.out.print("Enter target IP address: ");
String ipInput = scanner.nextLine();
InetAddress address = InetAddress.getByName(ipInput);
int port = 1234;  // Port du récepteur

byte[] buffer = message.getBytes();
DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
socket.send(packet);
```

#### Différence avec TCP/Client
```
TCP (Sc_3)                          UDP (Sc_4)
├─ Socket.connect()                ├─ Pas de connexion
├─ Streams (input/output)           ├─ Paquets datagram
├─ Fiable et ordonné                ├─ Non fiable, pas d'ordre
├─ Plus lent (plus de contrôle)     ├─ Plus rapide
└─ Idéal: Téléchargement, email    └─ Idéal: Chat en temps réel, jeu
```

### 🚀 Comment Exécuter Sc_4

#### Étape 1: Compiler
```bash
cd Sc_4
javac UDPReceiver.java
javac UDPSender.java
```

#### Étape 2: Lancer les programmes

Terminal 1 (Récepteur):
```bash
java UDPReceiver
```

Terminal 2 (Émetteur):
```bash
java UDPSender
```

### 📊 Exemple de Session
```
[TERMINAL 1 - UDPReceiver]
Receiver is listening on port 1234...
Press Ctrl+C to stop the receiver manually.
Received from [127.0.0.1:58234]: Hello from UDP!
Received from [127.0.0.1:58234]: This is a test message
Received from [127.0.0.1:58234]: exit
Exit command received. Shutting down.

[TERMINAL 2 - UDPSender]
Enter target IP address (e.g., 127.0.0.1): 127.0.0.1
Chat started. Type 'bye' to quit.
You: Hello from UDP!
You: This is a test message
You: exit
Terminating chat...
```

### 🎓 Concepts Clés Appris
- **UDP vs TCP**: Fiabilité vs Vitesse
- **DatagramSocket**: Socket UDP
- **DatagramPacket**: Unité de données UDP
- **Connectionless Protocol**: Pas d'établissement de connexion
- **Network Addresses**: `InetAddress`, conversions IP/Host
- **Stateless Communication**: Chaque paquet est indépendant

---

## Résumé Comparatif

| Aspect | Sc_1 | Sc_2 | Sc_3 | Sc_4 |
|--------|------|------|------|------|
| **Concept Principal** | Synchronization | Race Condition | TCP/IP | UDP |
| **Type** | Multithreading | Multithreading | Réseau | Réseau |
| **Problème** | Accès concurrent | Surréservation | Connexion unique | Non fiable |
| **Solution** | `synchronized` | `synchronized` | Threads/Leaderboard | Datagram |
| **Ports** | N/A | N/A | 1234 | 1234 |
| **Protocole** | Shared Memory | Shared Memory | TCP Stream | UDP Packet |

---

## 📸 Screenshots

Pour ajouter des screenshots des exécutions:

1. **Sc_1 Screenshot**: Afficher la sortie du `BankSimulation.java`
2. **Sc_2 Screenshot**: Montrer les places négatives (-1)
3. **Sc_3a Screenshot**: SimpleServer + Client
4. **Sc_3b Screenshot**: MultiThreadedServer + Clients multiples + Leaderboard
5. **Sc_4 Screenshot**: UDPReceiver et UDPSender côte à côte

*Les screenshots peuvent être ajoutés manuellement en exécutant les programmes et en captures d'écran les résultats.*

---

## 🎓 Conclusion

Ce TP couvre les concepts fondamentaux de la programmation concurrente et réseau en Java:
- ✅ Multithreading et synchronisation
- ✅ Race conditions et deadlocks
- ✅ Programmation réseau TCP/IP
- ✅ Programmation réseau UDP
- ✅ Architecture client-serveur
- ✅ Collections thread-safe

