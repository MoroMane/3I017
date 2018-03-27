Question 1

function connexion (formulaire)
{
	var login=formulaire.login.value
	var pass=fomulaire.pass.value
	var ok=verif_fomulaire_connexion(login,password)
	if (ok)
		connecte(login,password)
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
	var msg_box="<div id=\"msg_err_connexion\">"+msg+"</div>";
	var old_msg=$("#msg_err_connexion");
	if (old_msg.length==0)
	{ 
		$("form").prepond(msg_box); //ajoute_msg en 1er element du formulaire
	}
	else	
	{
		old_msg.replaceWith(msg_box);
	}
	$("msg_err_connexion").css({"color":"red","margin_top":"10px",...})
}

Question 2 - Tout en un
makeconnexionPannel.fonction retournant le html de la page de connexion
function makeConnexionPanel()
{
	var s = "<div id\"connexion_main\"> ... <div id=\"link_enregistrement\ onClick:\"javascript:makeEnregistrementPanel()\"></div>";
	$("body").html(s);
}

//$("body").html(s)//remplace
//$("body").append(o) //ajoute o à la fin du message
//$("body").prepend(o) //ajoute o au debut du message

Question 3
à la fin de la fonction makeMainPanel faire :

$("body").html(s)
CompleteMessages()
dans la fonction CompleteMessages $("#messages").append(m.getHTMl());

function connecte(login,password)
{
	console.log("connecte" + login + "" + password);
	var id_user=78;
	var key="ABCD...";
	if (!noConnexion){}
	else{
		responseConnexion({"key",key,"id":id_user,"login":login,"follows":[2]});
	}
}

functon responseConnexion(rep)
{
	if (rep.erreur==undefined)
	{
		env.key=rep.key;
		env.id=rep.id;
		env.login=rep.login;
		env.follows=new Set();
	}
	for (var i=0;rep.follows.length;i++)
	{
		env.follows.add(rep.follows[i]);
	}
	if (noConnection)
	{
		follows[rep.id]=new Set();
		for (var i=0;i<rep.follows.length;i++)
			follows[rep.id].add(rep.follows[i]);
	}
	makeMainPanel();
	else
		func_erreur(rep.erreur);
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