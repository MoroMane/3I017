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
	$("body").load("html/main.html");
}

function makeMainPanel2(fromId,fromLogin,query)
{
	if (fromId=undefined)
		fromId=-1;
	env.fromId=fromId;
	env.msg=[]
	env.query=query;
	env.fromLogin=fromLogin;
	console.log(env.fromLogin);
	var s="";
	if (env.fromId < 0)
	{
		//s+="<div id=title> Actualités </div>";
		$("body").load("main.html");
	}
	else
	{
		if (!env.follows.has(env.fromId))
		{
			s+="<div id=\"title\"><h1>Page de " + fromLogin + "</h1></div>";
			s+="<div class = \"add\">";
			s+="<input type=\"button\" value=\"suivre\" onclick='Javascript:follow()' />";
			//s+=<img src=\"images/add.png\" title=\"suivre\" onclick='Javascript:follow()' height=\"70\" width=\"70\"></div></div>";
			s+="</div></div>";
		}
		else
		{
			s+="<div id=\"title\"><h1>Page de " + fromLogin + "</h1></div>"
			//s+="<div class = \"add\"> <img src=\"images/remove.png\" title=\"suivre\" onclick='Javascript:stopfollow()' height=\"42\" width=\"42\"></div></div>";
		}
	}
	s+="</div> <div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")\")>"
	//s+="<div class = \"add\"> <img src=\"images/disco.png\" title=\"suivre\" onclick='Javascript:disconnect()' height=\"42\" width=\"42\"></div></div>";
	document.body.innerHTML=s;
	/*s+="<br>";
	s+="<div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")>";
	s+="<div class = \"profil\"> <a href=\"profil.html\" style=\"text-decoration:none; color:white;\"> Accéder au profil </a></div>";
	s+="<br>"
	s+="<div class = \"disco\"> <a href=\"deconnexion.html\"style=\"text-decoration:none; color:white;\"> Deconnexion </a></div>";
	s+="</div>";
	document.body.innerHTML=s;
	//document.getElementById("body").innerHTML=s;*/
}