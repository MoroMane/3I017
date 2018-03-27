function init()
{
	noConnection=true;
	env=new Object();
	SetVirtualDB();
	document.getElementById("liste_message").innerHTML=localdb[1].getHTML() + localdb[2].getHTML() + localdb[3].getHTML();
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

/* POUR PLUS TARD */
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
*/