Valentin Quiedeville FIL A1
Version du jdk : openjdk-8
OS : Fedora 26
Version du noyau Linux : 3.16.0-4-amd64

La piste bleue est terminée.
Les tests de la piste verte, de la piste bleue ainsi que les tests d'erreur sont tous validés.

J'ai crée toute une série d'exceptions perso, elles se trouvent dans le package parser.exception.
Elles sont accompagnés d'un message d'erreur aidant à debugger (token fautif par exemple).
J'ai également utilisé SonarLint afin de m'aider à nettoyer mon code.

J'ai crée une Map<String,Integer> afin de bind mes variables, avant de lire le sujet.
Mon implémentation étant proche de la classe State proposée, j'ai décidé de la garder.

