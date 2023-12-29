# Mini Projet
Il est à développer une application web pour la gestion des notes pour une école.

Cette application est censée gérer les professeurs, les filières, les modules, les éléments de modules, les modalités d’évaluation ainsi que les notes.

Règles de gestion :
•	Un professeur est caractérisé par son nom et prénom, sa spécialité, son code.
•	Un module appartient à une filière et à un semestre donné (de S1 à S5) et est caractérisé par code et son nom.
•	Un élément de module appartient à un seul module et dispose d’un coefficient dans le module (50%, 30%, 25%, etc.).
•	Les éléments de modules pris en charge par un professeur peuvent appartenir à une ou plusieurs filières.
•	Les modalités d’évaluation sont : CC, TP, Projet, Présentations.
•	Chaque élément de module dispose d’une ou plusieurs modalités d’évaluation (CC, TP et Projet par exemple), chacune avec un coefficient (par exemple CC : 30%, TP : 20%, Projet : 50%)
•	Un professeur prend en charge des éléments de modules.
•	Chaque professeur dispose d’un compte d’accès à l’application.
•	Les profils pour cette application sont : l’administrateur et le professeur. 
•	Tous les utilisateurs de cette application (les professeurs et l’administrateur) doivent se connecter via un login et un mot de passe.
Le travail à faire :

L’objectif principal derrière cette application est la gestion des notes, mais pas uniquement, les prochaines versions de cette application seront aussi destinées aux étudiants et à la direction de l’école. Les fonctionnalités à réaliser dans cette première version sont :

L’administrateur de cette application doit pouvoir gérer :
1.	Les professeurs,
2.	Les filières,
3.	Les modules et leurs éléments,
4.	Les modalités d’évaluation,
5.	L’affectation des éléments aux professeurs, et
6.	Les comptes utilisateurs.

Le professeur doit pouvoir :
1.	Saisir les notes des éléments qu’il prend en charge, (le système lui affiche la liste des étudiants qui sont lui attribués) 
2.	Les modifier quand il veut si le module n’est pas encore validé,
3.	Valider les notes pour un élément donné. Une fois les notes validées, l’élément est considéré comme validé par le professeur et ses notes ne sont plus modifiables.
4.	Exporter les notes d’un élément dans un fichier Excel ou PDF (à votre choix) si l’élément est validé.

Avant de valider un élément, l’application doit vérifier que les données sont valides : 
•	Toutes les notes doivent être saisies, 
•	Toutes les notes doivent être comprises entre 0 et 20,
•	S’il y a des 0 ou des 20 parmi les notes, l’application doit demander la confirmation du professeur avant de valider l’élément,
•	Un étudiant absent pour une évaluation doit être marqué comme absent et la note qui lui est donnée est 0. L’application doit différentier un étudiant absent et un autre qui a eu 0 en évaluation.

Votre application doit permettre aussi : 
•	D’enregistrer en brouillon les notes d’un élément, 
•	D’annuler l’opération de saisie, 
•	De calculer la moyenne de l’élément,
•	De calculer la moyenne d’un module si tous ses éléments sont validés.
