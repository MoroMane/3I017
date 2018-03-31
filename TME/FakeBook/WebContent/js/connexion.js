function init()
{
	noConnection=true;
	env=new Object();
	SetVirtualDB();
}

function SetVirtualDB()
{
	localdb=[];
	var a1={"id":1,"login":"sly"};
	var a2={"id:":2,"login":"fab"};
	var a3={"id":4, "login":"joe"};
	//follows=[];
	//follows[1]=[2,4];
	//follows[2]=new Set();
	//follows[2].add(4);
	//follows[4]=[1];
	var c1=new Commentaire(1,"user3","hum",new Date(),0);
	localdb[1]=new Message(42,"3408748","Blabla",new Date());
	localdb[2]=new Message(43,"3408749","Hello",new Date());
	localdb[3]=new Message(44,"3408750","Buenos Dias", new Date(),c1);
}

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
	var s="Message ID: "+this.id+" ";
	s+="<fieldset>" + this.text;
	s+="<br><br>";
	s+="From "+this.login+" the "+this.date;
	s+="<br>";
	s+="</fieldset>";
	//s+=this.comments.getHTML();
	if (this.comments.texte!=undefined)
	{
		s+= "<br>Commentaire : "+this.comments.texte;
		s+="<br>";
	}
	s+="</div>";
	s+="<br>";
	return s;
}

function Commentaire(id, auteur, texte, date, score){
	this.id=id;
	this.auteur=auteur;
	this.texte=texte;
	this.date=date;
	this.score=score;
}

Commentaire.prototype.getHTML=function()
{
	var s="Commentaire ID: "+this.id+" ";
	s+=this.text;
	s+="<br><br>";
	s+=this.score;
	s+="From "+this.auteur+" the "+this.date;
	s+="<br>";
	s+="</div>";
	s+="<br>";
	return s;
}

function connexion (formulaire)
{
	var login=formulaire.login.value;
	var pass=formulaire.pass.value;
	var ok=verif_formulaire_connexion(login,pass);
	if (ok)
		connecte(login,pass);
}

function verif_formulaire_connexion(l,p)
{
	if (l.length==0)
	{
		func_erreur("Login obligatoire");
		return false;
	}
	if (p.length==0)
	{
		func_erreur("Mot de passe obligatoire")
		return false;
	}
	if (l.length>20)
	{
		func_erreur("Login trop long");
		return false;
	}
	return true;
}

function func_erreur(msg)
{
	var msg_box="<div id=\"msg_erreur\">"+msg+"<br><br></div>";
	var old_msg=$("#msg_erreur");
	if (old_msg.length==0)
		$("form").prepend(msg_box); //ajoute_msg en 1er element du formulaire (prepend en premier element)
	else	
		old_msg.replaceWith(msg_box);
	$("#msg_erreur").css({"color":"red"})
}

function connecte(login,password)
{
	console.log("connection de " + login + ", mdp: " + password);
	var id=78;
	var key="ABCD";
	if (!noConnection){}
	else 
	{
		//responseConnexion({"key":key,"id":id_user,"login":login,"follows":[2]});
		responseConnexion({"key":key,"id":id,"login":login});
	}
}

function responseConnexion(rep)
{
	if (rep.erreur==undefined)
	{
		env.key=rep.key;
		env.id=rep.id;
		env.login=rep.login;
		//env.follows=new Set();
	}
	//for (var i=0;rep.follows.length;i++)
	//{
		//env.follows.add(rep.follows[i]);
	//}
	//if (noConnection)
	//{
	//	follows[rep.id]=new Set();
	//	for (var i=0;i<rep.follows.length;i++)
	//		follows[rep.id].add(rep.follows[i]);
	//}
	if (noConnection)
		makeMainPanel(env.id,env.login);
	else
		func_erreur(rep.erreur);
}


function makeMainPanel(fromId,fromLogin,query)
{
	env.msg=[]
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
		//if (!env.follows.has(env.fromId))
		//{
		//	s+="<div id=\"title\"> Page de " + fromLogin + "</div>"
		//	s+="<div class = \"add\"> <img src=\"Images/add.png\" title=\"suivre\" onclick='Javascript:follow()'></div></div>";
		//}
		//else
		//{
			s+="<div id=\"title\"><h1>Page de " + fromLogin + "</h1></div>"
			//s+="<div class = \"add\"> <img src=\"images/remove.png\" title=\"suivre\" onclick='Javascript:stopfollow()'></div></div>";
		//}
	}
	s+="<br>";
	s+="<div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")>";
	s+="<div class = \"profil\"> <a href=\"profil.html\" style=\"text-decoration:none; color:white;\"> Accéder au profil </a></div>";
	s+="<br>"
	s+="<div class = \"disco\"> <a href=\"deconnexion.html\"style=\"text-decoration:none; color:white;\"> Deconnexion </a></div>";
	s+="</div>";
	document.body.innerHTML=s;
	//document.getElementById("body").innerHTML=s;
}

/*
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
*/