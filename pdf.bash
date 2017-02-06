#!/bin/sh 
echo Tapez votre recherche #demande un mot-clé à l'utilisateur
read key    
mkdir $key #crée un dossier du nom du mot-clé
cd $key #se place dans un dossier
wget https://www.pexels.com/search/$key.html #va télécharger les photos sur le site internet

grep 'src=\"[^"]*.jpe*g' $key.html >sortie #récupère les liens des photos dans la page html

sed 's/.*src=\"\([^"]*.jpe*g\).*/\1/' sortie >album #"nettoie" les liens pour permettre le téléchargement

wget -i album #va télécharger les photos

mogrify -resize 800x600! *.jp*g #redimensionne les photos en 800x600 et écrase les originales

convert *.jp*g album$key.pdf #récupère les photos et en fait un pdf


