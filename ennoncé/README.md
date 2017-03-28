BDD
	Didier: factures:1038, patients:8119, rendezvous:1
	Assistante: patients:607
	Maud: patients:3841

# Cf. https://github.com/docker-library/postgres/issues/151
Avant de créer l'image il faut commencer chaque dump par la sélection de la BDD.
"\c assistante" pour BDD/backup-assistante-XXXX-XXXX.sql
"\c maud" pour BDD/backup-maud-XXXX-XXXX.sql
"\c didier" pour BDD/backup-didier-XXXX-XXXX.sql

``` bash
# création de l'image docker avec les BDD chargées
docker build -t zyra83/pono-from-dockerfile .

# Démarrage du container en mode démon ou non
docker run -p 5432:5432 --name pono --rm zyra83/pono-from-dockerfile
# ou
docker run -d -p 5432:5432 --name pono zyra83/pono-from-dockerfile

# rentrer dans le container
docker exec -ti pono /bin/bash

Technos à utiliser

momentjs pour les dates relatives et claires. http://momentjs.com/
Base CSS en http://materializecss.com/ ou Bootstrap avec material ou http://semantic-ui.com/.

```
