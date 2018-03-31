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

function getFromLocalDB(fromId,minId,maxId,nbMax)
{
	var tab=[];
	var nb=0;
	var f=new Set();
	if (from>0)
		f=follows[from];
	for (var i=localdb.length-1;i>=0;i--)
		tab.append(localdb[i]);
	return tab;
}

function completeMessages()
{
	if (!noConnection){}
	else
	{
		var tab=getFromLocalDB(env.fromId,-1,env.minId,1);
		completeMessagesReponse(JSON.stringify(tab));
	}
}

function completeMessagesReponse(rep) 
{
	var tab = (JSON.parse(rep, revival)).messages;
	for (var i=0; i < tab.length; i++) 
	{
		var m = listeMessages[i];
		$("#message").append(m.getHtml());
		env.messages[m.id] = m;
		if (m.id > env.maxId)
			env.maxId = m.id;
		if (m.id < env.minId)
			env.minId = m.id;
	}
}
//Pour l'enregistrement procéder de la même manière (avec makeConnexionPanel)
function developpeMessage(id)
{
	var m=env.msg[id];
	var el=$("#message "+id+".comments");
	for (var i=0;i<m.length;i++)
	{
		var i=m.comments[i];
		el.append(c.getHTMl());
	}
	el=$("#message "+id+".new_comment");
	el.append("<form name=\"new_comment_form\" id=\"new_comment_form\" action=\"javascript:func_new_comment("+id+")\")");
	$("#message "+id+" img").replaceWith("<img src=\"----\" on onClick=\"javascript:function replieMessage("+id+")\"/>");
}

function replieMessage(id)
{
	var m = env.msg[id];
	var el=$("#message "+id+".comments");
	el.html(" ");
	$("#message "+id+".img").replaceWith("<img src="____" onClick=\"javascript:developpeMessage("+id+")\"/>";
}

function new_comment(id)
{
	var text=$("#new " +id).val();
	if (!noConnection){}
	else
	{
		new Comment_response(id, JSON_stringify(new Commentaire(env.msg[id].comments.length+1,{"id",env.id,"login":env.login}, \
																								text,new Date()));
	}
}

function newComment_reponse(id,rep)
{
	var com=JSON.parse(rep,revival);
	if((com!=undefined && com.erreur==undefined))
	{
		var el=$(.."#meessage " +id+".comments");
		el.append(com.getHTML());
		env.msg[id].comments.push(com);
		if (noConnection)
			localdb[id]=env.msg[id];
		else
			alert(com.erreur);
	}
}

function follow ()
{
	if (!noConnection){}
	else
		reponseFollow({});
}

function reponseFollow(rep)
{
	if(rep.erreur==undefined)
	{
		//On ajoute dans l'environnement le suivi de l'utilisateur fromId
		env.follows.add(env.fromId)
		//si on a pas de communication client/serveur, on modifie la bd local
		if (noConnection)
		{
			//ajoute à follows l'utilisateur fromId
			follows[env.id].add(env.fromId);
		}
		$("#add").html("<img src=\"mon_image_ne_plus_suivre\" onclick='javascript.stopFollow()'>");
	}
	else
		alert(rep.erreur);
}