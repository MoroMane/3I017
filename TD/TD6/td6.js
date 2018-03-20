==> html/CSS
	- page non dynamique
	- intéraction limité

==> langage de script (javascript)
	- modifications des élements
	- réaction à une action
	- communication client/serveur

Javascript
	- variable global	"x=5"
	- variable local	"var x=5"
	- les tableaux		var tab = [0,1,5,3]
						var tab2 = new Array() //creer un tableau vide
						tab2[1]=3

Les objets
Revision

monObjet={"a":2, "b":3}
==> créer un objet avec les attriuts a et b

 Avec un constructeur
	fonction MonObjet (p1,p2)
	{
		var a1=p1;
		this.a2=p2;
		X var methode_privée = function () {alert(a1)};
		X this.methode_public = function () {alert(a2)};
	}

Instancier objet
var obj=new MonObjet(2,4);
MonObjet.prototype.methode_public=function(){alert(a2)};
MonObjet.prototype.a1=2;
----------------------------------------------------------------------------------------------------------
Question 1

function Message(id,login,text,date,comments)
{
	this.id=id;
	this.login=login;
	this.text=text;
	this.date=date;
	if (comments == undefined)
		comments=[];
	this.comments=comments;
}

Message.prototype.getHTML=function()
{
	var s= "<div id=message_" + this.id+ "class=message>"
	s+= "<div class=text_message>" + this.text + "</div>"
	s+= "<div class=infos message>"
	s+= "<span> Post de <span class=link.onclick=javascript.pageUser("this+auteur.id+")> </span></span></div></div>"
	return s;
}

Question 2

function Commentaire(id, auteur, texte, date, score){
	this.id=id;
	this.auteur=auteur;
	this.texte=texte;
	this.date=date;
	this.score=score;
} 

Commentaire.prototype.getHtml=function()
{
	var re = "<div class='comment_general'>"
	re+="<div class='comment'> ";
	var photoP =this.auteur.photo;
	...
}


----------------------------------------------------------------------------------------------------------
==>eval // interprete du javascript
	objet javascript <=> JSON

==>JSON.parse(chaine_json,revival)

ex: x=JSON.parse("{id=1,login=2}")
	x["id"] //=1
	x["login"] //=2
	x.id //=1
	x.login //=2

revival est une fonction pour interpreter les couples clefs-valeurs.
revival (clef,valeur) -> la nouvelle valeur
----------------------------------------------------------------------------------------------------------
6.2
Question 1 
"{id:1,auteur:2,text:"blabla",date:"_____",comments:[{id:3,auteur:4,text:"OK",date:"______"}\
											{id:4,auteur:7,text:"blabla",date:"______"}]}";

function revival(key,value)
{
	if (value.comments!=undefined)
	{
		var c= new Message(value.id,value.auteur,value.date,value.comments);
		return c;
	}
	else if (value.text!=undefined)
	{
		var c = new commentaire(value.id,value.auteur,value.text,value.date);
		return c;
	}
	else if (key=="date")
	{
		var d=new Date(value);
		return d;
	}
	return value;
}
----------------------------------------------------------------------------------------------------------
6.3
<body onload ="javascript.init()">

function setVirtualDB()
{
	localdb=[]
	follows=[]
	var a1={"id":1,"login":"sly"};
	var a2={"id:":2,"login":"fab"};
	var a3={"id":4, "login","joe"};
	follows[1]=[2,4]
	follows[2]=new set()
	follows[2].add(4)
	follows[4]=[1]
	var c1=new Commentaire(1,user3,"hum",new Date())
	var c2=...
	localdb[1]=new Message(2,user1,"blabla")
	localdb[4]=new Message(4,user2,"hello",new Date[])
}

function init()
{
	nbConnection=true;
	env=new Object();
	SetVirtualDB();
}
----------------------------------------------------------------------------------------------------------
6.4

function makeMainPanel(fromId,fromLogin,query)
{
	env.msgs=[]
	if (fromId=undefined)
	{
		fromId=-1;
	}
	env.fromId=fromId;
	env.fromLogin=fromLogin;
	console.log(env.fromLogin);
	env.query=query;
	var s="<header id=top";
	if (env.fromId < 0)
		s+="<div id=title> Actualités </div>";
	else
	{
		if (!env.follows.has(env.fromId))
		{
			s+="<div id=\"title\"> Page de " + fromLogin + "</div>"
			s+="<div class = \"add\"> <img src=\"Images/add.png\" title=\"suivre\" onclick='Javascript:follow()'></div></div>";
		}
		else
		{
			s+="<div id=\"title\"> Page de " + fromLogin + "</div>"
			s+="<div class = \"add\"> <img src=\"Images/remove.png\" title=\"suivre\" onclick='Javascript:stopfollow()'></div></div>";
		}
	}
	s+="</div> <div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")\")>"
	s+="<div class = \"add\"> <img src=\"Images/disco.png\" title=\"suivre\" onclick='Javascript:disconnect()'></div></div>";
}