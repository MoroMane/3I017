function connexion (formulaire)
{
	var login=formulaire.login.value;
	var pass=formulaire.pass.value;
	alert(pass);
	var ok=verif_formulaire_connexion(login,pass);
	
	//if (ok)
	//	connecte(login,pass);
}

/*
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


function connecte(login,password)
{
	console.log("connecte" + login + "" + password);
	var id=78;
	var key="ABCD";
	//if (!noConnexion){}
	//else {
	//responseConnexion({"key":key,"id":id_user,"login":login,"follows":[2]});
	responseConnexion({"key":key,"id":id,"login":login});
	//}
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
	//	env.follows.add(rep.follows[i]);
	//}
	//if (noConnection)
	//{
	//	follows[rep.id]=new Set();
	//	for (var i=0;i<rep.follows.length;i++)
	//		follows[rep.id].add(rep.follows[i]);
	//}
	makeMainPanel();
	else
		func_erreur(rep.erreur);
}


function func_erreur(msg)
{
	var msg_box="<div id=\"msg_err_connexion\">"+msg+"</div>";
	var old_msg=$("#msg_err");
	if (old_msg.length==0)
		$("form").prepond(msg_box); //ajoute_msg en 1er element du formulaire
	else	
		old_msg.replaceWith(msg_box);
	//$("msg_err_connexion").css({"color":"red","margin_top":"10px",...})
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