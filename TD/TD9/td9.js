TD MapReduce

1 - Rappels de cours

Question 1 - Map-reduce
model de prog
==> parallélisation auto
==> Optimisation disque
==> Tolérence aux pannes

En 2 étapes
1) Un procédé de map ping (map)
2) Un procédé de récursion de l'info (reduce)'

Ex: Jean fait son tp de tech web de 3I017

Map : (Jean,1) (tp,1) (web,1)
(fait,1) (de, 1) (de,1)
(son,1) (techno,1) (3I017,1)

Reduce pour chaque ... opération, ici la somme.

[...] (de,2)

Question 2
-> crawl (ex : trouver du document)
-> Indexation (formater les documents pour pouvoir offrir une recherche efficace)
-> Recherche : répondre à une requête (en retournant les documents les plus pertinents)

Question 3
RSV ==> Donne un score d'un mot pour un document'
w = le mot 
d = le doc
tf (w,d) la fréquence d'un mot dans un document'
df (w) = le nombre de documents où apparait le mot w 
RSV(w,d)= tf (w,d) * log(nombre de document)/df(w)


2 - Exercice Map-Reduce et TF-IDF
Question 1
Pour un document, on obtient un vecteur (RSV (w1,d1)) = V1
										(RSV (w2,d2))
										(...		)
										(RSV (wi,dj))

Mesurer une similarité entre 2 documents (di,dj):
<vi,vj> si similaire RSV (wi,dj)

Mesure de similarité 

cos(di,dj)

Question 1 : calculer le document frequency avec map-reduce (définir les fonctions map et reduce)
function m() //la fonction de map
{
	var text = this.text
	var words = text.match ("/\w+ /g")
	var tf={}
	for (var i=0;i<words.length;i++)
	{
		if(tf[words[i]]==null)
			tf[words[i]]=1;
		else
			tf[words[i]]+=1;
	}
	for (w in tf)
		emit(w,1)
}

function r(key,values)
{
	return values.length
}

Question 2
"jean fait un projet"
"jean mange un sandwich"

{"jean":[(0,0),(1,0)]
"fait":[(0,1)],
"an":[(0,2),(0,2)]
}

m=function(){
	var text=this.text
	var id=this.id
	var words=text.match("/\w+ /g")
	var tf ={}
	for (var i=0;word.length;i++)
	{
		if(tf[words[i]]==null)
		{
			tf[word[i]]+=1;
		}
		else
		{
			emit tf[word[i]]+=1
		}
	}
	for (w in tf)
	{
		var ret={};
		ret[id]=tf[w];
		emit(w,ret);
	}
}

f=function (k,v){
	var df=Object.keys[v].length;
	for (d in v)
		v[d]=v[d]*Math.log(N/df);
	return v;
}






