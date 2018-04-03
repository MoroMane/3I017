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
	s+="<br/><br/>";
	s+="From "+this.login+" the "+this.date;
	s+="<br/>";
	s+="</fieldset>";
	if (this.comments.texte!=undefined)
	{
		s+= "<br/>Commentaire : "+this.comments.texte;
		s+="<br/>";
	}
	s+="</div>";
	s+="<br/>";
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
	s+=this.texte;
	s+="<br/><br/>";
	s+=this.score;
	s+="From "+this.auteur+" the "+this.date;
	s+="<br/>";
	s+="</div>";
	s+="<br/>";
	return s;
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
	var lm = JSON.parse(rep);
	for (var i=0; i < lm.length; i++)  
	{
		var m = lm[i];
		env.msg[m.id] = m;
		s="<div id=\"message_"+m.id+"\"";
		s+="<br/><fieldset>";
		s+=m.text;
		s+="<br/>"
		s+="Par " +m.login + " le " + m.date
		s+="</fieldset>";
		s+="</div>";
		s+="<br/>";
		s+="<fieldset>Commentaires :";
		s+="<br/>";
		s+="<br/>";
		s+="<div id=\"espace_commentaire_"+m.id+"\">";
		s+="</div>";
		s+="</fieldset>";
		s+="<br/>";
		s+="<div id=\"commentaire\">";
		s+="<form class =\"commentaire\" action=\"javascript:(function(){return;})()\" onSubmit=\"javascript:new_comment("+m.id+")\">";
		s+="<input type=\"text\" id=\"commentaire_"+m.id+"\"/> ";
		s+="<input type=\"submit\" value=\"Ajouter Commentaire\"/>";
		s+="</form>";
		s+="</div>";
		s+="<br/>";
		$("#message_users").append(s);
		if (m.id > env.maxId)
			env.maxId = m.id;
		if (m.id < env.minId)
			env.minId = m.id;
	}
}

function new_comment(id)
{
	var text=$("#commentaire_"+id).val();
	if (!noConnection){}
	else
	{
		var new_comment=new Commentaire(env.msg[id].comments.length+1,{"id":env.id,"login":env.login},text,new Date());
		newComment_response(id, JSON.stringify(new_comment));
	}
}

function newComment_response(id,rep)
{
	com=JSON.parse(rep,revival);
	//alert(com.getHTML());
	if((com!=undefined && com.erreur==undefined))
	{
		var el=$("#espace_commentaire_"+id);
		el.append(com.getHTML());
		env.msg[id].comments.push(com);
		if (noConnection)
			localdb[id]=env.msg[id];
		else
			alert(com.erreur);
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Pour l'enregistrement procéder de la même manière (avec makeConnexionPanel)
function developpeMessage(id)
{
	var m=env.msg[id];
	var el=$("#message "+id+".comments");
	for (var i=0;i<m.length;i++)
	{
		var i=m.comments[i];
		el.append(c.getHTML());
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
	$("#message "+id+".img").replaceWith("<img src=\"____\" onClick=\"javascript:developpeMessage("+id+")\"/>");
}