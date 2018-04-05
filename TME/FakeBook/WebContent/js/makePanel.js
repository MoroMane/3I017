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

function makeMainPanel2(fromId,fromLogin,query)
{
	$("body").load("html/main.html");
}

function makeMainPanel(fromId,fromLogin,query)
{
	s="<header>";
	s+="<div id=\"logo\">";
	s+="<img src=\"img/logo.png\" alt=\"Fakebook\" height=\"42\" width=\"42\"/>";
	s+="</div>";
	s+="<div id=\"search\">";
	s+="<br/>";
	s+="<input type=\"text\" id=\"recherche\"/>";
	s+="<input type=\"submit\" value=\"Recherche\"/>";
	s+="</div>";
	s+="<div id=\"connect\">";
	s+="<br/>";
	s+="<a href=\"javascript:makeProfilPanel2()\"> Profil </a> | ";
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
	s+="<input type=\"text\" id=\"message\"/>";
	s+="</div>";
	s+="<br/>";
	s+="<input type=\"submit\" value=\"Post\"/>";
	s+="<br/>";
	s+="<br/>";
	s+="</div>";
	s+="<div id=\"liste_message\">";
	s+="</div>";
	s+="</section>";
	$("body").html(s);
}


function makeProfilPanel()
{
	$("body").load("html/profil.html");
}

function makeProfilPanel2(fromId,fromLogin,query)
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
	s+="<a href=\"javascript:makeMainPanel()\"><img src=\"img/logo.png\" alt=\"Fakebook\" height=\"42\" width=\"42\"></a>";
	s+="</div>";
	s+="<div id=\"search\">";
	s+="<br/>";
	s+="<input type=\"text\" id=\"recherche\"/> ";
	s+="<input type=\"submit\" value=\"Recherche\"/>";
	s+="</div>";
	s+="<div id=\"connect\">";
	s+="<br/>";
	s+="<a href=\"javascript:makeMainPanel()\"> Main </a> | ";
	s+="<a href=\"javascript:makeConnexionPanel()\"> Deconnexion </a>";
	s+="</div>";
	s+="</header>";
	s+="<nav></nav>";
	s+="<section id=\"main\">"
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
			s+="<div class = \"add\">";
			s+="<input type=\"button\" value=\"suivre\" onclick='Javascript:follow()' />";
			s+="<br/>";
			s+="<br/>";
			s+="</div></div>";
		}
		else
		{
			s+="<br/>";
			s+="<br/>";
			s+="<div id=\"title\"><h1 style=\"color:white;\">Page de " + fromLogin + "</h1></div>"
			s+="<div class = \"remove\">";
			s+="<input type=\"button\" value=\"ne_plus_suivre\" onclick='Javascript:stopfollow()' />";
			s+="<br/>";
			s+="<br/>";
			s+="</div></div>";
		}
	}
	s+="<div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")>";
	s+="<br/>";
	s+="</div>";
	s+="<div id=\"message_users\">";
	s+="</div>";
	s+="</div>";
	s+="</section>";
	$("body").html(s);
	completeMessages();
}