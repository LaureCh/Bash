#!/bin/sh 

#Interface utilisateur
echo Tapez votre recherche
read key

#Création d'un dossier qui va contenir les photos à télécharger
mkdir $key
cd $key
wget https://www.pexels.com/search/$key.html

#Récupération et nettoyage des liens des photos à télécharger depuis la page html
grep 'src=\"[^"]*.jpe*g' $key.html >sortie
sed 's/.*src=\"\([^"]*.jpe*g\).*/\1/' sortie >album

#Téléchargement, redimensionnement des photos et création pdf
wget -i album
mogrify -resize 800x600! *.jp*g
convert *.jp*g album$key.pdf


