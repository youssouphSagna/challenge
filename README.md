# challenge Backend Wedoogift

## Domain Driven Design
J'ai utilié le Domain Driven Design (DDD) comme standard de développement.


## Concepts
Le DDD est un concept de structuration du code autour du domaine métier. Il est très utile pour créer des applications orientées process métier. Ses buts sont de

+ Centrer les problématiques autour du domaine et de la logique métier
+ Placer les designs complexes sur le modèle du domaine
+ Créer une collaboration entre les experts techniques et métier pour partager autour du modèle du domaine

Ce dernier point met en avant la notion de langage ubiquitaire, où les noms des objets dans le code seront les mêmes que ceux utilisés par les experts métier.


## Architecture en couches
Le DDD définit 4 couches logicielles pour structurer une application


### Couche User Interface
Elle est responsable de la présentation de l’information à l’utilisateur et de l’interprétation des commandes de l’utilisateur.


### Couche Application
C’est une couche fine qui coordonne l’activité de l’application. Elle ne contient pas de logique métier. Elle ne recèle pas l’état
des objets métier, mais elle peut détenir l’état de la progression d’une tâche applicative. 


### Couche Domaine
Cette couche contient les informations sur le domaine. C’est le cœur du logiciel métier. L’état des objets métier est renfermé ici.
La persistance des objets métier et peut-être aussi leur état est délégué à la couche infrastructure.




### Couche Infrastructure
Cette couche agit comme une bibliothèque de soutien pour toutes les autres couches.
 Elle fournit la communication entre les couches, implémente la persistance des objets métier, contient les bibliothèques auxiliaires de la couche d’interface utilisateur, etc.
