function makeConnexionPanel()
{
	$("body").load("html/connexion.html");
}

function makeEnregistrementPanel()
{
	$("body").load("html/enregistrement.html");
}

function makeMdpLostPanel()
{
	$("body").load("html/mdp_lost.html");
}

function makeMainPanel(fromId,fromLogin,query)
{
	s="<header>";
	s+="<div id=\"logo\">";
	s+="<img src=\"img/logo.png\" alt=\"Fakebook\" height=\"42\" width=\"42\"/>";
	s+="</div>";
	s+="<div id=\"search\">";
	s+="<br/>";
	//s+="<input type=\"text\" id=\"recherche\"/> ";
	//s+="<input type=\"submit\" value=\"Rechercher\"/>";
	s+="<form class =\"search\" action=\"javascript:(function(){return;})()\" onSubmit=\"javascript:rechercher(this)\">";
  	s+="<input type=\"text\" name=\"search\"/> ";
	s+="<input type=\"submit\" value=\"Rechercher\"/>";
	s+="</form>";
	s+="</div>";
	s+="<div id=\"connect\">";
	s+="<br/>";
	s+="<a href=\"javascript:makeProfilPanel("+fromId+",'"+fromLogin+"')\"> Profil </a> | ";
	s+="<a href=\"javascript:makeConnexionPanel()\"> Deconnexion </a> ";
	s+="</div>";
	s+="</header>";
	s+="</head>";
	s+="<br/>";
	s+="<nav></nav>	";
	s+="<section id=\"main\">";
	s+="<div id=\"new_message\">";
	s+="<br/>";
	s+="<br/>";
	s+="Message";
	s+="<br/>";
	s+="<br/>";
	s+="<div id=\"bla\">";
	s+="<form class =\"main_post\" action=\"javascript:(function(){return;})()\" onSubmit=\"javascript:new_message("+env.id+")\">";
	s+="<input type=\"text\" id=\"main_message\"/>";
	s+="<br/>";
	s+="<br/>";
	s+="<input type=\"submit\" id=\"poster\" value=\"Poster\"/>";
	s+="</form>";
	s+="<br/>";
	s+="</div>";
	s+="</div>";
	s+="<div id=\"liste_message\">";

	//Ajout des messages existant
	if (main_message.length!=0)
	{
		for (var j=0; j< main_message.length; j++)
			s+=main_message[j].getHTML();
	}

	/*
	//Ajout des messages de la session en cours
	if (env.msg.length!=0)
	{
		for (var j=0; j< env.msg.length; j++)
		{
			if (env.msg[j]!=undefined)
			{
				mess1 = new Message(env.msg[j].id,env.msg[j].login,env.msg[j].texte, env.msg[j].date, env.msg[j].comments)
				s+=mess1.getHTML();
			}
		}
	}*/
	s+="</div>";
	s+="</section>";
	$("body").html(s);
}

function makeProfilPanel(fromId,fromLogin,query)
{
	if (fromId==undefined)
		fromId=-1;
	env.fromId=fromId;
	env.msg=[];
	env.query=query;
	env.fromLogin=fromLogin;
	console.log(env.fromLogin);
	var s="";
	//HEADER
	s+="<header>";
	s+="<div id=\"logo\">";
	s+="<a href=\"javascript:makeMainPanel("+env.id+",'"+env.login+"')\"><img src=\"img/logo.png\" alt=\"Fakebook\" height=\"42\" width=\"42\"></a>";
	s+="</div>";
	s+="<div id=\"search\">";
	s+="<br/>";
	//s+="<input type=\"text\" id=\"recherche\"/> ";
	s+="<form class =\"search\" action=\"javascript:(function(){return;})()\" onSubmit=\"javascript:rechercher(this)\">";
  	s+="<input type=\"text\" name=\"search\"/> ";
	s+="<input type=\"submit\" value=\"Rechercher\"/>";
	s+="</form>";
	s+="</div>";
	s+="<div id=\"connect\">";
	s+="<br/>";
	s+="<a href=\"javascript:makeMainPanel("+env.id+",'"+env.login+"')\"> Main </a> | ";
	s+="<a href=\"javascript:makeConnexionPanel()\"> Deconnexion </a>";
	s+="</div>";
	s+="</header>";
	s+="<nav></nav>";
	s+="<section id=\"main\">";
	s+="<div id=\"profil\">";
	if (env.fromId < 0)
		$("body").load("html/profil.html");
	else
	{
		if (!env.follows.has(env.fromId))
		{
			s+="<br/>";
			s+="<br/>";
			s+="<div id=\"title\"><h1 style=\"color:white;\">Page de " + fromLogin + "</h1></div>";
			if (env.id!=fromId)
			{
				s+="<div id=\"follow\">";
				s+="<input type=\"button\" value=\"Suivre\" onClick='javascript:follow();'/> ";
				s+="<br/>";
				s+="<br/>";
				s+="</div>";
			}
			s+="</div></div>";
		}
		else
		{
			s+="<br/>";
			s+="<br/>";
			s+="<div id=\"title\"><h1 style=\"color:white;\">Page de " + fromLogin + "</h1></div>";
			if (env.id!=fromId)
			{
				s+="<div id= \"follow\">";
				s+="<input type=\"button\" value=\"Ne plus suivre\" onclick='Javascript:stopfollow()' />";
				s+="<br/>";
				s+="<br/>";
				s+="</div>";
			}
			s+="</div>";
		}
	}
	s+="<div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")>";
	s+="<br/>";
	s+="</div>";


	s+="<div id=\"new_message\">";
	s+="<div id=\"bla\">";
	s+="<form class =\"main_post\" action=\"javascript:(function(){return;})()\" onSubmit=\"javascript:new_message_users("+env.id+")\">";
	s+="<input type=\"text\" id=\"main_message\"/>";
	s+="<br/>";
	s+="<br/>";
	s+="<input type=\"submit\" id=\"poster\" value=\"Poster\"/>";
	s+="</form>";
	s+="<br/>";
	s+="</div>";
	s+="</div>";


	s+="<div id=\"message_users\">";
	s+="</div>";
	s+="</div>";
	s+="</section>";
	$("body").html(s);
	completeMessages();
}